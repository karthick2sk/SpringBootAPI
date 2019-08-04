package com.example.rest.Models;

public class WordCountResponse {
	
	private String w;
	private Long n;
	
	

	public String getW() {
		return w;
	}


	public void setW(String w) {
		this.w = w;
	}

	public Long getN() {
		return n;
	}

	public void setN(Long n) {
		this.n = n;
	}




	/**
	 * @param w
	 * @param n
	 */
	public WordCountResponse(String w, Long n) {
		super();
		this.w = w;
		this.n = n;
	}


	public WordCountResponse() {
		// TODO Auto-generated constructor stub
	}

}
