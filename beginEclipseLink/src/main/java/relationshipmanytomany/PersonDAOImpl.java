package relationshipmanytomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PersonDAOImpl implements PersonDAO {

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person5 insertPerson(String name, String surname, int age) {

		Person5 person = new Person5(name, surname, age);
		entityManager.persist(person);
		return person;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person5> findAllPersons() {

		Query query = entityManager.createQuery("SELECT p FROM Person5 p");
		return query.getResultList();

	}

}
