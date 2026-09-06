package com.example.boardadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.boardadmin.dto.AdminMemberListDTO;
import com.example.boardadmin.dto.AdminMemberRecentBoardDTO;
import com.example.boardadmin.dto.AdminMemberRecentReplyDTO;
import com.example.boardadmin.dto.AdminMemberSearchDTO;

@Mapper
public interface AdminMemberManageMapper {
	List<AdminMemberListDTO> findMemberList(AdminMemberSearchDTO searchDTO);
	List<AdminMemberRecentBoardDTO> findRecentBoardsByUserId(
		@Param("userId") String userId
	);
	List<AdminMemberRecentReplyDTO> findRecentRepliesByUserId(
		@Param("userId") String userId
	);
	AdminMemberListDTO findMemberDetail(
		@Param("userId") String userID
	);
	long countMembers();
}
