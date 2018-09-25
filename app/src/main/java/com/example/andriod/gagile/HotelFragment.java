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
public class HotelFragment extends Fragment {


    public HotelFragment() {
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

        tourList.add( new TourGuid( R.drawable.tanghotel, getString( R.string.hloc_name_one ), getString( R.string.hlo_one ) ) );
        tourList.add( new TourGuid( R.drawable.negirial, getString( R.string.hloc_name_two ),getString( R.string.hlo_two ) ) );
        tourList.add( new TourGuid( R.drawable.marriot, getString( R.string.hloc_name_three ), getString( R.string.hlo_three ) ) );


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
                    intent.putExtra( "loadsPosition", getString( R.string.hloc_name_one) );
                    intent.putExtra( "loadsPosition2", "Located in one of Accra's most sought after areas " +
                            "The Tang Palace Hotel welcomes its guests with all the comforts and personal attention you would" );
                    intent.putExtra( "loadsPosition4", "expect from an international 4 star hotel. " +
                            "From the freshly cut orchids to the impressive chandeliers to the impeccably dressed and attentive staff, " +
                            "the Tang Palace Hotel focuses on the details that makes your stay memorable." );
                    Bundle bundle = new Bundle();
                    bundle.putInt( "loadsPosition3", R.drawable.tanghotel );
                    intent.putExtras( bundle );
                    getActivity().startActivity( intent );

                }

                if (position == 1) {

                    Intent intent = new Intent( getActivity(), TourDescription.class );

                    Bundle bundle = new Bundle();
                    bundle.putInt( "loadsPosition3", R.drawable.negirial );
                    intent.putExtras( bundle );
                    intent.putExtra( "loadsPosition2", "Niagara Hotel is a family run hotel in Adabraka, " +
                            "just a short drive from the Ministries the" );
                    intent.putExtra( "loadsPosition", getString( R.string.hloc_name_two ));
                    intent.putExtra( "loadsPosition4", "administrative heart of Accra, and the vibrant commercial centres of Makola and Kantamanto markets. " );

                    getActivity().startActivity( intent );

                }

                if (position == 2) {

                    Intent intent = new Intent( getActivity(), TourDescription.class );

                    Bundle bundle = new Bundle();
                    bundle.putInt( "loadsPosition3", R.drawable.marriot );
                    intent.putExtras( bundle );
                    intent.putExtra( "loadsPosition2", "The service is excellent, smiling and profesional. Absolutely nothing to criticize." );
                    intent.putExtra( "loadsPosition", getString( R.string.hloc_name_three ));
                    intent.putExtra( "loadsPosition4", "Food is good and varies every day. Breakfast is spectacular in terms of choice. Room is spacious, clean. " );

                    getActivity().startActivity( intent );


                }
            }
        } );

        ImageView imageView = tourRoot.findViewById( R.id.banner_image );
        imageView.setImageResource( R.drawable.negirial );

        return tourRoot;
    }


}

