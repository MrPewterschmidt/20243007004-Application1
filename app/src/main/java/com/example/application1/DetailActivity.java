package com.example.application1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_TOPIC_INDEX = "topic_index";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        int topicIndex = getIntent().getIntExtra(
                EXTRA_TOPIC_INDEX, 0
        );

        String[] imageNames = getResources().getStringArray(
                R.array.string_array_images
        );

        String[] titles = getResources().getStringArray(
                R.array.string_array_titles
        );

        String[] contents = getResources().getStringArray(
                R.array.string_array_content
        );

        String imageName = imageNames[topicIndex].trim();
        String title = titles[topicIndex].trim();
        String content = contents[topicIndex].trim();

        int imageResourceId = getResources().getIdentifier(
                imageName,
                "drawable",
                getPackageName()
        );

        ImageView detailImage = findViewById(R.id.detailImage);
        detailImage.setImageResource(imageResourceId);

        String categoryName = imageName.replace("img_btn_", "");
        categoryName = categoryName.substring(0, 1).toUpperCase(Locale.ROOT)
                + categoryName.substring(1);

        TextView detailCategory = findViewById(R.id.detailCategory);
        detailCategory.setText(categoryName);

        TextView detailTitle = findViewById(R.id.detailTitle);
        detailTitle.setText(title);

        TextView detailContent = findViewById(R.id.detailContent);
        detailContent.setText(content);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}