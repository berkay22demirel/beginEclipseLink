package simpletypes;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SimpleTypesTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();

		Calendar nowDate = Calendar.getInstance();
		Date birthDate = prepareDate(1995, 9, 5);
		Date birthDate2 = prepareDate(1996, 4, 13);

		byte[] picture = { 1, 2, 3, 4 };

		Person2 person1 = personService.insertPerson(1, "Berkay", "Demirel", 24, 10000, JobEnum.COMPUTER_ENGINEER, birthDate, nowDate, picture);
		Person2 person2 = personService.insertPerson(2, "Sİmple", "Test", 11, 22222, JobEnum.TEACHER, birthDate2, nowDate, picture);
		entityTransaction.commit();

		System.out.println(person1);
		System.out.println(person2);

		entityManager.close();
		entityManagerFactory.close();

	}

	public static Date prepareDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		return calendar.getTime();
	}

}
