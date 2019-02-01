package queryjoin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JoinTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonDAO personService = new PersonDAOImpl(entityManager);

		entityTransaction.begin();
		Person10 person1 = personService.insertPerson("Berkay", "DEMİREL", 24);
		Person10 person2 = personService.insertPerson("EclipseLink", "Test", 12);
		Person10 person3 = personService.insertPerson("JSF", "Test", 22);
		entityTransaction.commit();
		
		DepartmentDAO departmentService = new DepartmentDAOImpl(entityManager);
		
		entityTransaction.begin();
		Department3 department1 = departmentService.insertDepartment("Software Development");
		Department3 department2 = departmentService.insertDepartment("JPA");
		entityTransaction.commit();

		entityTransaction.begin();
		person1.setDepartment(department1);
		person2.setDepartment(department2);
		entityTransaction.commit();

		System.out.println("JOIN");
		List<Person10> personList = personService.join();
		for (Person10 person : personList) {

			System.out.println(person);
		}

		System.out.println("OUTER JOIN");
		List<Person10> outerJoinList = personService.outerJoin();
		for (Person10 person : outerJoinList) {

			System.out.println(person);
		}

		entityManager.close();
		entityManagerFactory.close();

	}

}
