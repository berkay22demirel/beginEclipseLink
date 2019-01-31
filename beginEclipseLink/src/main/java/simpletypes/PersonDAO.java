package simpletypes;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface PersonDAO {

	public Person2 insertPerson(int id, String name, String surname, int age,
			int s, JobEnum job, Date dateOfBirth, Calendar nowDate,
			byte[] picture);

	public List<Person2> findAllPersons();

}
