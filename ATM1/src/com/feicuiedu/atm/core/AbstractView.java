package com.feicuiedu.atm.core;

import com.feicuiedu.atm.entity.User;

public abstract class AbstractView {

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    public abstract void view(RequestMap request);

}