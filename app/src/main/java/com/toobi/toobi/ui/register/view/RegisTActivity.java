package com.toobi.toobi.ui.register.view;

import android.content.Intent;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.register.presenter.registerpreIMpl;
import com.toobi.toobi.ui.register.view.AccountActivity;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;

import org.w3c.dom.Text;

import java.util.HashMap;

public class RegisTActivity extends BaseActivity implements View.OnClickListener, registerIView {
    private EditText phone;
    private TextView send;
    private registerpreIMpl registerpreIMpl;
    private EditText possw;
    private ImageView accomplish;
    private EditText yzm;
    private ImageView finish;
    private TimeCount timeCount;
    private String number1;
    private String psw1;

    @Override
    protected void initoperate() {

    }

    @Override
    protected void initListener() {
        send.setOnClickListener(this);
        accomplish.setOnClickListener(this);
        finish.setOnClickListener(this);
        phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                EditText _v = (EditText) v;
                if (!hasFocus) {// 失去焦点
                    _v.setHint(_v.getTag().toString());
                } else {
                    String hint = _v.getHint().toString();
                    _v.setTag(hint);
                    _v.setHint("");
                }
            }
        });
        possw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                EditText _v = (EditText) v;
                if (!hasFocus) {// 失去焦点
                    _v.setHint(_v.getTag().toString());
                } else {
                    String hint = _v.getHint().toString();
                    _v.setTag(hint);
                    _v.setHint("");
                }
            }
        });

    }

    @Override
    protected void initData() {
        finish = findViewById(R.id.regt_finish);
        phone = findViewById(R.id.regt_phone);
        send = findViewById(R.id.regt_send);
        possw = findViewById(R.id.regt_psw);
        yzm = findViewById(R.id.regt_yzm);
        accomplish = findViewById(R.id.regt_below);
        timeCount = new TimeCount(60000, 1000);
        registerpreIMpl = new registerpreIMpl(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regis_t;
    }


    @Override
    public void onClick(View view) {
        String number = phone.getText().toString().trim();
        switch (view.getId()) {
            case R.id.regt_send:
                if (number.isEmpty()) {
                    Toast.makeText(this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
                } else if (number.length() != 11) {
                    Toast.makeText(this, "手机号码长度为11位", Toast.LENGTH_SHORT).show();
                } else if (!number.isEmpty() && number.length() == 11) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("phone", number);
                    map.put("type", "1");
                    timeCount.start();
                    registerpreIMpl.getRegisterPost(map);
                }
                break;
            case R.id.regt_below:
                number1 = phone.getText().toString().trim();
                String yanzm1 = yzm.getText().toString().trim();
                psw1 = possw.getText().toString().trim();
                HashMap<String, String> map2 = new HashMap<>();
                map2.put("phone", number1);
                map2.put("code", yanzm1);
                map2.put("password", psw1);
                registerpreIMpl.getRegTwoPost(map2);
                break;
            case R.id.regt_finish:
                finish();
                break;
        }
    }


    @Override
    public void Regissucceed(iphonenumber iphonenumber) {
        Toast.makeText(this, iphonenumber.getMsg(), Toast.LENGTH_LONG).show();
        Log.e("-------->", iphonenumber.getMsg());
    }

    @Override
    public void RegisTwosucceed(RegisTwo regisTwo) {
        Toast.makeText(this, regisTwo.getMsg(), Toast.LENGTH_LONG).show();
        if (regisTwo.getError_code().equals("200")) {
            Intent intent = new Intent(this, AccountActivity.class);
            intent.putExtra("iphone", number1);
            intent.putExtra("psw", psw1);
            startActivity(intent);
        }
        Log.e("-------->", regisTwo.getError_code());
    }

    @Override
    public void backposswordsucceed(backpassword backpassword) {

    }

    @Override
    public void loginsucceed(LoginBean loginBean) {

    }

    @Override
    public void photosucceed(photo photo) {

    }

    @Override
    public void registersucceed(register register) {

    }

    @Override
    public void nothing(String nothing) {
        Toast.makeText(this, nothing, Toast.LENGTH_SHORT).show();
    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//总时长，单时间间隔
        }

        @Override
        public void onTick(long l) {//计时过程显示
            if (send != null) {
                send.setClickable(false);
                send.setText(l / 1000 + "秒后" + "重新获取验证码");
            }
        }

        @Override
        public void onFinish() {//计时完毕显示
            send.setClickable(true);
            send.setText("获取验证码");
        }

    }
}
