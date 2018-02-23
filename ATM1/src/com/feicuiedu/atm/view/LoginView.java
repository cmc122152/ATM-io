package com.feicuiedu.atm.view;

import com.feicuiedu.atm.core.AbstractView;
import com.feicuiedu.atm.core.RequestMap;
import com.feicuiedu.atm.exception.MyException;
import com.feicuiedu.atm.util.CommonUtils;

import java.io.IOException;
import java.util.Scanner;

public class LoginView extends AbstractView{

    @Override
    public void view(RequestMap request) {
        try {
            CommonUtils.printFromFile("login.txt");
        } catch (MyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        // 处理用户和密码的业务


        if ("1".equals(input)) {

            request.setDispatherPath("AdminMenuView");
        }
        else if ("2".equals(input)){
            request.setDispatherPath("UserMenuView");
        }
        else {
            request.setDispatherPath("LoginView");
        }
    }
}
