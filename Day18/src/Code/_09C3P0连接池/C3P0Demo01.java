package Code._09C3P0连接池;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo01 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        for (int i = 0; i < 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+"->"+conn);
            if (i == 4){
                conn.close();
            }
        }
    }
}
