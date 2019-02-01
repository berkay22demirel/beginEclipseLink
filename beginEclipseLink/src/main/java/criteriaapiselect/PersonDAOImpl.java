package criteriaapiselect;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PersonDAOImpl implements PersonDAO {

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person12 insertPerson(String name, String surname, int age) {

		Person12 person = new Person12(name, surname, age);
		entityManager.persist(person);
		return person;
	}

	@Override
	public List<Person12> selectAll() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person12> criteriaQuery = criteriaBuilder.createQuery(Person12.class);
		Root<Person12> root = criteriaQuery.from(Person12.class);
		criteriaQuery.select(root);
		TypedQuery<Person12> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();

	}

	@Override
	public List<String> selectAllName() {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Person12> root = criteriaQuery.from(Person12.class);
		criteriaQuery.multiselect(root.get("name"));
		TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
		
	}

	@Override
	public List<Tuple> SelectAllNameSurname() {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
		Root<Person12> root = criteriaQuery.from(Person12.class);
		criteriaQuery.multiselect(root.get("name"), root.get("surname"));
		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
		
	}


}
