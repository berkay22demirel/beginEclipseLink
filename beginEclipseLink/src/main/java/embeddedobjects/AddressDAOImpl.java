package embeddedobjects;


public class AddressDAOImpl implements AddressDAO {

	@Override
	public Address insertAddress(String city) {

		return new Address(city);
	}

}
