//@ Author: Tyler Crosbie
//Date: September 23, 2024

package edu.up.cust_coloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
//import android.widget.SeekBar;

public class FruitView extends SurfaceView {

    /**
     External Citation
     Date: 23 September 2024
     Problem: to initialize paints and draw rectangles and circles
     Resource: CS 371 lab 3: Events
     Solution: I used the format from the lab but changed values and names to adhere to my intended output
     */

    //Initializes paints
    Paint tablePaint = new Paint();
    Paint bowlPaint = new Paint();
    Paint applePaint = new Paint();
    Paint orangePaint = new Paint();
    Paint grapePaint = new Paint();
    Paint pearPaint = new Paint();
    Paint backgroundPaint = new Paint();
    Paint textPaint = new Paint();

    private FruitModel fruitMod;

    public FruitView(Context context, AttributeSet attrs) {
        super(context, attrs);


        setWillNotDraw(false);

        //Declares paints with appropriate color
        tablePaint.setColor(0xFF913e17);
        tablePaint.setStyle(Paint.Style.FILL);
        bowlPaint.setColor(0xFFd9ac6f);
        bowlPaint.setStyle(Paint.Style.FILL);
        applePaint.setColor(0xFFde2612);
        applePaint.setStyle(Paint.Style.FILL);
        orangePaint.setColor(0xFFfa8b02);
        orangePaint.setStyle(Paint.Style.FILL);
        grapePaint.setColor(0xFFa702fa);
        grapePaint.setStyle(Paint.Style.FILL);
        pearPaint.setColor(0xFFd1e231);
        pearPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setColor(0xFF88edf2);
        backgroundPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(0xFF00FF00);
        textPaint.setStyle(Paint.Style.FILL);

        setBackgroundColor(0xFF88edf2);



    }
    @Override
    public void onDraw(Canvas canvas){

        //Updates colors
        applePaint.setColor(fruitMod.appleColor);
        tablePaint.setColor(fruitMod.tableColor);
        orangePaint.setColor(fruitMod.orangeColor);
        pearPaint.setColor(fruitMod.pearColor);
        bowlPaint.setColor(fruitMod.bowlColor);
        grapePaint.setColor(fruitMod.grapeColor);


        // Draws the table
        canvas.drawRect(300, 500, 400, 1000, tablePaint);
        canvas.drawRect(1600, 500, 1700, 1000, tablePaint);
        canvas.drawRect(300, 500, 1800, 600, tablePaint);

        //Draws the Bowl
        canvas.drawCircle(1040,300, 200, bowlPaint);
        canvas.drawRect(800, 100, 1300, 300, backgroundPaint);

        // Draws the Fruit
        //canvas.drawCircle(900,180, 60, applePaint);

        canvas.drawCircle(875,175, 60, applePaint);
        canvas.drawCircle(1000, 250, 70, orangePaint);
        canvas.drawCircle(1080, 115, 70, pearPaint);

        for (int i = 0; i < 3; i++) {
            canvas.drawCircle(1130+(50*i), 210, 30, grapePaint);
        }
        canvas.drawCircle(1155, 250, 30, grapePaint);
        canvas.drawCircle(1205, 250, 30, grapePaint);
        canvas.drawCircle(1180, 290, 30, grapePaint);

        // Checks which element has been touched
        if (fruitMod.touched) {
            String elementTouched = "None";

            if (fruitMod.isAppleTouched(fruitMod.xLoc, fruitMod.yLoc)) {
                elementTouched = "Apple";
            } else if (fruitMod.isPearTouched(fruitMod.xLoc, fruitMod.yLoc)) {
                elementTouched = "Pear";
            } else if (fruitMod.isTableTouched(fruitMod.xLoc, fruitMod.yLoc)) {
                elementTouched = "Table";
            } else if (fruitMod.isGrapesTouched(fruitMod.xLoc, fruitMod.yLoc)) {
                elementTouched = "Grapes";
            } else if (fruitMod.isOrangeTouched(fruitMod.xLoc, fruitMod.yLoc)) {
                elementTouched = "Orange";
            } else if (fruitMod.isBowlTouched(fruitMod.xLoc, fruitMod.yLoc)) {
                elementTouched = "Bowl";
            }

            textPaint.setColor(Color.RED);
            textPaint.setTextSize(50);
            String location = "Selected Element: " + (elementTouched);
            canvas.drawText(location, 700, 800, textPaint);

        }


    } // onDraw


    public FruitModel getFruitModel() {
        return fruitMod;
    }

    public void setFruitModel(FruitModel fruitMod) {
        this.fruitMod = fruitMod;
    }
}

