package com.toobi.toobi.ui.register.view;


import android.content.Intent;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;

import android.provider.MediaStore;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.netease.nim.uikit.NimUIKit;
import com.toobi.toobi.utils.UserManage;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.squareup.picasso.Picasso;
import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.homepage.view.HomePageActivity;
import com.toobi.toobi.ui.register.presenter.registerpreIMpl;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;
import com.toobi.toobi.utils.view.GlideRoundTransform;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.PicassoEngine;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccountActivity extends BaseActivity implements View.OnClickListener, registerIView {
    private static final int REQUEST_CODE_CHOOSE = 6;
    private static final int CODE_FOR_WRITE_PERMISSION =6 ;
    private ImageView finish;
    private ImageView img;
    private EditText name;
    private EditText age;
    private ImageView ok;
    private RadioButton nan;
    private RadioButton nv;
    public static final int IMAGE_REQUEST_CODE = 2;
    private static final int RESULT_REQUEST_CODE = 3;
    private byte[] cc;
    private registerpreIMpl registerpreIMpl;

    private String avatar;
    private String iphone;
    private String psw;
    public static final int TAKE_PHOTO = 1;
    public static final int SELECT_PHOTO = 2;


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void initoperate() {
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
        age.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
        finish.setOnClickListener(this);
        img.setOnClickListener(this);
        ok.setOnClickListener(this);
    }

    @Override
    protected void initData() {


        nan = findViewById(R.id.nan);
        nv = findViewById(R.id.nv);
        finish = findViewById(R.id.account_finish);
        img = findViewById(R.id.account_img);
        name = findViewById(R.id.account_name);
        age = findViewById(R.id.account_age);
        ok = findViewById(R.id.account_ok);
        registerpreIMpl = new registerpreIMpl(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_account;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.account_finish:
                finish();
                break;
            case R.id.account_img:
                        Matisse.from(AccountActivity.this)
                                .choose(MimeType.allOf()) // 选择 mime 的类型
                                .countable(true)
                                .maxSelectable(1) // 图片选择的最多数量
                                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                                .thumbnailScale(0.85f) // 缩略图的比例
                                .imageEngine(new PicassoEngine()) // 使用的图片加载引擎
                                .forResult(REQUEST_CODE_CHOOSE); // 设置作为标记的请求码
                break;
            case R.id.account_ok:
                HashMap<String, Object> map = new HashMap<>();
                iphone = getIntent().getStringExtra("iphone");
                psw = getIntent().getStringExtra("psw");
                map.put("phone", iphone);
                map.put("password", psw);
                int sexx = 0;
                if (nan.isChecked()) {
                    sexx = 1;
                } else if (nv.isChecked()) {
                    sexx = 2;
                }
                map.put("sex", sexx);
                String naa = name.getText().toString().trim();
                map.put("userName", naa);
                map.put("avatar", avatar);
                String ag = age.getText().toString().trim();
                map.put("age", ag);
                registerpreIMpl.getregisterPost(map);
                break;
        }
    }

    private List<Uri> list = new ArrayList<>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            list = Matisse.obtainResult(data);
            Uri uri = list.get(0);
            String path = getPath(uri);
            registerpreIMpl.getphotoPost(path);
        }
    }
    @SuppressWarnings("deprecation")
    private String getPath(Uri uri) {
        String[] projection = {MediaStore.Video.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    @Override
    public void Regissucceed(iphonenumber iphonenumber) {

    }

    @Override
    public void RegisTwosucceed(RegisTwo regisTwo) {

    }

    @Override
    public void backposswordsucceed(backpassword backpassword) {

    }

    @Override
    public void loginsucceed(LoginBean loginBean) {
        EventBus.getDefault().postSticky(loginBean);
        UserManage.getInstance().saveUserInfo(AccountActivity.this, iphone, loginBean.getData().getUserInfo().getUser_id(), psw, null, null);
        LoginInfo loginInfo = new LoginInfo(loginBean.getData().getUserInfo().getWangyi_account(), loginBean.getData().getUserInfo().getWangyi_token(), loginBean.getData().getUserInfo().getWangyi_appkey());
        NimUIKit.login(loginInfo, new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo loginInfo) {
                Log.d("MainActivity----------", "成功");
                //   Toast.makeText(RegisterActivity.this, "成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed(int i) {

            }

            @Override
            public void onException(Throwable throwable) {

            }
        });

        Intent intent = new Intent(AccountActivity.this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void photosucceed(photo photo) {
        Toast.makeText(this, photo.getMsg(), Toast.LENGTH_SHORT).show();
        Log.e("AccountActivity", photo.getMsg());
        Log.e("AccountActivity", photo.getData().getAvatar());
        avatar = photo.getData().getAvatar();
        Picasso.with(this).load(photo.getData().getAvatar()).resize(200,200).transform(new GlideRoundTransform()).placeholder(R.drawable.tb5).into(img);

    }

    @Override
    public void registersucceed(register register) {
        if (register.getError_code().equals("200")) {
            HashMap<String, String> map = new HashMap<>();
            map.put("phone", iphone);
            map.put("password", psw);
            registerpreIMpl.getLoginPost(map);
        }

    }

    @Override
    public void nothing(String nothing) {

    }
}
