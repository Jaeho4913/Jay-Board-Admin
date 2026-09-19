package com.example.boardadmin.service;

import java.util.List;

import com.example.boardadmin.dto.AdminBoardGroupDTO;

public interface AdminBoardGroupService {
	List<AdminBoardGroupDTO> getBoardGroupList();
	int createBoardGroup(AdminBoardGroupDTO boardGroup);
	AdminBoardGroupDTO getBoardGroup(Integer boardGroupIdx);
	int updateBoardGroup(AdminBoardGroupDTO boardGroup);
	int deleteBoardGroup(Integer boardGroupIdx);
}
