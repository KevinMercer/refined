package com.tina.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexTest {

	public RexTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String rex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher("1870441612@qq.voc");
		if (matcher.find()) {
			System.out.println("success！");
		} else {
			System.out.println("failed");
		}
	}

}
