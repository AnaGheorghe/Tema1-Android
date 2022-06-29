package com.example.tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroActivity extends AppCompatActivity {

    // objects
    private TextView heroTV  = null;
    private TextView heroTV2  = null;
    private ImageView heroIM = null;
    private Button heroInfoBT  = null;

    private Hero data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        data=(Hero)bundle.getSerializable("hero");

        // connect objects with widgets
        heroTV = findViewById(R.id.textView3);
        heroTV2 = findViewById(R.id.textView4);
        heroIM = findViewById(R.id.imageView2);
        heroInfoBT = findViewById(R.id.button);



        // populate the views with data
        heroTV.setText(data.getName());
        heroTV2.setText(data.getAlias());

        // get image name without extension
        String imageName = data.getImage();
        imageName = imageName.substring(0,imageName.indexOf("."));

        // get the image id
        int imageId = getResources().getIdentifier(imageName, "drawable",getPackageName());
        heroIM.setImageResource(imageId);

        // deal with the button
        heroInfoBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the indent
                Intent intent = new Intent(HeroActivity.this, DetailsActivity.class);

                // get a bundle to carry data
                Bundle bundle = new Bundle();
                bundle.putSerializable("hero", data);

                // put bundle to intent
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });


    }


}