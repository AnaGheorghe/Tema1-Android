package com.example.tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView nameTV, aliasTV, abilitiesTV, actorTV,  plotTV;
    private Hero data=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // connect objects with widgets
        nameTV = findViewById(R.id.NameView);
        aliasTV = findViewById(R.id.aliasView);
        abilitiesTV = findViewById(R.id.abilitiesView);
        actorTV=findViewById(R.id.actorview);
        plotTV = findViewById(R.id.plotView);

        // get data ready from intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        data = (Hero)bundle.getSerializable("hero");

        // populate fields with data
        nameTV.setText("Name: " +data.getName());
        aliasTV.setText("Alias: "+data.getAlias());
        abilitiesTV.setText("Played by: "+data.getAbilities());
        actorTV.setText("Abilities: "+data.getActor());
        plotTV.setText("Movie plot: "+data.getPlot());

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(data.getUrl());


    }
}