package relationshiponetomany;

import java.util.List;

public interface PersonDAO {

	public Person6 insertPerson(String name, String surname, int age);

	public List<Person6> findAllPersons();

}
