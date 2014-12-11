package com.osu.autograder.ocr;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class XMLUtil {

	private static final String POINTS_VALUE = "13.0";

	private static final String CONFIDENCE_VALUE = "0";

	private static final String ANSWERVALUE = "AnswerValue";

	private static final String QUESTIONID = "QuestionID";

	private static final String IS_FORCED_REVIEW = "<IsForcedReview>false</IsForcedReview>";

	private static final String IS_REVIEWED = "<IsReviewed>false</IsReviewed>";

	private static final String POINTS = "<Points>" + POINTS_VALUE
			+ "</Points>";

	private static final String CONFIDENCE = "<Confidence>" + CONFIDENCE_VALUE
			+ "</Confidence>";

	private static final String ANSWER = "<Answer>" + ANSWERVALUE + "</Answer>";

	private static final String QUESTION_ID = "<Question_ID>" + QUESTIONID
			+ "</Question_ID>";

	private static String STATIC_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<Assignment xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n	<Type>Homework</Type>\n	<Assignment_ID>100</Assignment_ID>\n	<Course_ID>0</Course_ID>\n	<Student_ID>0</Student_ID>\n	<Questions>";

	public static void createXML(String xmlPath, List<Question> questions) {
		StringBuffer stringBuffer = new StringBuffer(STATIC_CONTENT);
		for (Question question : questions) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("\n<Question>\n<Section_ID>1</Section_ID>\n");
			stringBuilder.append(QUESTION_ID.replace(QUESTIONID,
					question.getNumber() + ""));
			stringBuilder.append("\n<Content>Content</Content>\n");
			stringBuilder.append(ANSWER.replace(ANSWERVALUE,
					question.getFoundAnswer()));
			stringBuilder.append("\n");
			stringBuilder.append(CONFIDENCE.replace(CONFIDENCE_VALUE,
					question.getConfidence() + ""));
			stringBuilder.append("\n");
			stringBuilder.append(POINTS.replace(POINTS_VALUE,
					question.getPointsSecured() + ""));
			stringBuilder.append("\n");
			stringBuilder.append(IS_REVIEWED);
			stringBuilder.append("\n");
			stringBuilder.append(IS_FORCED_REVIEW);
			stringBuilder.append("\n</Question>");

			stringBuffer.append(stringBuilder);
		}
		stringBuffer.append("</Questions>");
		stringBuffer.append("</Assignment>");

		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(xmlPath);
			printWriter.print(stringBuffer.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
