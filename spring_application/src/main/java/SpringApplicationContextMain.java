

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.GuestService;
import com.itwill.user.UserService;

public class SpringApplicationContextMain {

	public static void main(String[] args) {
		
		System.out.println("----Spring Container초기화 시작[ApplicationContext객체생성시작]----");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("~.xml");
		System.out.println("----Spring Container초기화 종료[ApplicationContext객체생성종료]----");
		
	}

}
