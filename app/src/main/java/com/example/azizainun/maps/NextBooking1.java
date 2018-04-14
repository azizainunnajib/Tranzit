package com.example.azizainun.maps;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.google.firebase.database.DatabaseReference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.azizainun.maps.User.mFirebaseInstance;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextBooking1 extends Fragment implements View.OnClickListener {
    MyTextView harga, tanggal;
    NumberPicker tamu_picker;
    EditText nama_wakil;
    Button confirm_book;
    String UID, nama_tempat;
    ArrayList<String> Sdate;
    Integer max_tamu;
    private static final String TAG = "NextBooking1";

    public NextBooking1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_next_booking1, container, false);
        harga = view.findViewById(R.id.harga);
        tanggal = view.findViewById(R.id.tanggal_booked);
        tamu_picker = view.findViewById(R.id.tamu_picker);
        nama_wakil = view.findViewById(R.id.nama_wakil);
        confirm_book = view.findViewById(R.id.confirm_book);

        Bundle args = getArguments();
        UID = args.getString("UID");
        nama_tempat = args.getString("nama tempat");
        max_tamu = ((Integer) args.getInt("max tamu"));
        Sdate = args.getStringArrayList("dates");

        tamu_picker.setMaxValue(max_tamu);
        confirm_book.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + UID, Sdate);
        childUpdates.put("/dates/", Sdate );
        Log.d(TAG, "onClick: date" + Sdate.get(1));
        Log.d(TAG, "onClick: " +UID);
        String uid = User.getUID();
        Log.d(TAG, "onClick: 1" + uid);
        User.setUID();
        uid = User.getUID();
        Log.d(TAG, "onClick: 2" + uid);
        final DatabaseReference pushbooked = mFirebaseInstance.getInstance().getReference().child("User/" + User.getUID() + "/Booked/" + nama_tempat);
        pushbooked.updateChildren(childUpdates);
    }
}
