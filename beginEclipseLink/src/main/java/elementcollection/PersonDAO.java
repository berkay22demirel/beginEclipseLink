package elementcollection;

import java.util.List;

public interface PersonDAO {

	public Person8 insertPerson(String name, String surname, int age);

	public List<Person8> findAllPersons();

}
