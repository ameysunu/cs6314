package ie.ucc.stabirca.recycleviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private DataAdapter adapter = null;
    private String names [] = null;
    private PeopleXMLData data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recyclerView and simple setups
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //make data
        data = new PeopleXMLData(this);
        names = data.getNames();

        // Adaptor
        adapter = new DataAdapter(names, R.layout.row_layout, this);
        recyclerView.setAdapter(adapter);

    }
}