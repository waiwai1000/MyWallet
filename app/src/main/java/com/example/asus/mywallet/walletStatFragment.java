package com.example.asus.mywallet;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class walletStatFragment extends Fragment {
    private TextView sum_dec,sum_limit_dec,avg_dec,monthly_limit;
    private TextView sum_jan,sum_limit_jan,avg_jan,sum_feb,sum_limit_feb,avg_feb,sum_mar,sum_limit_mar,avg_mar,sum_apr,sum_limit_apr,avg_apr;
    private TextView sum_may,sum_limit_may,avg_may,sum_jun,sum_limit_jun,avg_jun,sum_jul,sum_limit_jul,avg_jul,sum_aug,sum_limit_aug,avg_aug;
    private TextView sum_sep,sum_limit_sep,avg_sep,sum_oct,sum_limit_oct,avg_oct,sum_nov,sum_limit_nov,avg_nov;

    Cursor dec,cursor;
    Cursor jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        Log.e("CREATION","here?");
        final View rootView = inflater.inflate(R.layout.stat, container, false);

        monthly_limit = (TextView) rootView.findViewById(R.id.stat_monthly_limit);
        myDbAdapter helper = new myDbAdapter(getActivity());
        cursor = helper.getLimit();
        monthly_limit.setText(cursor.getString(2));


try {
    sum_jan = (TextView) rootView.findViewById(R.id.sum_spend_jan);
    sum_limit_jan = (TextView) rootView.findViewById(R.id.sum_limit_jan);
    avg_jan = (TextView) rootView.findViewById(R.id.avg_jan);
    jan = helper.get_Jan();
    avg_jan.setText(jan.getString(0));
    sum_jan.setText(jan.getString(1));
    sum_limit_jan.setText(jan.getString(2));
}
catch(Exception e)
        {
        }

        try {
            sum_feb = (TextView) rootView.findViewById(R.id.sum_spend_feb);
            sum_limit_feb = (TextView) rootView.findViewById(R.id.sum_limit_feb);
            avg_feb = (TextView) rootView.findViewById(R.id.avg_feb);
            feb = helper.get_Feb();
            avg_feb.setText(feb.getString(0));
            sum_feb.setText(feb.getString(1));
            sum_limit_feb.setText(feb.getString(2));
        }
        catch(Exception e)
        {
        }

        try {
            sum_mar = (TextView) rootView.findViewById(R.id.sum_spend_mar);
            sum_limit_mar = (TextView) rootView.findViewById(R.id.sum_limit_mar);
            avg_mar = (TextView) rootView.findViewById(R.id.avg_mar);
            mar = helper.get_Mar();
            avg_mar.setText(mar.getString(0));
            sum_mar.setText(mar.getString(1));
            sum_limit_mar.setText(mar.getString(2));
        }
        catch(Exception e)
        {
        }

        try {
            sum_apr = (TextView) rootView.findViewById(R.id.sum_spend_apr);
            sum_limit_apr = (TextView) rootView.findViewById(R.id.sum_limit_apr);
            avg_apr = (TextView) rootView.findViewById(R.id.avg_apr);
            apr = helper.get_Apr();
            avg_apr.setText(apr.getString(0));
            sum_apr.setText(apr.getString(1));
            sum_limit_apr.setText(apr.getString(2));
        }
        catch(Exception e)
        {
        }

        try {
            sum_may = (TextView) rootView.findViewById(R.id.sum_spend_may);
            sum_limit_may = (TextView) rootView.findViewById(R.id.sum_limit_may);
            avg_may = (TextView) rootView.findViewById(R.id.avg_may);
            may = helper.get_May();
            avg_may.setText(may.getString(0));
            sum_may.setText(may.getString(1));
            sum_limit_may.setText(may.getString(2));
        }
        catch(Exception e)
        {
        }

        try {
            sum_jun = (TextView) rootView.findViewById(R.id.sum_spend_jun);
            sum_limit_jun = (TextView) rootView.findViewById(R.id.sum_limit_jun);
            avg_jun = (TextView) rootView.findViewById(R.id.avg_jun);
            jun = helper.get_Jun();
            avg_jun.setText(jun.getString(0));
            sum_jun.setText(jun.getString(1));
            sum_limit_jun.setText(jun.getString(2));
        }
        catch(Exception e)
        {
        }

        try {
            sum_jul = (TextView) rootView.findViewById(R.id.sum_spend_jul);
            sum_limit_jul = (TextView) rootView.findViewById(R.id.sum_limit_jul);
            avg_jul = (TextView) rootView.findViewById(R.id.avg_jul);
            jul = helper.get_Jul();
            avg_jul.setText(jul.getString(0));
            sum_jul.setText(jul.getString(1));
            sum_limit_jul.setText(jul.getString(2));
        }
        catch(Exception e)
        {
        }

        try {
            sum_aug = (TextView) rootView.findViewById(R.id.sum_spend_aug);
            sum_limit_aug = (TextView) rootView.findViewById(R.id.sum_limit_aug);
            avg_aug = (TextView) rootView.findViewById(R.id.avg_aug);
            aug = helper.get_Aug();
            avg_aug.setText(aug.getString(0));
            sum_aug.setText(aug.getString(1));
            sum_limit_aug.setText(aug.getString(2));
        }
        catch(Exception e)
        {
        }

        try {
            sum_sep = (TextView) rootView.findViewById(R.id.sum_spend_sep);
            sum_limit_sep = (TextView) rootView.findViewById(R.id.sum_limit_sep);
            avg_sep = (TextView) rootView.findViewById(R.id.avg_sep);
            sep = helper.get_Sep();
            avg_sep.setText(sep.getString(0));
            sum_sep.setText(sep.getString(1));
            sum_limit_sep.setText(sep.getString(2));
        }
        catch(Exception e)
        {
        }

        try {
            sum_oct = (TextView) rootView.findViewById(R.id.sum_spend_oct);
            sum_limit_oct = (TextView) rootView.findViewById(R.id.sum_limit_oct);
            avg_oct = (TextView) rootView.findViewById(R.id.avg_oct);
            oct = helper.get_Oct();
            avg_oct.setText(oct.getString(0));
            sum_oct.setText(oct.getString(1));
            sum_limit_oct.setText(oct.getString(2));
        }
        catch(Exception e)
        {
        }

        try {
            sum_nov = (TextView) rootView.findViewById(R.id.sum_spend_nov);
            sum_limit_nov = (TextView) rootView.findViewById(R.id.sum_limit_nov);
            avg_nov = (TextView) rootView.findViewById(R.id.avg_nov);
            nov = helper.get_Nov();
            avg_nov.setText(nov.getString(0));
            sum_nov.setText(nov.getString(1));
            sum_limit_nov.setText(nov.getString(2));
        }
        catch(Exception e)
        {
        }

        try {
            sum_dec = (TextView) rootView.findViewById(R.id.sum_spend_dec);
            sum_limit_dec = (TextView) rootView.findViewById(R.id.sum_limit_dec);
            avg_dec = (TextView) rootView.findViewById(R.id.avg_dec);
            dec = helper.get_Dec();
            avg_dec.setText(dec.getString(0));
            sum_dec.setText(dec.getString(1));
            sum_limit_dec.setText(dec.getString(2));
        }
        catch(Exception e)
        {
        }
















        return rootView;
    }
}
