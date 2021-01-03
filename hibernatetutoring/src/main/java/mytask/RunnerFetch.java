package mytask;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch {

	public static void main(String[] args) {

		Question question = new Question();
		Answer answer = new Answer();

		Configuration con = new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Question.class).
								addAnnotatedClass(Answer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		String sqlQuery1 = "SELECT q.question, a.answer \n"
							+ "FROM question s INNER JOIN answer b\n"
							+ "ON s.question_no = b.question_no";
		
		List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
		for(Object[] w : resultList1) {
			System.out.println(Arrays.toString(w));
		}
		
		String sqlQuery2 = "SELECT q.question, a.answer, a.answer_no \n"
							+ "FROM Question s LEFT JOIN Answer b\n"
							+ "ON a.question_no = q.question_no";
		List<Object[]> resultList3 = session.createSQLQuery(sqlQuery2).getResultList();
		for(Object[] w : resultList3) {
			System.out.println(Arrays.toString(w));
		}		

		String sqlQuery3 = "SELECT q.question, a.answer, a.answer_no \n"
							+ "FROM question s RIGHT JOIN answer b\n"
							+ "ON q.question_no = a.question_no";
		List<Object[]> resultList5 = session.createSQLQuery(sqlQuery3).getResultList();
		for(Object[] w : resultList5) {
			System.out.println(Arrays.toString(w));
		}
		
		String sqlQuery4 = "SELECT q.question, a.answer, a.answer_no \n"
							+ "FROM question s FULL JOIN answer b\n"
							+ "ON q.queston_no = a.question_no";
		List<Object[]> resultList7 = session.createSQLQuery(sqlQuery4).getResultList();
		for(Object[] w : resultList7) {
			System.out.println(Arrays.toString(w));
		}
		
		tx.commit();
		
		sf.close();
		session.close();

	}

}
