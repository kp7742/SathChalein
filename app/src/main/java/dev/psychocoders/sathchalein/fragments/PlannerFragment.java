package dev.psychocoders.sathchalein.fragments;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.activites.MainActivity;
import dev.psychocoders.sathchalein.utils.NotificationHelper;

public class PlannerFragment extends Fragment {
    static PlannerFragment plannerFragment;

    public static PlannerFragment instance(){
        if(plannerFragment == null){
            plannerFragment = new PlannerFragment();
        }
        return plannerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_myplanner, container, false);
        Button button = (Button) v.findViewById(R.id.travel_new_frnd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Thank you for giving us your data! We will let you know through notifications if we find a similar search",Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, 0);

                        NotificationHelper helper = new NotificationHelper(getContext());
                        Notification.Builder notification = helper.getNotification1("Hola! Match Found..","We have matched a similar tourist with you.Click to see if you want to match and communicate ");
                        notification.setContentIntent(pendingIntent);
                        helper.notify(0,notification);
                    }
                },4000);
            }
        });
        return v;
    }
}
