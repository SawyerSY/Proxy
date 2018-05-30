package neusoft.sawyer.learn.aop.pattern;

/**
 * Created by sawyer on 2018/5/29.
 * Proxy
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("Real subject execute request.");
    }
}
