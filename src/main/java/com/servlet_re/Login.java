package com.servlet_re;

import com.entity.UserEntity;
import com.service.DoDateBase;
import com.service.LoginTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "login",urlPatterns = {"/login"})
//@Controller
public class Login extends HttpServlet {


    @Autowired
    private DoDateBase doDateBase;
    @Autowired
    private SessionFactory sessionfactory;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,getServletContext());

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        UserEntity userEntity=new UserEntity();
        PrintWriter pr=response.getWriter();



        String name=request.getParameter("username");
        String pass=request.getParameter("pass");
        userEntity.setUsername(name);
        userEntity.setPassword(pass);
        System.out.println(name+pass);

        List<UserEntity> list =doDateBase.queryLogin(userEntity);


        System.out.println();
        if (list.size()!=1){
                response.sendRedirect("lo_re.html");
                pr.write("<script>alret('撒打撒打撒')</script>");
        }else {
            System.out.println("登陆成功");
            for (UserEntity user :list) {
                request.setAttribute("username",user.getUsername());
                request.setAttribute("pass",user.getPassword());
            }


            request.getRequestDispatcher("luntan.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
