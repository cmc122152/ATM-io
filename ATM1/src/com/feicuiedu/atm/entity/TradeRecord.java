package com.feicuiedu.atm.entity;

import java.io.Serializable;
import java.util.Date;

public class TradeRecord implements Serializable{

    // 交易账户
    private String sourceAccount;

    // 交易类型 1:存款 2:取款 3: 转账支出  4: 转账收入
    private String tradeType;

    // 交易金额
    private Double tradeAmount;

    // 目标账户
    private String targetAccount;

    // 交易时间
    private Date tradeTime;

    // 交易前余额
    private Double beforeAmount;

    // 交易后余额
    private Double afterAmount;

    public TradeRecord(String sourceAccount, String tradeType, Double tradeAmount, String targetAccount, Date tradeTime,
                       Double beforeAmount, Double afterAmount) {

        this.sourceAccount = sourceAccount;
        this.tradeType = tradeType;
        this.tradeAmount = tradeAmount;
        this.targetAccount = targetAccount;
        this.tradeTime = tradeTime;
        this.beforeAmount = beforeAmount;
        this.afterAmount = afterAmount;
    }
}
