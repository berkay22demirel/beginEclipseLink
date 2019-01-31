package queryselect;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PersonDAOImpl implements PersonDAO {

	private static final String SELECT_ALL = "Select p FROM Person9 p";
	private static final String SELECT_BY_ID = "Select p FROM Person9 p WHERE p.id = ?1";
	private static final String SELECT_NAME = "Select p.name FROM Person9 p WHERE p.id = :id";

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person9 insertPerson(String name, String surname, int age) {

		Person9 person = new Person9(name, surname, age);
		entityManager.persist(person);
		return person;
	}

	@Override
	public List<Person9> findAllPersons() {

		TypedQuery<Person9> query = entityManager.createQuery(SELECT_ALL, Person9.class);
		return query.getResultList();

	}

	@Override
	public Person9 findPerson(int id) {
		
		TypedQuery<Person9> query = entityManager.createQuery(SELECT_BY_ID,
				Person9.class).setParameter(1, id);
		return query.getSingleResult();
	}

	@Override
	public String findPersonName(int id) {
		
		TypedQuery<String> query = entityManager.createQuery(SELECT_NAME,
				String.class).setParameter("id", id);
		return query.getSingleResult();
	}

}
