package criteriaapiselect;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Tuple;

public class SelectTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();
		Person12 person1 = personService.insertPerson("Berkay", "DEMİREL", 24);
		Person12 person2 = personService.insertPerson("EclipseLink", "Test", 12);
		Person12 person3 = personService.insertPerson("JSF", "Test", 22);
		Person12 person4 = personService.insertPerson("Spring", "Test", 33);
		entityTransaction.commit();

		System.out.println("All Persons");
		List<Person12> personList = personService.selectAll();
		for (Person12 person : personList) {

			System.out.println(person);
		}

		System.out.println("All Names");
		List<String> nameList = personService.selectAllName();
		for (String name : nameList) {

			System.out.println(name);
		}

		System.out.println("All Names And Surnames");
		List<Tuple> nameSurnameList = personService.SelectAllNameSurname();
		for (Tuple nameSurname : nameSurnameList) {

			System.out.println(nameSurname.get(0) + " - " + nameSurname.get(1));
		}



		entityManager.close();
		entityManagerFactory.close();

	}

}
