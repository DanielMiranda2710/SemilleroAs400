package com.google.qa.screenplaydatatable.models;

public class Phrase {
	private String wordOne;
	private String wordTwo;
	
	public Phrase(String wordOne, String wordTwo) {
		this.wordOne = wordOne;
		this.wordTwo = wordTwo;
	}
	
	public String getWordOne() {
		return wordOne;
	}
	public void setWordOne(String wordOne) {
		this.wordOne = wordOne;
	}
	public String getWordTwo() {
		return wordTwo;
	}
	public void setWordTwo(String wordTwo) {
		this.wordTwo = wordTwo;
	}
	
}
