package indi.aljet.mypreloader_master.preloader;

import indi.aljet.mypreloader_master.preloader.interfaces.DataListener;

public class StateLoading extends StateBase {

    public StateLoading(Worker<?> worker) {
        super(worker);
    }

    @Override
    public boolean listenData() {
         super.listenData();
         return worker.doWaitForDataLoaderWork();
    }

    @Override
    public boolean listenData(DataListener listener) {
         super.listenData(listener);
         return worker.doWaitForDataLoaderWork();
    }

    @Override
    public boolean dataLoadFinished() {
         super.dataLoadFinished();
         return worker.doDataLoadFinishWork();
    }


    @Override
    public String name() {
        return "StateLoading";
    }
}
