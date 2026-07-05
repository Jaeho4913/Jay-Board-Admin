package com.example.boardadmin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.boardadmin.dto.AdminMemberListDTO;
import com.example.boardadmin.mapper.AdminMemberManageMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminMemberManageService {

	private final AdminMemberManageMapper adminMemberManageMapper;

	public List<AdminMemberListDTO> getMemberList() {
		return adminMemberManageMapper.findMemberList();
	}
}
