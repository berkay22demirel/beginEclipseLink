package relationshipmanytomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManyToOneTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();
		Person5 person1 = personService.insertPerson("Berkay", "DEMİREL", 24);
		Person5 person2 = personService.insertPerson("EclipseLink", "Test", 12);
		entityTransaction.commit();
		
		ProjectDAO departmentService = new ProjectDAOImpl(entityManager);
		
		entityTransaction.begin();
		Project project1 = departmentService.insertProject("EclipseLink");
		Project project2 = departmentService.insertProject("Hibernate");
		Project project3 = departmentService.insertProject("JSF");
		entityTransaction.commit();

		entityTransaction.begin();
		person1.getProjects().add(project1);
		person1.getProjects().add(project2);
		person2.getProjects().add(project3);
		entityTransaction.commit();

		System.out.println("All Persons");
		List<Person5> personList = personService.findAllPersons();
		for (Person5 person : personList) {

			System.out.println(person);
		}

		entityManager.close();
		entityManagerFactory.close();

	}

}
