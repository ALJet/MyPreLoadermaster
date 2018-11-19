package indi.aljet.mypreloader_master.preloader;

public class StatusInitialed extends StateBase {

    public StatusInitialed(Worker<?> worker) {
        super(worker);
    }

    @Override
    public boolean startLoad() {
         super.startLoad();
         return worker.doStartLoadWork();
    }


    @Override
    public String name() {
        return "StatusInitialed";
    }
}
