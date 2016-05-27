package lobanov.persontree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    TreeSet<Person> Persons = new TreeSet<Person>();
    TextView textViewFirstname, textViewLastname, textViewSex, textViewResult, textViewTest;
    Button buttonConfirm, buttonShow;
    EditText editTextFirstname, editTextLastname,editTextResult;
    RadioGroup radioGroupSex;
    RadioButton radioButtonMale,radioButtonFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewFirstname = (TextView) findViewById(R.id.textViewFirstname);
        textViewLastname = (TextView) findViewById(R.id.textViewLastname);
        textViewSex = (TextView) findViewById(R.id.textViewSex);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textViewTest = (TextView) findViewById(R.id.textViewTest);
        editTextFirstname = (EditText) findViewById(R.id.editTextFirstname);
        editTextLastname = (EditText) findViewById(R.id.editTextLastname);
        editTextResult = (EditText) findViewById(R.id.editTextResult);
        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
        buttonShow = (Button) findViewById(R.id.buttonShow);
        radioGroupSex = (RadioGroup) findViewById(R.id.radioGroupSex);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);


        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroupSex.getCheckedRadioButtonId()==R.id.radioButtonMale)
                {
                    PersonMale P = new PersonMale(
                        editTextFirstname.getText().toString(),
                        editTextLastname.getText().toString(),
                        Integer.parseInt(editTextResult.getText().toString()));
                    editTextLastname.setText("");
                    editTextFirstname.setText("");
                    editTextResult.setText("");
                    radioGroupSex.clearCheck();
                    //textViewTest.setText(P.get_firstname() + " " + P.get_lastname() + " " + P.get_result());
                    Persons.add(P);
                }
                else if (radioGroupSex.getCheckedRadioButtonId()==R.id.radioButtonFemale)
                {
                    PersonFemale F = new PersonFemale(
                            editTextFirstname.getText().toString(),
                            editTextLastname.getText().toString(),
                            Integer.parseInt(editTextResult.getText().toString()));
                    editTextLastname.setText("");
                    editTextFirstname.setText("");
                    editTextResult.setText("");
                    radioGroupSex.clearCheck();
                    Persons.add(F);
                }
            }
        });
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewTest.setText("");
                for (Person p : Persons
                     ) {
                    if (p.getClass().toString().equals("class lobanov.persontree.PersonMale")) {
                        textViewTest.setText(textViewTest.getText() + p.get_firstname() + " " + p.get_lastname() + " " + ((PersonMale)p).get_result() + "\r\n");
                    }
                    else if (p.getClass().toString().equals("class lobanov.persontree.PersonFemale")) {
                        textViewTest.setText(textViewTest.getText() + p.get_firstname() + " " + p.get_lastname() + " " + ((PersonFemale)p).get_result() + "\r\n");
                    }
                }

            }
        });
    }

}
