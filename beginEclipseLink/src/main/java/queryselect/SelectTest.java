package queryselect;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SelectTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();
		Person9 person1 = personService.insertPerson("Berkay", "DEMİREL", 24);
		Person9 person2 = personService.insertPerson("EclipseLink", "Test", 12);
		entityTransaction.commit();

		System.out.println("All Persons");
		List<Person9> personList = personService.findAllPersons();
		for (Person9 person : personList) {

			System.out.println(person);
		}

		Person9 person3 = personService.findPerson(person2.getId());
		System.out.println("Get person2 : " + person3);

		String person1Name = personService.findPersonName(person1.getId());
		System.out.println("person1 name : " + person1Name);

		entityManager.close();
		entityManagerFactory.close();

	}

}
