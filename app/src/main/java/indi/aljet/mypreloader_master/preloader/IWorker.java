package indi.aljet.mypreloader_master.preloader;

import java.util.concurrent.ExecutorService;

import indi.aljet.mypreloader_master.preloader.interfaces.DataListener;

/**
 * Created by LJL-lenovo on 2018/11/5.
 */

public interface IWorker {

    /**
     * set thread-pool executor for current worker
     * @param threadPoolExecutor thread-pool executor
     */
    void setThreadPoolExecutor(ExecutorService
                               threadPoolExecutor);


    /**
     * start to load data
     */
    boolean preLoad();

    /**
     * refresh worker
     */
    boolean refresh();

    /**
     * start to listen data with {@link DataListener}
     * @param dataListener {@link DataListener}
     */
    boolean listenData(DataListener dataListener);


    /**
     * start to listen data with no {@link DataListener}
     * you can add {@link DataListener} later
     */
    boolean listenData();

    /**
     * remove {@link DataListener} for worker
     * @param listener {@link DataListener}
     */
    boolean removeListener(DataListener listener);

    /**
     * destroy this worker
     */
    boolean destroy();
}
