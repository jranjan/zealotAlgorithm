/*
 * ********************************************************************************************************************
 *  Copyright(c) 2022, Jyoti Ranjan (jranjan@gmail.com) and his associates. All rights reserved.
 *
 * *******************************************************************************************************************
 */

package main.java.com.zealot.language;

public class AppSampleDummyProduct {
    private final String name;

    public AppSampleDummyProduct(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        AppSampleDummyProduct p = new AppSampleDummyProduct(("Car"));
        System.out.println(p.getName());
    }
}
