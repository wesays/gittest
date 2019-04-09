package Code._02数据源工具类;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class DataSourceUtil {
    // 连接池对象
    private static DataSource ds = null;
    // 在类加载的时候只会执行一次
    static {
        try {
            // 创建属性集合对象
            Properties info = new Properties();
            // 加载配置文件信息
            info.load(DataSourceUtil.class.getResourceAsStream(
                    "/druid.properties"));
            // 创建数据源对象(连接池对象)
            ds = DruidDataSourceFactory.createDataSource(info);
        } catch (Exception e) {

        }
    }

    // 返回数据源对象
    public static DataSource getDataSource(){
        return ds;
    }

    // 返回连接对象
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    //抽取代码的思路：将重复代码抽取一个方法中，将不同的内容座作为方法参数
    public static int update(String sql,Object...params){
        try (
                //获得连接对象
                Connection conn = DataSourceUtil.getConnection();
                //获得预编译对象
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            //获得参数元数据对象
            ParameterMetaData pmd = ps.getParameterMetaData();
            //获得占位符个数
            int count = pmd.getParameterCount();
            //遍历占位符给占位符赋值
            for (int i = 0; i < count; i++) {
                //根据索引获得占位符的值
                Object param = params[i];
                //给占位符赋值
                ps.setObject(i+1,param);
            }
            //执行sql语句
            return ps.executeUpdate();
        } catch (Exception e){
            return 0;
        }
    }

    // 关闭资源
    public static void close(ResultSet rs, Statement stmt,Connection coon){
        try{
            if (rs != null)
                rs.close();
        } catch (Exception e){

        }
        try{
            if (stmt!= null)
                stmt.close();
        } catch(Exception e){

        }
        try{
            if (coon!= null)
                coon.close();
        } catch(Exception e){

        }
    }

    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);
    }
}
