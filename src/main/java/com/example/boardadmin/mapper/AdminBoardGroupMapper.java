package com.example.boardadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.boardadmin.dto.AdminBoardGroupDTO;

@Mapper
public interface AdminBoardGroupMapper {
	List<AdminBoardGroupDTO> findAll();
	int insert(AdminBoardGroupDTO boardGroup);
	AdminBoardGroupDTO findById(Integer boardGroupIdx);
	int update(AdminBoardGroupDTO boardGroup);
	long countBoardByGroupIdx(Integer boardGroupIdx);
	int deleteById(Integer boardGroupIdx);
}
