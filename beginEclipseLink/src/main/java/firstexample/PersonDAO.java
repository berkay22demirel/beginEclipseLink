package firstexample;

import java.util.List;

public interface PersonDAO {

	public Person insertPerson(int id, String name, String surname, int age);

	public Person findPerson(int id);

	public List<Person> findAllPersons();

	public void removePerson(int id);

	public Person changePersonAge(int id, int age);

}
