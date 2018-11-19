package indi.aljet.mypreloader_master.preloader;


import java.util.logging.Logger;

import indi.aljet.mypreloader_master.preloader.interfaces.DataListener;

import static indi.aljet.mypreloader_master.preloader.PreLoader.logger;

public abstract class StateBase implements State {

    protected Worker<?> worker;

    public StateBase(Worker<?> worker) {
        this.worker = worker;
    }

    @Override
    public boolean destroy() {
        log("destroy");
        if(this instanceof StateDestroyed){
            return false;
        }else{
            return worker.doDestroyWork();
        }

    }

    @Override
    public boolean startLoad() {
        log("startLoad()");
        return false;
    }

    @Override
    public boolean listenData() {
        log("listenData()");
        return false;
    }

    @Override
    public boolean listenData(DataListener listener) {
        log("listenData(listener)");
        return false;
    }

    @Override
    public boolean removeListener(DataListener listener) {
        log("removeListener");
        return worker.doRemoveListenerWork(listener);
    }

    @Override
    public boolean dataLoadFinished() {
        log("dataLoadFinished()");
        return false;
    }

    @Override
    public boolean refresh() {
        log("refresh()");
        return false;
    }


    private void log(String str){
        logger.info(name() + "---->> " + str);
    }
}
