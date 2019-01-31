package primarykey;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PrimaryKeyTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();

		Person3 person1 = personService.insertPerson("Berkay", "DEMİREL", 24);
		Person3 person2 = personService.insertPerson("EclipseLink", "Test", 12);
		entityTransaction.commit();

		System.out.println("All Persons");
		List<Person3> personList = personService.findAllPersons();
		for (Person3 person : personList) {

			System.out.println(person);
		}

		entityManager.close();
		entityManagerFactory.close();

	}

}
