package indi.aljet.mypreloader_master.preloader;

public class StateDestroyed extends StateBase {
    public StateDestroyed(Worker<?> worker) {
        super(worker);
    }

    @Override
    public boolean destroy() {
        return false;
    }

    @Override
    public String name() {
        return "StateDestroyed";
    }
}
