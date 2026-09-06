package com.example.boardadmin.dto;

import lombok.Data;

@Data
public class AdminMemberSearchDTO {
	private Integer page = 1;
	private Integer size = 10;

	public int getOffset() {
		return (page - 1) * size;
	}
}
