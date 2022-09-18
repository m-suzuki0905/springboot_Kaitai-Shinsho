package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	/* ログイン画面を表示する */
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}
}
