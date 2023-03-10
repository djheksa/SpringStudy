package org.zerock.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.security.domain.CustomUser;
import org.zerock.security.domain.MemberVO;
import org.zerock.security.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Inject
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By UserName : "+username);
		
		MemberVO vo = memberMapper.read(username);
		
		log.warn("queried by member mapper : "+vo);
		return vo==null?null:new CustomUser(vo);
	}

}
