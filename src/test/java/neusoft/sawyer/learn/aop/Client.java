package neusoft.sawyer.learn.aop;

import neusoft.sawyer.learn.aop.cglib.DemoMethodInterceptor;
import neusoft.sawyer.learn.aop.chain.Chain;
import neusoft.sawyer.learn.aop.chain.ChainHandler;
import neusoft.sawyer.learn.aop.chain.Handler;
import neusoft.sawyer.learn.aop.dynamic.JdkProxySubject;
import neusoft.sawyer.learn.aop.pattern.RealSubject;
import neusoft.sawyer.learn.aop.pattern.Subject;
import neusoft.sawyer.learn.aop.pattern.SubjectProxy;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sawyer on 2018/5/29.
 * SubjectProxy
 */
public class Client {

    public static void main(String[] args) {
        chainHandle();
    }

    /*
     * 静态代理
     * */
    private static void staticProxy() {
        Subject subject = new SubjectProxy(new RealSubject());
        subject.request();
    }

    /*
     * JDK基于接口动态代理
     * */
    private static void dynamicProxy() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealSubject realSubject = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Subject.class}, new JdkProxySubject(realSubject));
        proxySubject.hello();
    }

    private static void cglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.hello();
    }

    private static void handle() {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        handlerA.execute();
    }

    private static void chainHandle() {
        List<ChainHandler> chainHandlerList = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );
        new Chain(chainHandlerList).proceed();
    }

    private static class HandlerA extends Handler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by a");
        }
    }

    private static class HandlerB extends Handler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by b");
        }
    }

    private static class HandlerC extends Handler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by c");
        }
    }

    private static class ChainHandlerA extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("chain handler by a");
        }
    }

    private static class ChainHandlerB extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("chain handler by b");
        }
    }

    private static class ChainHandlerC extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("chain handler by c");
        }
    }
}
