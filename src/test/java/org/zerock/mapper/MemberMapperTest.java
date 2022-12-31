package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:config/spring/datasource-context.xml"})
@Log4j
public class MemberMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	
	@Test
	public void testRead() {
		MemberVO vo = memberMapper.read("admin92");
		log.info(vo);
		
		vo.getAuthList().forEach(authVO -> log.info(authVO));
	}
}
