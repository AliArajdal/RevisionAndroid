package com.ali.revision;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ali.revision.adapter.PersonneAdapter;
import com.ali.revision.adapter.UserAdapter;
import com.ali.revision.database.Dao;
import com.ali.revision.model.Personne;
import com.ali.revision.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = findViewById(R.id.list_view);
        Dao dao = new Dao(this);
        dao.open();
        List<User> users = dao.allUsers();
        listView.setAdapter(new UserAdapter(this, users));

        listView.setOnItemClickListener((parent, view, position, id) -> {
            User u = users.get(position);
            Intent i = new Intent(this, PersonneDetailsActivity.class);
            i.putExtra("user", u);
            startActivity(i);

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_personne:
                Intent it = new Intent(this, AddPersonneActivity.class);
                startActivity(it);
                break;
            case R.id.exit:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}