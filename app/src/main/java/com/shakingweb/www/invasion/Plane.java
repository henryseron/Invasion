package com.shakingweb.www.invasion;

import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

/**
 * Created by henry on 3/4/15.
 */
public class Plane extends ActionBarActivity {

    private ImageView imgPlane;
    // margin values to move the plane from up to bottom or left to right
    private int xMargin;
    private int yMargin;
    // max and min values to move the plane into the screen device
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    // size of the gameboard
    private int widthGameBoard;
    private int heightGameBoard;

    private ImageView shootAhead;

    public Plane(ImageView imgPlane){
        this.imgPlane = imgPlane;

        this.xMargin = 0;
        this.yMargin = 0;

        // the plane can be moved from 100 pixels from left to 900 pixels to the right
        this.xMin = 100;
        this.xMax = 900;
        // the plane can be moved from 400 pixels from up to 900 pixels to bottom
        this.yMin = 300;
        this.yMax = 900;
    }

    public void sizeGameBoard(int width, int height){
        this.widthGameBoard = width;
        this.heightGameBoard = height;

        this.xMax = (int)(this.widthGameBoard * 0.8);
        this.yMax = (int)(this.heightGameBoard * 0.7);
    }

    public void movePlane(int direction){
        // used to know position of th plane in the screen
        float positionX;
        float positionY;
        // pixels amount that plane is moved each time
        int moveSpace = 50;

        switch (direction){
            case Globals.MOVE_LEFT:
                positionX = this.imgPlane.getX();
                if(positionX >= this.xMin) {
                    this.xMargin -= moveSpace;
                    this.imgPlane.setTranslationX(this.xMargin);
                }
                break;
            case Globals.MOVE_RIGHT:
                positionX = this.imgPlane.getX();
                if(positionX <= this.xMax) {
                    this.xMargin += moveSpace;
                    this.imgPlane.setTranslationX(this.xMargin);
                }
                break;
            case Globals.MOVE_UP:
                positionY = this.imgPlane.getY();
                if(positionY >= this.yMin) {
                    this.yMargin -= moveSpace;
                    this.imgPlane.setTranslationY(this.yMargin);
                }
                break;
            case Globals.MOVE_DOWN:
                positionY = this.imgPlane.getY();
                if(positionY <= this.yMax) {
                    this.yMargin += moveSpace;
                    this.imgPlane.setTranslationY(this.yMargin);
                }
                break;
            default:
                break;
        }
    }

    public void shootAhead(ImageView shoot){
        shootAhead = shoot;

//        new Thread(new Runnable() {
//            public void run() {
                int yAxe = 0;
                //float positionY = shootAhead.getY();
                //shootAhead.setVisibility(View.VISIBLE);
                while (shootAhead.getY() >= yMin) {
                    yAxe -= 50;
                    shootAhead.setTranslationY(yAxe);
                    try{
                        wait(500);
                    }
                    catch (InterruptedException ie){
                        System.out.println(ie.getMessage());
                    }
                }
//            }
//        }).start();
    }
}
