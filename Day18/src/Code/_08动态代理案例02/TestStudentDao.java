package Code._08动态代理案例02;

import Code._06反射回顾.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestStudentDao {
    public static void main(String[] args) {
        StudentDao stuDao = new StudentDao();

        Dao proxy = (Dao) Proxy.newProxyInstance(StudentDao.class.getClassLoader(),
                StudentDao.class.getInterfaces(),
                new InvocationHandler() {
                    public boolean check(){
                        System.out.println("ok");
                        return true;
                    }
                    public void log(){
                        System.out.println("记录日志信息。。");
                    }
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (check()){
                            Object result = method.invoke(stuDao, args);
                            log();
                            return result;
                        }
                        return null;
                    }
                });

        proxy.save(new Student());
        proxy.delete(1);
        proxy.update(new Student());
        Student stu = (Student) proxy.find(2);
        System.out.println(stu);
    }
}
