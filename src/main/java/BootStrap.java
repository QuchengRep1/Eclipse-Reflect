
import com.qucheng.reflectpj.dao.IBookDao;
import com.qucheng.reflectpj.dao.IUserDao;
import com.qucheng.reflectpj.reflect.ApplicationContext;
import com.qucheng.reflectpj.reflect.ApplicationContextAnno;


public class BootStrap {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	/**	
		ApplicationContext applicationContext = new ApplicationContext();
		applicationContext.initContext();
		System.out.println(applicationContext.getBean(IBookDao.class));
	**/
		
		ApplicationContextAnno applicationContextAnno = new ApplicationContextAnno();
		applicationContextAnno.loadAnno();
		
		
		
		
	} 

}