package com.example.multimediapfproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class addForumPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfroum);




        //include layout
        View includedLayout = findViewById(R.id.actionbar);
        TextView title = includedLayout.findViewById(R.id.titleAction);
        title.setText("Forum");
        ImageButton baki= includedLayout.findViewById(R.id.home);
        baki.setOnClickListener(v -> {
            finish();
        });

        ImageButton profileButton = includedLayout.findViewById(R.id.profileButt);
        profileButton.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), profile.class));
        });

        ////////////////////////////////////////////////////////////////



        //BOTTOM NAVIGATION
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.forumButton);
        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.forumButton){
                    return true;
                } else if (itemId == R.id.homeButton) {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                } else if (itemId == R.id.dietButton) {
                    startActivity(new Intent(getApplicationContext(), DietPage.class));
                    overridePendingTransition(0,0);
                    return true;
                }return false;
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////




    }
}