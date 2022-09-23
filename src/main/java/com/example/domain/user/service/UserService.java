package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.MUser;

public interface UserService {
	// ユーザー登録メソッド
	public void signup(MUser user);

	// ユーザー取得
	public List<MUser> getUsers();

	// ユーザー取得(1件)
	public MUser getUserOne(String userId);

	// ユーザー取得(1件)
	public void updateUserOne(String userId, String password, String userName);

	// ユーザー取得(1件)
	public void deleteUserOne(String userId);
}
