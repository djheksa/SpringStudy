package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.security.domain.AuthVO;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model m) {
		log.info("access Denied : "+auth);
		m.addAttribute("msg","AccessDenied");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {	
		//String error , String logout 변수타입과 이름은 고정임 스프링시큐리티에서 자동으로 값을 각 동작을 하였을때 값을 넣어주는 변수들임
		log.info("error: "+error);
		log.info("logout: "+logout);
		model.addAttribute("result","test성공~!~!~!~");
		if(error != null) {
			model.addAttribute("error","Login Error Check Your Account");
		}
		if(logout != null) {
			model.addAttribute("logout","LogOut!!");
		}
	}
	
	@GetMapping("/modelTest")
	public String modalTest() {
		
		return "reviewEdit2";
	}
	
	@PostMapping("/post")
	public void testPost(@ModelAttribute("auth") AuthVO auth,Model model) {
		model.addAttribute("testAuth",auth);
		
	}
	
	@PostMapping(value = "/rest/testpost", produces="application/json;charset=utf-8")
	@ResponseBody
	public AuthVO restTestPost(@RequestBody AuthVO auth) {
		return auth;
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom logout");
	}
	

}
