package com.my.study.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.security.domain.AuthVO;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//스프링 컨텍스트 생성시 참조할 파일 지정 이외에 security-context, aop-context 등등..
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/resources/config/spring/datasource-context.xml" })
@Log4j
public class ControllerTestSample {

	@Inject
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	//@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/customLogin"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}

//	@Test
	public void testPost() throws Exception {
		log.info(mockMvc
				.perform(MockMvcRequestBuilders.post("/post")
						.param("userid", "testste")
						.param("auth", "sssss"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}

	@Test
	public void testRestPost() throws Exception {
		AuthVO vo = new AuthVO();
		vo.setAuth("ROLE_ADMIN");
		vo.setUserid("오득춘");
		String jsonStr = new Gson().toJson(vo);
		
		log.info(
				mockMvc
				.perform(MockMvcRequestBuilders.post("/rest/testpost")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(jsonStr))
//				.andExpect(content().contentType("application/json;charset=utf-8"))
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andDo(print())
				.andReturn()
				);
	}
}