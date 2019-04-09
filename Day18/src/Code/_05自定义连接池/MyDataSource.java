package Code._05自定义连接池;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements DataSource{
    // 连接参数
    // 初始连接数
    private int initSize = 5 ;
    // 最大连接数
    private int maxSize = 10 ;
    // 记录当前创建的连接数量
    private int currentSize = 0;
    // 创建集合：存储连接对象
    private LinkedList<Connection> list = new LinkedList<>();

    public MyDataSource(){
        // 一开始就创建5个连接对象存储到集合中
        for (int i = 0; i < 5; i++) {
            Connection conn = createConnection();
        }
        // 创建连接对象
        // 将连接对象添加集合中
    }

    // 创建一个连接对象返回
    public Connection createConnection(){
        try{
            // 与数据库建立连接并获得连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql:///day18",
                    "root", "root");
            // 当前连接数计数加一
            currentSize++;
            // 返回连接对象
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 返回一个连接对象
    @Override
    public Connection getConnection() throws SQLException {
        // 判断集合是否还有连接对象可用
        if (list.size() > 0) {
            // 获得一个连接对象返回并将连接对象从集合中删除
            return list.removeFirst();
        }
        // 判断当前连接对象的数量是否已经达到最大值
        if (currentSize < maxSize) {
            // 创建一个新的连接对象返回
            Connection coon = createConnection();
            // 返回连接对象
            return coon;
        }
        // 没有连接对象可用，抛出异常
        throw new RuntimeException("无连接可用。。");
    }

    // 将连接对象返回集合中
    public void close(Connection conn){
        list.addLast(conn);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }




}
