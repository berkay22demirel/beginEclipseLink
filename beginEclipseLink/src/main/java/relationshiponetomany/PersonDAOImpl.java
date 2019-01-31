package relationshiponetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PersonDAOImpl implements PersonDAO {

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person6 insertPerson(String name, String surname, int age) {

		Person6 person = new Person6(name, surname, age);
		entityManager.persist(person);
		return person;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person6> findAllPersons() {

		Query query = entityManager.createQuery("SELECT p FROM Person6 p");
		return query.getResultList();

	}

}
