package firstexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();

		Person person1 = personService.insertPerson(1, "Berkay", "DEMİREL", 24);
		Person person2 = personService.insertPerson(2, "EclipseLink", "Test", 12);
		entityTransaction.commit();
		
		person2 = personService.findPerson(2);
		System.out.println("Person2 : " + person2);

		entityTransaction.begin();
		person2 = personService.changePersonAge(2, 99);
		entityTransaction.commit();
		System.out.println("Person2 : " + person2);

		entityTransaction.begin();
		personService.removePerson(2);
		entityTransaction.commit();

		System.out.println("All Persons");
		List<Person> personList = personService.findAllPersons();
		for (Person person : personList) {

			System.out.println(person);
		}

	}

}
