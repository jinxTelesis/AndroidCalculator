package com.example.dre.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText enterAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultText;
    private TextView textViewSeekbar;
    private float enteredBillFloat;

    private int seekbarPercentage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAmount = (EditText) findViewById(R.id.eTBillOutID);
        seekBar = (SeekBar) findViewById(R.id.percentageSeekBarID);
        calculateButton = (Button) findViewById(R.id.calculateBtnID);
        totalResultText = (TextView) findViewById(R.id.resultID);
        textViewSeekbar = (TextView) findViewById(R.id.textViewSeekbarID);

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewSeekbar.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarPercentage = seekBar.getProgress();
            }
        });
    }


    @Override
    public void onClick(View v) {
        calculate();

    }

    public void calculate(){
        float result = 0.0f;

        if(!enterAmount.getText().toString().equals(""))
        {
            enteredBillFloat = Float.parseFloat(enterAmount.getText().toString());
            result = enteredBillFloat * seekbarPercentage / 100;
            totalResultText.setText("your tip will be " + String.valueOf(result));
        }
        else
        {
            Toast.makeText(MainActivity.this, "Please enter a bill amount.", Toast.LENGTH_LONG).show();
        }


}

}
