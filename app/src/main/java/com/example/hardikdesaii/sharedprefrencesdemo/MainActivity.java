package com.example.hardikdesaii.sharedprefrencesdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,email,mobile;
    Button save;
    final String Myprefrences="Prefrences";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.EditTextName);
        email=(EditText)findViewById(R.id.EditTextEmail);
        mobile=(EditText)findViewById(R.id.EditTextNumber);

        // fetching data from sharedprefrences when app is startd for the second time after storing data in shared prefrences
        SharedPreferences prefrences=getSharedPreferences(Myprefrences, MODE_PRIVATE);
        name.setText(prefrences.getString(Constants.NAME,"Enter name"));
        email.setText(prefrences.getString(Constants.EMAIL,"Enter email"));
        mobile.setText(prefrences.getString(Constants.NUMBER,"Enter nubmer"));




        save=(Button)findViewById(R.id.ButtonSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  // initial code before fetching data from shared prefrences and for first time storing

                SharedPreferences prefrences=getSharedPreferences(Myprefrences, MODE_PRIVATE);
                String n  = name.getText().toString();
                String ph  = email.getText().toString();
                String e  = mobile.getText().toString();

                SharedPreferences.Editor editor = prefrences.edit();

                editor.putString(Constants.NAME, n);
                editor.putString(Constants.EMAIL, ph);
                editor.putString(Constants.NUMBER, e);
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks for Storing Data in Shared Prefrences", Toast.LENGTH_LONG).show();

            }
        });
    }
}
