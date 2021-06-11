
import java.io.*;
import java.util.*;
import java.sql.*;

public class Exercise34_7 {
  private ArrayList<Quiz> chapters = new ArrayList<Quiz>();
  private PreparedStatement stmt;
  private String createTable =
		  "create table Quiz("+
				   "questionId int,"+
				   "question varchar(4000),"+
				   "choicea varchar(1000),"+
				   "choiceb varchar(1000),"+
				   "choicec varchar(1000),"+
				   "choiced varchar(1000),"+
				   "answer varchar(5));";

  static class Quiz {
    String question = "";
    String choicea = "";
    String choiceb = "";
    String choicec = "";
    String choiced = "";
    String answer;
    String hint;
  }

  public static void main(String[] args) {
    new Exercise34_7();
  }

  /** Initialize global variables */
  public Exercise34_7() {
    try {
      readTest(chapters);

      initializeJdbc();
      int questionNo = 1;
      for (Quiz question : chapters) {
        storeQuiz(questionNo++, question);
      }

    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void readTest(List<Quiz> testForAChapter) throws
    Exception {
    // Buffer reader for reading quiz.txt
    BufferedReader fileInput = new BufferedReader(new FileReader(
      "Quiz.txt"));

    int questionTotal = 0;
    boolean beginningOfQuiz = true; // for the first one

    // Text line from the question file
    String line = "";
    Quiz question = null;

    // Read and process each line from the text file
    loop:while ((line = fileInput.readLine()) != null) {
      // Process a blank line in the text file
      if (line.length() < 1) {
        continue;
      }

      // Breakdown textfile to questions and answers
      if (line.charAt(0) == 'a' && line.charAt(1) == '.') {
        question.choicea = line.substring(2);
      }
      else if (line.charAt(0) == 'b' && line.charAt(1) == '.') {
        question.choiceb = line.substring(2);
      }
      else if (line.charAt(0) == 'c' && line.charAt(1) == '.') {
        question.choicec = line.substring(2);
      }
      else if (line.charAt(0) == 'd' && line.charAt(1) == '.') {
        question.choiced = line.substring(2);
      }
      else if (line.matches("(\\d)+\\..*")) { //look for new question
        beginningOfQuiz = true;
        questionTotal++; // add to total number of questions
        question = new Quiz();
        testForAChapter.add(question);
				question.question += line;
     }
      else if (line.toUpperCase().indexOf("ANSWER") == 0) { // End of question section
        // Extract answer and explanation
        StringTokenizer stringToken = new StringTokenizer(line.substring(7),
                                                 ".\n\r\t ");

        question.answer = stringToken.nextToken().toUpperCase();

        if (stringToken.hasMoreTokens()) {
          question.hint = stringToken.nextToken("\n\r");
        }
      }
      else if (line.charAt(0) == ' ') {
        String spaces = "";
        for (int j = 0;
                     ((j < line.length()) && (line.charAt(j) == ' ')); j++) {
          spaces += "&nbsp";
        }
        question.question += spaces;
        question.question += line;
      }
      else {
        if (beginningOfQuiz && Character.isDigit(line.charAt(0)) &&
            line.charAt(1) == '.') {
          question.question += line.substring(2);
          beginningOfQuiz = false;
        }
        else if (beginningOfQuiz && Character.isDigit(line.charAt(0)) &&
                 Character.isDigit(line.charAt(1))
                 && line.charAt(2) == '.') {
          question.question += line.substring(3);
          beginningOfQuiz = false;
        }
        else {
          question.question += line;
        }
      }
    }
    fileInput.close();
  }

  private void initializeJdbc() {
    try {
      // Load the JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded");


		Connection conn = DriverManager.getConnection
		("jdbc:mysql://apollo.gtc.edu/brothenm2_javabook", "brothenm2", "password");
		//create the table
	    createTable(conn);

      // Create a statement to insert questions
      stmt = conn.prepareStatement("insert into Quiz " +
        "(questionId, question, choicea, choiceb, choicec, choiced, answer)"
        + "values (?, ?, ?, ?, ?, ?, ?)");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /** Store a question to the database */
  private void storeQuiz(int questionNo,
                             Quiz question) throws SQLException {
    stmt.setInt(1, questionNo);
    stmt.setString(2, question.question);
    stmt.setString(3, question.choicea);
    stmt.setString(4, question.choiceb);
    stmt.setString(5, question.choicec);
    stmt.setString(6, question.choiced);
    stmt.setString(7, question.answer);
    stmt.executeUpdate();
  }
  private void createTable(Connection conn) {
	  try{
		  Statement tableStatement = conn.createStatement();
		  tableStatement.executeUpdate(createTable);
	  } catch(Exception ex){
		  ex.printStackTrace();
	  }
  }
}