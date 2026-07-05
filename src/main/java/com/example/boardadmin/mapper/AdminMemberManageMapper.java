package com.example.boardadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.boardadmin.dto.AdminMemberListDTO;

@Mapper
public interface AdminMemberManageMapper {
	List<AdminMemberListDTO> findMemberList();
}
