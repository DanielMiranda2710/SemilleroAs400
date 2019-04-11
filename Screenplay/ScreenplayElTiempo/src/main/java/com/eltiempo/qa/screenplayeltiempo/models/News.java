package com.eltiempo.qa.screenplayeltiempo.models;

public class News {
	private String wordOne;
	private String wordTwo;
	
	public News(String wordOne, String wordTwo) {
		this.wordOne = wordOne;
		this.wordTwo = wordTwo;
	}

	public String getwordOne() {
		return wordOne;
	}

	public void setwordOne(String wordOne) {
		this.wordOne = wordOne;
	}

	public String getwordTwo() {
		return wordTwo;
	}

	public void setwordTwo(String wordTwo) {
		this.wordTwo = wordTwo;
	}
}
