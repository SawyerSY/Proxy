package neusoft.sawyer.learn.aop.dynamic;

import neusoft.sawyer.learn.aop.pattern.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sawyer on 2018/5/29.
 */
public class JdkProxySubject implements InvocationHandler {

    private RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Before");

        Object result;

        try {
            result = method.invoke(realSubject, args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("After");
        }

        return result;
    }
}
