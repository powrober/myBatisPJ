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

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/bUpdate.bo")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("bId : " + bId + "title : " + title + ", " + "content : " + content);
		
		Board b = new Board();
		b.setbId(bId);
		b.setbTitle(title);
		b.setbContent(content);
		
		BoardService bService = new BoardServiceImpl();
		
		int result = bService.updateBoardDetail(b);
		
		System.out.println(result);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/list.bo");
		}else {
			request.setAttribute("msg", "게시글 수정에 실패하였습니다.");
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
