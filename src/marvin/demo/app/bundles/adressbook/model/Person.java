package marvin.demo.app.bundles.adressbook.model;

//import javafx.beans.property.SimpleStringProperty;

public final class Person {
    
//    private final SimpleStringProperty firstName = new SimpleStringProperty("");
//    private final SimpleStringProperty lastName = new SimpleStringProperty("");
//    private final SimpleStringProperty email = new SimpleStringProperty("");
//
//    public Person() {
//        this("", "", "");
//    }
//    
//    public Person(String firstName, String lastName, String email) {
//        setFirstName(firstName);
//        setLastName(lastName);
//        setEmail(email);
//    }
//
//    public String getFirstName() {
//        return firstName.get();
//    }
// 
//    public void setFirstName(String fName) {
//        firstName.set(fName);
//    }
//        
//    public String getLastName() {
//        return lastName.get();
//    }
//    
//    public void setLastName(String fName) {
//        lastName.set(fName);
//    }
//    
//    public String getEmail() {
//        return email.get();
//    }
//    
//    public void setEmail(String fName) {
//        email.set(fName);
//    }
   
    private String firstName;
    private String lastName;
    private String email;

    public Person() {
    }
    
    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
}
