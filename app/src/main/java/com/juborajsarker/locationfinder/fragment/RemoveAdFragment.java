package com.juborajsarker.locationfinder.fragment;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juborajsarker.locationfinder.R;

public class RemoveAdFragment extends Fragment {

    View view;
    Button removeAds;


    public RemoveAdFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_remove_ad, container, false);

        removeAds = (Button) view.findViewById(R.id.btn_remove_ads);
        removeAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeAd();
            }
        });



        return view;
    }


    public void removeAd() {
        try {
            Intent rateIntent = removeAdsIntentForUrl("market://details");
            startActivity(rateIntent);
        }
        catch (ActivityNotFoundException e)
        {
            Intent rateIntent = removeAdsIntentForUrl("https://play.google.com/store/apps/details");
            startActivity(rateIntent);
        }
    }


    private Intent removeAdsIntentForUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, "com.juborajsarker.locationfinderpro" )));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21)
        {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        }
        else
        {
            //noinspection deprecation
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;
    }

}
