package com.example.application1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    public void facilitiesClicked(View view) {
        openDetail(0);
    }

    public void eventsClicked(View view) {
        openDetail(1);
    }

    public void clubsClicked(View view) {
        openDetail(2);
    }

    public void supportClicked(View view) {
        openDetail(3);
    }

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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}