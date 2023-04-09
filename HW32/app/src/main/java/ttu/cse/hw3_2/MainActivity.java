package ttu.cse.hw3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TextWatcher {
    Spinner spin1;
    Spinner spin2;
    EditText edit1;
    EditText edit2;
    int num1,num2;
    double db1,db2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin1=findViewById(R.id.spinner);
        spin1.setOnItemSelectedListener(this);
        spin2=findViewById(R.id.spinner2);
        spin2.setOnItemSelectedListener(this);
        edit1=findViewById(R.id.editTextTextPersonName);
        edit1.addTextChangedListener(this);
        edit2=findViewById(R.id.editTextTextPersonName2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            cal();
    }

    protected  void cal(){
        num1=spin1.getSelectedItemPosition();
        num2=spin2.getSelectedItemPosition();
        try{
            db1=Double.parseDouble(edit1.getText().toString());
        }
        catch(Exception e){
            db1=0;
        }
        if(num1==num2)
        {
            db2=db1;

        }
        else if(num1==0&&num2==1)
        {
            db2=db1*9/5+32;
        }
        else if(num1==0&&num2==2)
        {
            db2=db1+273.15;
        }
        else if(num1==1&&num2==0)
        {
            db2=(db1-32)*5/9;
        }
        else if(num1==1&&num2==2)
        {
            db2=(db1+459.67)*5/9;
        }
        else if(num1==2&&num2==0)
        {
            db2=db1-273.15;
        }
        else if(num1==2&&num2==1)
        {
            db2=db1*9/5-459.67;
        }
        edit2.setText(String.format("%.2f",db2));
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
            cal();
    }
}