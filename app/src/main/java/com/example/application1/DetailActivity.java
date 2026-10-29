package com.example.application1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    // Key used to receive the selected topic index from MainActivity.
    public static final String EXTRA_TOPIC_INDEX = "topic_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display and load the detail page layout.
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Retrieve the selected topic index passed through the Intent.
        // The default value is 0, which represents Facilities.
        int topicIndex = getIntent().getIntExtra(
                EXTRA_TOPIC_INDEX, 0
        );

        // Load the image names, titles, and detail content from array.xml.
        String[] imageNames = getResources().getStringArray(
                R.array.string_array_images
        );

        String[] titles = getResources().getStringArray(
                R.array.string_array_titles
        );

        String[] contents = getResources().getStringArray(
                R.array.string_array_content
        );

        // Use the topic index to retrieve matching data from each array.
        // trim() removes any extra whitespace stored in the XML resources.
        String imageName = imageNames[topicIndex].trim();
        String title = titles[topicIndex].trim();
        String content = contents[topicIndex].trim();

        // Convert the drawable image name stored as a String
        // into its Android drawable resource ID.
        int imageResourceId = getResources().getIdentifier(
                imageName,
                "drawable",
                getPackageName()
        );

        // Display the correct topic image in the header.
        ImageView detailImage = findViewById(R.id.detailImage);
        detailImage.setImageResource(imageResourceId);

        // Create the short category name from the drawable name.
        // Example: "img_btn_facilities" becomes "Facilities".
        String categoryName = imageName.replace("img_btn_", "");
        categoryName = categoryName.substring(0, 1).toUpperCase(Locale.ROOT)
                + categoryName.substring(1);

        // Display the category name in the header.
        TextView detailCategory = findViewById(R.id.detailCategory);
        detailCategory.setText(categoryName);

        // Display the title associated with the selected topic.
        TextView detailTitle = findViewById(R.id.detailTitle);
        detailTitle.setText(title);

        // Display the detailed content associated with the selected topic.
        TextView detailContent = findViewById(R.id.detailContent);
        detailContent.setText(content);

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