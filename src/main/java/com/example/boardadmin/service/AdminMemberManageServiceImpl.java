package com.example.boardadmin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.boardadmin.dto.AdminMemberListDTO;
import com.example.boardadmin.dto.AdminMemberRecentBoardDTO;
import com.example.boardadmin.dto.AdminMemberRecentReplyDTO;
import com.example.boardadmin.dto.AdminMemberSearchDTO;
import com.example.boardadmin.exception.MemberNotFoundException;
import com.example.boardadmin.mapper.AdminMemberManageMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminMemberManageServiceImpl implements AdminMemberManageService {

	private final AdminMemberManageMapper adminMemberManageMapper;

	private void validatePage(AdminMemberSearchDTO searchDTO) {
		Integer page = searchDTO.getPage();
		Integer size = searchDTO.getSize();

		if (page == null || page < 1) {
			searchDTO.setPage(1);
		}

		if (size == null || (size != 10 && size != 20 && size != 50 && size != 100)) {
			searchDTO.setSize(10);
		}
	}

	@Override
	public List<AdminMemberListDTO> getMemberList(AdminMemberSearchDTO searchDTO) {
		validatePage(searchDTO);
		return adminMemberManageMapper.findMemberList(searchDTO);
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
	public List<AdminMemberRecentReplyDTO> getRecentRepliesByUserId(String userId) {
		return adminMemberManageMapper.findRecentRepliesByUserId(userId);
	}
	
	@Override
	public long getMemberCount() {
		return adminMemberManageMapper.countMembers();
	}
}
