package mytask;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	private int question_no;
	private String question;
	private String question_lecture;
	
	@OneToMany(mappedBy = "question")
	private List<Answer> answerList = new ArrayList<Answer>();

	public int getQuestion_no() {
		return question_no;
	}

	public void setQuestion_no(int question_no) {
		this.question_no = question_no;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion_lecture() {
		return question_lecture;
	}

	public void setQuestion_lecture(String question_lecture) {
		this.question_lecture = question_lecture;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	@Override
	public String toString() {
		return "Question [question_no=" + question_no + ", question=" + question + ", question_lecture="
				+ question_lecture + ", answerList=" + answerList + "]";
	}

	
	
}
