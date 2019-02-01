package querywhere;

import java.util.List;

public interface PersonDAO {

	public Person11 insertPerson(String name, String surname, int age);

	public List<Person11> findAllPersons();

	public List<Person11> where(int arg1);

	public List<Person11> between(int arg1, int arg2);

	public List<Person11> like(String name);

	public List<Person11> in(String arg1, String arg2);

}
