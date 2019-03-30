package com.example.PraktikumPPB_D2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView namaPemesan2,pembayaran,kembalian,bayar;
    TextView tArabika,tRobusta,tAmericano;
    TextView cArabika,cRobusta,cAmericano;
    TextView toArabika,toRobusta,toAmericano;
    TextView jTotal;

    TextView hArabika,hRobusta,hAmericano;

    int iTotal;

    EditText jPembayaran;
    TextView jKembalian;
    RelativeLayout kosong;
    TextView tkosong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        namaPemesan2=findViewById(R.id.namaPemesan2);
        pembayaran=findViewById(R.id.pembayaran);
        kembalian=findViewById(R.id.kembalian);
        bayar=findViewById(R.id.bayar);

        jPembayaran=findViewById(R.id.JPembayaran);
        jKembalian=findViewById(R.id.JKembalian);
        iTotal=0;

        if(getIntent().getExtras()!=null){
            namaPemesan2.setText(getIntent().getStringExtra(getString(R.string.namaPemesan2)));
            pembayaran.setText(getIntent().getStringExtra(getString(R.string.pembayaran2)));
            kembalian.setText(getIntent().getStringExtra(getString(R.string.kembalian2)));
            bayar.setText(getIntent().getStringExtra(getString(R.string.bayar2)));
            if (getIntent().getStringExtra(getString(R.string.c1)).equals(getString(R.string.f))){
                RelativeLayout RL1=findViewById(R.id.RL1);
                RL1.setVisibility(View.GONE);
            }
            else{
                tArabika=findViewById(R.id.TArabika);
                tArabika.setText(getIntent().getStringExtra(getString(R.string.SrBS1)));
                hArabika=findViewById(R.id.HArabika);
                hArabika.setText(getIntent().getStringExtra(getString(R.string.hMenu1)));
                cArabika=findViewById(R.id.CArabika);
                cArabika.setText(getString(R.string.x)+getIntent().getStringExtra(getString(R.string.jMenu1)));
                toArabika=findViewById(R.id.ToArabika);
                toArabika.setText(getIntent().getStringExtra(getString(R.string.toMenu1)));
                iTotal+=Integer.parseInt(getIntent().getStringExtra(getString(R.string.toMenu1)));
            }
            if (getIntent().getStringExtra(getString(R.string.c2)).equals(getString(R.string.f))){
                RelativeLayout RL2=findViewById(R.id.RL2);
                RL2.setVisibility(View.GONE);
            }
            else{
                tRobusta=findViewById(R.id.TRobusta);
                tRobusta.setText(getIntent().getStringExtra(getString(R.string.SrBS2)));
                hRobusta=findViewById(R.id.HRobusta);
                hRobusta.setText(getIntent().getStringExtra(getString(R.string.hMenu2)));
                cRobusta=findViewById(R.id.CRobusta);
                cRobusta.setText(getString(R.string.x)+getIntent().getStringExtra(getString(R.string.jMenu2)));
                toRobusta=findViewById(R.id.ToRobusta);
                toRobusta.setText(getIntent().getStringExtra(getString(R.string.toMenu2)));
                iTotal+=Integer.parseInt(getIntent().getStringExtra(getString(R.string.toMenu2)));
            }
            if (getIntent().getStringExtra(getString(R.string.c3)).equals(getString(R.string.f))){
                RelativeLayout RL3=findViewById(R.id.RL3);
                RL3.setVisibility(View.GONE);
            }
            else{
                tAmericano=findViewById(R.id.TAmericano);
                tAmericano.setText(getIntent().getStringExtra(getString(R.string.SrBS3)));
                hAmericano=findViewById(R.id.HAmericano);
                hAmericano.setText(getIntent().getStringExtra(getString(R.string.hMenu3)));
                cAmericano=findViewById(R.id.CAmericano);
                cAmericano.setText(getString(R.string.x)+getIntent().getStringExtra(getString(R.string.jMenu3)));
                toAmericano=findViewById(R.id.ToAmericano);
                toAmericano.setText(getIntent().getStringExtra(getString(R.string.toMenu3)));
                iTotal+=Integer.parseInt(getIntent().getStringExtra(getString(R.string.toMenu3)));
            }
            jTotal=findViewById(R.id.JTotal);
            jTotal.setText(Integer.toString(iTotal));
        }
    }

    public void bayar(View view) {
        String hasil;
        if(jPembayaran.getText().toString().isEmpty()){
            ToastBahasa(getString(R.string.masukanUangPembayaran_i),getString(R.string.masukanUangPembayaran_e));
        }
        else{
            int ibayar=Integer.parseInt(jPembayaran.getText().toString());
            if (ibayar>iTotal){
                hasil=Integer.toString(ibayar-iTotal);
                jKembalian.setText(hasil);
                ToastBahasa(getString(R.string.berhasil_i),getString(R.string.berhasil_e));
            }
            else{
                ToastBahasa(getString(R.string.uangKurang_i),getString(R.string.uangKurang_e));
            }
        }
    }

    public void ToastBahasa(String i, String e){
        if (getIntent().getStringExtra(getString(R.string.bahasa)).equals(getString(R.string.i))){
            Toast.makeText(getApplicationContext(),i,Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),e,Toast.LENGTH_LONG).show();
        }

    }
}

