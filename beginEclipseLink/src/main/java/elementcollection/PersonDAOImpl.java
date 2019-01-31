package elementcollection;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PersonDAOImpl implements PersonDAO {

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person8 insertPerson(String name, String surname, int age) {

		Person8 person = new Person8(name, surname, age);
		entityManager.persist(person);
		return person;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person8> findAllPersons() {

		Query query = entityManager.createQuery("SELECT p FROM Person8 p");
		return query.getResultList();

	}

}
