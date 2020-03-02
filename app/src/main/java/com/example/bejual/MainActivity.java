package com.example.bejual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText edtnamapel, edtnamabar, edtjumlahbel, edtharga, edtuangbay;
    private Button btnproses;
    private Button btnhapus;
    private Button btnexit;
    private TextView txtnamapel;
    private TextView txtnamabar;
    private TextView txtjumlahbel;
    private TextView txtharga;
    private TextView txtuangbay;
    private TextView txtbonus;
    private TextView txttotalbelanja;
    private TextView txtuangkembali;
    private TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("PENJUALAN");

        edtnamapel= (EditText) findViewById(R.id.namapelangan);
        edtnamabar= (EditText) findViewById(R.id.namabarang);
        edtjumlahbel= (EditText) findViewById(R.id.jumlahbeli);
        edtharga= (EditText) findViewById(R.id.harga);
        edtuangbay= (EditText) findViewById(R.id.uangbayar);
        btnproses=(Button) findViewById(R.id.tombol1);
        btnhapus=(Button) findViewById(R.id.tombol2);
        btnexit=(Button) findViewById(R.id.tombol3);

        txtnamapel=(TextView) findViewById(R.id.namapelangan);
        txtnamabar=(TextView) findViewById(R.id.namabarang);
        txtjumlahbel=(TextView) findViewById(R.id.jumlahbeli);
        txtharga=(TextView) findViewById(R.id.harga);
        txtuangbay=(TextView) findViewById(R.id.uangbayar);
        txtbonus=(TextView) findViewById(R.id.bonus);
        txttotalbelanja=(TextView) findViewById(R.id.totalbelanja );
        txtuangkembali=(TextView) findViewById(R.id.uangkembali);
        txtketerangan=(TextView) findViewById(R.id.keterangan);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namapelanggan=edtnamapel.getText().toString().trim();
                String namabarang=edtnamabar.getText().toString().trim();
                String jumlahbeli=edtjumlahbel.getText().toString().trim();
                String harga=edtharga.getText().toString().trim();
                String uangbayar=edtuangbay.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbelanja.setText("Total Belanja : "+total);

                if (total >= 200000) {
                    txtbonus.setText("Bonus : Boneka");
                }else if (total >= 100000) {
                    txtbonus.setText("Bonus : Sepatu");
                }else if (total >= 50000) {
                    txtbonus.setText("Bonus : Sendal");
                }else {
                    txtbonus.setText("Bonus : Tidak dapat bonus");
                }
                double kembalian = (ub - total);

                if (ub < total){
                    txtketerangan.setText("Keterangan : Uang bayar kurang RP " + (-kembalian));
                    txtuangkembali.setText("Uang Kembali : Rp 0");
                }else if (ub == total){
                    txtketerangan.setText("Keterangan : Tidak ada kembalian");
                    txtuangkembali.setText("Uang Kembali : " + kembalian);
                }else {
                    txtketerangan.setText("Keterangan : Tunggu Kembalian");
                    txtuangkembali.setText("Uang Kembali : " + kembalian);
                }
            }
        });
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtnamapel.setText(" ");
                txtnamabar.setText(" ");
                txttotalbelanja.setText("total belanja : rp0 ");
                txtharga.setText(" ");
                txtuangbay.setText(" ");
                txtuangkembali.setText("uang kembalian : rp0 ");
                txtbonus.setText("bonus :- ");
                txtjumlahbel.setText(" ");
                txtketerangan.setText("keterangan : -");

                Toast.makeText(getApplicationContext(),"data sudah di reset",Toast.LENGTH_LONG).show();
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
            }
        });
    }
}
