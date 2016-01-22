package com.wh.mvcdemo.model;

/**
 * Created by Whiker on 2016/1/21.
 */
public class Course {

	private Integer id;
	private String name;
	private Long duration;
	private String imagePath;
	private String info;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setInfo(String info) { this.info = info; }

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getDuration() {
		return duration;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getInfo() { return info; }
}
