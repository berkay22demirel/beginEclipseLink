package criteriaapiselect;

import java.util.List;

import javax.persistence.Tuple;

public interface PersonDAO {

	public Person12 insertPerson(String name, String surname, int age);

	public List<Person12> selectAll();

	public List<String> selectAllName();

	public List<Tuple> SelectAllNameSurname();

}
