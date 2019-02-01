package querywhere;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PersonDAOImpl implements PersonDAO {

	private static final String SELECT_ALL = "SELECT p FROM Person11 p";
	private static final String WHERE = "SELECT p FROM Person11 p WHERE p.age < ?1";
	private static final String BETWEEN = "SELECT p FROM Person11 p WHERE p.age BETWEEN ?1 AND ?2";
	private static final String LIKE = "SELECT p FROM Person11 p WHERE p.name LIKE ?1";
	private static final String IN = "SELECT p FROM Person11 p WHERE p.name IN (?1, ?2)";

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person11 insertPerson(String name, String surname, int age) {

		Person11 person = new Person11(name, surname, age);
		entityManager.persist(person);
		return person;
	}

	@Override
	public List<Person11> findAllPersons() {

		TypedQuery<Person11> query = entityManager.createQuery(SELECT_ALL, Person11.class);
		return query.getResultList();

	}

	@Override
	public List<Person11> where(int arg1) {
		TypedQuery<Person11> query = entityManager.createQuery(WHERE,
				Person11.class).setParameter(1, arg1);
		return query.getResultList();
	}

	@Override
	public List<Person11> between(int arg1, int arg2) {
		TypedQuery<Person11> query = entityManager.createQuery(BETWEEN,
				Person11.class).setParameter(1, 18).setParameter(1, arg1).setParameter(2, arg2);
		return query.getResultList();
	}

	@Override
	public List<Person11> like(String name) {
		name = "%" + name + "%";

		TypedQuery<Person11> query = entityManager.createQuery(LIKE,
				Person11.class).setParameter(1, name);
		return query.getResultList();
	}

	@Override
	public List<Person11> in(String arg1, String arg2) {
		TypedQuery<Person11> query = entityManager.createQuery(IN,
				Person11.class).setParameter(1, arg1).setParameter(2, arg2);
		return query.getResultList();
	}


}
