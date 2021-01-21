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
import com.ict.board.model.vo.SearchCondition;
import com.ict.common.Pagination;

/**
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet("/search.bo")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		String search = request.getParameter("search");
		
		System.out.println("condition : " + condition + ", " + "search : " + search );
		
		// 검색 조건을 저장하기 위한 클래스 작성 및 객체 생성
		SearchCondition sc = new SearchCondition();
		
		// 전달받은 searchCondition에 해당하는 파라미터에 따라 set함수를 이용해서 value값을 적용시키자~
		if(condition.equals("writer")) {
			sc.setWriter(search);
		}else if(condition.equals("title")) {
			sc.setTitle(search);
		}else if(condition.equals("content")) {
			sc.setContent(search);
		}
				
		// 검색에 관련된 리스트 출력 또한 페이징 처리를 위한 코드를 작성한다.
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		BoardService bService = new BoardServiceImpl();
		
		// 검색 결과에 해당되는 게시물 갯수 조회
		int listCount = bService.getSearchResultListCount(sc);
		
		System.out.println("listCount : " + listCount);
		
		// 페이지 정보가 담겨있는 PageInfo를 받기 위해서 Pagination static 함수 호출
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		// 검색 결과에 해당되는 게시물 목록을 조회
		ArrayList<Board> list = bService.selectSearchResultList(sc,pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		request.setAttribute("sc", sc);
		request.setAttribute("condition", condition);
		request.setAttribute("search", search);
		
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
