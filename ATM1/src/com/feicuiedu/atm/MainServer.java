package com.feicuiedu.atm;

import com.feicuiedu.atm.core.AbstractView;
import com.feicuiedu.atm.core.RequestMap;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.exception.MyException;
import com.feicuiedu.atm.util.CommonUtils;

import java.io.IOException;


public class MainServer {

   
	public static void main(String[] args) {

		RequestMap requestMap = new RequestMap();

        requestMap.setDispatherPath("LoginView");


        while (true) {

            AbstractView av = requestMap.forward();
            av.view(requestMap);
        }


    }

    public static void initData() {

        User user = new User("admin","admin","0");

        try {
            CommonUtils.writeObjectToFile("data",user);
        } catch (MyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
