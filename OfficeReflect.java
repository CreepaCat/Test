package com.reflect;
import java.lang.reflect.*;
import java.lang.Class;
import java.util.*;
import java.lang.reflect.Method;
/**
 * Created by ghost on 2016/10/25.
 */
public class OfficeReflect {
    public static void main(String[] args){
        Print p=new Print();
        Class c=p.getClass();
        //按顺序存储方法名
        ArrayList<String> mOder=new ArrayList<String>();
        //ArrayList A=new ArrayList();
        //java.lang.String a="add";


        //获得Class Print里的所有方法（包括保护的）但不包括继承的
        //getMethod可获得继承方法
        Method[] m=c.getDeclaredMethods();
        //Field[] f=c.getFields();
        Field[] f=c.getDeclaredFields();
        for(Field field:f){
            //此处getType得到一个Class类
            System.out.print("成员变量类型" + field.getType().getName() + " ");
            System.out.println("变量名：" + field.getName());
        }
        for(int i=0;i<m.length;i++) {
            int j = 0;
            mOder.add(m[i].getName());
            System.out.println("返回值类型：" + m[i].getReturnType().toString());
            System.out.println("方法名：" + m[i].getName());
            System.out.println("==========================");
            System.out.println(mOder.get(i));
            /*获得参数类型列表，返回一个Class集合*/
            Class[] paramTypes = m[i].getParameterTypes();
            for (Class paramType : paramTypes) {
                j++;
                System.out.print("参数" + j + ":(" + paramType.getName() + ")");
               // Field f=m[i]


            }
            System.out.println("\n");


            }


            System.out.println("\n");
        //调用方法
        Object o;
        //getMethod只能获得public方法
        //getDeclaredMethod可获得自定义方法(不包括继承方法)
        try {
            Method c1=c.getDeclaredMethod("print", String.class, String.class);
            Method c2=c.getDeclaredMethod("print",int.class,int.class);
           // Method c1=c.getDeclaredMethod();
            try {
                c1.invoke(p, "hello","World");
                c2.invoke(p, 2,3);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //Object接收返回类型


        //System.out.println("方法名："+c.getName());
        //  System.out.println("参数列表");


        }//main

    }



class Print{
    public int c=3;
    String d="str";
     void print(String a,String b){

        System.out.println(a.toUpperCase()+b.toLowerCase()+c);

    }

    void print(int a,int b){
        System.out.println(a+b);
    }

}