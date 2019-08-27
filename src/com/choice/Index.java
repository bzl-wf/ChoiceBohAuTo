package com.choice;



public class Index {
    public  static void main(String args[]) throws InterruptedException {
        /**
         * 调用构造方法,入参
         * 调用登录方法
         */
        Login log = new Login();
        log.setUrl("http://172.16.7.10:18832/ChoiceBoh/login/loginIn.do");
        log.setName("admin");
        log.setPwd("choice@all2018");
        log.loginMethod();



    }
}
