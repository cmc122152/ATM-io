package com.feicuiedu.atm;

import com.feicuiedu.atm.core.RequestMap;
import com.feicuiedu.atm.view.LoginView;

public class Test {

	private static final RequestMap RequestMap = null;

	public static void main(String[] args) {
		LoginView lv=new LoginView();
		lv.view(RequestMap);
	}

}
