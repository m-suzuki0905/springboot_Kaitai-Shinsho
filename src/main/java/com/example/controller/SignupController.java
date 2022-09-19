package com.example.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;

@Controller
@RequestMapping("/user")
public class SignupController {
	@Autowired
	private UserApplicationService userApplicationService;

	/* ユーザー登録画面を表示する */
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale) {
		// 性別を取得する
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);

		// ユーザー登録画面に遷移させる
		return "user/signup";
	}

	/* ユーザーの登録処理 */
	@PostMapping("/signup")
	public String postSigup() {
		return "redirect:/login";
	}
}
