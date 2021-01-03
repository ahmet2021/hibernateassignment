package mytask;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	private int answer_no;
	private String answer;
	private String answer_lecture;
	
	@ManyToOne
	@JoinColumn(name = "question_no")
	private Question question;

	public int getAnswer_no() {
		return answer_no;
	}

	public void setAnswer_no(int answer_no) {
		this.answer_no = answer_no;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer_lecture() {
		return answer_lecture;
	}

	public void setAnswer_lecture(String answer_lecture) {
		this.answer_lecture = answer_lecture;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [answer_no=" + answer_no + ", answer=" + answer + ", answer_lecture=" + answer_lecture
				+ ", question=" + question + "]";
	}	

}
