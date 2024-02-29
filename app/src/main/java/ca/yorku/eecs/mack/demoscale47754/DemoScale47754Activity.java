package ca.yorku.eecs.mack.demoscale47754;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import java.io.InputStream;

import ca.yorku.eecs.mack.demoscale.R;


/**
 * Demo_Scale - with modifications by...
 *
 * Login ID - niaraj1
 * Student ID - 217047754
 * Last name - Rajnish
 * First name(s) - Nia
 */

public class DemoScale47754Activity extends Activity
{
    PaintPanel imagePanel; // the panel in which to paint the image
    StatusPanel statusPanel; // a status panel the display the image coordinates, size, and scale
    int SELECT_PICTURE = 200;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // hide title bar
        setContentView(R.layout.main);


        // get references to UI components
        // cast removed (not needed anymore, avoids warning message)
        imagePanel = findViewById(R.id.paintpanel);
        statusPanel = findViewById(R.id.statuspanel);

        // give the image panel a reference to the status panel
        imagePanel.setStatusPanel(statusPanel);
        // Set up double-tap zoom

//        GestureDetector gestureDetector = new GestureDetector(this, imagePanel.new MyGestureListener());
//
//        // Attach the gesture detector to the imagePanel
//        imagePanel.setOnTouchListener((v, event) -> {
//            gestureDetector.onTouchEvent(event);
//            return true; // Handle the event
//        });



    }


    // Called when the "Reset" button is pressed.
    public void clickReset(View view)
    {
        imagePanel.xPosition = 10;
        imagePanel.yPosition = 10;
        imagePanel.scaleFactor = 1f;
        imagePanel.invalidate();
    }

    public void clickSelect(View view)
    {
        imageChooser();
    }

    // this function is triggered when
    // the Select Image Button is clicked
    void imageChooser() {


        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Context context = getApplicationContext();

        if (resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();

            // update the preview image in the layout
            imagePanel.setImage(context,selectedImageUri);



        }
    }

}