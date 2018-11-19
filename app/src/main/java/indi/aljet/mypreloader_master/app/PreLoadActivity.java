package indi.aljet.mypreloader_master.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import indi.aljet.mypreloader_master.R;
import indi.aljet.mypreloader_master.preloader.PreLoader;
import indi.aljet.mypreloader_master.preloader.PreLoaderWrapper;
import indi.aljet.mypreloader_master.preloader.interfaces.DataListener;
import indi.aljet.mypreloader_master.preloader.interfaces.DataLoader;

public class PreLoadActivity extends AppCompatActivity {


    private PreLoaderWrapper<String> preLoader;
    private TimeWatcher allTime;
    private TextView logTextView,readmeTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        //time between the beginning of onCreate(...) and end of Listener.onDataArrived()
        allTime = TimeWatcher.obtainAndStart("total");
        //start pre-loader for this page
        preLoader = preLoad();
        //time of UI initialization
        TimeWatcher timeWatcher = TimeWatcher.obtainAndStart("init layout");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_load);
        setTitle(R.string.pre_loader_inside_page_title);
        try {
            //mock UI initialization time cost
            Thread.sleep(200);
        } catch(Exception e) {
            e.printStackTrace();
        }
        readmeTextView = (TextView)findViewById(R.id.readme);
        readmeTextView.setText(R.string.pre_loader_inside_page_readme);
        logTextView = (TextView)findViewById(R.id.log);
        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allTime.start();
                readmeTextView.setText(R.string.pre_loader_refresh);
                logTextView.setText("");
                if (preLoader != null) {
                    preLoader.refresh();
                }
            }
        });
        //UI initialization finished, record the time cost
        String s = timeWatcher.stopAndPrint();
        logTextView.append(s + "\n");
        //ready for data listener
        // if data is loading, waiting for data to show
        // if data is loaded, show data by listener

        preLoader.listenData();
}



    private PreLoaderWrapper<String> preLoad(){
        return PreLoader.just(new Loader(),
                new Listener());
    }

    class Loader implements DataLoader<String>{
        @Override
        public String loadData() {
            TimeWatcher timeWatcher = TimeWatcher
                    .obtainAndStart("load data");
            try{
                Thread.sleep(600);
            }catch (InterruptedException ignored){

            }

            return timeWatcher.stopAndPrint();
        }
    }


    class Listener implements DataListener<String>{
        @Override
        public void onDataArrived(String data) {
            //总耗时结束
            String s = allTime.stopAndPrint();
            logTextView.append(data + "\n" + s + "\n");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        preLoader.destroy();
    }
}
