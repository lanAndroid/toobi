package com.toobi.toobi.ui.personage.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.toobi.toobi.utils.UserManage;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.auth.AuthService;
import com.squareup.picasso.Picasso;
import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.personage.presenter.PersonPresenter;
import com.toobi.toobi.ui.register.presenter.registerpreIMpl;
import com.toobi.toobi.ui.register.view.LoginActivity;
import com.toobi.toobi.ui.register.view.registerIView;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.RegisTwo;
import com.toobi.toobi.utils.entry.backpassword;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.iphonenumber;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.entry.photo;
import com.toobi.toobi.utils.entry.register;
import com.toobi.toobi.utils.entry.suggest;
import com.toobi.toobi.utils.entry.userInfoUpdate;
import com.toobi.toobi.utils.view.GlideRoundTransform;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.PicassoEngine;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RedactActivity extends BaseActivity implements View.OnClickListener, PersonIView, registerIView {
    private static final int REQUEST_CODE_CHOOSE = 8;
    private static final int CODE_FOR_WRITE_PERMISSION = 0;
    private ImageView redact_finish;
    private ImageView img;
    private TextView ok;
    private EditText namee;
    private EditText agee;
    private AutoRelativeLayout redact_atr2;
    private EditText sexx;
    private PersonPresenter personPresenter;
    private AutoRelativeLayout auto_ll_ll;
    private EditText redact_sign;
    private String imgurl;
    private String sex;
    private String name;
    private AutoRelativeLayout redact_atr8;
    private String id;
    private TextView redact_phone;
    private String nameee;
    private String ageee;
    private String sexxx;
    private String sign;
    private String avatar;
    public static final int TAKE_PHOTO = 1;
    public static final int SELECT_PHOTO = 2;
    private PopupWindow popupWindow;
    private com.toobi.toobi.ui.register.presenter.registerpreIMpl registerpreIMpl;
    private String login;


    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initoperate() {

    }

    @Override
    protected void initListener() {
        redact_atr8.setOnClickListener(this);
        redact_finish.setOnClickListener(this);
        redact_atr2.setOnClickListener(this);
        ok.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this,android.R.color.white));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        auto_ll_ll = findViewById(R.id.auto_ll_ll);
        redact_atr2 = findViewById(R.id.redact_atr2);
        personPresenter = new PersonPresenter(this);
        registerpreIMpl = new registerpreIMpl(this);
        redact_atr8 = findViewById(R.id.redact_atr8);
        redact_phone = findViewById(R.id.redact_phone);
        redact_finish = findViewById(R.id.redact_finish);
        img = findViewById(R.id.redact_img);
        ok = findViewById(R.id.redact_ok);
        namee = findViewById(R.id.redact_name);
        redact_sign = findViewById(R.id.redact_sign);
        agee = findViewById(R.id.redact_age);
        sexx = findViewById(R.id.redact_sex);
        personPresenter = new PersonPresenter(this);
        login = getIntent().getStringExtra("login");
        name = getIntent().getStringExtra("name");
        sex = getIntent().getStringExtra("sex");
        imgurl = getIntent().getStringExtra("img");
        sign = getIntent().getStringExtra("sign");
        ageee = String.valueOf(getIntent().getIntExtra("age", 0));
        if (ageee.equals("0")) {
            agee.setText("25");
        } else {
            agee.setText(ageee);
        }

        namee.setText(name);
        redact_sign.setText(sign);
        if (sex.equals("1")) {
            sexx.setText("男");
        } else if (sex.equals("2")) {
            sexx.setText("女");
        }
        if (login.equals("1")) {
            redact_phone.setText("手机登录");
        } else if (login.equals("2")) {
            redact_phone.setText("微信登录");
        }

        Picasso.with(this).load(imgurl).resize(144,144).transform(new GlideRoundTransform()).placeholder(R.drawable.tb5).into(img);

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(LoginBean event) {
        id = event.getData().getUserInfo().getUser_id();
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_redact;
    }

    String see = null;

    @Override
    public void onClick(View view) {
        nameee = namee.getText().toString().trim();
        ageee = agee.getText().toString().trim();
        sexxx = sexx.getText().toString().trim();
        sign = redact_sign.getText().toString().trim();
        switch (view.getId()) {
            case R.id.redact_finish:
                finish();
                break;
            case R.id.redact_ok:
                Toast.makeText(this, "确定", Toast.LENGTH_SHORT).show();
                HashMap<String, String> map = new HashMap<>();
                if (sexxx.equals("男")) {
                    see = "1";
                } else if (sexxx.equals("女")) {
                    see = "2";
                }
                map.put("user_id", id);
                map.put("sex", see);
                map.put("user_name", nameee);
                map.put("age", ageee);
                map.put("sign", sign);
                map.put("avatar", imgurl);
                personPresenter.getuserInfoUpdatePOST(map);
                View v = LayoutInflater.from(this).inflate(R.layout.pop_login, null);
                popupWindow = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.showAtLocation(auto_ll_ll, Gravity.CENTER, 0, 0);
                break;
            case R.id.redact_atr2:
                Matisse.from(RedactActivity.this)
                        .choose(MimeType.allOf()) // 选择 mime 的类型
                        .countable(true)
                        .maxSelectable(1) // 图片选择的最多数量
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f) // 缩略图的比例
                        .imageEngine(new PicassoEngine()) // 使用的图片加载引擎
                        .forResult(REQUEST_CODE_CHOOSE); // 设置作为标记的请求码
                break;
            case R.id.redact_atr8:
                Intent intent = new Intent(RedactActivity.this, LoginActivity.class);
                startActivity(intent);
                UserManage.getInstance().disspass(this);
                EventBus.getDefault().removeAllStickyEvents();
                NIMClient.getService(AuthService.class).logout();
                ondiss();
                finish();
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
    public void Personsucceed(userInfoUpdate userInfoUpdate) {
        Toast.makeText(this, userInfoUpdate.getMsg(), Toast.LENGTH_SHORT).show();
        popupWindow.dismiss();
        Intent intent = new Intent();
        intent.putExtra("name", nameee);
        intent.putExtra("sex", see);
        intent.putExtra("img", imgurl);
        intent.putExtra("sign", sign);
        intent.putExtra("age", ageee);
        intent.setAction("TOOBI_ACC");
        sendBroadcast(intent);
        setResult(1, intent);
        finish();
    }

    @Override
    public void login(LoginBean loginBean) {

    }

    @Override
    public void suggest(suggest loginBean) {

    }

    @Override
    public void myroom(myRoom loginBean) {

    }

    @Override
    public void fan(fans loginBean) {

    }

    @Override
    public void nothing() {
        popupWindow.dismiss();
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

    }

    @Override
    public void photosucceed(photo photo) {
        imgurl = photo.getData().getAvatar();
        Picasso.with(this).load(imgurl).resize(144,144).transform(new GlideRoundTransform()).placeholder(R.drawable.tb5).into(img);

    }

    @Override
    public void registersucceed(register register) {

    }

    @Override
    public void nothing(String nothing) {

    }
}
