package com.example.boardadmin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdminExceptionHandler {
	@ExceptionHandler(MemberNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleMemberNotFound(MemberNotFoundException ex, Model model) {
		model.addAttribute("message", ex.getMessage());
		return "error/404";
	}
	
	@ExceptionHandler(BoardGroupNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handlerBoardGroupNotFound(BoardGroupNotFoundException ex, Model model) {
		model.addAttribute("message", ex.getMessage());
		return "error/404";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleIllegalArgument(IllegalArgumentException ex) {
		return ex.getMessage();
	}
}
