package com.ict.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ict.board.model.vo.Board;
import com.ict.board.model.vo.PageInfo;
import com.ict.board.model.vo.SearchCondition;

public class BoardDao {

	/**
	 * 1_1. 게시판 총 갯수 조회용
	 * @param session
	 * @return int
	 */
	public int getListCount(SqlSession session) {
		// 조회된 게시판 총 갯수를 담을 변수 선언
		int listCount = session.selectOne("boardMapper.selectListCount");
		return listCount;
	}

	/**
	 * 1_2. 페이징 처리된 게시판 목록들 조회용
	 * @param session
	 * @param pi
	 * @return
	 */
	public ArrayList<Board> selectBoardList(SqlSession session, PageInfo pi) {
		// 게시글 목록을 담을 변수 선언
		ArrayList<Board> list = null;
		
		// jsp/Servlet에서는 쿼리문에서의 RowNum을 조건을 통해서 조회 
		// -> 마이바티스는 페이징 처리를 위해 RowBounds라는 클래스를 제공한다.
		// RowBounds => offset과 limit값을 넘겨 받아 페이징 처리를 쉽게 구현할 객체
		
		// * offset - 몇개의 게시글을 건너 뛰고 조회를 할 지에 대해 계산
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		//                  1 -1 * 5  0 
		//                  2 -1 * 5  5
		//                  3 -1 * 5  10
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		// 리스트를 조회 하기 위해 session의 selectList()메소드를 사용하는데
		// 메소드 사용 시 전달 인자로 3개의 값을 넘기게 되는데
		// 첫번째 인자는 쿼리문이 존재하는 '매퍼의 네임스페이스.쿼리문 아이디'
		// 두번째 인자는 조회시 필요한 데이터 : 넘겨줄 값이 없으면 null , Member타입객체, Board타입객체, Map객체를 이용(key,value) 
		//                                                                                      "member",member
		//                                                                                      "board",board
		// 세번째 인자로는 RowBounds 객체를 전달한다.
		list = (ArrayList)session.selectList("boardMapper.selectBoardList",null,rowBounds);
		
		return list;
	}

	/**
	 * 2_1. 게시글 상세조회 시 조회수 증가용
	 * @param session
	 * @param bId
	 * @return
	 */
	public int updateCount(SqlSession session, int bId) {
		int result = session.update("boardMapper.updateBoardCount",bId);
		return result;
	}

	/**
	 * 2_2. 게시글 상세조회용
	 * @param session
	 * @param bId
	 * @return
	 */
	public Board selectBoardDetail(SqlSession session, int bId) {
		// bId에 해당하는 게시글을 조회해 오는데, 이 때 그 해당 게시글에 달려있는 댓글들도 다 조회해보자
		Board b = session.selectOne("boardMapper.selectBoardDetail",bId);
		return b;
	}

	public int getSearchResultListCount(SqlSession session, SearchCondition sc) {
		
		int listCount = session.selectOne("boardMapper.selectSearchResultCount",sc);
		
		return listCount;
	}

	/**
	 * 3_2. 검색된 게시글 목록 조회용
	 * @param session 연결객체정보
	 * @param sc  검색어
	 * @param pi  페이지정보
	 * @return
	 */
	public ArrayList<Board> selectSearchResultList(SqlSession session, SearchCondition sc, PageInfo pi) {
		
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		list = (ArrayList)session.selectList("boardMapper.selectSearchResultList",sc,rowBounds);
		
		return list;
	}

	/**
	 * 4. 게시글 수정용 메소드
	 * @param session
	 * @param b
	 * @return
	 */
	public int updateBoardDetail(SqlSession session, Board b) {
		int result = session.update("boardMapper.updateBoardResult",b);
		return result;
	}

	/**
	 * 5. 게시글 등록용 메소드
	 * @param session
	 * @param b
	 * @return
	 */
	public int insertBoard(SqlSession session, Board b) {
		int result = session.insert("boardMapper.insertBoardResult",b);
		return result;
	}

	/**
	 * 6. 게시글 삭제용 메소드
	 * @param session
	 * @param bId
	 * @return
	 */
	public int deleteBoard(SqlSession session, int bId) {
		int result = session.update("boardMapper.updateBoard",bId);
		return result;
	}

}










