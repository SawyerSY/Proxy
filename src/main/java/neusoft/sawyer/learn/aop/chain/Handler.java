package neusoft.sawyer.learn.aop.chain;

/**
 * Created by sawyer on 2018/5/30.
 * Proxy
 */
public abstract class Handler {

    private Handler successor;

    public Handler getSucessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void execute() {
        handleProcess();
        if (successor != null) {
            this.successor.execute();
        }
    }

    protected abstract void handleProcess();
}
