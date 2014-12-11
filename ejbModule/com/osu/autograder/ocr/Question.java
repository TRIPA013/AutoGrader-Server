package com.osu.autograder.ocr;
public class Question {

	private int pageNumber;

	private String expectedAnswer;

	private double pointsWorth;

	private double pointsSecured;

	private int number;

	private Coordinates foundCoordinates;

	private String foundAnswer;

	private Coordinates expectedCoordinates;

	private double confidence;

	public Question(int questionNumber, int pageNumber, String expectedString,
			double points, Coordinates expectedCoordinates) {
		this.pageNumber = pageNumber;
		this.number = questionNumber;
		this.expectedAnswer = expectedString;
		this.pointsWorth = points;
		this.expectedCoordinates = expectedCoordinates;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getExpectedAnswer() {
		return expectedAnswer;
	}

	public void setExpectedAnswer(String expectedAnswer) {
		this.expectedAnswer = expectedAnswer;
	}

	public double getPointsWorth() {
		return pointsWorth;
	}

	public void setPointsWorth(double pointsWorth) {
		this.pointsWorth = pointsWorth;
	}

	public double getPointsSecured() {
		return pointsSecured;
	}

	public void setPointsSecured(double pointsSecured) {
		this.pointsSecured = pointsSecured;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Coordinates getFoundCoordinates() {
		return foundCoordinates;
	}

	public void setFoundCoordinates(Coordinates foundCoordinates) {
		this.foundCoordinates = foundCoordinates;
	}

	public String getFoundAnswer() {
		return foundAnswer;
	}

	public void setFoundAnswer(String foundAnswer) {
		this.foundAnswer = foundAnswer;
	}

	public Coordinates getExpectedCoordinates() {
		return expectedCoordinates;
	}

	public void setExpectedCoordinates(Coordinates expectedCoordinates) {
		this.expectedCoordinates = expectedCoordinates;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

}