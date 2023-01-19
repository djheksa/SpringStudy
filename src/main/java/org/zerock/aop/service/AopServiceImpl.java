package org.zerock.aop.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AopServiceImpl implements AopService {
	
	@Override
	public int aopTestMethod(String param1, String param2) throws Exception{
		log.info("param1 : " + param1);
		log.info("param2 : " + param2);
		log.info("serviceImpl Method Execution");
		return 10;
	}
}
