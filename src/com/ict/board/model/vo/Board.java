package com.ict.board.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class Board {

	private int bId;
	private int bType;
	private String bTitle;
	private String bContent;
	private int bWriter;
	private String userName;  // Member의 mId와 bWriter의 Join을 통해 알아올 게시판 작성자 이름
	private int bCount;
	private Date bCreateDate;
	private Date bModifyDate;
	private String bStatus;
	
	private ArrayList<Reply> replyList; // 게시판에 달려있는 댓글 리스트

	public Board() {}

	public Board(int bId, int bType, String bTitle, String bContent, int bWriter, String userName, int bCount,
			Date bCreateDate, Date bModifyDate, String bStatus, ArrayList<Reply> replyList) {
		super();
		this.bId = bId;
		this.bType = bType;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.userName = userName;
		this.bCount = bCount;
		this.bCreateDate = bCreateDate;
		this.bModifyDate = bModifyDate;
		this.bStatus = bStatus;
		this.replyList = replyList;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public int getbType() {
		return bType;
	}

	public void setbType(int bType) {
		this.bType = bType;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public int getbWriter() {
		return bWriter;
	}

	public void setbWriter(int bWriter) {
		this.bWriter = bWriter;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public Date getbCreateDate() {
		return bCreateDate;
	}

	public void setbCreateDate(Date bCreateDate) {
		this.bCreateDate = bCreateDate;
	}

	public Date getbModifyDate() {
		return bModifyDate;
	}

	public void setbModifyDate(Date bModifyDate) {
		this.bModifyDate = bModifyDate;
	}

	public String getbStatus() {
		return bStatus;
	}

	public void setbStatus(String bStatus) {
		this.bStatus = bStatus;
	}

	public ArrayList<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(ArrayList<Reply> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "Board [bId=" + bId + ", bType=" + bType + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bWriter="
				+ bWriter + ", userName=" + userName + ", bCount=" + bCount + ", bCreateDate=" + bCreateDate
				+ ", bModifyDate=" + bModifyDate + ", bStatus=" + bStatus + ", replyList=" + replyList + "]";
	}
}
