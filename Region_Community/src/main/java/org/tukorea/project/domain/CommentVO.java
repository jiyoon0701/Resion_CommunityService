package org.tukorea.project.domain;

import java.util.Date;

public class CommentVO {
	private int comment_num;
	private int boardnum;
	private String userid;
	private String comment;
	private Date board_date;
	private String residence;
	private String residenceGu;
	
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getResidenceGu() {
		return residenceGu;
	}
	public void setResidenceGu(String residenceGu) {
		this.residenceGu = residenceGu;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int board_num) {
		this.boardnum = board_num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	

}
