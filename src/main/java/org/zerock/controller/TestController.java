package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.security.domain.AuthVO;


//test 컨트롤러
@Controller
public class TestController {
	//Post Test method
	@PostMapping("/post")
	public void testPost(@ModelAttribute("auth") AuthVO auth,Model model) {
		model.addAttribute("testAuth",auth);
		
	}
	
	//Rest Post Test Method
	@PostMapping(value = "/rest/testpost", produces="application/json;charset=utf-8")
	@ResponseBody
	public AuthVO restTestPost(@RequestBody AuthVO auth) {
		
		return auth;
	}
	
	
}
