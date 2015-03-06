package com.shakingweb.www.invasion;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private Button about;
    private Button play;
    private Button close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.play = (Button)findViewById(R.id.btn_play);
        this.about = (Button)findViewById(R.id.btn_about);
        this.close = (Button)findViewById(R.id.btn_close);

        this.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent form_play = new Intent(MainActivity.this, play.class);
                startActivity(form_play);
            }
        });

        this.about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent form_about = new Intent(MainActivity.this, about.class);
                startActivity(form_about);
            }
        });

        this.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(1);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
