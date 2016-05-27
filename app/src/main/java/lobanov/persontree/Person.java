package lobanov.persontree;

import java.util.Comparator;

public class Person implements Comparator<Person> {
    private String _firstname;
    private String _lastname;
    public Person(){
        _lastname = "notsetted";
        _firstname = "notsetted";
    }
    public Person(String lastname, String firstname) {
        _firstname = firstname;
        _lastname = lastname;
    }
    public String get_firstname(){
        return _firstname;
    }
    public String get_lastname(){
        return  _lastname;
    }
    public void set_firstname(String newfirstname){
        _firstname = newfirstname;
    }
    public void set_lastname(String newlastname){
        _lastname = newlastname;
    }

    public int compare(Person A, Person B) {
        return A.get_lastname().compareTo(B.get_lastname());
    }

    @Override
    public String toString() {
        return (_firstname+" "+_lastname);
    }
}