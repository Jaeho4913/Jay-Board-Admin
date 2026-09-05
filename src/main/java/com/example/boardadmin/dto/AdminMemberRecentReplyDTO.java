package com.example.boardadmin.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AdminMemberRecentReplyDTO {
	private Long replyIdx;
	private Long boardIdx;
	private String boardTitle;
	private String content;
	private LocalDateTime createdAt;
}
