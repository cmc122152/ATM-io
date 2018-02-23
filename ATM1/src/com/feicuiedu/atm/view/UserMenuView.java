package com.feicuiedu.atm.view;

import com.feicuiedu.atm.core.AbstractView;
import com.feicuiedu.atm.core.RequestMap;
import com.feicuiedu.atm.exception.MyException;
import com.feicuiedu.atm.util.CommonUtils;

import java.io.IOException;
import java.util.Scanner;

public class UserMenuView extends AbstractView {

    @Override
    public void view(RequestMap request) {
        try {
            CommonUtils.printFromFile("menu_user.txt");
        } catch (MyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if ("e".equals(input)) {
            request.setDispatherPath("LoginView");
        }
    }
}
