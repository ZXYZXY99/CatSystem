package com.service;

import com.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoDateBase {
    @Autowired
    private SessionFactory sessionfactoy;

    public  void addUser(UserEntity userEntity){
        Session session=sessionfactoy.getCurrentSession();
        session.save(userEntity);
//        session.close();


    }

    public List<UserEntity> queryLogin(UserEntity userEntity){
        Session session=sessionfactoy.getCurrentSession();

        String hql=" from UserEntity where username=:u and password=:p ";
        Query query=session.createQuery(hql);
        query.setString("u",userEntity.getUsername());
        query.setString("p",userEntity.getPassword());
        List<UserEntity> list=query.list();
//        session.close();

    return list;
    }




}
