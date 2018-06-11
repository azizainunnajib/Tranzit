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
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPickerListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.azizainun.maps.User.mFirebaseDatabase;
import static com.example.azizainun.maps.User.mFirebaseInstance;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextBooking1 extends Fragment implements View.OnClickListener {
    MyTextView harga, tanggal;
    ScrollableNumberPicker tamu_picker;
    EditText nama_wakil;
    Button confirm_book;
    String UID, nama_tempat, Sharga;
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
        harga = view.findViewById(R.id.harga_booked);
        tanggal = view.findViewById(R.id.tanggal_booked);
        tamu_picker = view.findViewById(R.id.tamu_picker);
        nama_wakil = view.findViewById(R.id.nama_wakil);
        confirm_book = view.findViewById(R.id.confirm_book);

        Bundle args = getArguments();
        UID = args.getString("UID");
        nama_tempat = args.getString("nama tempat");
        max_tamu = ((Integer) args.getInt("max tamu"));
        Sdate = args.getStringArrayList("dates");
        Sharga = args.getString("harga");

        tamu_picker.setMaxValue(max_tamu);
        tamu_picker.setMinValue(1);
        confirm_book.setOnClickListener(this);
        tamu_picker.setListener(new ScrollableNumberPickerListener() {
            @Override
            public void onNumberPicked(int value) {
                setHarga(value);
            }
        });
        return view;
    }

    private void setHarga(int value) {
        int a = value * Integer.parseInt(Sharga);
        harga.setText(a);
    }

    @Override
    public void onClick(View v) {
        Map<String, Object> childUpdates = new HashMap<>();
        Log.d(TAG, "onClick: date" + Sdate.get(1));
        Log.d(TAG, "onClick: " +UID);
        String uid = User.getUID();
        Log.d(TAG, "onClick: 1" + uid);
        User.setUID();
        uid = User.getUID();
        Log.d(TAG, "onClick: 2" + uid);
        DatabaseReference pushbooked = mFirebaseInstance.getInstance().getReference().child("User/" + uid + "/Booked/");
        String key = pushbooked.push().getKey();
        ModelBooked modelBooked = new ModelBooked();
        modelBooked.setBooked(nama_tempat);
        modelBooked.setWas_Booking(uid);
        modelBooked.setBookedBy(UID);
        modelBooked.setStatus("pending");
        modelBooked.setDate(Sdate);
        modelBooked.setHarga("harga");
        modelBooked.setNama_wakil("nama wakil");
        modelBooked.setJumlah_tamu(4);
        childUpdates.put(key, modelBooked );
        pushbooked.updateChildren(childUpdates);
    }
}
