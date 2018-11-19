package indi.aljet.mypreloader_master.preloader.interfaces;


/**
 * Created by LJL-lenovo on 2018/11/5.
 */

public interface DataLoader<DATA> {
    /**
     * pre-load loaded data
     * Note: this method will runs in thread pool,
     * @return load result data (maybe null when load failed)
     */
    DATA loadData();
}
