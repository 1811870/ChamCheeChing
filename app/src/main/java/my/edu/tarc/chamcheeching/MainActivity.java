package my.edu.tarc.chamcheeching;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public Spinner spinnerAge;
    public CheckBox checkBoxStudent;
    public CheckBox checkBoxDisabled;
    public CheckBox checkBoxHaj;
    private TextView textViewFee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = findViewById(R.id.spinner1);
        checkBoxStudent = findViewById(R.id.checkBoxStudent);
        checkBoxDisabled = findViewById(R.id.checkBoxDisabled);
        checkBoxHaj = findViewById(R.id.checkBoxHaj);
        textViewFee = findViewById(R.id.textViewFee);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculateFee(View view)
    {
        int position;
        int group;
        int disabled;
        double fee = 0;
        position = spinnerAge.getSelectedItemPosition();
        switch(position)
        {
            case 0:
                fee += 100;
                break;

            case 1:
                fee += 200;

                if(checkBoxStudent.isChecked())
                {
                    fee = 100;
                }

                break;

            case 2:
                fee+=200;
                break;

            case 3:
                fee+=100;
                break;
        }

        if(checkBoxHaj.isChecked())
        {
            fee = 100;
        }

        if(checkBoxDisabled.isChecked())
        {
            fee = 0;
        }

        textViewFee.setText("RM " + fee + "");
    }

    public void reset(View view)
    {
        spinnerAge.setSelection(0);
        checkBoxStudent.setChecked(false);
        checkBoxDisabled.setChecked(false);
        checkBoxHaj.setChecked(false);
        textViewFee.setText("RM " + 0.00 + "");
    }
}
