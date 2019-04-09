package Code.JdbcTemplate执行DQL;

import Code._02数据源工具类.DataSourceUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/*
    JdbcTemplate执行DQL：使用行映射器对象将记录封装成一个自定义对象

    RowMapper接口概述
        一个该接口的实现类对象就是一个行映射器对象：用来将一行记录封装成自定义对象
* */
public class JdbcTemplateDemo02 {
    //query 使用rowMap做映射返回一个对象：product
    //需求：查询所有的产品信息，返回List集合：存储Product对象
    @Test
    public void test06() throws Exception{
        //创建模板对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
        //执行查询操作
        List<Product> list = jdbcTemplate.query("" +
                        "SELECT * FROM product;",
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        double price = resultSet.getDouble("price");
                        return new Product(id, name, price);
                    }
                });

        for (Product product : list) {
            System.out.println(product);
        }
    }

    // query使用BeanPropertyRowMapper做映射返回对象
    // 需求：查询所有的产品信息，返回List集合：存储Product对象
    /*
    public <T> List<T> query(String sql, RowMapper<T> rowMapper)
        执行查询语句，返回一个List集合，List中存放的是RowMapper指定类型的数据。

    public class BeanPropertyRowMapper<T> implements RowMapper<T>
        BeanPropertyRowMapper类实现了RowMapper接口
    */
    @Test
    public void test07(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
        List<Product> products = jdbcTemplate.query("select * from product",
                new BeanPropertyRowMapper<>(Product.class));
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // 根据id查询产品信息，返回一个Product
    @Test
    public void test08(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
        Product product = jdbcTemplate.queryForObject("select * from product where id = 1;",
                new BeanPropertyRowMapper<>(Product.class));
        System.out.println(product);
    }
}
