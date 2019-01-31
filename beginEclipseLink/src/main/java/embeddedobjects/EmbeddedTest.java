package embeddedobjects;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmbeddedTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();
		Person7 person1 = personService.insertPerson("Berkay", "DEMİREL", 24);
		Person7 person2 = personService.insertPerson("EclipseLink", "Test", 12);
		entityTransaction.commit();
		
		AddressDAO addressService = new AddressDAOImpl();
		
		entityTransaction.begin();
		Address address1 = addressService.insertAddress("İstanbul");
		Address address2 = addressService.insertAddress("San Francisco");
		entityTransaction.commit();

		entityTransaction.begin();
		person1.setAddress(address1);
		person2.setAddress(address2);
		entityTransaction.commit();

		System.out.println("All Persons");
		List<Person7> personList = personService.findAllPersons();
		for (Person7 person : personList) {

			System.out.println(person);
		}

		entityManager.close();
		entityManagerFactory.close();

	}

}
