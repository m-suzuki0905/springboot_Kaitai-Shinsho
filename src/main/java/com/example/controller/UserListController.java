package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserListController {

	// ユーザー一覧画面を表示する
	@GetMapping("/list")
	public String getUserList() {
		// ユーザー一覧画面を返却
		return "user/list";
	}
}
