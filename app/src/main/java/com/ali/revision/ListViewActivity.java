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
import com.ali.revision.model.Personne;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = findViewById(R.id.list_view);

        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne(1, R.drawable.ic_launcher_background, "ali", "example@gmail.com"));
        personnes.add(new Personne(2, R.drawable.image1, "mohcine", "mohcine@gmail.com"));

        listView.setAdapter(new PersonneAdapter(this, personnes));

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Personne p = personnes.get(position);
            Intent i = new Intent(this, PersonneDetailsActivity.class);
            i.putExtra("personne", p);
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