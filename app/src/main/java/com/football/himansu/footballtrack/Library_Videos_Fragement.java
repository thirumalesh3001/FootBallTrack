package com.football.himansu.footballtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by santhu on 24-Sep-17.
 */

public class Library_Videos_Fragement extends Fragment{
    Button video_play;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.library_videos_listview, container, false);

        video_play=(Button)v.findViewById(R.id.video_paly);
        video_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),VideoViewActivity.class);
                startActivity(i);
            }
        });
        return v;
    }

}
