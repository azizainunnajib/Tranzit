package com.example.azizainun.maps;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class KelolaTempatSewa extends AppCompatActivity {
    ArrayList<Model> listunit = new ArrayList<>();
    private int currentPage = 0;
    RecyclerView myRecyclerView;
    private static final String TAG = "KelolaTempatSewa";
    Adapterkelola mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listunit.clear();
        mAdapter = new Adapterkelola(listunit);
        setContentView(R.layout.activity_kelola_tempat_sewa);
        String UID = User.getUID();
        myRecyclerView = (RecyclerView) findViewById(R.id.cardView);
        LinearLayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext());
        myRecyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                moredataload();
            }
        });
        if (listunit.size() == 0) {
            dataload();
        } else {
            Initialist(myRecyclerView);
        }
    }

    private void moredataload() {
        currentPage++;
        dataload();
    }

    private void dataload() {
        new Database().mReadDataOnce("Home", new Database.OnGetDataListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(DataSnapshot data) {
                if(!data.hasChildren()) {
                    Toast.makeText(getApplicationContext(), "ini yang terakhir", Toast.LENGTH_SHORT).show();
                    currentPage--;
                }

                Model item = new Model();
                for (DataSnapshot snapshot : data.getChildren()) {
                    Model model = snapshot.getValue(Model.class);
                    listunit.add(model);
                }
                myRecyclerView.setHasFixedSize(true);
                LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getParent());
                MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                myRecyclerView.setLayoutManager(MyLayoutManager);
                if (listunit.size() > 0 & myRecyclerView != null) {
                    myRecyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    Log.d(TAG, "onSuccess: "+ listunit.get(1).getKotakab());
                }
                int t = listunit.size();
                int v = t++;
            }

            @Override
            public void onFailed(DatabaseError databaseError) {

            }
        });
    }

    public class Adapterkelola extends RecyclerView.Adapter<MyViewHolder> {
        private ArrayList<Model> list;
        private Context context;

        public Adapterkelola(ArrayList<Model> Data) {
            this.list = Data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_items,parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.titlePrice.setText(list.get(position).getHarga() + " untuk " + list.get(position).getTipe_bangunan());
            holder.titleName.setText(list.get(position).getNama_tempat());
            holder.titlePlace.setText("di " + list.get(position).getKotakab());
//            holder.coverImageView.setImageResource(list.get(position).getUrut());

            Glide
                    .with(getParent())
                    .load(list.get(position).getUrl())
                    .asBitmap()
                    .centerCrop()
//                    .override(50, 50)
                    .dontAnimate()
                    .into(holder.coverImageView);

            holder.setItemClickCard(new ItemClickCard() {
                @Override
                public void onClick(View view, int position) {
                    Intent intent = new Intent(getApplicationContext(), DetailUnit.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("detail", list.get(position));
                    intent.putExtras(bundle);
                    getApplicationContext().startActivity(intent);

                    //Toast.makeText(getActivity(), "terclick " + list.get(position), Toast.LENGTH_LONG).show();



                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView titlePlace;
        TextView titlePrice;
        TextView titleName;
        ImageView coverImageView;
        CardView cardView;
        private ItemClickCard itemClickCard;
        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            titlePlace = (TextView) itemView.findViewById(R.id.kotakab);
            titlePrice = (TextView) itemView.findViewById(R.id.titlePrice);
            titleName = (TextView) itemView.findViewById(R.id.titlePlace);
            coverImageView = (ImageView) itemView.findViewById(R.id.coverImageView);

            itemView.setOnClickListener(this);
        }

        public void setItemClickCard(ItemClickCard itemClickCard) {
            this.itemClickCard = itemClickCard;
        }

        @Override
        public void onClick(View v) {
            itemClickCard.onClick(v, getAdapterPosition());
        }
    }

    public void Initialist(RecyclerView myRecyclerView) {
        myRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getParent());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(MyLayoutManager);
        if (listunit.size() > 0 & myRecyclerView != null) {
            myRecyclerView.setAdapter(new Adapterkelola(listunit));
        }
        /*for (int i=0; i<4 ; i++) {
            Model item = new Model();
            item.setLokasi(Bangunan[i]);
            item.setHarga(Bangunan[i]);
            item.setUrut(Imag[i]);
            listunit.add(item);
        }*/
    }
}
