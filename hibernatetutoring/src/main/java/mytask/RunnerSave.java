package mytask;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {

	public static void main(String[] args) {

		Question question1 = new Question();
		Question question2 = new Question();
		
		Answer q1_answer1 = new Answer();
		Answer q1_answer2 = new Answer();
		Answer q1_answer3 = new Answer();
		
		Answer q2_answer1 = new Answer();
		Answer q2_answer2 = new Answer();
		Answer q2_answer3 = new Answer();

		question1.setQuestion_no(001);
		question1.setQuestion("What is (9*9)");
		question1.setQuestion_lecture("Math");
		question1.getAnswerList().add(q1_answer1);
		question1.getAnswerList().add(q1_answer2);
		question1.getAnswerList().add(q1_answer3);
		
		question2.setQuestion_no(002);
		question2.setQuestion("What are the first 3 laws of thermodynamics");
		question2.setQuestion_lecture("Physics");
		question2.getAnswerList().add(q2_answer1);
		question2.getAnswerList().add(q2_answer2);
		question2.getAnswerList().add(q2_answer3);
		
		q1_answer1.setAnswer_no(101);
		q1_answer1.setAnswer("9 * 9 = 81");
		q1_answer1.setAnswer_lecture("Multiplication");
		q1_answer1.setQuestion(question1);
		
		q1_answer2.setAnswer_no(102);
		q1_answer2.setAnswer("9 * 9 = 9 power 2");
		q1_answer2.setAnswer_lecture("Exponentiation");
		q1_answer2.setQuestion(question1);
		
		q1_answer3.setAnswer_no(103);
		q1_answer3.setAnswer("(8+1)*(8+1)");
		q1_answer3.setAnswer_lecture("Multiplication and Addition");
		q1_answer3.setQuestion(question1);
		
		q2_answer1.setAnswer_no(201);
		q2_answer1.setAnswer("total energy of an isolated system remains constant.");
		q2_answer1.setAnswer_lecture("First law of thermodynamics");
		q2_answer1.setQuestion(question2);

		q2_answer2.setAnswer_no(201);
		q2_answer2.setAnswer("Entropy, as a measurable physical property that is most commonly\r\n" + 
							 "associated with a state of disorder, randomness, or uncertainty.");
		q2_answer2.setAnswer_lecture("Second law of thermodynamics");
		q2_answer2.setQuestion(question2);
		
		q2_answer3.setAnswer_no(203);
		q2_answer3.setAnswer("The entropy of a system approaches a constant value as its\r\n" + 
							 "temperature approaches absolute zero.");
		q2_answer3.setAnswer_lecture("Third law of thermodynamics");
		q2_answer3.setQuestion(question2);
		
		Configuration con = new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Question.class).
								addAnnotatedClass(Answer.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(question1);
		session.save(question2);
		
		session.save(q1_answer1);
		session.save(q1_answer2);
		session.save(q1_answer3);
		
		session.save(q2_answer1);
		session.save(q2_answer2);
		session.save(q2_answer3);
		
		tx.commit();
	}

}
