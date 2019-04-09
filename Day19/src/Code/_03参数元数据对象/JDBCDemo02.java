package Code._03参数元数据对象;

import Code._02数据源工具类.DataSourceUtil;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

/*
添加学生信息
如何获得参数元数据对象
    通过预编译对象的方法获得，该方法申明如下
    * ParameterMetaData getParameterMetaData();

    ParameterMetaData接口常用方法
        int getParameterCount();获得参数占位符（?）个数
        String getParameterTypeName(int index);
        根据索引获得占位符问号的数据类型
* */
public class JDBCDemo02 {
    public static void main(String[] args) throws Exception {
        // 获得连接对象
        Connection conn = DataSourceUtil.getConnection();
        // 准备SQL语句
        String sql = "insert into student values(null,?,?,?)";
        // 获得预编译对象
        PreparedStatement ps = conn.prepareStatement(sql);
        // 给占位符问号赋值
        ps.setString(1,"zhangsan");
        ps.setString(2,"男");
        ps.setString(3,"1995-02-06");
        // 执行SQL语句
        int row = ps.executeUpdate();
        // 获得参数元数据对象
        ParameterMetaData pmd = ps.getParameterMetaData();
        // 获得占位符问号的个数
        int count = pmd.getParameterCount();
        System.out.println(count);

        // 遍历获得每一个占位符的数据类型
        for (int i = 1; i <= count; i++) {
            String typeName = pmd.getParameterClassName(i);
            System.out.println(typeName);
        }
        DataSourceUtil.close(ps,conn);
    }
}
