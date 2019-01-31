package relationshipmanytoone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PersonDAOImpl implements PersonDAO {

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person4 insertPerson(String name, String surname, int age) {

		Person4 person = new Person4(name, surname, age);
		entityManager.persist(person);
		return person;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person4> findAllPersons() {

		Query query = entityManager.createQuery("SELECT p FROM Person4 p");
		return query.getResultList();

	}

}
