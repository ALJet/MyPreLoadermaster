package indi.aljet.mypreloader_master.preloader.interfaces;

/**
 * Created by LJL-lenovo on 2018/11/5.
 */

public interface GroupedDataLoader<DATA> extends
        DataLoader<DATA> {

    /**
     * key of this data-loader in the group
     * should be unique
     * @return unique key in the group
     */
    String keyInGroup();
}
