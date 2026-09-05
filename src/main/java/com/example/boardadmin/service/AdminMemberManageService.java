package com.example.boardadmin.service;

import java.util.List;

import com.example.boardadmin.dto.AdminMemberListDTO;
import com.example.boardadmin.dto.AdminMemberRecentBoardDTO;
import com.example.boardadmin.dto.AdminMemberRecentReplyDTO;

public interface AdminMemberManageService {

	List<AdminMemberListDTO> getMemberList();

	AdminMemberListDTO getMemberDetail(String userId);

	List<AdminMemberRecentBoardDTO> getRecentBoardsByUserId(String userId);

	List<AdminMemberRecentReplyDTO> getRecentRepliesByUserId(String userId);

}
