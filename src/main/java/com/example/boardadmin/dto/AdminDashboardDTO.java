package com.example.boardadmin.dto;

import lombok.Data;

@Data
public class AdminDashboardDTO {

	private int totalMemberCount;
	private int totalBoardCount;
	private int totalReplyCount;
	private int totalLikeCount;

	private int monthMemberCount;
	private int monthBoardCount;
	private int monthReplyCount;
	private int monthLikeCount;
}
