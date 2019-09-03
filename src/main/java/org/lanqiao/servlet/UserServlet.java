package org.lanqiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {

    //生命周期分4个
    /*
    第一次访问的时候进行实例化和初始化
     */

    //1.实例化，调用构造方法
    public UserServlet(){
        System.out.println("实例化");
    }
    //2.初始化
    public void init(){
        System.out.println("初始化");
    }
    //3.服务
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //3.服务
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("服务");
        PrintWriter p = response.getWriter();
        p.print("hello World baobeier");
        p.print("dsadf");
        p.print("ewrty");
        p.print("ewrty");
        p.print("ewrty");
        p.flush();
        p.close();
    }

    //4.销毁
    public void destroy(){
        System.out.println("销毁");
    }

}
