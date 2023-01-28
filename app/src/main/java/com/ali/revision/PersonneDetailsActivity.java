package com.ali.revision;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.revision.model.Personne;
import com.ali.revision.model.User;

public class PersonneDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personne_details);

        User u = this.getIntent().getParcelableExtra("user");

        ((ImageView)findViewById(R.id.image)).setImageResource(R.drawable.image1);
        ((TextView)findViewById(R.id.name)).setText(u.getNom());
        ((TextView)findViewById(R.id.email)).setText(u.getEmail());

    }
}