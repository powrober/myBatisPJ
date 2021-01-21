package com.ict.board.model.service;

import java.util.ArrayList;

import com.ict.board.model.vo.Board;
import com.ict.board.model.vo.PageInfo;
import com.ict.board.model.vo.SearchCondition;

public interface BoardService {

	/**
	 * 1_1. 게시판 목록 수 조회용 메소드
	 * @return
	 */
	int getListCount();
	
	/**
	 * 1_2. 페이징 처리 된 게시판 목록 조회용 메소드
	 * @param pi
	 * @return
	 */
	ArrayList<Board> selectBoardList(PageInfo pi);
	
	/**
	 * 2. 게시물 상세보기용 메소드
	 * @param bId
	 * @return
	 */
	Board selectBoardDetail(int bId);

	/**
	 * 3_1. 검색된 게시판 목록 수 조회용 메소드
	 * @param sc 검색어
	 * @return
	 */
	int getSearchResultListCount(SearchCondition sc);

	/**
	 * 3_2. 검색된 게시판 목록들 조회용 메소드
	 * @param sc
	 * @param pi
	 * @return
	 */
	ArrayList<Board> selectSearchResultList(SearchCondition sc, PageInfo pi);

	/**
	 * 4. 게시글 수정하기용 메소드
	 * @param b 수정정보(제목, 내용)
	 * @return
	 */
	int updateBoardDetail(Board b);

	/**
	 * 5. 게시글 등록용 메소드 
	 * @param b
	 * @return
	 */
	int insertBoard(Board b);

	/**
	 * 6. 게시글 삭제용 메소드
	 * @param bId
	 * @return
	 */
	int deleteBoard(int bId);
}










