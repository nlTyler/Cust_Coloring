//@ Author: Tyler Crosbie
//Date: September 23, 2024

package edu.up.cust_coloring;

import android.graphics.Color;
//import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
//import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;


public class FruitController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    private FruitView fruitVi;
    private FruitModel fruitMod;
    private TextView selectedEle;

    public FruitController(FruitView fruitV, FruitModel fruitM, TextView TextVi) {
        // Initializes the view and model
        this.fruitVi = fruitV;
        this.fruitMod = fruitM;
        this.selectedEle = TextVi;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        int redProg = fruitMod.redBar.getProgress();
        int greenProg = fruitMod.greenBar.getProgress();
        int blueProg = fruitMod.blueBar.getProgress();

        fruitMod.setColor(Color.rgb(redProg, greenProg, blueProg));

        fruitVi.invalidate();

    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (fruitMod == null) {
            return false;
        }



        fruitMod.touched = true;
        float xLocation = motionEvent.getX();
        float yLocation = motionEvent.getY();
        fruitMod.xLoc = xLocation;
        fruitMod.yLoc = yLocation;
        int pixelColor = fruitMod.getColor();

        if (fruitMod.isAppleTouched(fruitMod.xLoc, fruitMod.yLoc)) {
            selectedEle.setText("Selected Element: Apple");
        } else if (fruitMod.isOrangeTouched(fruitMod.xLoc, fruitMod.yLoc)) {
            selectedEle.setText("Selected Element: Orange");
        } else if (fruitMod.isPearTouched(fruitMod.xLoc, fruitMod.yLoc)) {
            selectedEle.setText("Selected Element: Pear");
        } else if (fruitMod.isGrapesTouched(fruitMod.xLoc, fruitMod.yLoc)) {
            selectedEle.setText("Selected Element: Grapes");
        } else if (fruitMod.isBowlTouched(fruitMod.xLoc, fruitMod.yLoc)) {
            selectedEle.setText("Selected Element: Bowl");
        } else if (fruitMod.isTableTouched(fruitMod.xLoc, fruitMod.yLoc)) {
            selectedEle.setText("Selected Element: Table");
        } else {
            selectedEle.setText("Selected Element: None");
        }

        fruitMod.redBar.setProgress(Color.red(pixelColor));
        fruitMod.greenBar.setProgress(Color.green(pixelColor));
        fruitMod.blueBar.setProgress(Color.blue(pixelColor));
        fruitVi.performClick();
        fruitVi.invalidate();
        return true;
    }



}

