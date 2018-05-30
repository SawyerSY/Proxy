package neusoft.sawyer.learn.aop;

import neusoft.sawyer.learn.aop.dynamic.JdkProxySubject;
import neusoft.sawyer.learn.aop.pattern.RealSubject;
import neusoft.sawyer.learn.aop.pattern.Subject;

import java.lang.reflect.Proxy;

/**
 * Created by sawyer on 2018/5/29.
 * Proxy
 */
public class Client {

    public static void main(String[] args) {
        /*
         * 静态代理
         * */
        // Subject subject = new Proxy(new RealSubject());
        // subject.request();

        /*
         * JDK基于接口动态代理
         * */
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Subject.class}, new JdkProxySubject(new RealSubject()));
        subject.request();
    }
}
