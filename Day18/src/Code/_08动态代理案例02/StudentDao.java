package Code._08动态代理案例02;

import Code._06反射回顾.Student;

public class StudentDao implements Dao<Student> {
    @Override
    public void save(Student student) {
        System.out.println("保存了");
    }

    @Override
    public void delete(int id) {
        System.out.println("删除学生信息");
    }

    @Override
    public void update(Student student) {
        System.out.println("更新学生信息");
    }

    @Override
    public Student find(int id) {
        System.out.println("查询学生信息");
        return new Student();
    }
}
