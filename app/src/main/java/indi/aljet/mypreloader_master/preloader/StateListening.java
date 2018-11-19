package indi.aljet.mypreloader_master.preloader;

import indi.aljet.mypreloader_master.preloader.interfaces.DataListener;

public class StateListening extends StateBase {

    public StateListening(Worker<?> worker) {
        super(worker);
    }

    @Override
    public boolean dataLoadFinished() {
        super.dataLoadFinished();
        return worker.doSendLoadedDataToListenerWork();
    }

    @Override
    public boolean listenData(DataListener listener) {
         super.listenData(listener);
         return worker.doAddListenerWork(listener);
    }

    @Override
    public String name() {
        return "StateListening";
    }
}
