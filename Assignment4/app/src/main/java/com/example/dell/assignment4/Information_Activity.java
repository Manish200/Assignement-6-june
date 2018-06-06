package com.example.dell.assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Dell on 06-06-2018.
 */

public class Information_Activity extends AppCompatActivity
{
    int Postion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_display);

         final TextView name=findViewById(R.id.text_name);
         final TextView email=findViewById(R.id.Text_mail);
         final TextView mobile=findViewById(R.id.text_mobile);
         TextView state=findViewById(R.id.text_state);
         final TextView city=findViewById(R.id.text_city);
         Button back=findViewById(R.id.button_submit);


        Postion=Integer.parseInt(getIntent().getStringExtra("state_position"));
        Log.d("TEST",Postion+"");
        name.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("mail"));
        mobile.setText(getIntent().getStringExtra("phone"));
        state.setText(getIntent().getStringExtra("state"));
        city.setText(getIntent().getStringExtra("city"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Information_Activity.this,MainActivity.class);
                intent.putExtra("name2",name.getText().toString());
                intent.putExtra("mail2",email.getText().toString());
                intent.putExtra("phone2",mobile.getText().toString());
                intent.putExtra("city2",city.getText().toString());
                intent.putExtra("string_position",Postion);
                startActivity(intent);
            }
        });


    }
}
