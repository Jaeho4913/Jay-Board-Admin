package com.example.boardadmin.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AdminMemberListDTO {

	private String userId;
	private String userName;
	private String email;
	private LocalDateTime createdAt;

	private int boardCount;
	private int replyCount;
	private int likeCount;
}
