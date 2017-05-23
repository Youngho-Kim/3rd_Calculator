package com.veryworks.android.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.veryworks.android.calculator.util.Logger;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "Main";
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

        // 배열을 중간에 삭제하기 위해서 컬렉션을 사용한다.
        ArrayList<String> list = new ArrayList<>();
        for(String temp : splitted){
            list.add(temp);
        }

        // 반복문이 splitted 을 돌면서 * 와 / 만 먼저 연산해준다
        for(int i=0; i<list.size() ; i++){
            String temp = list.get(i);
            int resultTemp = 0;
            if(temp.equals("*") || temp.equals("/")){
                int before = Integer.parseInt(list.get(i-1));
                int after = Integer.parseInt(list.get(i+1));
                if(temp.equals("*"))
                    resultTemp = before * after;
                else
                    resultTemp = before / after;

                // 결과값 저장
                list.set(i, resultTemp+"");
                list.remove(i+1);
                list.remove(i-1);
                i--;
            }
        }

        // 반복문이 splitted 을 돌면서 남은 + 와 - 를 연산해준다
        for(int i=0; i<list.size() ; i++){
            String temp = list.get(i);
            int resultTemp = 0;
            if(temp.equals("+") || temp.equals("-")){
                int before = Integer.parseInt(list.get(i-1));
                int after = Integer.parseInt(list.get(i+1));
                if(temp.equals("+"))
                    resultTemp = before + after;
                else
                    resultTemp = before - after;
                // 결과값 저장
                list.set(i, resultTemp+"");
                // 필요없는 배열 뒤, 앞 두개 삭제
                list.remove(i+1);
                list.remove(i-1);
                i--;
            }
        }
        return list.get(0);
    }

    private void setPreview(int number){
        String current = txtPreview.getText().toString();
        Logger.i(TAG,"로그의내용="+number);
        Logger.d(TAG,"로그의내용="+number);
        Logger.w(TAG,"로그의내용="+number);
        Logger.e(TAG,"로그의내용="+number);

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
