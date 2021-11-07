package com.example.assignmentamey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailView extends AppCompatActivity  {
    private TextView name = null;
    private PersonDetails data = null;
    private ImageView imageView=null;
    private Button InfoButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name = findViewById(R.id.textView5);
        InfoButton = findViewById(R.id.button2);
        imageView=findViewById(R.id.imageView);

        Intent intent = getIntent();
        data = (PersonDetails) intent.getExtras().getSerializable("names");
        int image= (int) intent.getExtras().getSerializable("images");


        name.setText(data.getName());
        imageView.setImageResource(image);

        InfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailView.this,InfoView.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("names",data);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });


    }
}
