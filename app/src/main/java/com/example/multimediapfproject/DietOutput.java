package com.example.multimediapfproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DietOutput extends AppCompatActivity {
    private TextView caloriesToBurnTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietoutput);

        caloriesToBurnTextView = findViewById(R.id.txtCaloriesToBurn);

        Intent intent = getIntent();
        if (intent != null) {
            String currentWeight = intent.getStringExtra("currentWeight");
            String targetWeight = intent.getStringExtra("targetWeight");
            String daysToReach = intent.getStringExtra("daysToReach");
            String caloriesToBurn = intent.getStringExtra("caloriesToBurn");

            caloriesToBurnTextView.setText("Calories to Burn: " + caloriesToBurn);
        }


        //include layout
        View includedLayout = findViewById(R.id.actionbar);
        TextView title = includedLayout.findViewById(R.id.titleAction);
        title.setText("Diet");
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
        bottomNavigationView.setSelectedItemId(R.id.dietButton);
        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.forumButton){
                    startActivity(new Intent(getApplicationContext(), ForumPage.class));
                    overridePendingTransition(0,0);
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
