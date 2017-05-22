package com.veryworks.android.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtPreview,txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i < 10 ; i ++) {
            // 문자열로 id 가져오기
            int id = getResources().getIdentifier("btn" + i, "id", getPackageName());
            findViewById(id).setOnClickListener(this);
        }
//        findViewById(R.id.btn1).setOnClickListener(this);
//        findViewById(R.id.btn2).setOnClickListener(this);
//        findViewById(R.id.btn3).setOnClickListener(this);
//        findViewById(R.id.btn4).setOnClickListener(this);
//        findViewById(R.id.btn5).setOnClickListener(this);
//        findViewById(R.id.btn6).setOnClickListener(this);
//        findViewById(R.id.btn7).setOnClickListener(this);
//        findViewById(R.id.btn8).setOnClickListener(this);
//        findViewById(R.id.btn9).setOnClickListener(this);
//        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnDivide).setOnClickListener(this);
        findViewById(R.id.btnResult).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);

        txtPreview = (TextView) findViewById(R.id.txtPreview);
        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1: setPreview(1); break;
            case R.id.btn2: setPreview(2); break;
            case R.id.btn3: setPreview(3); break;
            case R.id.btn4: setPreview(4); break;
            case R.id.btn5: setPreview(5); break;
            case R.id.btn6: setPreview(6); break;
            case R.id.btn7: setPreview(7); break;
            case R.id.btn8: setPreview(8); break;
            case R.id.btn9: setPreview(9); break;
            case R.id.btn0: setPreview(0); break;
            case R.id.btnPlus: setPreview("+"); break;
            case R.id.btnMinus: setPreview("-"); break;
            case R.id.btnMultiply: setPreview("*"); break;
            case R.id.btnDivide: setPreview("/"); break;
            case R.id.btnResult: result(); break;
            case R.id.btnClear: clear(); break;
        }
    }

    private void result(){
        String current = txtPreview.getText().toString();
        txtResult.setText(calculate(current));
    }
    private String calculate(String preview){
        String result = "";

        // TODO 문자열을 쪼갠후 우선순위에 따라 연산하시오
        // 1. 문자열을 정규식으로 * / + - 을 이용해서 배열로 자른다
        String splitted[] = preview.split("(?<=[*/+-])|(?=[*/+-])");
        //    예)  123 * 45 + 67 / 89
        // 결과값 : splitted[0] = 123
        //         splitted[1] = *
        //         splitted[2] = 45
        //         splitted[3] = +
        //         splitted[4] = 67
        //         splitted[5] = /
        //         splitted[6] = 89

        return result;
    }

    private void setPreview(int number){
        String current = txtPreview.getText().toString();
        txtPreview.setText(current + number);
    }

    private void setPreview(String str){
        String current = txtPreview.getText().toString();
        txtPreview.setText(current + str);
    }

    private void clear(){
        txtPreview.setText("0");
        txtResult.setText("0");
    }
}
