package Code._05自定义连接池;

import java.sql.Connection;
import java.sql.SQLException;

public class MyDataSourceDemo01 {
    public static void main(String[] args) throws SQLException {
        MyDataSource ds = new MyDataSource();
        for (int i = 0; i < 6; i++) {
            Connection conn = ds.getConnection();
            /*if ( i == 4){
                ds.close(conn);
            }*/
            System.out.println(i+"->"+conn);
        }
    }
}
