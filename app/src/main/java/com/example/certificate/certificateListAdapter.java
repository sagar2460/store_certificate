package com.example.certificate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class certificateListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Certificate> certificateList;

    public certificateListAdapter(Context context, int layout, ArrayList<Certificate> certificateList) {
        this.context = context;
        this.layout = layout;
        this.certificateList = certificateList;
    }

    @Override
    public int getCount() {
        return certificateList.size();
    }

    @Override
    public Object getItem(int position) {
        return certificateList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textname, textregno;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.textname = (TextView) row.findViewById(R.id.textView);
            holder.textregno = (TextView) row.findViewById(R.id.textView2);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);
            row.setTag(holder);

        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Certificate certificate = certificateList.get(position);

        holder.textname.setText(certificate.getName());
        holder.textregno.setText(certificate.getRegno());

        byte[] certificateimage = certificate.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(certificateimage, 0 , certificateimage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
