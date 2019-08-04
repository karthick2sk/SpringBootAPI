package com.example.rest.Models;

import javax.validation.constraints.NotNull;

/**
 * @author Karthick
 *
 */
public class WordCountRequest {

	@NotNull
	private String para;

	/**
	 * @param para
	 */
	public WordCountRequest(String para) {
		super();
		this.para = para;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public WordCountRequest() {
		// TODO Auto-generated constructor stub
	}

}
