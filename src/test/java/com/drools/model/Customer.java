package com.drools.model;

/**
 * @author sen.huang
 * @date 2018/8/2.
 * https://wenku.baidu.com/view/9776af9031b765ce04081455.html
 */
public class Customer {

    public Customer(String name, int age, Boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private String name;
    private int age;
    //true为男，false 女
    private Boolean gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
