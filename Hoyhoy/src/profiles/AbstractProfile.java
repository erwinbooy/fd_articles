package profiles;

public abstract class AbstractProfile implements Profile{
	
	private Address address = null;
	private Person person = null;
	
	/**
	 * Most simple constructor using Person and Address
	 * @param person
	 * @param address
	 */
	public AbstractProfile(Person myPerson, Address myAddress){
		person = myPerson;
		address = myAddress;
	}
	
	public Address getAddress(){
		return address;
	}
	
	public Person getPerson(){
		return person;
	}
}
