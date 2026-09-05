package com.example.boardadmin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.boardadmin.dto.AdminMemberListDTO;
import com.example.boardadmin.dto.AdminMemberRecentBoardDTO;
import com.example.boardadmin.dto.AdminMemberRecentReplyDTO;
import com.example.boardadmin.exception.MemberNotFoundException;
import com.example.boardadmin.mapper.AdminMemberManageMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminMemberManageServiceImpl implements AdminMemberManageService {

	private final AdminMemberManageMapper adminMemberManageMapper;

	@Override
	public List<AdminMemberListDTO> getMemberList() {
		return adminMemberManageMapper.findMemberList();
	}

	@Override
	public AdminMemberListDTO getMemberDetail(String userId) {
		AdminMemberListDTO member = adminMemberManageMapper.findMemberDetail(userId);
		
		if (member == null) {
			throw new MemberNotFoundException(userId);
		}
		
		return member;
	}
	
	@Override 
	public List<AdminMemberRecentBoardDTO> getRecentBoardsByUserId(String userId) {
		return adminMemberManageMapper.findRecentBoardsByUserId(userId);
	}
	
	@Override
	public 	List<AdminMemberRecentReplyDTO> getRecentRepliesByUserId(String userId) {
		return adminMemberManageMapper.findRecentRepliesByUserId(userId);
	}
}
