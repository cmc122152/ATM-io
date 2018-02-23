package com.feicuiedu.atm.entity;

import java.io.Serializable;

/**
 *
 */
public class User implements Serializable {

    // 卡号
    private String account;

    // 名字
    private String username;

    // 余额
    private Double amount;

    // 
    private String sex;

    // 卡号
    private String card;

    // 类型
    private String userType;

    // 密码
    private String passwd;
    
    // 学历
	private Object education;
	
    // 地址
	private String address;
	

	private Double balance;

	private Object gender;
   // 身份证
	private Object idnumber;

    public User() {

    }

    public User(String account, String userType, String passwd) {
        this.account = account;
        this.userType = userType;
        this.passwd = passwd;
    }

    public User(String account, String passwd) {
        this.account = account;
        this.passwd = passwd;
    }

    public User(String username, Double amount, String sex) {
        this.username = username;
        this.amount = amount;
        this.sex = sex;
    }

    public User(String account, String username, Double amount, String sex, String card, String userType, String passwd) {
        this.account = account;
        this.username = username;
        this.amount = amount;
        this.sex = sex;
        this.card = card;
        this.userType = userType;
        this.passwd = passwd;
    }

    public String getAccount() {
        return account;
    }
    
	public double getBalance() {		
		return balance;
	}

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return account != null ? account.equals(user.account) : user.account == null;
    }

    @Override
    public int hashCode() {
        return account != null ? account.hashCode() : 0;
    }

	public void setEducation(String edu) {
		this.education=education;
		
	}

	public void setAddress(String address) {
		this.address=address;
		
		
	}

	public void setBalance(Double balance) {
		this.balance=balance;
		
	}

	public void setGender(String gender1) {
		this.gender=gender;
		
	}

	public void setIdNumber(String iD) {
		this.idnumber=idnumber;
		
	}

	public void setUserName(String name) {
		this.username=username;
		
	}


}
