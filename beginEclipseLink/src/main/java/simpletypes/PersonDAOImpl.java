package simpletypes;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PersonDAOImpl implements PersonDAO {

	private EntityManager entityManager;

	public PersonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Person2 insertPerson(int id, String name, String surname, int age,
			int salary, JobEnum job, Date dateOfBirth, Calendar nowDate,
			byte[] picture) {

		Person2 person = new Person2(id, name, surname, age, salary, job,
				dateOfBirth, nowDate, picture);
		entityManager.persist(person);
		return person;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person2> findAllPersons() {

		Query query = entityManager.createQuery("SELECT p FROM Person2 p");
		return query.getResultList();

	}

}
