package relationshiponetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToManyTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();
		Person6 person1 = personService.insertPerson("Berkay", "DEMİREL", 24);
		Person6 person2 = personService.insertPerson("EclipseLink", "Test", 12);
		Person6 person3 = personService.insertPerson("Hibernate", "Test", 32);
		entityTransaction.commit();
		
		DepartmentDAO departmentService = new DepartmentDAOImpl(entityManager);
		
		entityTransaction.begin();
		Department2 department1 = departmentService.insertDepartment("Software Development");
		Department2 department2 = departmentService.insertDepartment("JPA");
		entityTransaction.commit();

		entityTransaction.begin();
		person1.setDepartment(department1);
		department1.getPersons().add(person1);
		person2.setDepartment(department2);
		department2.getPersons().add(person2);
		person3.setDepartment(department2);
		department2.getPersons().add(person3);
		entityTransaction.commit();

		System.out.println("All Persons");
		List<Person6> personList = personService.findAllPersons();
		for (Person6 person : personList) {

			System.out.println(person.getName() + " - " + person.getDepartment().getName());
		}

		entityManager.close();
		entityManagerFactory.close();

	}

}
