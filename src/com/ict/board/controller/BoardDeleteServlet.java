package com.ict.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.board.model.service.BoardService;
import com.ict.board.model.service.BoardServiceImpl;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/bDelete.bo")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		System.out.println("bId 확인 : " + bId);
		
		BoardService bService = new BoardServiceImpl();
		
		int result = bService.deleteBoard(bId);
		
		System.out.println("result 결과 확인 : " + result);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/list.bo");
		}else {
			request.setAttribute("msg", "게시글 삭제에 실패하였습니다.");
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
