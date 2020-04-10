package com.example.imageeffects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView myimageview;
    Drawable myfruit;
    Bitmap bitmapImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myimageview = findViewById(R.id.imageView);
        myfruit = ResourcesCompat.getDrawable(getResources(), R.drawable.apple, null);//import an image
        bitmapImage = ((BitmapDrawable) myfruit).getBitmap();
        Bitmap newphoto = invertImage(bitmapImage);
        myimageview.setImageBitmap(newphoto);
    }
}
