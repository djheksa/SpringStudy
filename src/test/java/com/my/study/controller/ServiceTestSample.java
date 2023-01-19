package com.my.study.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.aop.service.AopService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//스프링 컨텍스트 생성시 참조할 파일 지정 이외에 security-context, aop-context 등등..
@ContextConfiguration({ "file:src/main/resources/config/spring/*-context.xml" })
@Log4j
public class ServiceTestSample {	
	
	@Inject
	private AopService aopService;
	
	@Test
	public void testAop() throws Exception{
		log.info(aopService);
		log.info(aopService.getClass().getName());
		log.info(aopService.aopTestMethod("하이용", "반가워용"));
	}
}	
