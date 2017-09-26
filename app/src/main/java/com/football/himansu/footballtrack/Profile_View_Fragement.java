package com.football.himansu.footballtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by santhu on 20-Sep-17.
 */

public class Profile_View_Fragement extends Fragment implements View.OnClickListener{
    JSONObject response, profile_pic_data, profile_pic_url;
    TextView user_name;
    ImageView user_picture;
    Button statistics_btn,videos_library_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.constraint_layout_sample, container, false);
        Bundle bundle = getArguments();
        user_name = (TextView)v. findViewById(R.id.UserName);
        user_picture = (ImageView)v. findViewById(R.id.profilePic);
        statistics_btn=(Button)v.findViewById(R.id.statistics);
        videos_library_btn=(Button)v.findViewById(R.id.videos_library);

        statistics_btn.setOnClickListener(this);
        videos_library_btn.setOnClickListener(this);

        try {
           response = new JSONObject(bundle.getString("json"));
            user_name.setText(response.get("name").toString());
           profile_pic_data = new JSONObject(response.get("picture").toString());
            profile_pic_url = new JSONObject(profile_pic_data.getString("data"));
            Picasso.with(this.getActivity()).load(profile_pic_url.getString("url"))
                    .into(user_picture);

        } catch(Exception e){
            e.printStackTrace();
        }
       return v;
    }

    @Override
    public void onClick(View v) {
        if(v==statistics_btn)
        {
            FragmentManager childFragMan = getChildFragmentManager();
            FragmentTransaction childFragTrans = childFragMan.beginTransaction();
            Statistics_Fragment fragB = new Statistics_Fragment ();
            childFragTrans.add(R.id.frame, fragB);
            childFragTrans.addToBackStack("B");
            childFragTrans.commit();
        }
        if(v==videos_library_btn)
        {
            FragmentManager childFragMan = getChildFragmentManager();
            FragmentTransaction childFragTrans = childFragMan.beginTransaction();
            Library_Videos_Fragement fragB = new Library_Videos_Fragement ();
            childFragTrans.add(R.id.frame, fragB);
            childFragTrans.addToBackStack("B");
            childFragTrans.commit();
        }

    }
}
