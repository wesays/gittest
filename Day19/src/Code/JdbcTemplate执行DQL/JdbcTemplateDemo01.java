package Code.JdbcTemplate执行DQL;

import Code._02数据源工具类.DataSourceUtil;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
    JdbcTemplate执行DQL：查询数据
* */
public class JdbcTemplateDemo01 {
    //查询产品记录数
    //queryForInt 返回一个int类型整数
    @Test
    public void test01(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
        int count = jdbcTemplate.queryForInt("select count(*) from product;");
        System.out.println(count);

        Integer count2 = jdbcTemplate.queryForObject("select count(*) from product;",
                Integer.class);
        System.out.println(count2);
    }

    // queryForLong  返回一个long类型整数
    @Test
    public void test02(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.
                getDataSource());
        long price1 = jdbcTemplate.queryForLong(
                "select price from product where id = ?;",
                2);
        Object price2 = jdbcTemplate.queryForObject(
                "select price from product where id = ?;"
                , Long.class, 4);
        System.out.println(price1);
        System.out.println(price2);
    }

    // 需求：根据编号查询产品名称，返回字符串
    /*
    	public <T> T queryForObject(String sql, Class<T> requiredType)
		执行查询语句，返回一个指定类型的数据。
	 */
    @Test
    public void test03(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
        String name = jdbcTemplate.queryForObject(
                "select name from product where id = ?;",
                String.class, 4);
        System.out.println(name);
    }

    // 需求：查询所有的产品信息
    /*
    	public List<Map<String, Object>> queryForList(String sql)
		执行查询语句，返回一个List集合，List中存放的是Map类型的数据。
    */
    @Test
    public void test04(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from product;");
        for (Map<String, Object> map : list){
            System.out.println(map);
        }
    }
}
