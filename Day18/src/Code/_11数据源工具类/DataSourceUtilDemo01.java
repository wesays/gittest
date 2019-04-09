package Code._11数据源工具类;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSourceUtilDemo01 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DataSourcrUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM student where id = 2");
        int row = ps.executeUpdate();
        System.out.println(row);

        DataSourcrUtil.close(ps,conn);
    }
}
