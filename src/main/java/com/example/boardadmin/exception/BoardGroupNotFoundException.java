package com.example.boardadmin.exception;

public class BoardGroupNotFoundException extends RuntimeException{
	public BoardGroupNotFoundException(Integer boardGroupIdx) {
		super("게시판을 찾을 수 없습니다: " + boardGroupIdx);
	}
}
