package com.example.boardadmin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.boardadmin.dto.AdminBoardGroupDTO;
import com.example.boardadmin.mapper.AdminBoardGroupMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminBoardGroupServiceImpl implements AdminBoardGroupService {
	private final AdminBoardGroupMapper adminBoardGroupMapper;

	@Override
	public List<AdminBoardGroupDTO> getBoardGroupList() {
		return adminBoardGroupMapper.findAll();
	}

	@Override
	public int createBoardGroup(AdminBoardGroupDTO boardGroup) {
		return adminBoardGroupMapper.insert(boardGroup);
	}

	@Override
	public AdminBoardGroupDTO getBoardGroup(Integer boardGroupIdx) {
		return adminBoardGroupMapper.findById(boardGroupIdx);
	}

	@Override
	public int updateBoardGroup(AdminBoardGroupDTO boardGroup) {
		return adminBoardGroupMapper.update(boardGroup);
	}

	@Override
	public int deleteBoardGroup(Integer boardGroupIdx) {
		long boardCount = adminBoardGroupMapper.countBoardByGroupIdx(boardGroupIdx);

		if (boardCount > 0) {
			return 0;
		} else {
			return adminBoardGroupMapper.deleteById(boardGroupIdx);
		}
	}
}
