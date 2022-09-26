package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {

	/*
	 * サービスの実行前にログ出力する. 対象:[UserService]をクラス名に含んでいるもの
	 */
	@Before("execution(* *..*.*UserService.*(..))")
	public void startLog(JoinPoint jp) {
		log.info("メソッド開始:" + jp.getSignature());
	}

	/*
	 * サービスの実行後にログ出力する. 対象:[UserService]をクラス名に含んでいるもの
	 */
	@After("execution(* *..*.*UserService.*(..))")
	public void endLog(JoinPoint jp) {
		log.info("メソッド終了:" + jp.getSignature());
	}

	/*
	 * コントローラー全ての実行前後にログを出力する 以下でbeanとアノテーションの直接指定もいける
	 */
	// @Around("bean(*Controller*)")
	// @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	@Around("@within(org.springframework.stereotype.Controller)")
	public Object startLog(ProceedingJoinPoint jp) throws Throwable {
		// 開始ログ出力
		log.info("メソッド開始:" + jp.getSignature());

		try {
			// メソッド実行
			Object result = jp.proceed();

			// 終了ログ出力
			log.info("メソッド終了:" + jp.proceed());

			// 実行結果を呼び出し元に返却する
			return result;
		} catch (Exception e) {
			// エラーログ出力
			log.error("メソッド異常終了:" + jp.getSignature());

			// エラーを再度スローする
			throw e;
		}
	}
}
