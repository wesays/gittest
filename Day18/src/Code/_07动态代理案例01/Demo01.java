package Code._07动态代理案例01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo01 {
    public static void main(String[] args) {
        BabyWall bw = new BabyWall();
        Star sjj = (Star) Proxy.newProxyInstance(BabyWall.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //System.out.println("成交！");
                        Object reslut = method.invoke(bw, args);
                        return reslut;
                    }
                });

        sjj.sing("绿光");
        sjj.dance();
    }
}
