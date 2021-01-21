package com.ict.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.board.model.service.BoardService;
import com.ict.board.model.service.BoardServiceImpl;
import com.ict.board.model.vo.Board;
import com.ict.board.model.vo.PageInfo;
import com.ict.common.Pagination;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService bService = new BoardServiceImpl();
	
		int currentPage = 1; 
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = bService.getListCount();
		System.out.println("listCount : " + listCount);
		
		// Pagination의 getPageInfo메소드로 currentPage, listCount 전달 --> PageInfo 객체 리턴
		
		// static이 붙은 메소드는 클래스명.메소드명으로 호출한다.
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);  
		
		ArrayList<Board> list = bService.selectBoardList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
