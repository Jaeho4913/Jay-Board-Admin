package com.example.boardadmin.exception;

import java.lang.RuntimeException;

public class  MemberNotFoundException extends RuntimeException {
	public MemberNotFoundException(String userId) {
		super("회원을 찾을 수 없습니다: " + userId);
	}
}
