package com.example.boardadmin.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminMemberRecentBoardDTO {
	
	private Long idx;
	private String title;
	private LocalDateTime createdAt;
	private Long likeCount;
	private Long replyCount;
}
