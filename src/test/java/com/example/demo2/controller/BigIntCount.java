package com.example.demo2.controller;

import java.util.ArrayList;

/**
 * @author Misaki
 * @date 2019/1/31/031 11:35
 **/
public class BigIntCount {

    public void count1(String parameter1, String parameter2) {
        //长短比较
        ArrayList<String> result = new ArrayList<>();
        int length = 0;
        String longString = "";
        if (parameter1.length() < parameter2.length()) {
            length = parameter1.length();
            longString = parameter2;
        } else if (parameter1.length() > parameter2.length()) {
            length = parameter2.length();
            longString = parameter1;
        } else {
            length = parameter2.length();
        }
        int temp = 0;
        int coount = 1;
        //以少数位置全数相加
        while (coount <= length) {
            int numericValue1 = Character.getNumericValue(parameter1.charAt(parameter1.length() - coount));
            int numericValue2 = Character.getNumericValue(parameter2.charAt(parameter2.length() - coount));
            int temp2 = numericValue1 + numericValue2 + temp;
            temp = 0;
            result.add(Integer.toString(temp2 % 10));
            if (temp2 > 9) {
                temp = 1;
            }
            coount++;
        }
        coount = 0;
        //剩余大数部分相加
        if (temp != 0) {
            if (!longString.equals("")) {
                int longStringLength = longString.length() - 1 - length;
                while (coount <= longStringLength && temp != 0) {
                    int numericValue = Character.getNumericValue(longString.charAt(longStringLength - coount));
                    numericValue += temp;
                    temp = 0;
                    result.add(Integer.toString(numericValue % 10));
                    if (numericValue > 9) {
                        temp = 1;
                    }
                    coount++;
                }
                if (coount < longStringLength)
                    result.add(longString.substring(0, longStringLength - 1 - coount));
                if (temp != 0)
                    result.add(Integer.toString(temp));
            } else {
                result.add(Integer.toString(temp));
            }

        }
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i));
        }
    }

    public static void main(String[] args) {
        new BigIntCount().count1("999999999", "1");
        new BigIntCount().count1("999999999", "999999999");

    }
}
