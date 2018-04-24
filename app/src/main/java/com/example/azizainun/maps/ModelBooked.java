package com.example.azizainun.maps;

import java.util.ArrayList;

public class ModelBooked {
    String was_Booking, bookedBy, booked, status, harga, nama_wakil;
    ArrayList<String> date;
    Integer jumlah_tamu;

    public ModelBooked() {
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public String getBooked() {
        return booked;
    }

    public void setBooked(String booked) {
        this.booked = booked;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWas_Booking() {
        return was_Booking;
    }

    public void setWas_Booking(String was_Booking) {
        this.was_Booking = was_Booking;
    }

    public String getNama_wakil() {
        return nama_wakil;
    }

    public void setNama_wakil(String nama_wakil) {
        this.nama_wakil = nama_wakil;
    }

    public Integer getJumlah_tamu() {
        return jumlah_tamu;
    }

    public void setJumlah_tamu(Integer jumlah_tamu) {
        this.jumlah_tamu = jumlah_tamu;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public ArrayList<String> getDate() {
        return date;
    }

    public void setDate(ArrayList<String> date) {
        this.date = date;
    }
}
