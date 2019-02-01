package queryjoin;

import java.util.List;

public interface PersonDAO {

	public Person10 insertPerson(String name, String surname, int age);

	public List<Person10> join();

	public List<Person10> outerJoin();

}
