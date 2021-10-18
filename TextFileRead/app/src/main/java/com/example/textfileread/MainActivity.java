package com.example.textfileread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.textView);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/people.xml";
        Log.d("DEBUG++>", Environment.getExternalStorageDirectory().getAbsolutePath());
        //new FileAsyncTask().execute(path);
        new FileAsyncTask().execute("http://www.cs.ucc.ie/~stabirca/people.xml");
    }

    //make async task
    public class FileAsyncTask extends AsyncTask<String, String, Void>{
        @Override
        protected Void doInBackground(String... strings) {

            //get the file from sdcard
            String path = strings[0];

            try {
                /*
                //make a stream and a reader from sdcard file
                File f = new File(path);
                InputStream is = new FileInputStream(f);
                */

                //make a stream and reader from URL
                URL url = new URL(path);
                InputStream is = url.openStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line = "";

                // read a line and publish it
                while((line = reader.readLine())!=null){
                    Thread.sleep(1000);
                    publishProgress(line);
                }


                //close
                reader.close(); is.close();
            } catch (Exception e){

            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //interface work before doInBack
            view.setText("Test\n\n");
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            //interface work after doInBack
            view.append("\n\nNew Test Appended");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            // append line to view
           String line = values[0];
           view.append(line + "\n");
        }
    }
}