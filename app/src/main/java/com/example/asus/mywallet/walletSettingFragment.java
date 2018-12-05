package com.example.asus.mywallet;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class walletSettingFragment extends Fragment {


   // private OnGetFromUserClickListener mListener1;
    private EditText daily_limit,monthly_limit,new_daily_limit,new_monthly_limit;
    myDbAdapter helper;
    Cursor cursor; private FragmentActivity myContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //return inflater.inflate(R.layout.setting, container, false);
        final View rootView = inflater.inflate(R.layout.setting, container, false);
        daily_limit = (EditText)rootView.findViewById(R.id.wallet_daily_limit);
        monthly_limit = (EditText)rootView.findViewById(R.id.current_monthly_limit);
         helper = new myDbAdapter(getActivity());
        cursor = helper.getLimit();
        cursor.moveToFirst();

        daily_limit.setText(cursor.getString(1));
        monthly_limit.setText(cursor.getString(2));



try {
    rootView.findViewById(R.id.update_limit_id).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.update_limit_id) {
                new_daily_limit = (EditText) rootView.findViewById(R.id.new_daily_limit);
                new_monthly_limit = (EditText) rootView.findViewById(R.id.new_monthly_limit);

                double daily = Double.parseDouble(new_daily_limit.getText().toString());
                double monthly = Double.parseDouble(new_monthly_limit.getText().toString());
                update_limit(daily, monthly);

            } else {

            }
        }
    });

}
catch (Exception e)
{}
       return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }
    public void update_limit(double new_daily_limit, double new_monthly_limit) {

        FragmentManager fragManager = myContext.getSupportFragmentManager();

        int a = helper.update_limit(new_daily_limit,new_monthly_limit);


        if (a>0)
        {
            myContext.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new walletSettingFragment()).commit();

        }
        else
        {
            myContext.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new walletFragment()).commit();
        }
    }




 /*   @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener1 = (walletSettingFragment.OnGetFromUserClickListener) activity;
            Log.e("CREATION","testing 234");
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnGetFromUserClickListener");
        }
    }

    public void update_limit(View v) {
        if (mListener1 != null) {

            double daily = Double.parseDouble(daily_limit.getText().toString());
            double monthly =  Double.parseDouble(monthly_limit.getText().toString());

            mListener1.update_limit(daily,monthly);

        }
        else
        {
            Log.e("CREATION","testing 12");
        }
    }

    public interface OnGetFromUserClickListener {

        void update_limit(Double daily, Double monthly);


    }
*/
}
