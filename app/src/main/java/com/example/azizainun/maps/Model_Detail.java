package com.example.azizainun.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Contacts;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by aziza on 8/31/2017.
 */

public class Model_Detail implements Parcelable{
    public String peraturan, deskripsi, harga, kotakab ,lokasi, uid_, tipe_tempat, tipe_bangunan, jenis_kasur,
            wifi, ac, tv, dapur, kulkas, parkir, airpanas, syariah,
            minimarket, angkot, ojek_daring, atm, checkin, checkout, judul, handphone, keyid;
    double longi, lat, rating;
    int total_tamu, total_kamar, total_kasur, total_toilet;
    public ArrayList<String> url;

    public Model_Detail()  {
    }

    protected Model_Detail(Parcel in) {
        keyid = in.readString();
        uid_ = in.readString();
        rating = in.readDouble();
        judul = in.readString();
        handphone = in.readString();
        checkin = in.readString();
        checkout = in.readString();
        peraturan = in.readString();
        deskripsi = in.readString();
        kotakab = in.readString();
        longi = in.readDouble();
        lat = in.readDouble();
        harga = in.readString();
        lokasi = in.readString();
        uid_ = in.readString();
        tipe_tempat = in.readString();
        tipe_bangunan = in.readString();
        jenis_kasur = in.readString();
        total_tamu = in.readInt();
        total_kamar = in.readInt();
        total_kasur = in.readInt();
        total_toilet = in.readInt();
        wifi = in.readString();
        ac = in.readString();
        tv = in.readString();
        dapur = in.readString();
        kulkas = in.readString();
        parkir = in.readString();
        airpanas = in.readString();
        syariah = in.readString();
        minimarket = in.readString();
        angkot = in.readString();
        ojek_daring = in.readString();
        atm = in.readString();
        url = in.createStringArrayList();
    }

    public static final Creator<Model_Detail> CREATOR = new Creator<Model_Detail>() {
        @Override
        public Model_Detail createFromParcel(Parcel in) {
            return new Model_Detail(in);
        }

        @Override
        public Model_Detail[] newArray(int size) {
            return new Model_Detail[size];
        }
    };

    public String getUid_() {
        return uid_;
    }

    public void setUid_(String uid_) {
        this.uid_ = uid_;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getHandphone() {
        return handphone;
    }

    public void setHandphone(String handphone) {
        this.handphone = handphone;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getPeraturan() {
        return peraturan;
    }

    public void setPeraturan(String peraturan) {
        this.peraturan = peraturan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKotakab() {
        return kotakab;
    }

    public void setKotakab(String kotakab) {
        this.kotakab = kotakab;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double aLong) {
        longi = aLong;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double aLat) {
        lat = aLat;
    }

    public String getMinimarket() {
        return minimarket;
    }

    public void setMinimarket(String minimarket) {
        this.minimarket = minimarket;
    }

    public String getAngkot() {
        return angkot;
    }

    public void setAngkot(String angkot) {
        this.angkot = angkot;
    }

    public String getOjek_daring() {
        return ojek_daring;
    }

    public void setOjek_daring(String ojek_daring) {
        this.ojek_daring = ojek_daring;
    }

    public String getAtm() {
        return atm;
    }

    public void setAtm(String atm) {
        this.atm = atm;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getDapur() {
        return dapur;
    }

    public void setDapur(String dapur) {
        this.dapur = dapur;
    }

    public String getKulkas() {
        return kulkas;
    }

    public void setKulkas(String kulkas) {
        this.kulkas = kulkas;
    }

    public String getParkir() {
        return parkir;
    }

    public void setParkir(String parkir) {
        this.parkir = parkir;
    }

    public String getAirpanas() {
        return airpanas;
    }

    public void setAirpanas(String airpanas) {
        this.airpanas = airpanas;
    }

    public String getSyariah() {
        return syariah;
    }

    public void setSyariah(String syariah) {
        this.syariah = syariah;
    }

    public String getJenis_kasur() {
        return jenis_kasur;
    }

    public void setJenis_kasur(String jenis_kasur) {
        this.jenis_kasur = jenis_kasur;
    }

    public int getTotal_tamu() {
        return total_tamu;
    }

    public void setTotal_tamu(int total_tamu) {
        this.total_tamu = total_tamu;
    }

    public int getTotal_kamar() {
        return total_kamar;
    }

    public void setTotal_kamar(int total_kamar) {
        this.total_kamar = total_kamar;
    }

    public int getTotal_kasur() {
        return total_kasur;
    }

    public void setTotal_kasur(int total_kasur) {
        this.total_kasur = total_kasur;
    }

    public int getTotal_toilet() {
        return total_toilet;
    }

    public void setTotal_toilet(int total_toilet) {
        this.total_toilet = total_toilet;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public ArrayList<String> getUrl() {
        return url;
    }

    public void setUrl(ArrayList<String> url) {
        this.url=url;
    }

    public String getTipe_tempat() {
        return tipe_tempat;
    }

    public void setTipe_tempat(String tipe_tempat) {
        this.tipe_tempat = tipe_tempat;
    }

    public String getTipe_bangunan() {
        return tipe_bangunan;
    }

    public void setTipe_bangunan(String tipe_bangunan) {
        this.tipe_bangunan = tipe_bangunan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(keyid);
        dest.writeString(uid_);
        dest.writeDouble(rating);
        dest.writeString(judul);
        dest.writeString(handphone);
        dest.writeString(checkin);
        dest.writeString(checkout);
        dest.writeString(peraturan);
        dest.writeString(deskripsi);
        dest.writeString(kotakab);
        dest.writeDouble(longi);
        dest.writeDouble(lat);
        dest.writeString(harga);
        dest.writeString(lokasi);
        dest.writeString(uid_);
        dest.writeString(tipe_tempat);
        dest.writeString(tipe_bangunan);
        dest.writeInt(total_kamar);
        dest.writeInt(total_kasur);
        dest.writeInt(total_tamu);
        dest.writeInt(total_toilet);
        dest.writeString(jenis_kasur);
        dest.writeString(wifi);
        dest.writeString(ac);
        dest.writeString(tv);
        dest.writeString(dapur);
        dest.writeString(kulkas);
        dest.writeString(parkir);
        dest.writeString(airpanas);
        dest.writeString(syariah);
        dest.writeString(minimarket);
        dest.writeString(angkot);
        dest.writeString(ojek_daring);
        dest.writeString(atm);
        dest.writeStringList(url);
    }
}
