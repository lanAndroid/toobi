package com.toobi.toobi.ui.personage.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.netease.nim.uikit.session.constant.RequestCode;
import com.squareup.picasso.Picasso;
import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseFragment;
import com.toobi.toobi.ui.personage.presenter.PersonPresenter;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.fans;
import com.toobi.toobi.utils.entry.myRoom;
import com.toobi.toobi.utils.entry.personage;
import com.toobi.toobi.utils.entry.suggest;
import com.toobi.toobi.utils.entry.userInfoUpdate;
import com.toobi.toobi.utils.view.GlideRoundTransform;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import javax.microedition.khronos.opengles.GL;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Rampant on 2017/11/3.
 */

public class PersonFragment extends BaseFragment implements View.OnClickListener, PersonIView {
    private TextView regard;
    private AutoRelativeLayout person_ll;
    private ImageView head_img;
    private AutoRelativeLayout per_all;
    private TextView head_name;
    private ImageView head_sex;
    private String name;
    private String sex;
    private String imgurl;
    private TextView head_title;
    private String sign;
    private String psw;
    private PersonPresenter personPresenter;
    private TextView person_fans;
    private PopupWindow popupWindow;
    private TextView huati;
    private int age;
    private String login;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initPrepare() {

    }

    @Override
    protected void onInvisible() {

    }

    @Override
    protected void initData() {
        head_name.setText(name);
        //   Log.d("PersonFragment----sex", sex);
        if (sex != null) {
            if (sex.equals("1")) {
                Glide.with(getActivity()).load(R.drawable.tb24).into(head_sex);
            } else if (sex.equals("2")) {
                Glide.with(getActivity()).load(R.drawable.tb25).into(head_sex);
            }
        }
        Picasso.with(getActivity())
                .load(imgurl).transform(new GlideRoundTransform())
                .resize(200,200)
                .placeholder(R.drawable.tb5)
                .into(head_img);
        head_title.setText(sign);
        person_fans.setOnClickListener(this);
        huati.setOnClickListener(this);
        regard.setOnClickListener(this);
        person_ll.setOnClickListener(this);
        head_img.setOnClickListener(this);
    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, null);
        regard = view.findViewById(R.id.regard);
        person_ll = view.findViewById(R.id.person_ll);
        huati = view.findViewById(R.id.huati);
        head_img = view.findViewById(R.id.head_img);
        per_all = view.findViewById(R.id.per_all);
        head_name = view.findViewById(R.id.head_name);
        head_sex = view.findViewById(R.id.head_sex);
        head_title = view.findViewById(R.id.head_title);
        person_fans = view.findViewById(R.id.person_fans);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.regard:
                Intent intent = new Intent(getActivity(), RegardActivity.class);
                startActivity(intent);
                break;
            case R.id.person_ll:
                Intent redact = new Intent(getActivity(), RedactActivity.class);
                redact.putExtra("img", imgurl);
                redact.putExtra("name", name);
                redact.putExtra("sex", sex);
                redact.putExtra("sign", sign);
                redact.putExtra("age", age);
                redact.putExtra("login", login);
                startActivityForResult(redact, 0);
                break;
            case R.id.person_fans:
                Intent to = new Intent(getActivity(), FansActivity.class);
                startActivity(to);
                break;
            case R.id.head_img:
                View view2 = View.inflate(getActivity(), R.layout.pop_img, null);
                popupWindow = new PopupWindow(view2, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                ImageView imageView = view2.findViewById(R.id.img_da);
                AutoRelativeLayout img_Auto_ll = view2.findViewById(R.id.img_Auto_ll);
                Picasso.with(getActivity()).load(imgurl).into(imageView);

                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(false);
                popupWindow.showAtLocation(per_all, Gravity.CENTER, 0, 0);
                img_Auto_ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.setTouchInterceptor(new View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                            popupWindow.dismiss();
                            return true;
                        }
                        return false;
                    }
                });

                break;
            case R.id.huati:
                Intent intent1 = new Intent(getActivity(), TopicActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == 1) {
            imgurl = data.getStringExtra("img");
            sex = data.getStringExtra("sex");
            name = data.getStringExtra("name");
            sign = data.getStringExtra("sign");
            age = Integer.parseInt(data.getStringExtra("age"));
            Picasso.with(getActivity()).load(data.getStringExtra("img")).transform(new GlideRoundTransform()).placeholder(R.drawable.tb5).into(head_img);
            String na = data.getStringExtra("name");
            String se = data.getStringExtra("sex");

            head_name.setText(na);
            head_title.setText(data.getStringExtra("sign"));
            //   Log.d("PersonFragment----sex", sex);
            if (se.equals("1")) {
                Picasso.with(getActivity()).load(R.drawable.tb24).into(head_sex);
            } else if (se.equals("2")) {
                Picasso.with(getActivity()).load(R.drawable.tb25).into(head_sex);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(LoginBean event) {
        name = event.getData().getUserInfo().getName();
        sex = event.getData().getUserInfo().getSex();
        imgurl = event.getData().getUserInfo().getAvatar();
        sign = event.getData().getUserInfo().getSign();
        age = event.getData().getUserInfo().getAge();
        login = event.getData().getUserInfo().getLogin_type();
        Toast.makeText(getActivity(), event.getData().getUserInfo().getUser_id(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void Personsucceed(userInfoUpdate userInfoUpdate) {

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

    }
}
