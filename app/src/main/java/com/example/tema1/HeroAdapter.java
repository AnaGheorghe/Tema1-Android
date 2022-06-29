package com.example.tema1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class HeroAdapter extends ArrayAdapter<Hero> {
    private Context context;
    private Hero [] heroes;

    public HeroAdapter(Context context, Hero [] heroes){
        super(context, R.layout.row, heroes);

        this.context = context;
        this.heroes = heroes;

    }

    public View getView(int position, View view, ViewGroup group){

        View customView = View.inflate(this.context, R.layout.row, null);

        // get the components of custom view
        ImageView rowImageView   = customView.findViewById(R.id.imageView);
        TextView titleTextView  = customView.findViewById(R.id.textView);
        //TextView detailsTextView = customView.findViewById(R.id.textView1);

        //populate these components
        titleTextView.setText(this.heroes[position].getName());
        //detailsTextView.setText(this.heroes[position].getAlias());

        // transform image name to image id
        String imageName = this.heroes[position].getLogo();
        imageName = imageName.substring(0, imageName.indexOf("."));

        int imageId = this.context.getResources().getIdentifier(imageName,"drawable",this.context.getPackageName());
        rowImageView.setImageResource(imageId);

        return customView;
    }
}
