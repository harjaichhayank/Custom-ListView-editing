package com.example.finalpractice1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class NewPersonForm extends AppCompatActivity {

    Button okay;
    EditText Name,Age,PhoneNumber;
    int positionToEdit = -1;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);

        okay = findViewById(R.id.okay);
        Name = findViewById(R.id.EditTextName);
        Age = findViewById(R.id.EditTextAge);
        PhoneNumber = findViewById(R.id.EditTextNum);

        Bundle incomingIntent = getIntent().getExtras();

        if(incomingIntent != null) {
            String name = incomingIntent.getString("name");
            int age = incomingIntent.getInt("age");
            int phoneNumber = incomingIntent.getInt("phoneNumber");
            positionToEdit = incomingIntent.getInt("edited");

            Name.setText(name);
            Age.setText(String.valueOf(age));
            PhoneNumber.setText(String.valueOf(phoneNumber));
        }

        okay.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get strings
                String newName = Name.getText().toString();
                String newAge = Age.getText().toString();
                String newPhoneNumber = PhoneNumber.getText().toString();

                Intent intent1 = new Intent(v.getContext(), MainActivity.class);
                //store in messages
                intent1.putExtra("edited",positionToEdit);
                intent1.putExtra("name",newName);
                intent1.putExtra("age",newAge);
                intent1.putExtra("phoneNumber",newPhoneNumber);

                startActivity(intent1);
            }
        });
    }
}
