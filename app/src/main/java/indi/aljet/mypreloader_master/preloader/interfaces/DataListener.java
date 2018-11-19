package indi.aljet.mypreloader_master.preloader.interfaces;

/**
 * Created by LJL-lenovo on 2018/11/5.
 */

public interface DataListener<DATA> {

    /**
     * do something with loaded data
     * Note: this method runs in main-thread
     * @param data loaded data (maybe null when load failed)
     */
    void onDataArrived(DATA data);
}
