package com.Murray.BobEvansMenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Graham
 * Date: 6/22/13
 * Time: 8:15 AM
 * To change this template use File | Settings | File Templates.
 */


public class BreakfastMenu extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        String test = getIntent().getExtras().getString("key");
        int test2 = Integer.parseInt(test);

        if (test2 == 1){
            //ToDO load A La Carte menu
            Toast.makeText(getApplicationContext(), "A La Carte", Toast.LENGTH_LONG).show();

        }

        if (test2 ==2){
            //ToDo load Egg Breakfast menu

            Toast.makeText(getApplicationContext(), "Egg Breakfast", Toast.LENGTH_LONG).show();
        }
        if (test2 ==3){
            //ToDo load Sausage menu

            Toast.makeText(getApplicationContext(), "Sausage", Toast.LENGTH_LONG).show();
        }
        if (test2 ==4){
            //ToDo load Griddle menu

            Toast.makeText(getApplicationContext(), "Griddle", Toast.LENGTH_LONG).show();
        }
        if (test2 !=5){
            //ToDo load omelet menu

            Toast.makeText(getApplicationContext(), "Omelet", Toast.LENGTH_LONG).show();
        }
}
}
