package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListView expandableListView = findViewById(R.id.expandableListView);

        HashMap<String, List<String>> item = new HashMap<>();

        ArrayList<String> personGroups = new ArrayList<>();
        personGroups.add("Fatmir");
        personGroups.add("Jesper");
        personGroups.add("Pooneh");

        item.put("Person", personGroups);

        ArrayList<String> breakfastGroups = new ArrayList<>();
        breakfastGroups.add("Egg");
        breakfastGroups.add("Milk");
        breakfastGroups.add("Toast");
        breakfastGroups.add("Bacon");

        item.put("Breakfast", breakfastGroups);

        ArrayList<String> carsGroup = new ArrayList<>();
        carsGroup.add("Mercedes");
        carsGroup.add("Volvo");
        carsGroup.add("BMW");
        carsGroup.add("Audi");

        item.put("Cars", carsGroup);

        ArrayList<String> weatherGroup = new ArrayList<>();
        weatherGroup.add("Sunny");
        weatherGroup.add("Cloudy");
        weatherGroup.add("Rainy");

        item.put("Weather", weatherGroup);

        ArrayList<String> drinksGroup = new ArrayList<>();
        drinksGroup.add("Coco-Cola");
        drinksGroup.add("Fanta");
        drinksGroup.add("Pepsi-Max");
        drinksGroup.add("Sprite");

        item.put("Drinks", drinksGroup);

        ArrayList<String> brandsGroup = new ArrayList<>();
        brandsGroup.add("Versace");
        brandsGroup.add("Gucci");
        brandsGroup.add("Adidas");
        brandsGroup.add("Nike");

        item.put("Brands", brandsGroup);

        ArrayList<String> starsGroup = new ArrayList<>();
        starsGroup.add("Ronaldo");
        starsGroup.add("Zlatan");
        starsGroup.add("Zidane");
        starsGroup.add("Thierry Henry");

        item.put("Stars", starsGroup);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);


        // Attempt to launch activity outside our own app
        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webAddress = Uri.parse(google);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webAddress);
                if (gotoGoogle.resolveActivity(getPackageManager()) !=null) {
                    startActivity(gotoGoogle);
                }
            }
        });
    }
}
