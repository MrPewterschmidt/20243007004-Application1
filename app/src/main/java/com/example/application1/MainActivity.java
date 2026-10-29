package com.example.application1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Handles clicks on the Facilities button and opens its detail page.
    public void facilitiesClicked(View view) {
        openDetail(0);
    }

    // Handles clicks on the Events button and opens its detail page.
    public void eventsClicked(View view) {
        openDetail(1);
    }

    // Handles clicks on the Clubs button and opens its detail page.
    public void clubsClicked(View view) {
        openDetail(2);
    }

    // Handles clicks on the Support button and opens its detail page.
    public void supportClicked(View view) {
        openDetail(3);
    }

    // Opens DetailActivity and passes the selected topic index through the Intent.
    private void openDetail(int topicIndex) {
        Intent intent = new Intent(
                MainActivity.this,
                DetailActivity.class
        );

        intent.putExtra(
                DetailActivity.EXTRA_TOPIC_INDEX,
                topicIndex
        );

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display and load the main activity layout.
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply system bar insets so the layout does not overlap
        // with the status bar or navigation bar.
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );
    }
}