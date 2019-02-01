package querywhere;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class WhereTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();
		Person11 person1 = personService.insertPerson("Berkay", "DEMİREL", 24);
		Person11 person2 = personService.insertPerson("EclipseLink", "Test", 12);
		Person11 person3 = personService.insertPerson("JSF", "Test", 35);
		Person11 person4 = personService.insertPerson("Spring", "Test", 26);
		entityTransaction.commit();

		System.out.println("All Persons");
		List<Person11> personList = personService.findAllPersons();
		for (Person11 person : personList) {

			System.out.println(person);
		}

		List<Person11> where = personService.where(30);
		List<Person11> between = personService.between(18, 27);
		List<Person11> like = personService.like("S");
		List<Person11> in = personService.in("Berkay", "JSF");

		System.out.println("WHERE");
		for (Person11 person : where) {

			System.out.println(person);
		}

		System.out.println("BETWEEN");
		for (Person11 person : between) {

			System.out.println(person);
		}

		System.out.println("LIKE");
		for (Person11 person : like) {

			System.out.println(person);
		}

		System.out.println("IN");
		for (Person11 person : in) {

			System.out.println(person);
		}

		entityManager.close();
		entityManagerFactory.close();

	}

}
