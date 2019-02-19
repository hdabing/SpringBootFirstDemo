package com.example.demo.util;

import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * PO转为mybatis的example工具
 * 只可以转换数据库实体PO，该PO的子类不可用
 */
public class PoToExampleUtil {

    /**
     * 将po转为example
     * @param po
     * @return
     */
    public static Example transform(Object po) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<? extends Object> poClass = po.getClass();
        Example example = new Example(poClass);
        Example.Criteria criteria = example.createCriteria();

        //获取该PO中的字段
        Field[] fields = poClass.getDeclaredFields();
        for (Field f : fields){
            //利用反射调用字段的get方法
            Method getter = poClass.getMethod(createMethodName(f,"get"));
            Object getterResult = getter.invoke(po);
            if(null != getterResult){
                //如果字段不为空，将字段值填充进example
                criteria.andEqualTo(f.getName(),getterResult);
            }
        }

        return example;
    }

    /**
     * 获取字段的getter/setter方法名
     * @param field
     * @param type getter或setter的区分
     * @return
     */
    public static String createMethodName(Field field, String type){
        StringBuilder methodName = new StringBuilder();
        //获取字段名称
        String fieldName = field.getName();
        //将字符串首字母大写
        char[] chars = fieldName.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char)(chars[0] - 32);
        }
        //拼接方法名
        if("get".equals(type)){
            methodName = methodName.append("get").append(chars);
        }else if("set".equals(type)){
            methodName = methodName.append("set").append(chars);
        }else{
            throw new RuntimeException("---createMethodName方法--type参数错误---");
        }

        return methodName.toString();
    }
}