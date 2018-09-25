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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallFragment extends Fragment {


    public MallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tourRoot;
        tourRoot = inflater.inflate( R.layout.tour_list,container,false );

        //=======================================================//
        // this part set the arraylist for the items            //
        //=====================================================//

        ArrayList<TourGuid> tourList = new ArrayList<>(  );

        tourList.add( new TourGuid( R.drawable.marina,getString( R.string.mloc_name_one ),getString( R.string.mlo_one ) ) );
        tourList.add( new TourGuid( R.drawable.westhills,getString( R.string.mloc_name_two ),getString( R.string.mlo_two ) ) );
        tourList.add( new TourGuid( R.drawable.opulent,getString( R.string.mloc_name_three ),getString( R.string.mlo_three ) ) );


        ListView tourListView = tourRoot.findViewById( R.id.tour_list );
        TourGuidAdapter tourGuidAdapter = new TourGuidAdapter( getActivity(),tourList,R.color.tema_color);
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

                if(position == 0){

                    Intent intent = new Intent(getActivity(), TourDescription.class);
                    intent.putExtra("loadsPosition",getString( R.string.mloc_name_one) );
                    intent.putExtra("loadsPosition2","The modern mall in the republic of Ghana.");
                    intent.putExtra("loadsPosition4","Located in the Airport City of Accra" );
                    Bundle bundle = new Bundle(  );
                    bundle.putInt( "loadsPosition3",R.drawable.marina );
                    intent.putExtras( bundle );
                    getActivity().startActivity(intent);

                }

                if(position == 1){

                    Intent intent = new Intent(getActivity(), TourDescription.class);

                    Bundle bundle = new Bundle(  );
                    bundle.putInt( "loadsPosition3",R.drawable.westhills );
                    intent.putExtras( bundle );
                    intent.putExtra("loadsPosition2","The Mall at the middle of the hill." );
                    intent.putExtra("loadsPosition",getString( R.string.mloc_name_two ));
                    intent.putExtra("loadsPosition4","administrative heart of Accra, and the vibrant commercial centres of McCarthy Hill. ");

                    getActivity().startActivity(intent);

                }

                if(position == 2){

                    Intent intent = new Intent(getActivity(), TourDescription.class);

                    Bundle bundle = new Bundle(  );
                    bundle.putInt( "loadsPosition3",R.drawable.opulent );
                    intent.putExtras( bundle );
                    intent.putExtra("loadsPosition2","The mall in the heart of the great Asante Kingdom" );
                    intent.putExtra("loadsPosition",getString( R.string.mloc_name_three ));
                    intent.putExtra("loadsPosition4","Not just a mall but full of culture ");

                    getActivity().startActivity(intent);


                }
            }
        } );


        ImageView imageView = tourRoot.findViewById( R.id.banner_image );
        imageView.setImageResource( R.drawable.marina );
        return tourRoot;
    }


}

