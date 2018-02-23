package com.feicuiedu.atm.util;

public class ColumnModel {

    // 列的key 必须与entity的变量名称完全一致
    private String key;

    // 列名
    private String desc;

    // 所占用的长度
    private int length;

    // 列的类型
    private Class type;

    public ColumnModel() {
    }

    public ColumnModel(String key, String desc, int length, Class type) {
        this.key = key;
        this.desc = desc;
        this.length = length;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}
