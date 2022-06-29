package com.example.tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView list = null;
    private HeroAdapter adapter = null;
    private Hero [] heroes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        heroes = (new XMLHeroData(this)).getHeroes();

        adapter = new HeroAdapter(this, heroes);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), heroes[i].getName(), Toast.LENGTH_SHORT).show();

                Intent intent= new Intent(MainActivity.this, HeroActivity.class);
                Bundle bundle=new Bundle();

                bundle.putSerializable("hero", heroes[i]);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });


    }
}