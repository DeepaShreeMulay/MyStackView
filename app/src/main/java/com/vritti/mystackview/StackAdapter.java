package com.vritti.mystackview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StackAdapter extends ArrayAdapter<StackItem> {

    private List<StackItem> items;
    private Context context;

    public StackAdapter(@NonNull Context context, int resource, @NonNull List<StackItem> objects) {
        super(context, resource, objects);
        this.items = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(R.layout.stack_item, null);
        }
        StackItem stackItem = items.get(position);
        if (stackItem != null) {
            // TextView defined in the stack_item.xml
            TextView textView = (TextView) itemView.findViewById(R.id.textView);
            // ImageView defined in the stack_item.xml
            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);


            if (textView != null) {
                textView.setText(stackItem.getItemText());

                // "image1", "image2",..
                String imageName= stackItem.getImageName();

                int resId= this.getDrawableResIdByName(imageName);

                imageView.setImageResource(resId);
                imageView.setBackgroundColor(Color.rgb(211,204,188));
            }

        }
        return itemView;
    }

    // Find Image ID corresponding to the name of the image (in the drawable folder).
    public int getDrawableResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i("MyLog", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
}
