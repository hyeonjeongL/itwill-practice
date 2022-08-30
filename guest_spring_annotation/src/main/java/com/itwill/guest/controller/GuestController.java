package com.itwill.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	/*
	 * <<요청 url(command)>> 
	 * /guest_main 			---forward--->/WEB-INF/view/guest_main.jsp 
	 * /guest_list 			---forward--->/WEB-INF/view/guest_list.jsp 
	 * /guest_view 			---forward--->/WEB-INF/view/guest_view.jsp
	 * /guest_write_form 	---forward--->/WEB-INF/view/guest_write_form.jsp 
	 * /guest_write_action 	---forward--->/WEB-INF/view/guest_write_action.jsp 
	 * /guest_modify_form 	---forward--->/WEB-INF/view/guest_modify_form.jsp 
	 * /guest_modify_action ---forward--->/WEB-INF/view/guest_modify_action.jsp 
	 * /guest_remove_action ---forward--->/WEB-INF/view/guest_remove_action.jsp 
	 * /guest_error 		---forward--->/WEB-INF/view/guest_error.jsp
	
	 */
	
	@Autowired
	private GuestService guestService;
	
	public GuestController() {
		System.out.println("### GuestController() 생성자");
	}
	@RequestMapping("/guest_main")
	public String guest_main() {
		return "forward:/WEB-INF/views/guest_main.jsp";
	}
	@RequestMapping("/guest_list")
	public String guest_list(Model model) throws Exception{
		List<Guest> guestList =  guestService.selectAll();
		model.addAttribute("guestList",guestList);
		return "forward:/WEB-INF/views/guest_list.jsp";
	}
	@RequestMapping("/guest_write_form")
	public String guest_write_form() {
		
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	@RequestMapping(value="/guest_write_action", method = RequestMethod.POST)
	public String guest_write_action(@ModelAttribute Guest guest) throws Exception {
		guestService.insertGuest(guest);
		
		return "redirect:guest_list";
//		return "forward:/WEB-INF/views/guest_list.jsp";
	}
	@RequestMapping("/guest_modify_form")
	public String guest_modify_form(@RequestParam int guest_no, Model model) throws Exception{
		Guest guest = guestService.selectByNo(guest_no);
		model.addAttribute(guest);
		
		return "forward:/WEB-INF/views/guest_modify_form.jsp";
	}
	@RequestMapping(value="/guest_modify_action", method = RequestMethod.POST)
	public String guest_modify_action(@ModelAttribute Guest guest) throws Exception {
		guestService.updateGuest(guest);
		
		return "redirect:guest_list";
	}
	
	@RequestMapping("/guest_view")
	public String guest_view(@RequestParam int guest_no, Model model) {
		try {
			Guest guest = guestService.selectByNo(guest_no);
			model.addAttribute("guest", guest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return"forward:/WEB-INF/views/guest_view.jsp";
	}
	@RequestMapping(value="/guest_remove_action", method = RequestMethod.POST)
	public String guest_remove(@RequestParam int guest_no, Model model) throws Exception {
		int rowCount = guestService.deleteGuest(guest_no);
	
		return "redirect:guest_list";
//		return "forward:/WEB-INF/views/guest_main.jsp";
	}
	
}
