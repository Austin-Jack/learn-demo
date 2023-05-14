package cn.llynsyw.jdbc.forward.test.dao;

import cn.llynsyw.jdbc.forward.bean.Customer;
import cn.llynsyw.jdbc.forward.dao.BaseDAO;
import cn.llynsyw.jdbc.forward.dao.CustomerDAOImpl;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * CustomerDAOImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>8�� 17, 2021</pre>
 */
public class CustomerDAOImplTest {

    CustomerDAOImpl dao = new CustomerDAOImpl();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: insert(Connection conn, Customer customer)
     */
    @Test
    public void testInsert() throws Exception {
//TODO: Test goes here...
        Connection conn = BaseDAO.getConnection();
        Customer customer = new Customer(1, "��˹", "lansi@163.com", new Date(457554842185L));
        dao.insert(conn, customer);
        System.out.println("��ӳɹ�");
        BaseDAO.closeConnection(conn);
    }

    /**
     * Method: deleteByID(Connection conn, int id)
     */
    @Test
    public void testDeleteByID() throws Exception {
//TODO: Test goes here...
        Connection conn = BaseDAO.getConnection();
        dao.deleteByID(conn, 22);
        System.out.println("ɾ���ɹ�");

        BaseDAO.closeConnection(conn);
    }

    /**
     * Method: update(Connection conn, Customer customer)
     */
    @Test
    public void testUpdate() throws Exception {
//TODO: Test goes here...
        Connection connection = BaseDAO.getConnection();
        Customer customer = new Customer(18, "�����", "baidu@wq.com", new Date(54546468546L));
        dao.update(connection, customer);
        System.out.println("�޸ĳɹ�");

        BaseDAO.closeConnection(connection);
    }

    /**
     * Method: getCustomerByID(Connection conn, int id)
     */
    @Test
    public void testGetCustomerByID() throws Exception {
//TODO: Test goes here...
        Connection connection = BaseDAO.getConnection();
        Customer customer = dao.getCustomerByID(connection, 13);

        System.out.println(customer);

        BaseDAO.closeConnection(connection);
    }

    /**
     * Method: getAll(Connection conn)
     */
    @Test
    public void testGetAll() throws Exception {
//TODO: Test goes here...
        Connection connection =BaseDAO.getConnection();

        List<Customer> list = dao.getAll(connection);
        list.forEach(System.out::println);

        BaseDAO.closeConnection(connection);
    }

    /**
     * Method: getCount(Connection conn)
     */
    @Test
    public void testGetCount() throws Exception {
//TODO: Test goes here...
        Connection connection = BaseDAO.getConnection();

        System.out.println("���еļ�¼����Ϊ" + dao.getCount(connection));

        BaseDAO.closeConnection(connection);
    }

    /**
     * Method: getMaxBirth(Connection conn)
     */
    @Test
    public void testGetMaxBirth() throws Exception {
//TODO: Test goes here...
        Connection connection = BaseDAO.getConnection();
        Date newest = dao.getMaxBirth(connection);
        System.out.println("���������Ϊ" + newest);

        BaseDAO.closeConnection(connection);
    }

} 
