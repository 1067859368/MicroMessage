package com.nb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Page;

import service.QueryService;

import bean.Message;

/**
 * 
 * �б�ҳ���ʼ������
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//���ñ���
			req.setCharacterEncoding("UTF-8");
			//����ҳ���ֵ
			String command = req.getParameter("command");
			String description = req.getParameter("description");
			String currentPage  = req.getParameter("currentPage");
			//������ҳ����
			Page page = new Page();
			Pattern pattern = Pattern.compile("[0-9]{1,9}");
			if(currentPage == null || !pattern.matcher(currentPage).matches()){
				page.setCurrentPage(1);
			} else{
				page.setCurrentPage(Integer.valueOf(currentPage));
			}
			
			QueryService queryService =new QueryService();
			//��ѯ��Ϣ�б�����ҳ��
			req.setAttribute("messageList",queryService.queryMessageListByPage(command, description,page));
			//��ҳ�洫ֵ
			req.setAttribute("command", command);
			req.setAttribute("description",description);
			req.setAttribute("page",page);
			//��ҳ����ת
			req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
