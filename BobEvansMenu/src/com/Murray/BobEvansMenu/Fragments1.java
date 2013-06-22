package com.Murray.BobEvansMenu;

/**
 * Created with IntelliJ IDEA.
 * User: Graham
 * Date: 6/20/13
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */

import android.content.Intent;
import com.actionbarsherlock.app.SherlockFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragments1 extends SherlockFragment {

    Button alacarte;
    Button eggBreakfasts;
    Button sausageBreakfasts;
    Button griddle;
    Button omelets;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Rootview = inflater.inflate(R.layout.fragments1, container, false);


             alacarte = (Button) Rootview.findViewById(R.id.alacarte1);
                alacarte.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Transfer to BreakfastMenu
                        Intent nextScreen = new Intent(getActivity(), BreakfastMenu.class).putExtra("key", 1);

                        startActivity(nextScreen);
                    }
                });

               eggBreakfasts = (Button) Rootview.findViewById(R.id.farmFreshEggs);
                eggBreakfasts.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        //Transfer to BreakfastMenu
                        Intent nextScreen = new Intent(getActivity(), BreakfastMenu.class).putExtra("key", 2);
                        startActivity(nextScreen);
                    }
                });

             sausageBreakfasts = (Button) Rootview.findViewById(R.id.sausageClassics);
                sausageBreakfasts.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        //Transfer to BreakfastMenu
                        Intent nextScreen = new Intent(getActivity(), BreakfastMenu.class).putExtra("key", 3);
                        startActivity(nextScreen);
            }
        });
             griddle = (Button) Rootview.findViewById(R.id.hotGriddle);
                griddle.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        //Transfer to BreakfastMenu
                        Intent nextScreen = new Intent(getActivity(), BreakfastMenu.class).putExtra("key", 4);
                        startActivity(nextScreen);
            }
        });

             omelets = (Button) Rootview.findViewById(R.id.eggOmelets);
                omelets.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        //Transfer to BreakfastMenu
                        Intent nextScreen = new Intent(getActivity(), BreakfastMenu.class).putExtra("key", 5);
                        startActivity(nextScreen);
            }
        });








        return Rootview;
    }


}
