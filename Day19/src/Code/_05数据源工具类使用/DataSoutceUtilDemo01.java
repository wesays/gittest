package Code._05数据源工具类使用;

import Code._02数据源工具类.DataSourceUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    数据源工具类执行增删改操作
* */
public class DataSoutceUtilDemo01 {
    //添加学生信息
    @Test
    public void testInsert() throws Exception{
        String sql = "insert into student values(null,?,?,?)";
        DataSourceUtil.update(sql,"老王","男","1992-04-06");
    }

    // 更新学生数据
    @Test
    public void testUpdate() throws Exception {
        String sql = "update student set name = ? where id = ?";
        DataSourceUtil.update(sql,"天王",6);
    }

    @Test
    public void testDelete() throws Exception {
        String sql = "delete from student where id = ?;";
        DataSourceUtil.update(sql,5);
    }
}
