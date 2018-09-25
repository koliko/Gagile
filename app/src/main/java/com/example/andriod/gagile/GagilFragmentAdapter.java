package com.example.andriod.gagile;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

//==========================================//
// this part extends the adapter with      //
// the FragmentPaerAdapter                //
//=======================================//

public class GagilFragmentAdapter extends FragmentPagerAdapter {

    private Context contextExtends;

    public GagilFragmentAdapter(Context context, FragmentManager manageFragment) {

        super( manageFragment );
        contextExtends = context;

    }

    //================================================//
    // this part gets to determines the fragment     //
    // of each tab                                  //
    //=============================================//

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new HotelFragment();
        } else if (position == 1) {
            return new MallFragment();
        } else if (position == 2) {
            return new RestaurentFragment();
        } else {
            return new HistoricalSiteFragment();
        }
    }

    //============================================//
    // this part determines the number of tabs   //
    //==========================================//


    @Override
    public int getCount() {
        return 4;
    }

    //=========================================//
    // this part determines the title for     //
    // each tab                              //
    //======================================//

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return contextExtends.getString( R.string.hotel_tab );
            case 1:
                return contextExtends.getString( R.string.mall_tab );
            case 2:
                return contextExtends.getString( R.string.restaurent_tab );
            case 3:
                return contextExtends.getString( R.string.historical_tab );
            default:
                return null;
        }

    }
}
