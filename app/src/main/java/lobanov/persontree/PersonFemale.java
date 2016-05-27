package lobanov.persontree;

import java.util.Comparator;

public class PersonFemale extends Person implements Comparable<Person>{
    private static Integer _norm = 5;
    private Integer _result = 0;
    public PersonFemale(String lastname,String firstname,Integer result){
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
        PersonFemale._norm = norm;
    }


    public int compareTo(Person B) {
        return get_lastname().compareTo(B.get_lastname());
    }
}