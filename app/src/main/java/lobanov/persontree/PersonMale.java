package lobanov.persontree;

import java.util.Comparator;

public class PersonMale extends Person implements Comparable<Person>{
    public static Integer _norm = 10;
    private Integer _result = 0;
    public PersonMale(String lastname, String firstname, Integer result){
        super(lastname, firstname);
        _result=result;
    }
    public Integer get_result(){
        return _result;
    }
    public void set_result(Integer res){
        _result=res;
    }
    public boolean isComplied(){
        return _result>_norm;
    }

    @Override
    public String toString() {
        return (get_firstname()+" "+get_lastname()+" "+_result);
    }

    public static Integer get_norm(){
        return _norm;
    }

    public static void set_norm(Integer norm){
        PersonMale._norm = norm;
    }
    
    public int compareTo(Person B) {
        return get_lastname().compareTo(B.get_lastname());
    }
}
