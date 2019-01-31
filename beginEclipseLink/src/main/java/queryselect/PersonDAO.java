package queryselect;

import java.util.List;

public interface PersonDAO {

	public Person9 insertPerson(String name, String surname, int age);

	public List<Person9> findAllPersons();

	public Person9 findPerson(int id);

	public String findPersonName(int id);

}
