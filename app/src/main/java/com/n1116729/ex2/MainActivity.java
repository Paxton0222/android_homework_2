package com.n1116729.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txv;
    Button btn;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);

        BtnOnclick btnOnClick = new BtnOnclick();
        BtnOnLongClick btnOnLongClick = new BtnOnLongClick();
        TxvOnclick txvOnclick = new TxvOnclick();
        TxvOnLongClick txvOnLongClick = new TxvOnLongClick();

        btn.setOnClickListener(btnOnClick);
        btn.setOnLongClickListener(btnOnLongClick);
        txv.setOnClickListener(txvOnclick);
        txv.setOnLongClickListener(txvOnLongClick);
    }

    class BtnOnclick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            txv.setText(String.valueOf(++counter));
        }
    }

    class TxvOnclick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            txv.setText(String.valueOf(--counter));
        }
    }

    class BtnOnLongClick implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View view) {
            counter += 2;
            txv.setText(String.valueOf(counter));
            return true;
        }
    }

    class TxvOnLongClick implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View view) {
            counter = 0;
            txv.setText("0");
            return true;
        }
    }
}