package com.example.azizainun.maps;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.savvi.rangedatepicker.CalendarCellView;
import com.savvi.rangedatepicker.CalendarPickerView;
import com.savvi.rangedatepicker.DayViewAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static com.example.azizainun.maps.User.mFirebaseInstance;

public class BookingPage extends AppCompatActivity {
    CalendarPickerView calendar;
    Button button;
    String UID;
    String nama_tempat;
    Integer max_tamu;
    private static final String TAG = "BookingPage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_page);
        final Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.MONTH, 3);
        final Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.MONTH, 0);

        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        button = (Button) findViewById(R.id.get_selected_dates);
        Intent i = getIntent();
        UID = i.getExtras().getString("UID");
        nama_tempat = i.getExtras().getString("nama tempat");
        max_tamu = i.getExtras().getInt("max tamu");
        final ArrayList<Date> arrayList = new ArrayList<>();
        /*try {
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
            String strdate = "14-4-2018";
            String strdate2 = "16-4-2018";
            Date newdate = dateformat.parse(strdate);
            Date newdate2 = dateformat.parse(strdate2);
            arrayList.add(newdate);
            arrayList.add(newdate2);

            String strdate3 = "20-4-2018";
            Date newdate1 = dateformat.parse(strdate);

//            int i = Integer.parseInt(strdate3);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(20042018);
            calendar.deactivateDates(list);

        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        calendar.init(lastYear.getTime(), nextYear.getTime(), Locale.getDefault()) //
                .inMode(CalendarPickerView.SelectionMode.RANGE) //
                .withSelectedDate(new Date())
                .withHighlightedDates(arrayList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                Log.d("list",  calendar.getSelectedDates().toString());
                Log.d(TAG, "onClick: " + UID);
                Log.d(TAG, "onClick: " + nama_tempat);
                List<Date> date = calendar.getSelectedDates();
                ArrayList<String> Sdate = new ArrayList<>();
                for (Date a: date) {
                    String c = simpleDateFormat.format(a.getTime());
                    Log.d(TAG, "onClick: " + c);
                    Sdate.add(c);
                }
                Log.d(TAG, "onClick: " + date);
                NextBooking1 nextBooking1 = new NextBooking1();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                bundle.putString("UID", UID);
                bundle.putString("nama tempat", nama_tempat);
                bundle.putStringArrayList("dates", Sdate);
                bundle.putInt("max tamu", max_tamu);
                nextBooking1.setArguments(bundle);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame_next, nextBooking1).addToBackStack(null);
                ft.commit();

                /*String UID = getIntent().getStringExtra("UID");
                String nama_tempat = getIntent().getStringExtra("nama tempat");
                DatabaseReference ref = mFirebaseInstance.getInstance().getReference();
                DatabaseReference pushDate = ref.child("User/" + UID +  "/Booked");
                DatabaseReference pushUser = ref.child("User/" + UID +  "Booked");

                SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
                String strdate3 = "20180421";
                HashMap<String, Object> result = new HashMap<>();
                */
                /*Log.d(TAG, "onClick: before try");
                try {
                    Date newdate1 = dateformat.parse(strdate3);
                    ArrayList<Date> dateArrayList = new ArrayList<>();
                    dateArrayList.add(newdate1);
                    Booked.Dates dates = new Booked.Dates(dateArrayList);
                    ArrayList<String> arrayList1 = new ArrayList<>();
                    Booked.Users users = new Booked.Users(arrayList1, dates);
                    Booked booked = new Booked(dates,  users);

                    HashMap<String, Object> result = new HashMap<>();
                    result.put(nama_tempat, booked);
                    pushDate.updateChildren(result);
                    Log.d(TAG, "onClick: after update children");
                } catch (ParseException e) {
                    e.printStackTrace();
                }*/
//                pushUser.setValue();
            }
        });

    }
}
