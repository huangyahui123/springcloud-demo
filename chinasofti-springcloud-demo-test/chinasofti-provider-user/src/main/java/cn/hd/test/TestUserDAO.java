package cn.hd.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hd.dao.UserDao;
import cn.hd.entity.User;

public class TestUserDAO {
	
		public static void main(String[] args) {
			
	       /* <bean name="userDao" class="cn.hd.dao.impl.UserDaoImpl">
            	<property name="sqlSessionFactory" ref="sqlsessionFactory"></property>
            </bean>*/
			
			ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserDao userDao = (UserDao) aContext.getBean("userDao");
			
			/*User user = userDao.findUserById(102);
			System.out.println("==开始查询==");
			System.out.println(user);
			System.out.println("==结束查询==");*/
			
			//保存数据
			List<User> list = ReadExcel.getData();
			System.out.println("Excel表总共有: " + list.size() +" 条数据");
			userDao.saveListUser(list);
			
		}
}
