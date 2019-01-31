package embeddedobjects;

import java.util.List;

public interface PersonDAO {

	public Person7 insertPerson(String name, String surname, int age);

	public List<Person7> findAllPersons();

}
