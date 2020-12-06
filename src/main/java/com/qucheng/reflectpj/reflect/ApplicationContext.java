package com.qucheng.reflectpj.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import com.qucheng.reflectpj.dao.IBookDao;
import com.qucheng.reflectpj.dao.IUserDao;
import com.qucheng.reflectpj.dao.Impl.BookDaoImpl;
import com.qucheng.reflectpj.dao.Impl.UserDaoImpl;
import com.qucheng.reflectpj.service.BookService;
import com.qucheng.reflectpj.service.UserService;
import com.qucheng.reflectpj.service.impl.BookServiceImpl;
import com.qucheng.reflectpj.service.impl.UserServiceImpl;


public class ApplicationContext<T> {

	private  HashMap<Class, Object> beanFactory = new HashMap<>();
	
	public  T getBean(Class clazz) {
		return (T)beanFactory.get(clazz);
	}
	
	public  void initContext() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

//使用读取配置文件的方式
		InputStream resource = ApplicationContext.class.getClassLoader().getResourceAsStream("config/bean.config");
		Properties properties = new Properties();
		try {
			properties.load(resource);
			Set<Object> keys = properties.keySet();
			for(Object key:keys) {
				beanFactory.put(Class.forName(key.toString()), 
						Class.forName(properties.getProperty(key.toString())).newInstance()  );
				
				System.out.println("key: "+key+" --value: "+properties.getProperty(key.toString()));
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}	
/** 		
		beanFactory.put(IUserDao.class, new UserDaoImpl());
		beanFactory.put(IBookDao.class, new BookDaoImpl());
		beanFactory.put(UserService.class, new UserServiceImpl());
		beanFactory.put(BookService.class, new BookServiceImpl());	
**/	
	}
}
