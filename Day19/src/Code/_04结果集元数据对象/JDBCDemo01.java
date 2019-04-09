package Code._04结果集元数据对象;

import Code._02数据源工具类.DataSourceUtil;

import java.sql.*;
import java.util.Collection;

/*
    结果集元数据对象使用

    ResultSetMetaData接口的常用方法
        int getColumnCount();获得列的数量
        String getColumnName(int index);
        根据所以获得列的名称，索引从1开始
        String getColumnTypeName(int index);
        根据索引获得数据类型
* */
public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
        //获得连接对象
        Connection conn = DataSourceUtil.getConnection();
        //获得预编译对象
        PreparedStatement ps = conn.prepareStatement("" +
                "select id,name from student;");
        //执行查询操作
        ResultSet rs = ps.executeQuery();
        //获得结果集元数据对象
        ResultSetMetaData rmd = rs.getMetaData();

        //获得列数量
        int columnCount = rmd.getColumnCount();
        System.out.println(columnCount);

        //遍历获得每一列的名字和数据类型
        for (int i = 1; i <= columnCount; i++) {
            //根据索引获得列名
            String typeName = rmd.getColumnTypeName(i);
            System.out.println(columnCount+"->"+typeName);
        }

        //关闭资源
        DataSourceUtil.close(rs,ps,conn);
    }
}
