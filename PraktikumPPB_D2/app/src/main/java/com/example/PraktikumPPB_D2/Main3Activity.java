package com.example.PraktikumPPB_D2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    RadioButton bi,be;
    TextView TNamaPemesan,TMenuKopi,TSajian,TJumlah;
    EditText ENamaPemesan;
    RadioButton rBS11,rBS12,rBS21,rBS22,rBS31,rBS32;
    Button Pesan;

    CheckBox c1,c2,c3;
    TextView jMenu1,jMenu2,jMenu3;

    String bahasa;
    String nama;
    String nilaic1,nilaic2,nilaic3;
    String SrBS1,SrBS2,SrBS3;
    String SjMenu1,SjMenu2,SjMenu3;

    String namaPemesan2;
    String pembayaran2,kembalian2,bayar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bi=findViewById(R.id.rBI);
        be=findViewById(R.id.rBE);

        TNamaPemesan=findViewById(R.id.namaPemesan);
        ENamaPemesan=findViewById(R.id.editNamaPemesan);
        TMenuKopi=findViewById(R.id.menuCoffe);
        TSajian=findViewById(R.id.sajian);
        TJumlah=findViewById(R.id.jumlah);
        rBS11=findViewById(R.id.rBS11);
        rBS12=findViewById(R.id.rBS12);
        rBS21=findViewById(R.id.rBS21);
        rBS22=findViewById(R.id.rBS22);
        rBS31=findViewById(R.id.rBS31);
        rBS32=findViewById(R.id.rBS32);
        Pesan=findViewById(R.id.pesan);

        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        jMenu1=findViewById(R.id.jMenu1);
        jMenu2=findViewById(R.id.jMenu2);
        jMenu3=findViewById(R.id.jMenu3);
    }
    public void Pengecekan(View view) {
        if(ENamaPemesan.getText().toString().isEmpty()){
            if (bi.isChecked()){
                Toast.makeText(getApplicationContext(),getString(R.string.masukanNama_i),Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(),getString(R.string.masukanNama_e),Toast.LENGTH_LONG).show();
            }
        }
        else if (c1.isChecked() || c2.isChecked() || c3.isChecked()){
            if ((c1.isChecked() && jMenu1.getText().toString().equals(getString(R.string.nol))) ||
                    (c2.isChecked() && jMenu2.getText().toString().equals(getString(R.string.nol))) ||
                    (c3.isChecked() && jMenu3.getText().toString().equals(getString(R.string.nol)))){
                ToastBahasa(getString(R.string.jumlahMinuman_i),getString(R.string.jumlahMinuman_e));
            }
            else{
                Order();
            }
        }
        else{
            ToastBahasa(getString(R.string.pilihMenu_i),getString(R.string.pilihMenu_e));
        }
    }
    public void ToastBahasa(String i,String e){
        if (bi.isChecked()){
            Toast.makeText(getApplicationContext(),i,Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),e,Toast.LENGTH_LONG).show();
        }

    }
    public void Order() {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        nama=ENamaPemesan.getText().toString();
        if (bi.isChecked()){
            bahasa=getString(R.string.i);
            namaPemesan2= getString(R.string.nama_pemesan2_i);
            pembayaran2=getString(R.string.pembayaran_i);
            kembalian2=getString(R.string.kembalian_i);
            bayar2=getString(R.string.bayar_i);
        }
        else{
            bahasa=getString(R.string.e);
            namaPemesan2= getString(R.string.nama_pemesan2_e);
            pembayaran2=getString(R.string.pembayaran_e);
            kembalian2=getString(R.string.kembalian_e);
            bayar2=getString(R.string.bayar_e);
        }
        intent.putExtra(getString(R.string.bahasa), bahasa);
        intent.putExtra(getString(R.string.namaPemesan2), namaPemesan2+nama);
        intent.putExtra(getString(R.string.pembayaran2), pembayaran2);
        intent.putExtra(getString(R.string.kembalian2), kembalian2);
        intent.putExtra(getString(R.string.bayar2), bayar2);

        nilaic1=getString(R.string.f);
        nilaic2=getString(R.string.f);
        nilaic3=getString(R.string.f);
        if(c1.isChecked()){
            nilaic1=getString(R.string.t);
            int toMenu1=0;
            SrBS1=getString(R.string.tmenu1);
            if(rBS11.isChecked()){
                if (bi.isChecked()){
                    SrBS1+=getString(R.string.hangat_i);
                }
                else{
                    SrBS1+=getString(R.string.hangat_e);
                }
                toMenu1=3000;
            }
            else{
                if (bi.isChecked()){
                    SrBS1+=getString(R.string.dingin_i);
                }
                else{
                    SrBS1+=getString(R.string.dingin_e);
                }
                toMenu1=3500;
            }
            intent.putExtra(getString(R.string.SrBS1), SrBS1);
            intent.putExtra(getString(R.string.hMenu1), getString(R.string.Rupiah)+Integer.toString(toMenu1));

            SjMenu1 = jMenu1.getText().toString();
            intent.putExtra(getString(R.string.jMenu1), SjMenu1);
            toMenu1*=Integer.parseInt(SjMenu1);
            intent.putExtra(getString(R.string.toMenu1), Integer.toString(toMenu1));
        }
        if(c2.isChecked()){
            nilaic2=getString(R.string.t);
            int toMenu2=0;
            SrBS2=getString(R.string.tmenu2);
            if(rBS21.isChecked()){
                if (bi.isChecked()){
                    SrBS2+=getString(R.string.hangat_i);
                }
                else{
                    SrBS2+=getString(R.string.hangat_e);
                }
                toMenu2=4000;
            }
            else{
                if (bi.isChecked()){
                    SrBS2+=getString(R.string.dingin_i);
                }
                else{
                    SrBS2+=getString(R.string.dingin_e);
                }
                toMenu2=4500;
            }
            intent.putExtra(getString(R.string.SrBS2), SrBS2);
            intent.putExtra(getString(R.string.hMenu2), getString(R.string.Rupiah)+Integer.toString(toMenu2));
            SjMenu2 = jMenu2.getText().toString();
            intent.putExtra(getString(R.string.jMenu2), SjMenu2);
            toMenu2*=Integer.parseInt(SjMenu2);
            intent.putExtra(getString(R.string.toMenu2), Integer.toString(toMenu2));
        }
        if(c3.isChecked()){
            nilaic3=getString(R.string.t);
            int toMenu3=0;
            SrBS3=getString(R.string.tmenu3);
            if(rBS31.isChecked()){
                if (bi.isChecked()){
                    SrBS3+=getString(R.string.hangat_i);
                }
                else{
                    SrBS3+=getString(R.string.hangat_e);
                }
                toMenu3=5000;
            }
            else{
                if (bi.isChecked()){
                    SrBS3+=getString(R.string.dingin_i);
                }
                else{
                    SrBS3+=getString(R.string.dingin_e);
                }
                toMenu3=5500;
            }
            intent.putExtra(getString(R.string.SrBS3), SrBS3);
            intent.putExtra(getString(R.string.hMenu3), getString(R.string.Rupiah)+Integer.toString(toMenu3));
            SjMenu3 = jMenu3.getText().toString();
            intent.putExtra(getString(R.string.jMenu3), SjMenu3);
            toMenu3*=Integer.parseInt(SjMenu3);
            intent.putExtra(getString(R.string.toMenu3), Integer.toString(toMenu3));
        }
        intent.putExtra(getString(R.string.c1), nilaic1);
        intent.putExtra(getString(R.string.c2), nilaic2);
        intent.putExtra(getString(R.string.c3), nilaic3);
        startActivity(intent);
    }

    public void BahasaIndonesia(View view) {
        TNamaPemesan.setText(R.string.nama_pemesan_i);
        TMenuKopi.setText(R.string.menu_coffe_i);
        TSajian.setText(R.string.sajian_i);
        TJumlah.setText(R.string.jumlah_i);
        ENamaPemesan.setHint(R.string.masukkan_nama_i);
        rBS11.setText(R.string.hangat_i);
        rBS12.setText(R.string.dingin_i);
        rBS21.setText(R.string.hangat_i);
        rBS22.setText(R.string.dingin_i);
        rBS31.setText(R.string.hangat_i);
        rBS32.setText(R.string.dingin_i);
        Pesan.setText(R.string.pesan_i);
    }public void BahasaInggris(View view) {
        TNamaPemesan.setText(R.string.nama_pemesan_e);
        TMenuKopi.setText(R.string.menu_coffe_e);
        TSajian.setText(R.string.sajian_e);
        TJumlah.setText(R.string.jumlah_e);
        ENamaPemesan.setHint(R.string.masukkan_nama_e);
        rBS11.setText(R.string.hangat_e);
        rBS12.setText(R.string.dingin_e);
        rBS21.setText(R.string.hangat_e);
        rBS22.setText(R.string.dingin_e);
        rBS31.setText(R.string.hangat_e);
        rBS32.setText(R.string.dingin_e);
        Pesan.setText(R.string.pesan_e);
    }

    public void pMenu1(View view) {
        String jmenu1=jMenu1.getText().toString();
        int ijmenu=Integer.parseInt(jmenu1);
        if(ijmenu<5){
            jMenu1.setText(Integer.toString(ijmenu+1));
        }
    }public void mMenu1(View view) {
        String jmenu1=jMenu1.getText().toString();
        int ijmenu=Integer.parseInt(jmenu1);
        if(ijmenu>0){
            jMenu1.setText(Integer.toString(ijmenu-1));
        }
    }
    public void pMenu2(View view) {
        String jmenu2=jMenu2.getText().toString();
        int ijmenu=Integer.parseInt(jmenu2);
        if(ijmenu<5){
            jMenu2.setText(Integer.toString(ijmenu+1));
        }
    }public void mMenu2(View view) {
        String jmenu2=jMenu2.getText().toString();
        int ijmenu=Integer.parseInt(jmenu2);
        if(ijmenu>0){
            jMenu2.setText(Integer.toString(ijmenu-1));
        }
    }
    public void pMenu3(View view) {
        String jmenu3=jMenu3.getText().toString();
        int ijmenu=Integer.parseInt(jmenu3);
        if(ijmenu<5){
            jMenu3.setText(Integer.toString(ijmenu+1));
        }
    }public void mMenu3(View view) {
        String jmenu3=jMenu3.getText().toString();
        int ijmenu=Integer.parseInt(jmenu3);
        if(ijmenu>0){
            jMenu3.setText(Integer.toString(ijmenu-1));
        }
    }

}
