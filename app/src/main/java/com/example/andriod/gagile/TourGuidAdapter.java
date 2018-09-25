package com.example.andriod.gagile;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourGuidAdapter extends ArrayAdapter<TourGuid> {

    private int tColorResourceID;
    private static final String LOG_TAG = TourGuid.class.getSimpleName();
    public TourGuidAdapter(Activity context, ArrayList<TourGuid> Tourguid, int tColorR){

        super(context,0,Tourguid);
        tColorResourceID = tColorR;
    }

    //===================================================//
    // this checks if the existing view is been reused  //
    // if  not inflate the view                        //
    //================================================//

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootListView = convertView;
        if(rootListView == null){
            rootListView = LayoutInflater.from( getContext()).inflate(
                    R.layout.list_item,parent,false );
        }

        //===============================================//
        // this gats the positions of each list         //
        //=============================================//

        TourGuid tourGetPosition = getItem( position );

        ImageView tourImage = rootListView.findViewById( R.id.tour_image );
        TextView tourLocName = rootListView.findViewById( R.id.tour_loc_title );
        TextView tourLocAdd = rootListView.findViewById( R.id.tour_loc_add );

        tourImage.setImageResource( tourGetPosition.getLocationImg() );
        tourLocName.setText( tourGetPosition.getLocationName() );
        tourLocAdd.setText( tourGetPosition.getLocationAdd() );

        View themeColor = rootListView.findViewById( R.id.tour_linearView );
        int color = ContextCompat.getColor( getContext(),tColorResourceID );
        themeColor.setBackgroundColor( color );

        return rootListView;
    }
}
