package indi.aljet.mypreloader_master.preloader.interfaces;

/**
 * Created by LJL-lenovo on 2018/11/5.
 */

public interface GroupedDataListener<DATA>
        extends DataListener<DATA> {

    String keyInGroup();
}
