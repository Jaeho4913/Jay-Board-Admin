package com.example.boardadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.boardadmin.service.AdminMemberManageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/members")
public class AdminMemberController {

	private final AdminMemberManageService adminMemberManageService;

	@GetMapping
	public String memberList(Model model) {
		model.addAttribute("memberList", adminMemberManageService.getMemberList());
		return "admin/member/list";
	}
}
