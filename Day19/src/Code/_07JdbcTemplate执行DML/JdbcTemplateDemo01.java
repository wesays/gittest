package Code._07JdbcTemplate执行DML;

import Code._02数据源工具类.DataSourceUtil;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

/*
    JdbcTemplate执行DML语句：update方法
* */
public class JdbcTemplateDemo01 {
    // JDBCTemplate添加数据
    @Test
    public void test01() throws Exception{
        //创建模板对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
        //准备Sql语句
        String sql = "insert into product values (null,?,?);";
        //执行sql语句
        jdbcTemplate.update(sql,"iPhone6",2500);
        jdbcTemplate.update(sql,"iPhone6s",2800);
        jdbcTemplate.update(sql,"iPhone6x",3000);
        jdbcTemplate.update(sql,"iPhone6xp",3500);
    }

    @Test
    public void test02(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
        String sql = "update product set price = ? where id = ? ";
        int row = jdbcTemplate.update(sql, 1000, 2);
        System.out.println(row);
    }

    @Test
    public void test03(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
        String sql = "delete from product where id = ?";
        int row = jdbcTemplate.update(sql, 3);
        System.out.println(row);
    }
}
