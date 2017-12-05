package com.toobi.toobi.ui.personage.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;
import com.toobi.toobi.ui.register.view.XieYiActivity;
import com.zhy.autolayout.AutoRelativeLayout;

public class RegardActivity extends BaseActivity implements View.OnClickListener {
    private ImageView regard_finish;
    private TextView regard_cencal;
    private TextView regard_protocol;
    private TextView regard_feedback;
    private AutoRelativeLayout autoRelativeLayout;

    @Override
    protected void initoperate() {

    }

    @Override
    protected void initListener() {
        regard_finish.setOnClickListener(this);
        regard_cencal.setOnClickListener(this);
        regard_protocol.setOnClickListener(this);
        regard_feedback.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this,android.R.color.white));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        regard_finish = findViewById(R.id.regard_finish);
        regard_cencal = findViewById(R.id.regard_cencal);
        regard_protocol = findViewById(R.id.regard_protocol);
        regard_feedback = findViewById(R.id.regard_feedback);
        autoRelativeLayout = findViewById(R.id.auto_feed_ll);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regard;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.regard_finish:
                finish();
                break;
            case R.id.regard_cencal:

                View view1 = LayoutInflater.from(this).inflate(R.layout.pop_login, null);
                final PopupWindow popupWindow = new PopupWindow(view1, 300, 300);
                popupWindow.showAtLocation(autoRelativeLayout, Gravity.CENTER, 0, 0);
                CleanMessageUtil.clearAllCache(getApplicationContext());
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        popupWindow.dismiss();
                        Toast.makeText(RegardActivity.this, "清理成功", Toast.LENGTH_SHORT).show();

                    }
                }, 2000);

                break;
            case R.id.regard_protocol:
                Intent intent = new Intent(this, XieYiActivity.class);
                startActivity(intent);
                break;
            case R.id.regard_feedback:
                Intent intent1 = new Intent(this, FeedbackActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
