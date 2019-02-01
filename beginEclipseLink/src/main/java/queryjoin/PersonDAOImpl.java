package queryjoin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PersonDAOImpl implements PersonDAO {

	private static final String JOIN = "Select p FROM Person10 p JOIN p.department d";
	private static final String OUTER_JOIN = "Select p FROM Person10 p LEFT JOIN p.department d";

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person10 insertPerson(String name, String surname, int age) {

		Person10 person = new Person10(name, surname, age);
		entityManager.persist(person);
		return person;
	}

	@Override
	public List<Person10> join() {

		TypedQuery<Person10> query = entityManager.createQuery(JOIN, Person10.class);
		return query.getResultList();

	}

	@Override
	public List<Person10> outerJoin() {
		
		TypedQuery<Person10> query = entityManager.createQuery(OUTER_JOIN, Person10.class);
		return query.getResultList();
		
	}

}
