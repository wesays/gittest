package Code._06JdbcTemlate入门;

import Code._02数据源工具类.DataSourceUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/*
    JdbcTemplate基本使用
    使用步骤：
        1.创建JdbcTemplate对象并制定数据源对象
        2.调用JdbcTemplate对象的execute方法执行DDL语句

    需求：创建产品表：表明id，产品名称，产品价格
* */
class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
        jdbcTemplate.execute("" +
                "create table product(" +
                "id int primary key auto_increment," +
                "name varchar(20) not null unique," +
                "price double" +
                ");");
    }
}
