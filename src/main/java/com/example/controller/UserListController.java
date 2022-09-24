package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.UserListForm;

@Controller
@RequestMapping("/user")
public class UserListController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	// ユーザー一覧画面を表示する
	@GetMapping("/list")
	public String getUserList(@ModelAttribute UserListForm form, Model model) {

		/* formをMUserクラスに変換する */
		MUser user = modelMapper.map(form, MUser.class);

		/* ユーザーを検索して取得する */
		List<MUser> userList = userService.getUsers(user);

		/* Modelに登録する */
		model.addAttribute("userList", userList);

		// ユーザー一覧画面を返却
		return "user/list";
	}

	// ユーザー検索処理
	@PostMapping("/list")
	public String postUserList(@ModelAttribute UserListForm form, Model model) {
		/* formをMUserクラスに変換する */
		MUser user = modelMapper.map(form, MUser.class);

		/* ユーザーを検索して取得する */
		List<MUser> userList = userService.getUsers(user);

		/* Modelに登録する */
		model.addAttribute("userList", userList);

		/* ユーザー一覧画面を返却 */
		return "user/list";
	}
}
