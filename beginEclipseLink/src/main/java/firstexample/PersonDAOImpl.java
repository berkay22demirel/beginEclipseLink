package firstexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PersonDAOImpl implements PersonDAO {

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Person insertPerson(int id, String name, String surname, int age) {

		Person person = new Person(id, name, surname, age);
		entityManager.persist(person);
		return person;
	}

	public Person findPerson(int id) {

		return entityManager.find(Person.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Person> findAllPersons() {

		Query query = entityManager.createQuery("SELECT p FROM Person p");
		return query.getResultList();

	}

	public void removePerson(int id) {

		Person person = findPerson(id);
		if (person != null) {
			entityManager.remove(person);
		}
	}

	public Person changePersonAge(int id, int age) {

		Person person = findPerson(id);
		if (person != null) {
			person.setAge(age);
		}
		return person;

	}

}
