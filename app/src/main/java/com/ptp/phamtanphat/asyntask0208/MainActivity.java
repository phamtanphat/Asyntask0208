package com.ptp.phamtanphat.asyntask0208;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtKetqua;
    Button btnxuly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKetqua = (TextView) findViewById(R.id.textviewketqua);
        btnxuly = (Button) findViewById(R.id.buttonxuly);

        btnxuly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new QuanLyTienTrinh().execute();
            }
        });
    }
    private class QuanLyTienTrinh extends AsyncTask<String,ArrayList<String>,String>{

        @Override
        protected void onPreExecute() {
            txtKetqua.setText("Bat dau thuc hien " + "\n");
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            for (int i = 0 ; i<5;i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ArrayList<String> mangten = new ArrayList<>();
                mangten.add("1");
                publishProgress(mangten);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(ArrayList<String>... values) {
            txtKetqua.append(values[0].get(0));
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            txtKetqua.append(s);
            super.onPostExecute(s);
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }
    }
}
