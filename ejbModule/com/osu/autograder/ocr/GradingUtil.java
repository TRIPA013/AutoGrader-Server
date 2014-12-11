package com.osu.autograder.ocr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradingUtil {

	// static TessAPI1.TessBaseAPI handle = TessAPI1.TessBaseAPICreate();

	public static void gradeFiles(List<File> fileList, File gradingFile)
			throws FileNotFoundException, IOException {

		if (gradingFile != null) {
			List<Question> questionList = generateQuestions(gradingFile);

			for (File file : fileList) {
				File[] listFiles = file.listFiles();
				if (listFiles.length == 1) {
					gradeQuestionsInFile(listFiles[0].getAbsolutePath(),
							questionList);
				}
			}
		}
	}

	private static List<Question> generateQuestions(File gradingFile)
			throws FileNotFoundException, IOException {
		List<Question> questions = new ArrayList<Question>();

		int x1 = 500;
		int x2 = 2300;
		int y1 = 190;
		int y2 = 380;

		for (int i = 0; i < 12; i++) {
			Question question = new Question(i + 1, 1, "", 10.0,
					new Coordinates(x1, y1, x2, y2));
			y1 += 106;
			y2 += 106;
			questions.add(question);
		}

		System.out.println("Initializing 1st file:");
		GradingUtil.checkFileForWords(gradingFile.getAbsolutePath(), questions);
		for (Question question : questions) {
			question.setFoundAnswer("true");

			question.setExpectedAnswer(question.getFoundAnswer());
			question.setFoundAnswer("");
		}
		return questions;
	}

	public static void gradeQuestionsInFile(String pathOfFile,
			List<Question> questions) throws IOException, FileNotFoundException {
		checkFileForWords(pathOfFile, questions);

		for (Question question : questions) {
			question.setFoundAnswer("true");
			String foundAnswer = question.getFoundAnswer();
			if (question.getExpectedAnswer().equals(foundAnswer)) {
				question.setPointsSecured(question.getPointsWorth());
			}
		}

		createXMLForCurrentAssignment(pathOfFile, questions);
	}

	private static void createXMLForCurrentAssignment(String pathOfFile,
			List<Question> questions) {
		String xmlPath = pathOfFile.replace(".pdf", ".xml");
		XMLUtil.createXML(xmlPath, questions);
	}

	public static List<Question> checkFileForWords(String pathOfFile,
			List<Question> questions) throws IOException, FileNotFoundException {
		String lang = "eng";
		File tiff = new File(pathOfFile);
		/*
		 * File[] files = PdfUtilities.convertPdf2Png(tiff); for (File file :
		 * files) { BufferedImage image = ImageIO.read(new
		 * FileInputStream(file)); ByteBuffer buf =
		 * ImageIOHelper.convertImageData(image); int bpp =
		 * image.getColorModel().getPixelSize(); int bytespp = bpp / 8; int
		 * bytespl = (int) Math.ceil(image.getWidth() * bpp / 8.0);
		 * TessAPI1.TessBaseAPIInit3(handle, "tessdata", lang);
		 * TessAPI1.TessBaseAPISetPageSegMode(handle,
		 * TessAPI1.TessPageSegMode.PSM_AUTO);
		 * TessAPI1.TessBaseAPISetImage(handle, buf, image.getWidth(),
		 * image.getHeight(), bytespp, bytespl);
		 * TessAPI1.TessBaseAPIRecognize(handle, null);
		 * TessAPI1.TessResultIterator ri = TessAPI1
		 * .TessBaseAPIGetIterator(handle); TessAPI1.TessPageIterator pi =
		 * TessAPI1 .TessResultIteratorGetPageIterator(ri);
		 * TessAPI1.TessPageIteratorBegin(pi);
		 * 
		 * do { Pointer pointer = TessAPI1.TessResultIteratorGetUTF8Text(ri,
		 * TessPageIteratorLevel.RIL_WORD); float confidence =
		 * TessAPI1.TessResultIteratorConfidence(ri,
		 * TessAPI1.TessPageIteratorLevel.RIL_WORD); if (pointer != null) {
		 * String word = pointer.getString(0); IntBuffer leftB =
		 * IntBuffer.allocate(1); IntBuffer topB = IntBuffer.allocate(1);
		 * IntBuffer rightB = IntBuffer.allocate(1); IntBuffer bottomB =
		 * IntBuffer.allocate(1); TessAPI1.TessPageIteratorBoundingBox(pi,
		 * TessPageIteratorLevel.RIL_WORD, leftB, topB, rightB, bottomB);
		 * 
		 * int left = leftB.get(); int top = topB.get(); int right =
		 * rightB.get(); int bottom = bottomB.get();
		 * 
		 * Coordinates presentCoordinates = new Coordinates(left, top, right,
		 * bottom); Question question = checkIsContained(questions,
		 * presentCoordinates); if (question != null) { //
		 * System.out.println("Answer:" + word); question.setFoundAnswer(word);
		 * question.setFoundCoordinates(presentCoordinates);
		 * question.setConfidence(confidence); } else { // if
		 * (word.equals("True") || word.equals("False")) { //
		 * System.out.println(word + " " + left + " " + top // + " " + right +
		 * " " + bottom + " " // + confidence); // } } } } while
		 * (TessAPI1.TessPageIteratorNext(pi,
		 * TessAPI1.TessPageIteratorLevel.RIL_WORD) == TessAPI1.TRUE); }
		 */
		return questions;
	}

	private static Question checkIsContained(List<Question> questions,
			Coordinates coordinates) {
		Question foundQuestionAnswer = null;
		if (questions != null) {
			for (Question question : questions) {
				if (checkIsContained(question.getExpectedCoordinates(),
						coordinates)) {
					foundQuestionAnswer = question;
				}
			}
		}
		return foundQuestionAnswer;
	}

	private static boolean checkIsContained(Coordinates expectedCoordinates,
			Coordinates coordinates) {
		if (checkIsGreater(coordinates.getX1(), expectedCoordinates.getX1())
				&& checkIsGreater(expectedCoordinates.getX2(),
						coordinates.getX2())) {
			if (checkIsGreater(coordinates.getY1(), expectedCoordinates.getY1())
					&& checkIsGreater(expectedCoordinates.getY2(),
							coordinates.getY2())) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkIsGreater(int x1, int x2) {
		if (x1 > x2) {
			return true;
		}
		return false;
	}

}
