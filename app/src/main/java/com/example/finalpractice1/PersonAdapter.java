package com.example.finalpractice1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends BaseAdapter {

    private Activity activity;
    private MyFriends myFriends;

    PersonAdapter(Activity activity, MyFriends myFriends) {
        this.activity = activity;
        this.myFriends = myFriends;
    }

    @Override
    public int getCount() {
        return myFriends.getMyFriendsList().size();
    }

    @Override
    public Person getItem(int position) {
        return myFriends.getMyFriendsList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View onePersonLine;
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = layoutInflater.inflate(R.layout.content_main,parent,false);

        TextView name = onePersonLine.findViewById(R.id.Name);
        TextView age = onePersonLine.findViewById(R.id.Age);
        ImageView icon = onePersonLine.findViewById(R.id.icon);

        Person person = this.getItem(position);

        name.setText(person.getName());
        age.setText(String.valueOf(person.getAge()));

        int[] iconResources = {
                R.drawable.baseline_help_black_24,
                R.drawable.baseline_home_black_24,
                R.drawable.baseline_language_black_24,
                R.drawable.baseline_pregnant_woman_black_24,
                R.drawable.baseline_room_black_24,
                R.drawable.baseline_search_black_24,
                R.drawable.baseline_settings_black_24,
                R.drawable.baseline_theaters_black_24
        };
        icon.setImageResource(iconResources[position]);
        return onePersonLine;
    }
}
