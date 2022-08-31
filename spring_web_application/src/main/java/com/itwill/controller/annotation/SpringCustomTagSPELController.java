package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.dto.Guest;

@Controller
public class SpringCustomTagSPELController {
	@RequestMapping("/jstl_fmt_i18n.do")
	public String jstl_fmt_i18n() {
		
		return"forward:/WEB-INF/views/jstl_fmt_i18n.jsp";
//		return"jstl_fmt_i18n";
	}
	@RequestMapping("/spring_customtag_spel.do")
	public String spring_customtag_spel(HttpServletRequest request) {
		request.setAttribute("price0", 19900);
		request.setAttribute("name0", "limhyeonjeong");
		
		request.setAttribute("price1", 22000);
		request.setAttribute("name1", "kimkimkim");
		request.setAttribute("married", true);
		
		request.setAttribute("price2", 5500);
		request.setAttribute("name2", "wooyoungwoo");
		request.setAttribute("married2", false);
		
		request.setAttribute("guest", 
				new Guest(1, "김수미", "2022/08/31", "sumi@naver.com", "http:www.naver.com", 
						  "타이틀", "Spring tag, SPEL에 대해 공부했따리"));
		
		
		return "spring_customtag_spel";
		
		/************Spring JSP에서 국제화*******************
		1. application-config.xml에 MessageSource빈설정
		 <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
	  		<property name="basenames" value="messages/messages,messages/user"/>
	  	 </bean>
	  	 *****************************************************/
	}
	@RequestMapping("/spring_customtag_spel_i18n.do")
	public String spring_customtag_spel_i18n() {
		return "spring_customtag_spel_i18n";
	}
	
	
}
