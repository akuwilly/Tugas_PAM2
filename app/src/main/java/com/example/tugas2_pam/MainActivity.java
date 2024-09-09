package com.example.tugas2_pam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Deklarasikan variabel untuk EditText, RadioGroup, Button, dan intent
    EditText edtAngkaPertama, edtAngkaKedua;
    RadioGroup rgOperasi;
    Button btnKalkulasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen
        edtAngkaPertama = findViewById(R.id.edtAngkaSatu);
        edtAngkaKedua = findViewById(R.id.edtAngkaDua);
        rgOperasi = findViewById(R.id.rgOperasi);
        btnKalkulasi = findViewById(R.id.btnHitung);

        btnKalkulasi.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                // Ambil nilai dari EditText dan RadioButton
                String strAngka1 = edtAngkaPertama.getText().toString();
                String strAngka2 = edtAngkaKedua.getText().toString();
                int selectedId = rgOperasi.getCheckedRadioButtonId();

                // Lakukan perhitungan berdasarkan RadioButton yang dipilih
                int hasil = 0;
                if (selectedId == R.id.rbPlus) {
                    hasil = Integer.parseInt(strAngka1) + Integer.parseInt(strAngka2);
                }
                if (selectedId == R.id.rbMinus) {
                    hasil = Integer.parseInt(strAngka1) - Integer.parseInt(strAngka2);
                }
                if (selectedId == R.id.rbMultiply) {
                    hasil = Integer.parseInt(strAngka1) * Integer.parseInt(strAngka2);
                }
                if (selectedId == R.id.rbDifition) {
                    hasil = Integer.parseInt(strAngka1) / Integer.parseInt(strAngka2);
                }

                // Kirim data hasil, NIM, dan nama ke Activity kedua menggunakan Intent
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Hasil", hasil);
                intent.putExtra("NIM", "225150400111028");
                intent.putExtra("Nama", "Willy Arya Wiratama");
                startActivity(intent);
            }
        });
    }
}