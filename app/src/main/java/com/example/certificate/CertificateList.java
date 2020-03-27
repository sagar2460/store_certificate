package com.example.certificate;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class CertificateList extends AppCompatActivity {

    GridView gridView;
    ArrayList<Certificate> list;
    certificateListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.certificate_activity);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new certificateListAdapter(this, R.layout.certificate_items, list);
        gridView.setAdapter(adapter);

        // get all data from sqlite

        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM CERTIFICATE");
        list.clear();
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String regNo = cursor.getString(2);
            byte[] image = cursor.getBlob(3);

            list.add(new Certificate(id, name, regNo, image));

        }

        adapter.notifyDataSetChanged();

    }
}
