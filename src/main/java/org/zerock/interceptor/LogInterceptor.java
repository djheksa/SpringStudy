package org.zerock.interceptor;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.log4j.Log4j;

@Log4j
public class LogInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//요청 URL
		String requestURI = request.getRequestURI();
		//로그에 고유번호 부여
		String uuid = UUID.randomUUID().toString();
		//로그인한 유저정보 가져오기
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", "홍길동");// 임시 로그인 유저 추가
		String loginUser = session.getAttribute("loginUser") + "." + uuid.toString();
		
		//파라미터로 들어온 Object handler(ResourceHttpRequestHandler) 객체가 인터페이스 HandlerMethod를 구현한 객체가 맞다면
		//즉 @Controller 어노테이션이 선언 되어있는 컨트롤러에 메서드가 맞다면 이란 뜻이됨
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler;
			log.info("실행시간 : " + LocalDateTime.now() + " | 실행된 메서드 : " + hm + " | 요청 URL : " + requestURI + " | 로그인 유저"
					+ loginUser);
		}
		return true;
	}
}
