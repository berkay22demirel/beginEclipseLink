package relationshipmanytoone;

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
		Person4 person1 = personService.insertPerson("Berkay", "DEMİREL", 24);
		Person4 person2 = personService.insertPerson("EclipseLink", "Test", 12);
		entityTransaction.commit();
		
		DepartmentDAO departmentService = new DepartmentDAOImpl(entityManager);
		
		entityTransaction.begin();
		Department department1 = departmentService.insertDepartment("Software Development");
		Department department2 = departmentService.insertDepartment("JPA");
		entityTransaction.commit();

		entityTransaction.begin();
		person1.setDepartment(department1);
		person2.setDepartment(department2);
		entityTransaction.commit();

		System.out.println("All Persons");
		List<Person4> personList = personService.findAllPersons();
		for (Person4 person : personList) {

			System.out.println(person);
		}

		entityManager.close();
		entityManagerFactory.close();

	}

}
