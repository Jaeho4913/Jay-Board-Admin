package com.example.boardadmin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.boardadmin.dto.AdminMemberDTO;

@Mapper
public interface AdminMemberMapper {
	AdminMemberDTO findByAdminId(@Param("adminId") String adminId);
}
