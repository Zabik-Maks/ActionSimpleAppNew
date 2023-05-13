package com.mirea.kt.actionsimpleappnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements PersonAdapter.OnPersonClickListener{

    @Override
    public void onPersonClick(Person person, int position){
        Toast.makeText(this, "Click on " +
                person.getFirstName() +
                " " +
                person.getLastName(),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Second");
            ab.setHomeButtonEnabled(true); // включение поддержки кнопки назад в экшнбаре
            ab.setDisplayHomeAsUpEnabled(true); // отображение кнопки назад
        }

        // имитация получения списка
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Ivan", "Ivanov", 19, null));
        persons.add(new Person("Petya", "Petrov", 18, null));
        persons.add(new Person("Masha", "Mashina", 28, null));
        persons.add(new Person("John", "Wick", 45, null));
        RecyclerView rcView = findViewById(R.id.recyclerView);
        PersonAdapter adapter = new PersonAdapter(persons, this);                 // maybe this idk  .............!!!!!
        rcView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        rcView.setAdapter(adapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.simple_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_favorite) {
            Toast.makeText(this, "Click favorite icon on Toolbar",
                    Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.action_update) {
            Toast.makeText(this, "Click update on Toolbar",
                    Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.action_exit) {
            finish();
            return true;
        } else if (itemId == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//
//    @Override
//    public void onClick(View v) {
//        if(v.getId() == R.id.btnStartActivity){
//            Intent intent = new Intent(this,TestFragmentActivity.class);
//            startActivity(intent);
//        }
//    }




}