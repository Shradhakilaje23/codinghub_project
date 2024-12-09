package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custombaseadapter extends BaseAdapter{
    Context context;
    String listCourse[];
    int listImages[];
    String urls[];
    LayoutInflater inflater;

    public Custombaseadapter(Context ctx, String[] courselist, int[]images, String[] urls){
              this.context=ctx;
              this.listCourse=courselist;
              this.listImages=images;
              this.urls= urls;
              inflater=LayoutInflater.from(ctx);
    }


    @Override
    public int getCount() {
        return listCourse.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view= inflater.inflate(R.layout.activity_custom_list,null);
        TextView textView=(TextView) view.findViewById(R.id.txt1);
        ImageView fruitimg = (ImageView) view.findViewById(R.id.imageIcon);
        textView.setText(listCourse[i]);
        fruitimg.setImageResource(listImages[i]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openLinksIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[i]));
                openLinksIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(openLinksIntent);
            }
        });
        return view;
    }
}
