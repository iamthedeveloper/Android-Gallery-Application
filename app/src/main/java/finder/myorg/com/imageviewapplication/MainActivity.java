package finder.myorg.com.imageviewapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import finder.myorg.com.imageviewapplication.model.SkuImageAttribute;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Drawable> drawables;
    List<SkuImageAttribute> lSkuImgAttrs;
    private Gallery gallery;
    private ImageView leftArrowImageView;
    private ImageView rightArrowImageView;
    private ImageView selectedImageView;
    private int selectedImagePosition = 0;
    private GalleryImageAdapter galImageAdapter;
    private ImageView downloadedImg;
    private ProgressDialog simpleWaitDialog;
    private MainActivity thisActivity;
    private void setupUI() {

        selectedImageView = (ImageView) findViewById(R.id.selected_imageview);
        selectedImageView.setClickable(true);
        leftArrowImageView = (ImageView) findViewById(R.id.left_arrow_imageview);
        rightArrowImageView = (ImageView) findViewById(R.id.right_arrow_imageview);
        gallery = (Gallery) findViewById(R.id.gallery);

        leftArrowImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (selectedImagePosition > 0) {
                    --selectedImagePosition;

                }

                gallery.setSelection(selectedImagePosition, false);
            }
        });

        rightArrowImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (selectedImagePosition < drawables.size() - 1) {
                    ++selectedImagePosition;

                }

                gallery.setSelection(selectedImagePosition, false);

            }
        });

        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                selectedImagePosition = pos;

                if (selectedImagePosition > 0 && selectedImagePosition < drawables.size() - 1) {

                    leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_left_enabled));
                    rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_enabled));

                } else if (selectedImagePosition == 0) {

                    leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_left_disabled));

                } else if (selectedImagePosition == drawables.size() - 1) {

                    rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_disabled));
                }

                //changeBorderForSelectedImage(selectedImagePosition);
                setSelectedImage(selectedImagePosition);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

        //galImageAdapter = new GalleryImageAdapter(this, drawables);

        //gallery.setAdapter(galImageAdapter);

        if (drawables.size() > 0) {

            gallery.setSelection(selectedImagePosition, false);

        }

        if (drawables.size() == 1) {

            rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_disabled));
        }

        selectedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedImage(selectedImagePosition);
                Log.d("MainActivity BITMAP :", " click" + selectedImageView.getDrawable() + " " + ((BitmapDrawable) selectedImageView.getDrawable()).getBitmap().getGenerationId());
                //Bitmap bitmap = ((BitmapDrawable) selectedImageView.getDrawable()).getBitmap();
                Intent mIntent = new Intent(MainActivity.this, PinchZoomActivity.class);
                mIntent.putExtra("zoom_image", selectedImagePosition);
                startActivity(mIntent);
            }
        });

    }

    /*private void changeBorderForSelectedImage(int selectedItemPos) {
        int count = gallery.getChildCount();
        for (int i = 0; i < count; i++) {
            ImageView imageView = (ImageView) gallery.getChildAt(i);
            imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.image_border));
            imageView.setPadding(3, 3, 3, 3);
        }
        ImageView imageView = (ImageView) gallery.getSelectedView();
        imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.selected_image_border));
        imageView.setPadding(3, 3, 3, 3);
    }*/

    private void getDrawablesList() {

        drawables = new ArrayList<Drawable>();
       /* drawables.add(getResources().getDrawable(R.drawable.natureimage2));
        drawables.add(getResources().getDrawable(R.drawable.natureimage3));
        drawables.add(getResources().getDrawable(R.drawable.natureimage4));
        drawables.add(getResources().getDrawable(R.drawable.natureimage5));
        drawables.add(getResources().getDrawable(R.drawable.natureimage6));
       */

        /* Creating Drawable with Dynamic Bitmap from URLs */
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ImageDownloader().execute();
            }
        }).start();
    }

   /* private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 100) {
                    *//********************************** MISTAKE IS GalleryImageAdapter IS GETTING NULL*//*
                    galImageAdapter = new GalleryImageAdapter();
                    gallery.setAdapter(galImageAdapter);
                    galImageAdapter.notifyDataSetChanged();
            }
            super.handleMessage(msg);
        }
    }; *///end of handler


    @Override

    public void onCreate(Bundle savedInstanceState) {
        thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDrawablesList();
        setupUI();
    }

    /*@Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type:
                pDialog = new ProgressDialog(this);
                pDialog.setMessage("Downloading file. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setCancelable(true);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }*/

    private void setSelectedImage(int selectedImagePosition) {

        BitmapDrawable bd = (BitmapDrawable) drawables.get(selectedImagePosition);
        Bitmap b = Bitmap.createScaledBitmap(bd.getBitmap(), (int) (bd.getIntrinsicHeight() * 0.9), (int) (bd.getIntrinsicWidth() * 0.7), false);
        selectedImageView.setImageBitmap(b);
        Log.d("MainActivity Selected:", b.getConfig().name());
        selectedImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }


    private class ImageDownloader extends AsyncTask<Context, Integer, List> {
        protected void onPreExecute() {
            super.onPreExecute();
            lSkuImgAttrs = Util.getSkuImageAttributes();
            //showDialog(progress_bar_type);
            Log.i("Async-Example", "onPreExecute Called "+lSkuImgAttrs.size());
            /*simpleWaitDialog = ProgressDialog.show(MainActivity.this,
                    "Wait", "Downloading Image")*/
            ;

        }

        protected List doInBackground(Context... context) {
            try {
                for (int i = 0; i < lSkuImgAttrs.size(); i++) {
                    if (null != lSkuImgAttrs.get(i).getValue()) {
                        try {
                            Log.d("Async-Example Asyntask ", lSkuImgAttrs.get(i).getValue().toString());
                            URL imageURL = new URL(new String(lSkuImgAttrs.get(i).getValue().toString()));
                            Bitmap bitmap = (Bitmap) BitmapFactory.decodeStream(imageURL.openStream());
                            drawables.add((Drawable) new BitmapDrawable(bitmap));
                        } catch (MalformedURLException mex) {
                            Log.d("doInBackground", mex.getMessage());
                        } catch (IOException iox) {
                            Log.d("doInBackground ", iox.getMessage());
                        }

                    }
                }

                publishProgress();
            } catch (Exception e) {
                Log.d("doInBackground", "Downloading Image Failed");
            }
            return drawables;

        }


        /*protected void onProgressUpdate(Integer... progress) {
            Log.d("Async-Example", "onProgressUpdate Called");
            Toast.makeText(getParent(),"Loading ", Toast.LENGTH_LONG).show();
            // pDialog.setProgress(progress[0]);
        }*/


        protected void onPostExecute(List list) {
            super.onPostExecute(list);
            Log.d("onPostExecute", " Drawable Size is "+drawables.size() +" List" +list.size());
            galImageAdapter = new GalleryImageAdapter(thisActivity,drawables);
            gallery.setAdapter(galImageAdapter);
            galImageAdapter.notifyDataSetChanged();
        }


    }

}
