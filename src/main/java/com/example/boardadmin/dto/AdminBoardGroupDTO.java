package com.example.boardadmin.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AdminBoardGroupDTO {
	private Integer boardGroupIdx;
	private String boardGroupName;
	private String description;
	private Integer sortOrder;
	private Boolean active;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
