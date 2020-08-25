package addressBook;


public class Person {
	public String name;
	public String firstName;
	public String lastName;
	public String street;
    public String city;
    public String state;
    public int zipcode;
    public int phoneNum;
    public static Integer counter = 0;
    public String phoneFmt = "(\\d{3})(\\d{3})(\\d{4})";


    public enum personInfo {
        FIRSTNAME, LASTNAME, STREET, CITY, STATE, ZIPCODE, PHONENUMBER;
    }
    
	public Person(String firstName, String lastName, String street, String city, 
				  String state, int zipcode, int phoneNum) {
        counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNum = phoneNum;
	}
	
    public String convertToString() {
        StringBuilder str = new StringBuilder();

        
        str.append(this.firstName)
           .append(",")
           .append(this.lastName)
           .append(",")
           .append(this.street)
           .append(",")
           .append(this.city)
           .append(",")
           .append(this.state)
           .append(",")
           .append(this.zipcode)
           .append(",")
           .append(this.phoneNum)
           .append("\n");
        
        return str.toString();
    }
	
    public void loadFromString(String line) {


        try{    
            String[] values = line.split(",");
            if(values.length != 7) {
                throw new Exception();
            }
            
            this.firstName = values[0];
            this.lastName = values[1];
            this.street = values[2];
            this.city = values[3];
            this.state = values[4];
            this.zipcode = Integer.parseInt(values[5]);
            this.phoneNum = Integer.parseInt(values[6]);
        }
        catch (Exception e)
        {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public void updateAnimal(Integer opt, String arg) {
        

        /* Using the ordinal value in personInfo enum and option to 
        *   identify what type of data is being passed to be updated. This is
        *   done as multiple Person properties share data types.
        */
        personInfo option = personInfo.values()[opt];
        
        /* Enum personInfo used to make switch case for Person info updater
        *   code more human readable.
        *   NAME, STREET, CITY, STATE, ZIPCODE, PHONENUMBER
        */
         try {
            switch(option) {
                case FIRSTNAME:
                    this.firstName = arg;
                    break;
                case LASTNAME:
                    this.lastName = arg;
                    break;
                case STREET:
                    this.street = arg;
                    break;
                case CITY:
                    this.city = arg;
                    break;
                case STATE:
                    this.state = arg;
                    break;
                case ZIPCODE:
                    this.zipcode = Integer.parseInt(arg);
                    break;
                case PHONENUMBER:
                    this.phoneNum = Integer.parseInt(arg);
                    break;
                default:
            }
        }
        catch(Exception except) {
                System.out.println("Error " + except.getMessage());
            }
    }
    
    
    public void setFisrtName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public void setZip(int zipcode) {
    	this.zipcode = zipcode;
    }
    
    public void setPhoneNum(int phoneNum) {
    	this.phoneNum = phoneNum;
    }
    
    public String getName() {
    	return this.firstName + " " + this.lastName;
    }
    
    public String getStreet() {
        return this.street;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public String getState() {
        return this.state;
    }
    
    public int getZip() {
        return this.zipcode;
    }
    
    public String getPhoneNum() {
    	String tempNum = Integer.toString(this.phoneNum);
    	return tempNum.replaceFirst(this.phoneFmt, "$1-$2-%3");
    }
    
}
