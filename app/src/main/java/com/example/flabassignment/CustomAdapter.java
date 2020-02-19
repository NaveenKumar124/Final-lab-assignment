package com.example.flabassignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.health.PackageHealthStats;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    Controllerdb controldb;
    SQLiteDatabase db;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> FName = new ArrayList<String>();
    private ArrayList<String> LName = new ArrayList<String>();
    private ArrayList<String> Phone = new ArrayList<String>();
    private ArrayList<String> Address = new ArrayList<String>();
    Button delete;
    public CustomAdapter(Context context, ArrayList<String> Id, ArrayList<String> FName, ArrayList<String> LName, ArrayList<String> Phone, ArrayList<String> Address
    )
    {
        this.mContext = context;
        this.Id = Id;
        this.FName = FName;
        this.LName = LName;
        this.Phone=Phone;
        this.Address=Address;
    }
    @Override
    public int getCount() {
        return Id.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final    viewHolder holder;
        controldb =new Controllerdb(mContext);
        LayoutInflater layoutInflater;

        if (convertView == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout, null);
            holder = new viewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.tvid);
            holder.fname = (TextView) convertView.findViewById(R.id.tvfname);
            holder.lname = (TextView) convertView.findViewById(R.id.tvlname);
            holder.phone = (TextView) convertView.findViewById(R.id.tvphone);
            holder.address = (TextView) convertView.findViewById(R.id.tvaddress);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }
        holder.id.setText(Id.get(position));
        holder.fname.setText(FName.get(position));
        holder.lname.setText(LName.get(position));
        holder.phone.setText(Phone.get(position));
        holder.address.setText(Address.get(position));
        return convertView;

    }


    public class viewHolder {

        TextView id;
        TextView fname;
        TextView lname;
        TextView phone;
        TextView address;

    }

}
