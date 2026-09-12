package com.example.boardadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boardadmin.dto.AdminBoardGroupDTO;
import com.example.boardadmin.service.AdminBoardGroupService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/categories")
public class AdminBoardGroupController {
	private final AdminBoardGroupService adminBoardGroupService;
	
	@GetMapping
	public String getBoardGroupList(Model model) {
		model.addAttribute("boardGroupList", adminBoardGroupService.getBoardGroupList());
		return "admin/category/category";
	}
	
	@GetMapping("/new")
	public String createNewBoard(Model model) {
		AdminBoardGroupDTO adminBoardGroupDTO = new AdminBoardGroupDTO();
		model.addAttribute("boardGroup", adminBoardGroupDTO);
		return "admin/category/form";
	}
	
	@ResponseBody
	@PostMapping
	public String createBoardGroup(AdminBoardGroupDTO boardGroup) {
		int result = adminBoardGroupService.createBoardGroup(boardGroup);
		
		if(result == 1) {
			return "success";
		}
		
		return "fail";
	}
	
	@GetMapping("/{boardGroupIdx}/edit")
	public String showEditForm(
			@PathVariable("boardGroupIdx") Integer boardGroupIdx,
			Model model) {
		AdminBoardGroupDTO boardGroup = adminBoardGroupService.getBoardGroup(boardGroupIdx);
		model.addAttribute("boardGroup", boardGroup);
		return "admin/category/form";
	}
	
	@ResponseBody
	@PostMapping("/{boardGroupIdx}")
	public String updateBoardGroup(
			@PathVariable("boardGroupIdx") Integer boardGroupIdx,
			AdminBoardGroupDTO boardGroup) {
		boardGroup.setBoardGroupIdx(boardGroupIdx);
		int result = adminBoardGroupService.updateBoardGroup(boardGroup);
		
		if(result == 1) {
			return "success";
		}
		
		return "fail";
	}
}
