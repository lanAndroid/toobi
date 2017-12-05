package com.toobi.toobi.ui.homepage.view;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hubert.library.Controller;
import com.app.hubert.library.NewbieGuide;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.msg.MsgService;
import com.toobi.toobi.MainActivity;
import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.base.BaseFragment;
import com.toobi.toobi.ui.conversation.view.ConverFragment;
import com.toobi.toobi.ui.homepage.persenter.HomePagerPersenter;
import com.toobi.toobi.ui.information.view.InformFragment;
import com.toobi.toobi.ui.personage.view.PersonFragment;
import com.toobi.toobi.utils.FragmentBuilder;
import com.toobi.toobi.utils.MyService;
import com.toobi.toobi.utils.OnProgressListener;
import com.toobi.toobi.utils.entry.LoginBean;
import com.toobi.toobi.utils.entry.chatNum;
import com.toobi.toobi.utils.entry.creatRoom;
import com.toobi.toobi.utils.entry.roomSearch;
import com.toobi.toobi.utils.view.BadgeView;
import com.toobi.toobi.utils.view.DrawableCenterRadioButton;
import com.toobi.toobi.utils.view.RedPointDrawable;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.zackratos.ultimatebar.UltimateBar;

import java.util.HashMap;

@SuppressWarnings("all")
public class HomePageActivity extends BaseActivity implements View.OnClickListener, HomePagerIView {
    private static final String TAG = "HomePageActivity";
    DrawableCenterRadioButton inform;
    DrawableCenterRadioButton establish;
    DrawableCenterRadioButton person;
    private AutoRelativeLayout rl;
    private int progress = 0;
    private static boolean isExit = false;
    MyService myService;
    private DrawableCenterRadioButton person_nv;
    private TextView ok;
    private TextView canclea;
    private ImageView search;
    private ImageView found;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    Handler handler;
    private HomePagerPersenter homePagerPersenter;
    private String id;
    private String wangyi_account;
    private TextView pop_title;
    private int num;
    private ImageView home_message;
    private EditText popedit;
    private String imgurl;
    private String sex;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            sex = intent.getStringExtra("sex");
            if (sex.equals("1")) {
                person.setVisibility(View.VISIBLE);
                person_nv.setVisibility(View.GONE);
            } else if (sex.equals("2")) {
                person.setVisibility(View.GONE);
                person_nv.setVisibility(View.VISIBLE);
            }

        }
    };

    public class MyTimeBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            num = intent.getIntExtra("num", 0);
            if (num == 0) {
                home_message.setVisibility(View.INVISIBLE);
            } else {
                home_message.setVisibility(View.VISIBLE);
            }
            Toast.makeText(context, "unreadNum:" + num, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onStart() {
        MyTimeBroadcast mTimeBroadcast = new MyTimeBroadcast();

        // 过滤出系统发送的时间改变的广播
        IntentFilter filter1 = new IntentFilter();
        filter1.addAction("TOOBI_Ation");
        // 注册广播
        registerReceiver(mTimeBroadcast, filter1);

        super.onStart();
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(HomePageActivity.this, MyService.class));//停止更新时间服务
        super.onDestroy();
        unregisterReceiver(receiver);
        EventBus.getDefault().unregister(this);
    }


    @Override
    protected void initoperate() {
    }

    @Override
    protected void initListener() {
        inform.setOnClickListener(this);
        person.setOnClickListener(this);
        search.setOnClickListener(this);
        found.setOnClickListener(this);
        establish.setOnClickListener(this);
        person_nv.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
        IntentFilter filter = new IntentFilter("TOOBI_ACC");
        registerReceiver(receiver, filter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, android.R.color.white));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        handler = new Handler();
        home_message = findViewById(R.id.home_message);
        person_nv = findViewById(R.id.person_nv);
        inform = findViewById(R.id.inform);
        establish = findViewById(R.id.establish);
        person = findViewById(R.id.person);
        search = findViewById(R.id.search);
        found = findViewById(R.id.found);
        rl = findViewById(R.id.auto_rl);
        if (sex.equals("1")) {
            person.setVisibility(View.VISIBLE);
            person_nv.setVisibility(View.GONE);
        } else if (sex.equals("2")) {
            person.setVisibility(View.GONE);
            person_nv.setVisibility(View.VISIBLE);
        }
        Controller controller = NewbieGuide.with(this).setEveryWhereCancelable(false)
                .setLabel("guide")
                .setLayoutRes(R.layout.pop_guide, R.id.pop_guile)
                .alwaysShow(false)
                .show();
        homePagerPersenter = new HomePagerPersenter(this);
        FragmentBuilder.getInstance().start(InformFragment.class, R.id.framelayout).builder();
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_home_page;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.inform:
                FragmentBuilder.getInstance().start(ConverFragment.class, R.id.framelayout).builder();
                break;
            case R.id.establish:
                FragmentBuilder.getInstance().start(InformFragment.class, R.id.framelayout).builder();
                break;
            case R.id.person:
                FragmentBuilder.getInstance().start(PersonFragment.class, R.id.framelayout).builder();
                break;
            case R.id.person_nv:
                FragmentBuilder.getInstance().start(PersonFragment.class, R.id.framelayout).builder();
                break;
            case R.id.found:
                View v_found = LayoutInflater.from(this).inflate(R.layout.pop_item2, null);
                final PopupWindow popupWindow = new PopupWindow(v_found, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                popedit = v_found.findViewById(R.id.pop_edt);
                pop_title = v_found.findViewById(R.id.pop_title);
                ok = v_found.findViewById(R.id.pop_ok);
                canclea = v_found.findViewById(R.id.pop_cancael);
                homePagerPersenter.Homechatnum();
                popupWindow.setFocusable(true);
                popupWindow.showAtLocation(rl, Gravity.CENTER, 0, 0);
                UltimateBar ultimateBar = new UltimateBar(this);
                ultimateBar.setColorBar(ContextCompat.getColor(this, R.color.touming));
                popedit.setHint("创建话题");
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            Window window = getWindow();
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                            window.setStatusBarColor(ContextCompat.getColor(HomePageActivity.this, android.R.color.white));
                            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                        }
                        HashMap<String, String> map = new HashMap<>();
                        map.put("user_id", id);
                        map.put("room_name", popedit.getText().toString().trim());
                        map.put("wangyi_account", wangyi_account);
                        homePagerPersenter.HomePagerPOST(map);
                        popupWindow.dismiss();
                    }
                });
                canclea.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            Window window = getWindow();
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                            window.setStatusBarColor(ContextCompat.getColor(HomePageActivity.this, android.R.color.white));
                            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                        }
                        popupWindow.dismiss();
                    }
                });
                break;
            case R.id.search:
                UltimateBar ultimateBar1 = new UltimateBar(this);
                ultimateBar1.setColorBar(ContextCompat.getColor(this, R.color.touming));
                View v_search = LayoutInflater.from(this).inflate(R.layout.pop_item, null);
                final PopupWindow pop = new PopupWindow(v_search, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                pop.setFocusable(true);
                pop.showAtLocation(rl, Gravity.CENTER, 0, 0);
                final EditText edit = v_search.findViewById(R.id.pop_edt);
                ok = v_search.findViewById(R.id.pop_ok);
                canclea = v_search.findViewById(R.id.pop_cancael);
                edit.setHint("想找的话题");
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            Window window = getWindow();
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                            window.setStatusBarColor(ContextCompat.getColor(HomePageActivity.this, android.R.color.white));
                            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                        }
                        homePagerPersenter.HomeRoomPOST("roomSearch/room_name/" + edit.getText().toString());
                        pop.dismiss();
                    }
                });
                canclea.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    Window window = getWindow();
                                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                                    window.setStatusBarColor(ContextCompat.getColor(HomePageActivity.this, android.R.color.white));
                                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                                }
                                pop.dismiss();
                            }
                        });
                break;

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true) //在ui线程执行
    public void onDataSynEvent(LoginBean event) {
        id = event.getData().getUserInfo().getUser_id();
        imgurl = event.getData().getUserInfo().getAvatar();
        wangyi_account = event.getData().getUserInfo().getWangyi_account();
        sex = event.getData().getUserInfo().getSex();
        Toast.makeText(this, event.getData().getUserInfo().getWangyi_account(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentManager.BackStackEntry entry = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1);
        String name = entry.getName();
        if ("InformFragment".equals(name) || "ConverFragment".equals(name) || "PersonFragment".equals(name)) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        } else {
            manager.popBackStackImmediate();
            String fragmentName = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1).getName();
            BaseFragment fragment = (BaseFragment) manager.findFragmentByTag(fragmentName);
            FragmentBuilder.getInstance().setLastFragment(fragment);
        }

    }

    //退出时的时间
    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(ContextCompat.getColor(HomePageActivity.this, android.R.color.white));
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }


    @Override
    public void Homepagersucceed(creatRoom creatRoom) {
        Log.e("HomePagerPersenter", creatRoom.getMsg());
        Intent intent = new Intent();
        intent.putExtra("name", popedit.getText().toString().trim());
        intent.putExtra("first", creatRoom.getData().getFirst_id());
        intent.putExtra("roomid", creatRoom.getData().getRoom_id());
        intent.putExtra("imgurl", imgurl);
        intent.setAction("TOOBI_CREATE");
        sendBroadcast(intent);
        FragmentBuilder.getInstance().start(InformFragment.class, R.id.framelayout).builder();
    }

    @Override
    public void HomeRoomsucceed(roomSearch roomSearch) {
        Toast.makeText(this, roomSearch.getMsg(), Toast.LENGTH_SHORT).show();
        EventBus.getDefault().post(roomSearch);
        FragmentBuilder.getInstance().start(InformFragment.class, R.id.framelayout).builder();
    }

    @Override
    public void Homechatsucceed(chatNum chatNum) {
        pop_title.setText("目前已有" + chatNum.getData().getNum() + "个话题");
    }

    @Override
    public void nothing(String nothing) {

    }

}
