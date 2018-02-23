package com.feicuiedu.atm.util;

import com.feicuiedu.atm.exception.MyException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class TableModel {

    private String tableName;
    private List<ColumnModel> listColumns;
    private List<?> listData;



    public TableModel(String tableName, List<ColumnModel> listColumns, List<?> listData) throws MyException {
        this.tableName = tableName;
        this.listColumns = listColumns;
        this.listData = listData;

        if (listColumns == null) {
            throw new MyException("列名必须设定");
        }
    }

    public String getTableName() {
        return tableName;
    }


    public List<ColumnModel> getListColumns() {
        return listColumns;
    }

    public List<?> getListData() {
        return listData;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (!CommonUtils.strIsNull(tableName)) {
            sb.append(tableName).append("\n").append("----------------------------------------").append("\n");
        }
        sb.append("序号");
        for (ColumnModel model:listColumns) {
            sb.append(":").append( model.getDesc());
        }
        sb.append("\n");
        if (CommonUtils.collectionIsNull(listData)) {
            sb.append("查无资料!");
            return sb.toString();
        }

        for (int i = 0; i < listData.size(); i++) {
           Object data = listData.get(i);
            sb.append(i);
            for (ColumnModel model:listColumns) {
                String key = model.getKey();
                String methodName = "get" + key.substring(0, 1).toUpperCase() + key.substring(1);
                String value = null;
                try {

                    Method method = data.getClass().getDeclaredMethod(methodName);
                    Object object = method.invoke(data);

                    if (object == null) {
                        sb.append(":     ");
                    } else {
                        sb.append(":" + object.toString());
                    }

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            sb.append("\n");
        }

        sb.append("----------------------------------------").append("\n");
        sb.append("一共"+listData.size()+"笔\n");

        return sb.toString();
    }
}
