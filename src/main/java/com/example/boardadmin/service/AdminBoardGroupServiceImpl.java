package com.example.boardadmin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.boardadmin.dto.AdminBoardGroupDTO;
import com.example.boardadmin.exception.BoardGroupNotFoundException;
import com.example.boardadmin.mapper.AdminBoardGroupMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminBoardGroupServiceImpl implements AdminBoardGroupService {
	private final AdminBoardGroupMapper adminBoardGroupMapper;

	private void validateBoardGroup(AdminBoardGroupDTO boardGroup) {
		String boardGroupName = boardGroup.getBoardGroupName();

		if (boardGroupName == null || boardGroupName.isBlank()) {
			throw new IllegalArgumentException("게시판명을 입력해주세요.");
		} else if (boardGroupName.length() > 50) {
			throw new IllegalArgumentException("게시판명은 50자 이내로 입력해주세요.");
		}

		String description = boardGroup.getDescription();

		if (description != null && description.length() > 255) {
			throw new IllegalArgumentException("설명은 255자 이내로 입력해주세요.");
		}

		Integer sortOrder = boardGroup.getSortOrder();

		if (sortOrder == null || sortOrder < 0) {
			throw new IllegalArgumentException("정렬 순서는 0 이상으로 입력해주세요.");
		}

		Boolean active = boardGroup.getActive();

		if (active == null) {
			throw new IllegalArgumentException("활성 상태를 선택해주세요.");
		}
	}

	@Override
	public List<AdminBoardGroupDTO> getBoardGroupList() {
		return adminBoardGroupMapper.findAll();
	}

	@Override
	public int createBoardGroup(AdminBoardGroupDTO boardGroup) {
		validateBoardGroup(boardGroup);
		
		return adminBoardGroupMapper.insert(boardGroup);
	}

	@Override
	public AdminBoardGroupDTO getBoardGroup(Integer boardGroupIdx) {

		AdminBoardGroupDTO boardGroup = adminBoardGroupMapper.findById(boardGroupIdx);

		if (boardGroup == null) {
			throw new BoardGroupNotFoundException(boardGroupIdx);
		}

		return boardGroup;
	}

	@Override
	public int updateBoardGroup(AdminBoardGroupDTO boardGroup) {
		getBoardGroup(boardGroup.getBoardGroupIdx());
		validateBoardGroup(boardGroup);
		
		return adminBoardGroupMapper.update(boardGroup);
	}

	@Override
	public int deleteBoardGroup(Integer boardGroupIdx) {
		getBoardGroup(boardGroupIdx);

		long boardCount = adminBoardGroupMapper.countBoardByGroupIdx(boardGroupIdx);

		if (boardCount > 0) {
			return 0;
		}
		return adminBoardGroupMapper.deleteById(boardGroupIdx);
	}
}
