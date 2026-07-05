package com.example.boardadmin.service;

import org.springframework.stereotype.Service;

import com.example.boardadmin.dto.AdminDashboardDTO;
import com.example.boardadmin.mapper.AdminDashboardMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminDashboardService {

	private final AdminDashboardMapper adminDashboardMapper;

	public AdminDashboardDTO getDashboard() {

		AdminDashboardDTO dashboard = new AdminDashboardDTO();

		dashboard.setTotalMemberCount(adminDashboardMapper.countTotalMember());
		dashboard.setTotalBoardCount(adminDashboardMapper.countTotalBoard());
		dashboard.setTotalReplyCount(adminDashboardMapper.countTotalReply());
		dashboard.setTotalLikeCount(adminDashboardMapper.countTotalLike());

		dashboard.setMonthMemberCount(adminDashboardMapper.countMonthMember());
		dashboard.setMonthBoardCount(adminDashboardMapper.countMonthBoard());
		dashboard.setMonthReplyCount(adminDashboardMapper.countMonthReply());
		dashboard.setMonthLikeCount(adminDashboardMapper.countMonthLike());

		return dashboard;
	}
}
