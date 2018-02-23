package com.feicuiedu.atm.core;

import com.feicuiedu.atm.exception.MyException;
import com.feicuiedu.atm.util.CommonUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> {

    private String fileName;

   
	public AbstractDao() {

        fileName = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                .getSimpleName().toLowerCase();
       //System.out.println(fileName);
    }

    public void save(T t) throws IOException, MyException, ClassNotFoundException {

        List<T> list = (List<T>) CommonUtils.readObjectFromFile(fileName);

        if (CommonUtils.collectionIsNull(list)) {
            list = new ArrayList<>();
        }

        list.add(t);
        CommonUtils.writeObjectToFile(fileName,t);
    }

    public List<T> findAll() throws IOException, ClassNotFoundException {
        List<T> list = (List<T>) CommonUtils.readObjectFromFile(fileName);

        return list;
    }
}
