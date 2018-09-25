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
public class RestaurentFragment extends Fragment {


    public RestaurentFragment() {
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

        ArrayList<TourGuid> tourList = new ArrayList<>();

        tourList.add( new TourGuid( R.drawable.erri, getString(R.string.rloc_name_one ), getString( R.string.rlo_one )) );
        tourList.add( new TourGuid( R.drawable.hamber, getString(R.string.rloc_name_two ), getString( R.string.rlo_two ) ) );
        tourList.add( new TourGuid( R.drawable.ladc, getString(R.string.rloc_name_three ), getString( R.string.rlo_three)) );


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
                    intent.putExtra( "loadsPosition", getString(R.string.rloc_name_one ));
                    intent.putExtra( "loadsPosition2", "This is the place they always says. Stomach has no holiday" );
                    intent.putExtra( "loadsPosition4", "Located right in the oil rich twin city" );
                    Bundle bundle = new Bundle();
                    bundle.putInt( "loadsPosition3", R.drawable.erri );
                    intent.putExtras( bundle );
                    getActivity().startActivity( intent );

                }

                if (position == 1) {

                    Intent intent = new Intent( getActivity(), TourDescription.class );

                    Bundle bundle = new Bundle();
                    bundle.putInt( "loadsPosition3", R.drawable.hamber );
                    intent.putExtras( bundle );
                    intent.putExtra( "loadsPosition2", "One of the best in the sub region." );
                    intent.putExtra( "loadsPosition", getString(R.string.rloc_name_two ));
                    intent.putExtra( "loadsPosition4", "Designed for the business minded people" );

                    getActivity().startActivity( intent );

                }

                if (position == 2) {

                    Intent intent = new Intent( getActivity(), TourDescription.class );

                    Bundle bundle = new Bundle();
                    bundle.putInt( "loadsPosition3", R.drawable.ladc );
                    intent.putExtras( bundle );
                    intent.putExtra( "loadsPosition2", "The place for all. You don't have to be rich to visit" );
                    intent.putExtra( "loadsPosition", getString(R.string.rloc_name_three ));
                    intent.putExtra( "loadsPosition4", "Food is good and varies every day. Breakfast is spectacular in terms of choice. " );

                    getActivity().startActivity( intent );


                }
            }
        } );

        ImageView imageView = tourRoot.findViewById( R.id.banner_image );
        imageView.setImageResource( R.drawable.erri );

        return tourRoot;
    }


}

