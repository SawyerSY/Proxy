package neusoft.sawyer.learn.aop.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by sawyer on 2018/5/30.
 */
public class DemoMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("Before in cglib");

        Object result;

        try {
            result = methodProxy.invokeSuper(o, objects);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("After in cglib");
        }

        return result;
    }
}
