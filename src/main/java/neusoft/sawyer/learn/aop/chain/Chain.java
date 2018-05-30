package neusoft.sawyer.learn.aop.chain;

import java.util.List;

/**
 * Created by sawyer on 2018/5/30.
 */
public class Chain {

    private List<ChainHandler> chainHandlerList;

    private int index;

    public Chain(List<ChainHandler> chainHandlerList) {
        this.chainHandlerList = chainHandlerList;
    }

    public void proceed() {
        if (index >= chainHandlerList.size()) {
            return;
        }
        chainHandlerList.get(index++).execute(this);
    }
}
