package com.example.boardadmin.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.boardadmin.dto.AdminMemberDTO;
import com.example.boardadmin.mapper.AdminMemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminUserDetailsService implements UserDetailsService{

	private final AdminMemberMapper adminMemberMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AdminMemberDTO adminMemberDTO = adminMemberMapper.findByAdminId(username);

		if(adminMemberDTO == null) {
			throw new UsernameNotFoundException("관리자 계정을 찾을 수 없습니다.");
		}
		return new AdminUserDetails(adminMemberDTO);
	}

}