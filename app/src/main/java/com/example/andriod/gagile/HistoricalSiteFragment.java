package com.example.andriod.gagile;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricalSiteFragment extends Fragment {


    public HistoricalSiteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tourRoot;
        tourRoot = inflater.inflate( R.layout.tour_list, container, false );

        //=======================================================//
        // this part set the arraylist for the items            //
        //=====================================================//

       final ArrayList<TourGuid> tourList = new ArrayList<>();

        tourList.add( new TourGuid( R.drawable.jato, getString( R.string.hiloc_name_one ), getString( R.string.hilo_one ) ) );
        tourList.add( new TourGuid( R.drawable.kakum,  getString( R.string.hiloc_name_two ), getString( R.string.hilo_two )  ) );
        tourList.add( new TourGuid( R.drawable.capecoast,  getString( R.string.hiloc_name_three ), getString( R.string.hilo_three )  ) );


        ListView tourListView = tourRoot.findViewById( R.id.tour_list );
        TourGuidAdapter tourGuidAdapter = new TourGuidAdapter( getActivity(), tourList, R.color.tema_color );
        tourListView.setAdapter( tourGuidAdapter );

        //======================================================//
        // this part handles the click event of the listview   //
        //====================================================//

        tourListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //===================================================//
                // this part update the description activity        //
                // clicked information                             //
                //================================================//

                if (position == 0) {

                    Intent intent = new Intent( getActivity(), TourDescription.class );
                    intent.putExtra( "loadsPosition", getString( R.string.hiloc_name_one ) );
                    intent.putExtra( "loadsPosition2", "The highest mountain in Ghana" );
                    intent.putExtra( "loadsPosition4", "it is located in the Volta Region" );
                    Bundle bundle = new Bundle();
                    bundle.putInt( "loadsPosition3", R.drawable.jato );
                    intent.putExtras( bundle );
                    getActivity().startActivity( intent );

                }

                if (position == 1) {

                    Intent intent = new Intent( getActivity(), TourDescription.class );

                    Bundle bundle = new Bundle();
                    bundle.putInt( "loadsPosition3", R.drawable.kakum );
                    intent.putExtras( bundle );
                    intent.putExtra( "loadsPosition2", "The Kakum National park is one of the oldest canopy walk in africa" );
                    intent.putExtra( "loadsPosition", getString( R.string.hiloc_name_two) );
                    intent.putExtra( "loadsPosition4", "This park can be found in the central region of Ghana " );

                    getActivity().startActivity( intent );

                }

                if (position == 2) {

                    Intent intent = new Intent( getActivity(), TourDescription.class );

                    Bundle bundle = new Bundle();
                    bundle.putInt( "loadsPosition3", R.drawable.capecoast );
                    intent.putExtras( bundle );
                    intent.putExtra( "loadsPosition2", "The place to visit in a life time" );
                    intent.putExtra( "loadsPosition", getString( R.string.hiloc_name_three ) );
                    intent.putExtra( "loadsPosition4", "Tells you the true history of Africa " );

                    getActivity().startActivity( intent );


                }
            }
        } );


        ImageView imageView = tourRoot.findViewById( R.id.banner_image );
        imageView.setImageResource( R.drawable.capecoast );

        return tourRoot;
    }

}

