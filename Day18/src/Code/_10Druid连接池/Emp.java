package Code._10Druid连接池;

public class Emp {
    private int code;
    private String name;
    private String sex;
    private String joindate;
    private double salary;

    public Emp(int code, String name, String sex, String joindate, double salary) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.joindate = joindate;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", joindate='" + joindate + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Emp() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
