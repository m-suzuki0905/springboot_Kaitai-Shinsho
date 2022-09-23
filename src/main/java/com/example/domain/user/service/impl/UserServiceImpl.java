package com.example.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	/* ユーザー登録処理 */
	@Override
	public void signup(MUser user) {
		user.setDepartmentId(1); // 部署
		user.setRole("ROLE_GENGERAL"); // ロール
		mapper.insertOne(user);
	}

	/* ユーザー取得 */
	@Override
	public List<MUser> getUsers() {
		return mapper.findMany();
	}

	/* ユーザー取得 1件 */
	@Override
	public MUser getUserOne(String userId) {
		return mapper.findOne(userId);
	}

	/* ユーザー更新 1件 */
	@Override
	public void updateUserOne(String userId, String password, String userName) {
		// TODO 自動生成されたメソッド・スタブ
		mapper.updateOne(userId, password, userName);
	}

	/* ユーザー削除 1件 */
	@Override
	public void deleteUserOne(String userId) {
		int count = mapper.deleteOne(userId);
	}
}
