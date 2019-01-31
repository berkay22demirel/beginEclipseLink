package primarykey;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PersonDAOImpl implements PersonDAO {

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person3 insertPerson(String name, String surname, int age) {

		Person3 person = new Person3(name, surname, age);
		entityManager.persist(person);
		return person;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person3> findAllPersons() {

		Query query = entityManager.createQuery("SELECT p FROM Person3 p");
		return query.getResultList();

	}

}
