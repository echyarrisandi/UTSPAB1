MainAcitivity.java
        package com.example.utspab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etnama, etNoDaftar;
    private Button btnDaftar;
    private CheckBox cbfacebook, cbinstagram, cbwebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = findViewById(R.id.et_nama);
        etNoDaftar = findViewById(R.id.et_noPendaftaran);
        btnDaftar = findViewById(R.id.btn_Daftar);
        cbfacebook = findViewById(R.id.cb_facebook);
        cbinstagram = findViewById(R.id.cb_instagram);
        cbwebsite = findViewById(R.id.cb_website);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, nodaftar, informasi;

                nama = etnama.getText().toString();
                nodaftar = etNoDaftar.getText().toString();

                if (nama.trim().equals("")) {
                    etnama.setError("Nama tidak boleh kosong");
                }
                else if (nodaftar.trim().equals("")) {
                    etNoDaftar.setError("Nama tidak boleh kosong");
                } else if(!cbfacebook.isChecked() && !cbinstagram.isChecked() && !cbwebsite.isChecked()){
                    Toast.makeText(getApplicationContext(), "Tidak ada data yang dipilih", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, KonfirmasiPendaftaran.class);
                    intent.putExtra("varNama", nama);
                    intent.putExtra("varNoDaftar", nodaftar);
                    informasi = "";
                    if(cbfacebook.isChecked()){
                        informasi += "Facebook";
                    }
                    if (cbinstagram.isChecked()){
                        informasi += "Instagram";
                    }
                    if (cbwebsite.isChecked()){
                        informasi += "Website";
                    }
                    String pilihan = informasi.toString();
                    intent.putExtra("informasi", pilihan);
                    startActivity(intent);


                }
            }
        });
    }
}onstraintLayout>