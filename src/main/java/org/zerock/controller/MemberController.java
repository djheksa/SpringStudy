package org.zerock.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/auth/*")
@Controller
public class MemberController {
	@GetMapping("general")
	public void doGeneral() {
		log.info("모든유저");
	}

	@GetMapping("member")
	public void doMember() {
		log.info("로그인한 유저");
	}

	@GetMapping("admin")
	public void doAdmin() {
		log.info("관리자");
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	@GetMapping("annoMember")
	public void doMember2() {
		log.info("logined annotation member");
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("annoAdmin")
	public void doAdmin2() {
		log.info("admin annotation only");
	}
}
