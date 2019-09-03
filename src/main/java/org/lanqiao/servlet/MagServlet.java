package org.lanqiao.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.BigClass;
import org.lanqiao.entity.Msg;
import org.lanqiao.service.MsgServiceImpl;
import org.lanqiao.service.MsgServiceMybatisImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/index")
public class MagServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNo = 1;

        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }

        PageHelper.startPage(pageNo, 3);

        List<Msg> msgList = new MsgServiceMybatisImpl().getAllMsg(1, 3);

        PageInfo<Msg> pageInfo = new PageInfo<>(msgList);

        request.setAttribute("pageInfo", pageInfo);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
