package com.example.imageeffects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Color;
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

    private Bitmap invertImage(Bitmap original) {
        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(), original.getHeight(), original.getConfig());
        //store color values
        int A, R, G, B;
        int pixelColor;
        int height = original.getHeight();
        int width = original.getWidth();

        for (int y=0; y<height; y++){
            for (int z=0; z<width; z++){
                pixelColor = original.getPixel(y,z);
                A = Color.alpha(pixelColor);
                //inverting colors by subtracting from 255
                R = 255-Color.red(pixelColor);
                G = 255-Color.green(pixelColor);
                B = 255-Color.blue(pixelColor);

                finalImage.setPixel(y,z, Color.argb(A,R,G,B));
            }
        }
        return finalImage;
    }
}
