package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestModifyActionController implements Controller {
	private GuestService guestService;

	public GuestModifyActionController() {
		System.out.println("### GuestModifyActionController()생성자 호출");
	}

	public void setGuestService(GuestService guestService) {
		System.out.println("### GuestModifyActionController : setGuestService(" + guestService + ") 메쏘드 호출");
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forwardPath="";
		try {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath="redirect:guest_main.do";
			} else {
				String noStr = request.getParameter("guest_no");
				Guest updateGuest = new Guest(Integer.parseInt(noStr), request.getParameter("guest_name"), null,
						  request.getParameter("guest_email"), 
						  request.getParameter("guest_homepage"), 
						  request.getParameter("guest_title"), 
						  request.getParameter("guest_content"));
				guestService.updateGuest(updateGuest);
				forwardPath="redirect:guest_view.do?guest_no="+noStr;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		ModelAndView mv=new ModelAndView(forwardPath);
		return mv;
	}

}
