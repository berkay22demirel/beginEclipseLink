package primarykey;

import java.util.List;

public interface PersonDAO {

	public Person3 insertPerson(String name, String surname, int age);

	public List<Person3> findAllPersons();

}
