package org.lanqiao.servlet;

import org.lanqiao.entity.Msg;
import org.lanqiao.service.MsgServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/insert")
public class InsertMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.	设置request编码
        request.setCharacterEncoding("utf-8");
//        2.	获得表单数据
        String name = request.getParameter("author");
        String msg = request.getParameter("message");
//        3.	封装对象
        Msg msg1 = new Msg();
        msg1.setMsg(msg);
        msg1.setName(name);
//        4.	调用service方法
        new MsgServiceImpl().insertMsg(msg1);
//        5.	页面跳转
        response.sendRedirect("/index");

    }

}
