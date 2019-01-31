package embeddedobjects;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PersonDAOImpl implements PersonDAO {

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person7 insertPerson(String name, String surname, int age) {

		Person7 person = new Person7(name, surname, age);
		entityManager.persist(person);
		return person;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person7> findAllPersons() {

		Query query = entityManager.createQuery("SELECT p FROM Person7 p");
		return query.getResultList();

	}

}
