package com.atguigu.java.test;

/**
 * @Description
 * @Author kaki
 * @create 2020-05-28-6:28 PM
 */
public class Test1 {

    public static void main(String[] args) {


        try {
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (ArithmeticException e){
            // catch时，需要将范围小的写到前面
            throw new ArithmeticException("NoGirlFriendException");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }


    }

}
