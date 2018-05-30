package neusoft.sawyer.learn.aop.chain;

/**
 * Created by sawyer on 2018/5/30.
 */
public abstract class ChainHandler {

    public void execute(Chain chain) {
        this.handleProcess();
        chain.proceed();
    }

    protected abstract void handleProcess();
}
