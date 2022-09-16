package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hello.HelloService;

@Controller
public class HelloController {

	@Autowired
	public HelloService service;

	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	};

	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1") String str, Model model) {

		model.addAttribute("sample", str);

		return "hello/response";
	}

	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2") String id, Model model) {
		/* 1件検索 */
		Employee employee = service.getEmployee(id);

		/* 検索結果をモデルに登録する */
		model.addAttribute("employee", employee);

		/* db.htmlへ反映させる */
		return "hello/db";

	}
};
