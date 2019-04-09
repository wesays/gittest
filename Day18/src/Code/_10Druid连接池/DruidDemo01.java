package Code._10Druid连接池;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        Properties info = new Properties();
        info.load(DruidDemo01.class.getResourceAsStream(
                "/druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(info);

        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        /*String sql = "create table dept1(code int primary key,name varchar(20) not null, sex varchar(1),joindate date, salary double);";
        stmt.execute(sql);
        //stmt.close();*/
        //PreparedStatement ps = conn.prepareStatement("insert into dept1 values(1,'jack','男','1990-01-02',2000),(2,'rose','女','1991-02-22',1000),(3,'noone','男','1012-01-01',2200);");
        //ps.executeUpdate();
        //PreparedStatement ps1 = conn.prepareStatement("Update dept1 set name = '猪八戒',salary = 3500,joindate = '2017-02-01' where code = 3;  ");
        //ps1.executeUpdate();
        /*List<Emp> list = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select * from dept1;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int code = rs.getInt("code");
            String name = rs.getString("name");
            String sex = rs.getString("sex");
            String joindate = rs.getString("joindate");
            double salary = rs.getDouble("salary");
            Emp emp = new Emp(code, name, sex, joindate, salary);
            list.add(emp);
        }
        System.out.println(list);*/

        /*PreparedStatement ps = conn.prepareStatement("" +
                "select avg(salary) from dept1;");
        ResultSet rs = ps.executeQuery();
        int a = rs.getInt("salary");
        System.out.println(a);*/
        PreparedStatement ps = conn.prepareStatement("" +
                "select avg(salary) as avgsalary from dept1 ;");
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            double avgsalary = rs.getDouble("avgsalary");
            System.out.println(avgsalary);
        }

       /* PreparedStatement ps = conn.prepareStatement("" +
                "select * from dept1 WHERE name like '张%';");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int code = rs.getInt("code");
            String name = rs.getString("name");
            String sex = rs.getString("sex");
            String joindate = rs.getString("joindate");
            double salary = rs.getDouble("salary");
            System.out.println(code+":"+name+":"+sex+":"+joindate+":"+salary);
        }*/

        /*Emp emp = getEmp(conn, 3);
        System.out.println(emp);
        int i = delete(conn, 2);
        System.out.println(i);*/
    }

    public static Emp getEmp(Connection conn,int n) throws Exception {
        PreparedStatement ps = conn.prepareStatement("select * from dept1 where code = ?; ");
        ps.setInt(1,n);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int code = rs.getInt("code");
        String name = rs.getString("name");
        String sex = rs.getString("sex");
        String joindate = rs.getString("joindate");
        Double salary = rs.getDouble("salary");
        Emp emp = new Emp(code, name, sex, joindate, salary);
        return emp;
    }

    public static int delete(Connection conn,int n) throws Exception {
        PreparedStatement ps = conn.prepareStatement("" +
                "delete from dept1 where code = ?");
        ps.setInt(1,n);
        int update = ps.executeUpdate();
        return update;
    }
}
