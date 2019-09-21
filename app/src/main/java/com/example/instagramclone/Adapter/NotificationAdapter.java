package com.example.instagramclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.instagramclone.Objects.Notification;
import com.example.instagramclone.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NotificationAdapter extends ArrayAdapter<Notification> {

    Context context;
    int layout;
    ArrayList<Notification> arrayList;

    ImageView profileImage, post;
    TextView userName1, userName2, notificationContent, finalComment, finalLikePost;

    public NotificationAdapter(Context context, int resource, ArrayList<Notification> arrayList) {
        super(context, resource, arrayList);
        this.context = context;
        this.layout = resource;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(layout, null);
        
        CreateWidgets(convertView);

        Notification notification = arrayList.get(position);

        // like
        if (arrayList.get(position).getStatus().equals("1")) {
            userName1.setVisibility(View.GONE);
            finalComment.setVisibility(View.GONE);
            notificationContent.setVisibility(View.GONE);

            userName2.setText(notification.getUserName());
            Picasso.get()
                    .load(notification.getUserProfileImage())
                    .into(profileImage);
        }
        // comment
        else {
            userName2.setVisibility(View.GONE);
            finalLikePost.setVisibility(View.GONE);

            userName1.setText(notification.getUserName());
            notificationContent.setText(notification.getContent());
            Picasso.get()
                    .load(notification.getUserProfileImage())
                    .into(profileImage);
        }

        return convertView;
    }

    private void CreateWidgets(View convertView) {
        profileImage = convertView.findViewById(R.id.profileImage);
        post = convertView.findViewById(R.id.notification_postImage);
        userName1 = convertView.findViewById(R.id.notification_userName1);
        userName2 = convertView.findViewById(R.id.notification_userName2);
        notificationContent = convertView.findViewById(R.id.notification_content);
        finalComment = convertView.findViewById(R.id.notification_finalComment);
        finalLikePost = convertView.findViewById(R.id.notification_finalLikePost);
    }
}
