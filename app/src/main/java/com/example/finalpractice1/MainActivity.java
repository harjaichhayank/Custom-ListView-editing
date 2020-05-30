package com.example.finalpractice1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button SortName, SortAge, Add;
    ListView listView;
    PersonAdapter personAdapter;
    MyFriends myFriends;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SortName = findViewById(R.id.button1);
        SortAge = findViewById(R.id.button2);
        Add = findViewById(R.id.button3);
        listView = findViewById(R.id.listView);

        myFriends = ((MyApplication) this.getApplication()).getMyFriends();

        personAdapter = new PersonAdapter(MainActivity.this, myFriends);

        listView.setAdapter(personAdapter);

        Bundle incomingMessages = getIntent().getExtras();

        if(incomingMessages != null){
            String name = incomingMessages.getString("name");
            int age = Integer.parseInt(Objects.requireNonNull(incomingMessages.getString("age")));
            int phoneNumber = Integer.parseInt(Objects.requireNonNull(incomingMessages.getString("phoneNumber")));
            int positionEdited = incomingMessages.getInt("edited");

            Person person = new Person(name,age,phoneNumber);

            if (positionEdited > -1){
                myFriends.getMyFriendsList().remove(positionEdited);
            }

            myFriends.getMyFriendsList().add(person);
            personAdapter.notifyDataSetChanged();

        }
        Add.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),NewPersonForm.class);
                startActivity(intent);
            }
        });

        SortName.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.getMyFriendsList());
                personAdapter.notifyDataSetChanged();
            }
        });

        SortAge.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.getMyFriendsList(), new Comparator<Person>() {
                    @Override
                    public int compare(Person person1, Person person2) {
                        return person1.getAge() - person2.getAge();
                    }
                });
                personAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), NewPersonForm.class);
                Person person = myFriends.getMyFriendsList().get(position);

                intent.putExtra("edited",position);
                intent.putExtra("name",person.getName());
                intent.putExtra("age",person.getAge());
                intent.putExtra("phoneNumber",person.getPhoneNumber());

                startActivity(intent);
            }
        });
    }
}
