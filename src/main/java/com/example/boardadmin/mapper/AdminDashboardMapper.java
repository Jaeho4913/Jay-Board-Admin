package com.example.boardadmin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDashboardMapper {

	int countTotalMember();

	int countTotalBoard();

	int countTotalReply();

	int countTotalLike();

	int countMonthMember();

	int countMonthBoard();

	int countMonthReply();

	int countMonthLike();
}
