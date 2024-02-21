package com.example.multimediapfproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DietPage extends AppCompatActivity {
    private EditText tfCurrentWeight;
    private EditText tfTargetWeight;
    private EditText tfDaysToReach;
    private Button calculateButton;

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);





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
                    return true;
                }return false;
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////



















        tfCurrentWeight = findViewById(R.id.tfCurrentWeight);
        tfTargetWeight = findViewById(R.id.tfTargetWeight);
        tfDaysToReach = findViewById(R.id.tfDaysToReach);
        calculateButton = findViewById(R.id.button);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        String currentWeightStr = tfCurrentWeight.getText().toString();
        String targetWeightStr = tfTargetWeight.getText().toString();
        String daysToReachStr = tfDaysToReach.getText().toString();

        // If one of the text fields are empty
        if (currentWeightStr.isEmpty() || targetWeightStr.isEmpty() || daysToReachStr.isEmpty()) {
            // Display error message if any of the fields are empty
            Toast.makeText(DietPage.this, "Please fill all the needed information", Toast.LENGTH_SHORT).show();
            return;
        }

        double currentWeight = Double.parseDouble(currentWeightStr);
        double targetWeight = Double.parseDouble(targetWeightStr);
        int daysToReach = Integer.parseInt(daysToReachStr);

        // Calculate the calories needed to be burned
        double caloriesToBurn = (currentWeight - targetWeight) * 7700 / daysToReach;

        // Round the calories to the nearest integer value
        int roundedCalories = (int) Math.round(caloriesToBurn);

        // Pass the calculated calories to the diet output page
        Intent intent = new Intent(DietPage.this, DietOutput.class);
        intent.putExtra("currentWeight", currentWeightStr);
        intent.putExtra("targetWeight", targetWeightStr);
        intent.putExtra("daysToReach", daysToReachStr);
        intent.putExtra("caloriesToBurn", String.valueOf(roundedCalories));
        startActivity(intent);






    }


}
