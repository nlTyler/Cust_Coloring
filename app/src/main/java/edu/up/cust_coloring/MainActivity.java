/**
 * MainActivity initializes the user interface, sets up the SeekBars for color adjustment,
 * and connects the FruitView, FruitModel, and FruitController for drawing and interaction
 *
 * @Author: Tyler Crosbie
 * @Date: September 23, 2024


 */

package edu.up.cust_coloring;

import android.content.pm.ActivityInfo;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sets the screen to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        FruitView fruitVi = findViewById(R.id.fruitview);

        // Finds the SeekBars who values will be adjusted
        SeekBar redSeekBar = findViewById(R.id.redBar);
        SeekBar greenSeekBar = findViewById(R.id.greeenBar);
        SeekBar blueSeekBar = findViewById(R.id.blueBar);

        // Initializes the FruitModel
        FruitModel fruitMod = new FruitModel(redSeekBar, greenSeekBar, blueSeekBar);
        TextView textEle = findViewById(R.id.textElement);

        // Initializes the FruitController
        FruitController FruitCon = new FruitController(fruitVi, fruitMod, textEle);
        fruitVi.setFruitModel(fruitMod);

        fruitVi.setOnTouchListener(FruitCon);

        greenSeekBar.setOnSeekBarChangeListener(FruitCon);
        redSeekBar.setOnSeekBarChangeListener(FruitCon);
        blueSeekBar.setOnSeekBarChangeListener(FruitCon);

    }
}