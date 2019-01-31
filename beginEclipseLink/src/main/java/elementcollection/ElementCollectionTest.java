package elementcollection;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ElementCollectionTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();
		Person8 person1 = personService.insertPerson("Berkay", "DEMİREL", 24);
		Person8 person2 = personService.insertPerson("EclipseLink", "Test", 12);
		entityTransaction.commit();
		
		Phone phone1 = new Phone("905453321452");
		Phone phone2 = new Phone("905452344352");
		Phone phone3 = new Phone("905431233122");

		entityTransaction.begin();
		person1.getPhones().add(phone1);
		person1.getPhones().add(phone2);
		person2.getPhones().add(phone3);
		entityTransaction.commit();

		System.out.println("All Persons");
		List<Person8> personList = personService.findAllPersons();
		for (Person8 person : personList) {

			System.out.println(person);
		}

		entityManager.close();
		entityManagerFactory.close();

	}

}
