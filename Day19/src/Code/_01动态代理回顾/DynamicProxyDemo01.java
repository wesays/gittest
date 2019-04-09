package Code._01动态代理回顾;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class DynamicProxyDemo01 {
    public static void main(String[] args) {
        //创建集合：真是对象
        List<String> list = new ArrayList<>();

        //创建代理对象
        List proxy = (List) Proxy.newProxyInstance(
                ArrayList.class.getClassLoader(),//真实对象的类加载器对象
                new Class[]{List.class},//真实对象实现的接口
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //判断method是否是add方法
                        if (method.getName().equals("add")) {
                            //获得add方法的参数
                            String param = "itcast_" + args[0];
                            //将字符串添加真实对象中
                            //list.add(param);
                            return method.invoke(list, param);
                        }
                        //直接调用真实对象的方法
                        return method.invoke(list, args);
                    }
                }
        );

        proxy.add("aa");
        proxy.add("bb");
        proxy.add("cc");

        System.out.println(list);
    }
}
