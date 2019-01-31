package elementcollection;

import javax.persistence.Embeddable;

@Embeddable
public class Phone {

	private String number;

	public Phone() {
		super();
	}

	public Phone(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Phone [number=" + number + "]";
	}

}
