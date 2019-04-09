package Code._03预编译对象;

import Code._02登录案例.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
        预编译对象执行增删改操作
* */
public class JDBCDemo01 {
    //添加数据：向学生表添加三条记录
    @Test
    public void insertStudent() throws Exception{
        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into student values(null,?,?)," +
                "(null,?,?),(null,?,?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,"小智");
        ps.setString(2,"日本");
        ps.setString(3,"小美");
        ps.setString(4,"日本");
        ps.setString(5,"小英");
        ps.setString(6,"日本");
        int row = ps.executeUpdate();
        System.out.println(row);
        JDBCUtil.close(ps,conn);
    }


    @Test
    public void updateStudent() throws Exception{
        Connection conn = JDBCUtil.getConnection();
        String sql = "Update student set name = ?,address = ? where id = 3;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,"嫦娥1");
        ps.setString(2,"广寒宫1");
        int row = ps.executeUpdate();
        System.out.println(row);
        JDBCUtil.close(ps,conn);
    }

    @Test
    public void deleteStudent() throws Exception{
        Connection conn = JDBCUtil.getConnection();
        String sql = "delete from student where id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,1);
        int row = ps.executeUpdate();
        System.out.println(row);
        JDBCUtil.close(ps,conn);
    }
}
