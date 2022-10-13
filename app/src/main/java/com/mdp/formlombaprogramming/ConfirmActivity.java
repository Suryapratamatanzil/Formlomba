package com.mdp.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity {
    DatePickerDialog datepicker;
    private TextView tvnama, tvjk, tvwa, tvalamat, tvtgl;
    private Button btntanggal, btnkonfirm;

    String nama, jk, nowa, alamat, choosendate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        tvnama = findViewById(R.id.tv_nama);
        tvjk = findViewById(R.id.tv_jk);
        tvwa = findViewById(R.id.tv_wa);
        tvalamat = findViewById(R.id.tv_alamat);
        tvtgl = findViewById(R.id.tv_tanggal);

        btntanggal = findViewById(R.id.btn_tanggal);
        btnkonfirm = findViewById(R.id.btn_konfirm);

       Intent terima = getIntent();
       nama = terima.getStringExtra("varnama");
       jk = terima.getStringExtra("varjk");
       nowa = terima.getStringExtra("varwa");
       alamat = terima.getStringExtra("varalamat");
       //set
        tvnama.setText(nama);
        tvjk.setText(jk);
        tvwa.setText(nowa);
        tvalamat.setText(alamat);

        btntanggal.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Calendar newcalendar = Calendar.getInstance();
                datepicker = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String tahun = Integer.toString(year);
                                String bulan = Integer.toString(month+1);
                                        String tanggal = Integer.toString(day);
                    choosendate = tanggal+"/"+bulan+"/"+tahun;
                     tvtgl.setText(choosendate);
                    }
                }, newcalendar.get(Calendar.YEAR), newcalendar.get(Calendar.MONTH), newcalendar.get(Calendar.DAY_OF_MONTH));
                datepicker.show();

            }
        });
        btnkonfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah data anda sudah benar?");
                //positif
                dialog.setPositiveButton("ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ConfirmActivity.this, "Terima Kasih, Pendaftaran Anda Berhasil",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ConfirmActivity.this, "Terima Kasih, Pendaftaran Anda Gagal",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                dialog.show();
            }
        });



    }
}