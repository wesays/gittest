package Code._03参数元数据对象;

import Code._02数据源工具类.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
        //获得连接对象
        Connection conn = DataSourceUtil.getConnection();
        //获得预编译对象
        PreparedStatement ps = conn.prepareStatement("create table student(" +
                "id int primary key auto_increment," +
                "name varchar(20) not null," +
                "gender char(1)," +
                "birthday date);");
        //执行SQL语句
        int row = ps.executeUpdate();
        System.out.println(row);
        DataSourceUtil.close(ps,conn);
    }
}
