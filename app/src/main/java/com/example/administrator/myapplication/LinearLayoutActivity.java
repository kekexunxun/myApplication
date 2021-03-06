package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class LinearLayoutActivity extends Activity {

    private RadioButton radioButton1;

    private RadioButton radioButton2;

    private RadioGroup radioGroup1;

    private RadioGroup radioGroup2;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout);

        Button button = (Button) findViewById(R.id.linear_btn);
        textView = (TextView) findViewById(R.id.linear_textview);
        radioGroup1 = (RadioGroup) findViewById(R.id.linear_radiogroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.linear_radiogroup2);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton1 = (RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId());
            }
        });
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton2 = (RadioButton) findViewById(radioGroup2.getCheckedRadioButtonId());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton1 == null || radioButton2 == null){
                    Toast.makeText(LinearLayoutActivity.this, "请选择出拳", Toast.LENGTH_SHORT).show();
                } else{
                    whichisbetter(radioButton1.getText().toString(), radioButton2.getText().toString());
                }
            }
        });

    }

    private void whichisbetter(String s, String s1) {
        switch (s) {
            case "剪刀":
                if (s1.equals("布")) {
                    textView.setText("关羽胜利");
                } else if (s1.equals(s)) {
                    textView.setText("平局");
                } else if (s1.equals("石头")) {
                    textView.setText("诸葛亮胜利");
                }
                break;
            case "石头":
                if (s1.equals("布")) {
                    textView.setText("诸葛亮胜利");
                } else if (s1.equals(s)) {
                    textView.setText("平局");
                } else if (s1.equals("剪刀")) {
                    textView.setText("关羽胜利");
                }
                break;
            case "布":
                if (s1.equals("剪刀")) {
                    textView.setText("诸葛亮胜利");
                } else if (s1.equals(s)) {
                    textView.setText("平局");
                } else if (s1.equals("石头")) {
                    textView.setText("关羽胜利");
                }
                break;
        }
    }
}
