package org.tukorea.project.domain;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {	
	private String id;
	private String residence;
	private String residenceGu;
	private String content;
	private String image;
	private MultipartFile imagefile;
	private int num;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String toString() {
		return "BoardVO [userId=" + id  + ", residence= " + residence + "content= "+ content +", num = "+num;
	}
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
