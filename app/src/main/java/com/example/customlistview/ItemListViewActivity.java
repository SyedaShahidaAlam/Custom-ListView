package com.example.customlistview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ItemListViewActivity extends AppCompatActivity {

    TextView title, subtitle;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_list_view);

        title = findViewById(R.id.tv_single_Tittle);
        subtitle = findViewById(R.id.tv_single_subTittle);
        imageView = findViewById(R.id.singleImageView);

        String titleText = getIntent().getStringExtra("Title");
        String subtitleText = getIntent().getStringExtra("Subtitle");
        int imageResource = getIntent().getIntExtra("Image", -1);

        if (titleText != null)
        {
            title.setText(titleText);
        }

        else
        {
            title.setText("Default Title");
        }

        if (subtitleText != null)
        {
            subtitle.setText(subtitleText);
        }

        else
        {
            subtitle.setText("Default Subtitle");
        }

        if (imageResource != -1)
        {
            imageView.setImageResource(imageResource);
        }
    }
}

