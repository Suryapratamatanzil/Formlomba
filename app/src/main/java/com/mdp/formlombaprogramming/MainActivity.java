package com.mdp.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText etnama, etwa, etalamat,etpass, etpin;
    private RadioGroup rgjk;
    private RadioButton rbjk;
    private Button btndaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = findViewById(R.id.et_nama);
        etwa = findViewById(R.id.et_wa);
        etalamat = findViewById(R.id.et_alamat);
        etpass = findViewById(R.id.et_pass);
        etpin = findViewById(R.id.et_pin);
        rgjk = findViewById(R.id.rg_jk);
        btndaftar = findViewById(R.id.btn_dftr);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etnama.getText().toString();
                String noWA = etwa.getText().toString();
                String alamat = etalamat.getText().toString();
                String password = etpass.getText().toString();
                String pin = etpin.getText().toString();

                int jkid = rgjk.getCheckedRadioButtonId();
                rbjk = findViewById(jkid);
                String jk = rbjk.getText().toString();
                if(nama.trim().equals(""))
                {
                    etnama.setError("Nama tidak boleh kosong");
                }
                else if(noWA.trim().equals(""))
                {
                    etnama.setError("Nomor WA tidak boleh kosong");
                }
                else if(alamat.trim().equals(""))
                {
                    etalamat.setError("alamat tidak boleh kosong");
                }
                else if(password.trim().equals(""))
                {
                    etpass.setError("Minimal isi password bg");
                }
                else if(pin.trim().equals(""))
                {
                    etpin.setError("Pin tidak boleh kosong");
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this,ConfirmActivity.class);
                    intent.putExtra("varnama", nama);
                    intent.putExtra("varjk", jk);
                    intent.putExtra("varwa", noWA);
                    intent.putExtra("varalamat", alamat);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        etnama.setText("");
        etalamat.setText("");
        etpass.setText("");
        etpin.setText("");
        etwa.setText("");
    }
}