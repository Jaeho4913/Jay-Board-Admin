package com.example.boardadmin.service;

import java.util.List;

import com.example.boardadmin.dto.AdminMemberListDTO;
import com.example.boardadmin.dto.AdminMemberRecentBoardDTO;
import com.example.boardadmin.dto.AdminMemberRecentReplyDTO;
import com.example.boardadmin.dto.AdminMemberSearchDTO;

public interface AdminMemberManageService {

	List<AdminMemberListDTO> getMemberList(AdminMemberSearchDTO searchDTO);

	AdminMemberListDTO getMemberDetail(String userId);

	List<AdminMemberRecentBoardDTO> getRecentBoardsByUserId(String userId);

	List<AdminMemberRecentReplyDTO> getRecentRepliesByUserId(String userId);
	
	long getMemberCount();
}
