package com.example.personinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonActivity extends AppCompatActivity {

    //objects

    private ImageView personImageView = null;
    private TextView nameTextView = null;
    private Button moreInfoButton = null;

    //data
    private Person data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wire
        personImageView = findViewById(R.id.imageView);
        nameTextView = findViewById(R.id.textView);
        moreInfoButton = findViewById(R.id.button);

        //create data
        data = new Person("Peter Griffin", "Quahog", "6969420","https://petergriffin.com", "peter.png");

        //populate widgets with data
        nameTextView.setText(data.getName());
        String imageName = data.getImage();
        Log.d("DEBUG-->", imageName);
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageID = this.getResources().getIdentifier(imageName, "drawable", getPackageName());
        personImageView.setImageResource(imageID);

    }
}