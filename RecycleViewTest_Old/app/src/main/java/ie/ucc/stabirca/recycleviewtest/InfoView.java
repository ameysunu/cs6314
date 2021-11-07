package ie.ucc.stabirca.recycleviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoView extends AppCompatActivity {

    private TextView name = null;
    private ImageView dp = null;
    private Button infoButton;

    private Person data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.textView2);
        dp = findViewById(R.id.imageView2);
        infoButton = findViewById(R.id.button);

        data = new Person("Peter Griffin", "Quahog", "3434243434", "https://peter.com", "peter.jpg");

        name.setText(data.getName());
        String imageName = data.getImage();
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageID = this.getResources().getIdentifier(imageName, "drawable", getPackageName());

        dp.setImageResource(imageID);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
