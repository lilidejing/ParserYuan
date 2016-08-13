package com.cl.glmusic.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 链接地址管理
 * 
 * @ClassName: HrefLink
 * @author yz
 * @date 2016�?�?�?下午10:17:59
 */
@Entity
@Table(name = "cl_href_link" ,uniqueConstraints={@UniqueConstraint(columnNames={"hrefTitle"})})
public class HrefLink implements Serializable  {

	private static final long serialVersionUID = -7224716659364436206L;

	private Integer hrefId;// ID

	private String hrefImg; // 展示图片
	
	private String hrefTime; // 播放时长
	
	private String hrefTitle; // 链接标题

	private String hrefLink; // 链接地址

	private Integer type;// 类型

	@Id
	@GeneratedValue
	public Integer getHrefId() {
		return hrefId;
	}

	public void setHrefId(Integer hrefId) {
		this.hrefId = hrefId;
	}

	public String getHrefImg() {
		return hrefImg;
	}

	public void setHrefImg(String hrefImg) {
		this.hrefImg = hrefImg;
	}

	public String getHrefTime() {
		return hrefTime;
	}

	public void setHrefTime(String hrefTime) {
		this.hrefTime = hrefTime;
	}

	public String getHrefTitle() {
		return hrefTitle;
	}
	
	public void setHrefTitle(String hrefTitle) {
		this.hrefTitle = hrefTitle;
	}
	
	public String getHrefLink() {
		return hrefLink;
	}

	public void setHrefLink(String hrefLink) {
		this.hrefLink = hrefLink;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
