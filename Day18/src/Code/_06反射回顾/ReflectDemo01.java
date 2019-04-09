package Code._06反射回顾;

import java.lang.reflect.Method;

/*
反射回顾：通过反射调用方法

    类加载器概述
        概念：一个负责加载类的对象
        作用：将类的字节码文件从硬盘中加载内存中并在内存中创建了一个Class对象。
        每一个类都必须有类加载器加载

    Class类与获取类加载器对象相关的方法
        * ClassLoader getClassLoader();

    三种类加载器
        * BootstrapClassLoader:
            * 引导类加载器  负责加载核心包下的类：比如：String
            * 如果获得类加载器对象为null，则代表由引导类加载器负责加载
        * ExtClassLoader：扩展类加载器  负责加载扩展包下的类
        * AppClassLoader：应用类加载器  加载自定义的类以及第三方jar中的类
* */
public class ReflectDemo01 {
    public static void main(String[] args) throws Exception {
        Class c = Student.class;
        Object obj = c.getConstructor().newInstance();
        Method m = c.getMethod("study", String.class, int.class);
        Object result = m.invoke(obj, "xiaoxiao", 8);
        System.out.println(result);


        ClassLoader classLoader = Student.class.getClassLoader();
        ClassLoader classLoader1 = ReflectDemo01.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader1);

        System.out.println(String.class.getClassLoader());
    }
}
