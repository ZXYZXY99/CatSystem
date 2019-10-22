package com.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginTest {

    @Autowired
    private DoDateBase doDateBase;
    @Autowired
    private SessionFactory sessionFactory;



    public  void login(){
        System.out.println(doDateBase);
        System.out.println(sessionFactory);
    }


}
