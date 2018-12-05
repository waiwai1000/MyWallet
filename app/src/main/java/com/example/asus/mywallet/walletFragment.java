package com.example.asus.mywallet;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

public class walletFragment extends Fragment {

    private OnGetFromUserClickListener mListener;
    private EditText new_amount_user, new_desc_wallet,check_daily_limit,check_usage;
    Cursor cursor, usage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
       // return inflater.inflate(R.layout.wallet, container, false);
       final View rootView = inflater.inflate(R.layout.wallet, container, false);
        new_amount_user = (EditText)rootView.findViewById(R.id.new_amount);
        new_desc_wallet = (EditText)rootView.findViewById(R.id.new_desc);
        myDbAdapter helper = new myDbAdapter(getActivity());
        cursor = helper.getLimit();
        cursor.moveToFirst();
        check_daily_limit = (EditText)rootView.findViewById(R.id.wallet_daily_limit);
        check_daily_limit.setText(cursor.getString(1));
        Log.e("CREATION","before getting");
       usage = helper.get_Usage();
        Log.e("CREATION","after getting");
        check_usage = (EditText)rootView.findViewById(R.id.today_usage);
        try {

            Log.e("CREATION", "before setting into");
            check_usage.setText(usage.getString(1));
            Log.e("CREATION", "after put into setText");
        }
   catch(Exception e)
            {
            check_usage.setText("0");
        }




        rootView.findViewById(R.id.add_new_button_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.add_new_button_id) {
                    add_new_list(v);

                }
                else
                {

                }
            }
        });
        return rootView;

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnGetFromUserClickListener ) activity;
            Log.e("CREATION","testing 234");
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnGetFromUserClickListener");
        }
    }

    public void add_new_list(View v) {
        try{
        if (mListener != null) {
                double am = Double.parseDouble(new_amount_user.getText().toString());
                String desc = new_desc_wallet.getText().toString();
                double limit = Double.parseDouble(check_daily_limit.getText().toString());
                double t_usage = Double.parseDouble(check_usage.getText().toString());
                mListener.add_new_list(am, desc, limit, t_usage);

            }
        else
            {
                Log.e("CREATION", "testing 12");
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(),"Please enter amount before add",Toast.LENGTH_SHORT).show();
        }
    }

    public interface OnGetFromUserClickListener {

        void add_new_list(double am , String desc,double limit, double t_usage);
    }


}

