/**
 * FruitModel manages the color state of each fruit and the bowl in the view.
 * It adheres to changes in SeekBars for red, green, and blue values to adjust the color of the selected fruit.
 *
 * @author Tyler Crosbie
 * @date September 23, 2024
 */

package edu.up.cust_coloring;

import android.graphics.Color;
import android.widget.SeekBar;

public class FruitModel {

    public boolean touched = false;
    public float xLoc;
    public float yLoc;
    public int appleColor = 0xFFde2612;
    public int pearColor = 0xFFd1e231;
    public int tableColor = 0xFF913e17; // Default table color
    public int grapeColor = 0xFFa702fa;
    public int orangeColor = 0xFFfa8b02;
    public int bowlColor = 0xFFd9ac6f;


    // Checks which element the user has tapped on
    public boolean isAppleTouched(float x, float y) {
        return ((x > 815 && x < 935) && (y > 115 && y < 235));
    }
    public boolean isPearTouched(float x, float y) {
        return ((x > 1010 && x < 1150) && (y > 45 && y < 185));
    }
    public boolean isTableTouched(float x, float y) {
        return ((((x < 1800) && (x > 300)) && ((y < 2000) && (y > 500))) && (((x < 400) || (x > 1600)) || (y < 600)));
    }
    public boolean isGrapesTouched(float x, float y) {
        return ((x > 1150 && x < 1220) && (y > 215 && y < 285));
    }
    public boolean isOrangeTouched(float x, float y) {
        return ((x > 930 && x < 1070) && (y > 180 && y < 320));
    }
    public boolean isBowlTouched(float x, float y) {
        return ((x > 840 && x < 1240) && (y > 300 && y < 500));
    }

    // returns the current color of the tapped element
    public int getColor() {
        if (isAppleTouched(xLoc, yLoc)) {
            return appleColor;
        } else if (isPearTouched(xLoc, yLoc)) {
            return pearColor;
        } else if (isTableTouched(xLoc, yLoc)) {
            return tableColor;
        } else if (isGrapesTouched(xLoc, yLoc)) {
            return grapeColor;
        } else if (isOrangeTouched(xLoc, yLoc)) {
            return orangeColor;
        } else if (isBowlTouched(xLoc, yLoc)) {
            return bowlColor;
        } else {
            return Color.TRANSPARENT;
        }
    }

    // Sets the color of an element
    public void setColor(int color) {
        if (isAppleTouched(xLoc, yLoc)) {
            appleColor = color;
        } else if (isPearTouched(xLoc, yLoc)) {
            pearColor = color;
        } else if (isTableTouched(xLoc, yLoc)) {
            tableColor = color;
        } else if (isGrapesTouched(xLoc, yLoc)) {
            grapeColor = color;
        } else if (isOrangeTouched(xLoc, yLoc)) {
            orangeColor = color;
        } else if (isBowlTouched(xLoc, yLoc)) {
            bowlColor = color;
        }
    }


    //Initializes SeekBars
    public SeekBar redBar;
    public SeekBar greenBar;
    public SeekBar blueBar;


    //Initializes the model with the SeekBars
    public FruitModel (SeekBar skbr, SeekBar skbr2, SeekBar skbr3) {
        this.redBar = skbr;
        this.greenBar = skbr2;
        this.blueBar = skbr3;
    }
}