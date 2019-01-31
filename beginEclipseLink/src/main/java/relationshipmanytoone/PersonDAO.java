package relationshipmanytoone;

import java.util.List;

public interface PersonDAO {

	public Person4 insertPerson(String name, String surname, int age);

	public List<Person4> findAllPersons();

}
