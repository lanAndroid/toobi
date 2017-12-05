package com.toobi.toobi.ui.register.view;

import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.register.presenter.registerpreIMpl;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;

import java.util.HashMap;

public class ForgetActivity extends BaseActivity implements View.OnClickListener, registerIView {
    private EditText phonenumber;
    private EditText possword;
    private EditText yanzhengma;
    private TextView send;
    private ImageView accomplish;
    private ImageView finish;
    private registerpreIMpl registerpreIMpl;
    private TimeCount timeCount;

    @Override
    protected void initoperate() {
        phonenumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
        possword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
    protected void initListener() {
        send.setOnClickListener(this);
        accomplish.setOnClickListener(this);
        finish.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        finish = findViewById(R.id.forget_finish);
        phonenumber = findViewById(R.id.forget_phone);
        possword = findViewById(R.id.forget_psw);
        yanzhengma = findViewById(R.id.forget_yzm);
        send = findViewById(R.id.forget_send);
        accomplish = findViewById(R.id.forget_ok);

        registerpreIMpl = new registerpreIMpl(this);
        timeCount = new TimeCount(60000, 1000);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_forget;
    }

    @Override
    public void onClick(View view) {
        String phone = phonenumber.getText().toString().trim();
        switch (view.getId()) {
            case R.id.forget_send:
                if (phone.isEmpty()) {
                    Toast.makeText(this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
                } else if (phone.length() != 11) {
                    Toast.makeText(this, "手机号码长度为11位", Toast.LENGTH_SHORT).show();
                } else if (!phone.isEmpty() && phone.length() == 11) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("phone", phone);
                    map.put("type", "2");
                    registerpreIMpl.getRegisterPost(map);
                    timeCount.start();
                }


                break;
            case R.id.forget_ok:
                String phone1 = phonenumber.getText().toString().trim();
                String yzm1 = yanzhengma.getText().toString().trim();
                String psw1 = possword.getText().toString().trim();
                Log.d("ForgetActivity", yzm1);
                Toast.makeText(this, yzm1, Toast.LENGTH_SHORT).show();
                HashMap<String, String> map2 = new HashMap<>();
                map2.put("phone", phone1);
                map2.put("code", yzm1);
                map2.put("newPassword", psw1);
                registerpreIMpl.getbackpostword(map2);
                break;
            case R.id.forget_finish:
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

    }

    @Override
    public void backposswordsucceed(backpassword backpassword) {
        Toast.makeText(this, "" + backpassword.getMsg(), Toast.LENGTH_SHORT).show();
        if (backpassword.getError_code().equals("200")) {
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
            finish();
        }
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
