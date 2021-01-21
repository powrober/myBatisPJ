package com.ict.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.board.model.service.BoardService;
import com.ict.board.model.service.BoardServiceImpl;
import com.ict.board.model.vo.Board;
import com.ict.member.model.vo.Member;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/bInsert.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		int bWriter = loginUser.getmId();
		String content = request.getParameter("content");
		
		
		Board b = new Board();
		b.setbWriter(bWriter);
		b.setbTitle(title);
		b.setbContent(content);
		
		System.out.println("입력할 정보 : " + b.toString());
		
		BoardService bService = new BoardServiceImpl();
		
		int result = bService.insertBoard(b);
		
		System.out.println("result : " + result);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/list.bo");
		}else {
			request.setAttribute("msg", "게시글 등록에 실패하였습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
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
