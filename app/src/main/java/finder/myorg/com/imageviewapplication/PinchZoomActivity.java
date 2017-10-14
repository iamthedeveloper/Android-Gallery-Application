package finder.myorg.com.imageviewapplication;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ScaleGestureDetector;
import android.widget.Toast;

import finder.myorg.com.imageviewapplication.views.ScaleImageView;

/**
 * Created by chinnii on 1/19/16.
 */
public class PinchZoomActivity extends AppCompatActivity  {
    private ScaleImageView imageView;
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();
    float scale = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        imageView = (ScaleImageView) findViewById(R.id.zoomView);
        Intent mIntent = getIntent();
        //Bitmap zoomImage = (Bitmap) mIntent.getParcelableExtra("zoom_image");

        //byte[] byteArray = mIntent.getByteArrayExtra("zoom_image");
        int iPosition = (int) mIntent.getIntExtra("zoom_image", 0);
        if (iPosition>=0) {
            imageView.setImageBitmap(((BitmapDrawable) MainActivity.drawables.get(iPosition)).getBitmap());

        } else {
            Toast.makeText(this, "Image is not laoded ", Toast.LENGTH_SHORT).show();

        }
    }



}