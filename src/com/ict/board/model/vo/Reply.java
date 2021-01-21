package com.ict.board.model.vo;

import java.sql.Date;

public class Reply {
	
	private int rId;
	private String rContent;
	private int refBid;
	private int rWriter;
	private String userName;
	private Date rCreateDate;
	private Date rModifyDate;
	private String rStatus;
	
	public Reply() {}

	public Reply(int rId, String rContent, int refBid, int rWriter, String userName, Date rCreateDate, Date rModifyDate,
			String rStatus) {
		super();
		this.rId = rId;
		this.rContent = rContent;
		this.refBid = refBid;
		this.rWriter = rWriter;
		this.userName = userName;
		this.rCreateDate = rCreateDate;
		this.rModifyDate = rModifyDate;
		this.rStatus = rStatus;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public int getRefBid() {
		return refBid;
	}

	public void setRefBid(int refBid) {
		this.refBid = refBid;
	}

	public int getrWriter() {
		return rWriter;
	}

	public void setrWriter(int rWriter) {
		this.rWriter = rWriter;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getrCreateDate() {
		return rCreateDate;
	}

	public void setrCreateDate(Date rCreateDate) {
		this.rCreateDate = rCreateDate;
	}

	public Date getrModifyDate() {
		return rModifyDate;
	}

	public void setrModifyDate(Date rModifyDate) {
		this.rModifyDate = rModifyDate;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	@Override
	public String toString() {
		return "Reply [rId=" + rId + ", rContent=" + rContent + ", refBid=" + refBid + ", rWriter=" + rWriter
				+ ", userName=" + userName + ", rCreateDate=" + rCreateDate + ", rModifyDate=" + rModifyDate
				+ ", rStatus=" + rStatus + "]";
	}
}
