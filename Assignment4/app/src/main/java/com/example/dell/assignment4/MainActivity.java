package com.example.dell.assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String states;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = findViewById(R.id.edit_name);
        final EditText email = findViewById(R.id.email);
        final EditText mobileNo = findViewById(R.id.MobNo);
        final EditText city = findViewById(R.id.City);
        final Spinner state = findViewById(R.id.statename);
       Button submit = findViewById(R.id.submit);

        final String ALLstates[] = {"Uttrakhand", "Uttar Pradesh", "Himachal Pradesh", "Madhya Pradesh", "Odisha"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ALLstates);
        state.setAdapter(arrayAdapter);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                states = ALLstates[i];
                position=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "You haven't selected anything ! ", Toast.LENGTH_LONG).show();
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Information_Activity.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("mail", email.getText().toString());
                intent.putExtra("phone", mobileNo.getText().toString());
                intent.putExtra("state", states);
                intent.putExtra("state_position", (position)+"");
                intent.putExtra("city", city.getText().toString());
                startActivity(intent);
            }
        });

        name.setText(getIntent().getStringExtra("name2"));
        email.setText(getIntent().getStringExtra("mail2"));
        mobileNo.setText(getIntent().getStringExtra("phone2"));
        city.setText(getIntent().getStringExtra("city2"));
        position=getIntent().getIntExtra("string_position",0);
        state.setSelection(position);


    }
}
