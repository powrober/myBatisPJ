package com.ict.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ict.member.model.service.MemberServiceImpl;
import com.ict.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd= request.getParameter("userPwd");
		
		System.out.println("userId : " + userId + " : " + "userPwd : " + userPwd);
		
		Member mem = new Member();
		mem.setUserId(userId);
		mem.setUserPwd(userPwd);
		
		Member loginUser = new MemberServiceImpl().selectMember(mem);
		
		System.out.println("loginUser : " + loginUser);
		
		if(loginUser != null) { // 로그인에 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("msg", "로그인 실패");
			RequestDispatcher error = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			error.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
