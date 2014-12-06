package com.example.emmaedv.tddc73_lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by emmaedv on 10/11/14.
 */
public class Lab1_java3 extends Activity {
    RelativeLayout layout;
    TextView question1, question2, question3;
    CheckBox answer1_1, answer1_2, answer1_3,
            answer2_1, answer2_2,
            answer3_1, answer3_2;
    ImageView image1;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int topMargin_px = getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin);
        int imageSize = getResources().getDimensionPixelSize(R.dimen.imgSize);
        //Declaring all objects
        layout = new RelativeLayout(this);
        question1 = new TextView(this);
        question2 = new TextView(this);
        question3 = new TextView(this);
        answer1_1 = new CheckBox(this);
        answer1_2 = new CheckBox(this);
        answer1_3 = new CheckBox(this);
        answer2_1 = new CheckBox(this);
        answer2_2 = new CheckBox(this);
        answer3_1 = new CheckBox(this);
        answer3_2 = new CheckBox(this);

        image1 = new ImageView(this);
        send = new Button(this);

        //Set id of all objects
        question1.setId(1);
        question2.setId(2);
        question3.setId(3);
        answer1_1.setId(11);
        answer1_2.setId(12);
        answer1_3.setId(13);
        answer2_1.setId(21);
        answer2_2.setId(22);
        answer3_1.setId(31);
        answer3_2.setId(32);
        image1.setId(41);
        send.setId(51);

        //Setting text of objects
        question1.setText(R.string.question1);
        question1.setEnabled(false);
        question2.setText(R.string.question2);
        question2.setEnabled(false);
        question3.setText(R.string.question3);
        question3.setEnabled(false);
        answer1_1.setText(R.string.well);
        answer1_2.setText(R.string.veryWell);
        answer1_3.setText(R.string.extremelyWell);
        answer2_1.setText(R.string.yes);
        answer2_2.setText(R.string.no);
        answer3_1.setText(R.string.yes);
        answer3_2.setText(R.string.no);
        image1.setImageResource(R.drawable.liu_logga);
        send.setText(R.string.send);


        //PARAMETERS
        //Layout parameters
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(layoutParams);

        //QUESTION 1 parameters
        RelativeLayout.LayoutParams question1Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        question1Params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        question1Params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        question1Params.setMargins(0,topMargin_px,0,0);

        RelativeLayout.LayoutParams answer1_1Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        answer1_1Params.addRule(RelativeLayout.BELOW, question1.getId());
        answer1_1Params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        RelativeLayout.LayoutParams answer1_2Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        answer1_2Params.addRule(RelativeLayout.BELOW, question1.getId());
        answer1_2Params.addRule(RelativeLayout.END_OF, answer1_1.getId());

        RelativeLayout.LayoutParams answer1_3Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        answer1_3Params.addRule(RelativeLayout.BELOW, question1.getId());
        answer1_3Params.addRule(RelativeLayout.END_OF, answer1_2.getId());

        //QUESTION 2 parameters
        RelativeLayout.LayoutParams question2Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        question2Params.addRule(RelativeLayout.BELOW, answer1_1.getId());
        question2Params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        question2Params.setMargins(0,topMargin_px,0,0);

        RelativeLayout.LayoutParams answer2_1Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        answer2_1Params.addRule(RelativeLayout.BELOW, question2.getId());
        answer2_1Params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        RelativeLayout.LayoutParams answer2_2Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        answer2_2Params.addRule(RelativeLayout.BELOW, question2.getId());
        answer2_2Params.addRule(RelativeLayout.END_OF, answer2_1.getId());

        //QUESTION 3 parameters
        RelativeLayout.LayoutParams image1Params = new RelativeLayout.LayoutParams(
                imageSize, imageSize);
        image1Params.addRule(RelativeLayout.BELOW, answer2_1.getId());
        image1Params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);

        RelativeLayout.LayoutParams question3Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        question3Params.addRule(RelativeLayout.BELOW, image1.getId());
        question3Params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        question3Params.setMargins(0,topMargin_px,0,0);

        RelativeLayout.LayoutParams answer3_1Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        answer3_1Params.addRule(RelativeLayout.BELOW, question3.getId());
        answer3_1Params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        RelativeLayout.LayoutParams answer3_2Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        answer3_2Params.addRule(RelativeLayout.BELOW, question3.getId());
        answer3_2Params.addRule(RelativeLayout.END_OF, answer3_1.getId());

        //Button parameters
        RelativeLayout.LayoutParams sendParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        sendParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        sendParams.addRule(RelativeLayout.BELOW, answer3_2.getId());
        question3Params.setMargins(0,topMargin_px,0,0);

        //Add all objects to layout
        layout.addView(question1, question1Params);
        layout.addView(answer1_1, answer1_1Params);
        layout.addView(answer1_2, answer1_2Params);
        layout.addView(answer1_3, answer1_3Params);
        layout.addView(question2, question2Params);
        layout.addView(answer2_1, answer2_1Params);
        layout.addView(answer2_2, answer2_2Params);
        layout.addView(question3, question3Params);
        layout.addView(answer3_1, answer3_1Params);
        layout.addView(answer3_2, answer3_2Params);
        layout.addView(image1, image1Params);
        layout.addView(send, sendParams);


        setContentView(layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lab1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
