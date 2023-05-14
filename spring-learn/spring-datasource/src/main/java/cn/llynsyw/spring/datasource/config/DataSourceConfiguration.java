package cn.llynsyw.spring.datasource.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String driverClassName;

    @Value("${jdbc.username}")
    private String name;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.url}")
    private String url;

    @Bean("dataSource") /*返回值放入容器中*/
    public DataSource getDataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(name);
        dataSource.setDriverClass(driverClassName);
        return dataSource;
    }
}
