package cn.llynsyw.mybatis.configuration;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/8/18
 **/
public class SqlSessionFactorySingleton {
    private static SqlSessionFactory instance;
    private static final String CONFIG_PATH = "sqlMapConfig.xml";

    private SqlSessionFactorySingleton() {
    }

    public static SqlSessionFactory getInstance() {
        if (instance == null) {
            synchronized (SqlSessionFactorySingleton.class) {
                if (instance == null) {
                    //获取核心配置文件
                    try (InputStream resourceAsStream = Resources.getResourceAsStream(CONFIG_PATH)) {
                        //构建SqlSessionFactoryBuilder 持有XML 解析资源 最好构建完SqlSessionFactory就释放
                        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
                        //SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在
                        instance = sqlSessionFactoryBuilder.build(resourceAsStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }
}
