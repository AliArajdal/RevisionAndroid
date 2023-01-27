package com.ali.revision;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.revision.model.Personne;

public class PersonneDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personne_details);

        Personne p = this.getIntent().getParcelableExtra("personne");

        ((ImageView)findViewById(R.id.image)).setImageResource(
                p.getImage()
        );
        ((TextView)findViewById(R.id.name)).setText(p.getName());
        ((TextView)findViewById(R.id.email)).setText(p.getEmail());

    }
}