package indi.aljet.mypreloader_master.preloader;

import indi.aljet.mypreloader_master.preloader.interfaces.DataListener;

public class StateDone extends StateBase {

    StateDone(Worker<?> worker){
        super(worker);
    }


    @Override
    public boolean refresh() {
        super.refresh();
        return worker.doStartLoadWork() &&
                worker.listenData();
    }

    @Override
    public boolean listenData() {
        super.listenData();
        return worker.doSendLoadedDataToListenerWork();
    }

    @Override
    public boolean listenData(DataListener listener) {
         super.listenData(listener);
         return worker.doSendLoadedDataToListenerWork(listener);

    }

    @Override
    public String name() {
        return "StateDone";
    }
}
