package com.feicuiedu.atm.util;

import com.feicuiedu.atm.exception.MyException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

public class CommonUtils {

    /**
     * 判断字符串如果""或者是null
     *
     * @param str
     * @return ""或者null 返回true 反之返回false
     */
    public static boolean strIsNull(String str) {

        boolean result = false;
        if (str == null || "".equals(str)) {
            result = true;
        }
        return result;
    }

    /**
     * 判断collection 是否为空<br>
     *
     * @param collection
     * @return collection 的 个数是0或者collection 是null的时候 返回true 反之返回false
     */
    public static boolean collectionIsNull(Collection collection) {

        boolean result = false;
        if (collection == null || collection.isEmpty()) {
            result = true;
        }
        return result;
    }

    /**
     * 判断map是否为空<br>
     *
     * @param map
     * @return map为null或者map中没有元素返回true 反之返回false
     */
    public static boolean mapIsNull(Map<Object, Object> map) {

        boolean result = false;
        if (map == null && map.isEmpty()) {
            result = true;
        }
        return result;
    }

    /**
     * 把值为null的字符串转为""
     *
     * @param str
     * @return ""字符串
     */
    public static String strNullToEmpty(String str) {
        if (str == null) {
            str = "";
        }

        return str;
    }

    /**
     * 从fileName文件中读取对象
     *
     * @param fileName
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object readObjectFromFile(String fileName) throws IOException, ClassNotFoundException {

        //System.out.println("write="+CommonUtils.class.getClassLoader().getResource("data").getFile());
        InputStream is = CommonUtils.class.getClassLoader().getResourceAsStream("data");

        if (is.available() != 0) {
            return null;
        }

        ObjectInputStream ois = new ObjectInputStream(is);

        return ois.readObject();
    }

    /**
     * 把data写入到fileName文件中
     *
     * @param fileName
     * @param data
     * @throws MyException
     * @throws IOException
     */
    public static void writeObjectToFile(String fileName, Object data) throws MyException, IOException {

        File file = readFileFromRecources(fileName);

        FileOutputStream fos = new FileOutputStream(file);

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(data);
    }

    /**
     * 被显示文件的名字
     *
     * @param fileName
     */
    public static void printFromFile(String fileName) throws MyException, IOException {
        File file = readFileFromRecources(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        while (true) {
            String strReader = br.readLine();

            if (strReader != null) {
                System.out.println(strReader);
            }

            if (strReader == null) {
                break;
            }
        }
    }

    public static String getValueFromProp(String key) throws IOException {

        Properties prop = new Properties();

        prop.load(CommonUtils.class.getClassLoader().getResourceAsStream("config.properties"));

        String value = prop.getProperty(key);

        return value;
    }
    public static void printFromProp(String key) throws IOException {



        String value = getValueFromProp(key);

        System.out.println(value);
    }
    /**
     * 从text 路径总读取fileName
     *
     * @param fileName 文件名字
     * @return File
     * @throws MyException
     */
    private static File readFileFromRecources(String fileName) throws MyException {

        String filePath = CommonUtils.class.getClassLoader().getResource(fileName).getFile();
        //System.out.println("write="+filePath);
        File file = new File(filePath);

        if (!file.exists()) {
            throw new MyException(fileName + "不存在");
        }

        return file;
    }

    /**
     * 根据key从config.properties中读取类型名获取实例
     * @param key
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static Object reflectInstanceFromProp(String key) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        String className = getValueFromProp(key);

        return reflectInstanceFromClassName(className);
    }

    /**
     * 根据类名获取类的实例
     * @param className
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object reflectInstanceFromClassName(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object instance = Class.forName(className).newInstance();

        return instance;
    }

    public static void main(String[] args) {

        /*List<String> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add("a"+i);
        }
        try {
            CommonUtils.writeObjectToFile("data",list);
            Object obj = CommonUtils.readObjectFromFile("data");
            System.out.println(obj);
            List<String> lst = (List<String>) obj;
            lst.add("afd");
            lst.add("100");
            CommonUtils.writeObjectToFile("data",lst);
            obj = CommonUtils.readObjectFromFile("data");
            System.out.println(">>>>"+obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }*/

       /* try {
            printFromFile("login.txt");
        } catch (MyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            readObjectFromFile("user.data");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
