package com.example.boardadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.boardadmin.service.AdminDashboardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

	private final AdminDashboardService adminDashboardService;

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@GetMapping({"", "/"})
	public String home(Model model) {
		model.addAttribute("dashboard", adminDashboardService.getDashboard());
		return "admin/home";
	}
}
