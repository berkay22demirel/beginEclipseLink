package relationshipmanytomany;

import java.util.List;

public interface PersonDAO {

	public Person5 insertPerson(String name, String surname, int age);

	public List<Person5> findAllPersons();

}
