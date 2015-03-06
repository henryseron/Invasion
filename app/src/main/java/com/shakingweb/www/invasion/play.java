package com.shakingweb.www.invasion;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class play extends ActionBarActivity {

    private ImageView btnLeft;
    private ImageView btnRight;
    private ImageView btnUp;
    private ImageView btnDown;

    private ImageView btnShootBlue;

    private ImageView imgPlane;
    private Plane plane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        this.makeJoystick();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void makeJoystick(){
        this.imgPlane = (ImageView) findViewById(R.id.plane);
        this.plane = new Plane(this.imgPlane);

        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();  // deprecated

        this.plane.sizeGameBoard(width, height);

        this.makeJoystickMovementButtons();

        this.makeJoystickShootButtons();
    }

    /**
     * Configuration of the movement buttons
     */
    private void makeJoystickMovementButtons(){
        /*
        * making left move to the plane
        * */
        this.btnLeft = (ImageView) findViewById(R.id.arrow_left);
        this.btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plane.movePlane( Globals.MOVE_LEFT);
            }
        });
        /*this.btnLeft.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                while(v.isPressed()) {
                    plane.movePlane(Globals.MOVE_LEFT);
                }
                return false;
            }
        });*/

        /*
        * making right move to the plane
        * */
        this.btnRight = (ImageView) findViewById(R.id.arrow_right);
        this.btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plane.movePlane(Globals.MOVE_RIGHT);
            }
        });

        /*
        * making up move to the plane
        * */
        this.btnUp = (ImageView) findViewById(R.id.arrow_up);
        this.btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plane.movePlane(Globals.MOVE_UP);
            }
        });

        /*
        * making down move to the plane
        * */
        this.btnDown = (ImageView) findViewById(R.id.arrow_bottom);
        this.btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plane.movePlane(Globals.MOVE_DOWN);
            }
        });
    }

    private void makeJoystickShootButtons(){
        /**
         * making shoot ahead button
         */
        this.btnShootBlue = (ImageView) findViewById(R.id.btn_blue_circle);
        this.btnShootBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting shoot ahead image
                plane.shootAhead((ImageView) findViewById(R.id.shoot_ahead));
            }
        });
    }

}
