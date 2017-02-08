/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvin.adressbook.repository;

import java.util.ArrayList;
import java.util.List;
import marvin.adressbook.model.Person;

/**
 *
 * @author cdi305
 */
public class PersonRepository {
    
    private static PersonRepository instance;

    private PersonRepository() {
    }
    
    public static PersonRepository getInstance(){
        if(instance == null) {
            instance = new PersonRepository();
        }
        
        return instance;
    }
    
    private List<Person> all = new ArrayList<>();
    
    private Person jac = new Person("Jacob", "Smith", "jacob.smith@example.com");
    private Person isa = new Person("Isabella", "Johnson", "isabella.johnson@example.com");
    private Person eth = new Person("Ethan", "Williams", "ethan.williams@example.com");
    private Person emm = new Person("Emma", "Jones", "emma.jones@example.com");
    private Person mic = new Person("Michael", "Brown", "michael.brown@example.com");
    
    public List<Person> getAll(){
        if(all.isEmpty()) {
            all.add(jac);
            all.add(isa);
            all.add(eth);
            all.add(emm);
            all.add(mic);
        }
        
        return all;
    }
    
}
