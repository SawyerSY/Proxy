package neusoft.sawyer.learn.aop.pattern;

/**
 * Created by sawyer on 2018/5/29.
 */
public class SubjectProxy implements Subject {

    private RealSubject realSubject;

    public SubjectProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("before");
        try {
            realSubject.request();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        System.out.println("after");
    }

    @Override
    public void hello() {
        System.out.println("before");
        try {
            realSubject.hello();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        System.out.println("after");
    }
}
