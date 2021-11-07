package com.example.assignmentamey;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoView extends AppCompatActivity {
    private TextView name = null;
    private TextView location = null;
    private TextView url = null;
    private Button infoButton = null;
    private PersonDetails data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        name = findViewById(R.id.textView4);
        location = findViewById(R.id.textView6);
        url = findViewById(R.id.textView7);
        infoButton = findViewById(R.id.button);

        Intent intent = getIntent();
        data = (PersonDetails) intent.getExtras().getSerializable("names");

        name.setText(data.getName());
        location.setText(data.getLocation());
        url.setText(data.getUrl());

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(data.getUrl()));
                startActivity(intent);
            }
        });
    }
}
