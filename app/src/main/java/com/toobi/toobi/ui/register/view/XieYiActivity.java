package com.toobi.toobi.ui.register.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseActivity;


public class XieYiActivity extends BaseActivity implements View.OnClickListener {
    private ImageView finish;
    private WebView webView;


    @Override
    protected void initoperate() {

    }

    @Override
    protected void initListener() {
        finish.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        webView = findViewById(R.id.webview);
        finish = findViewById(R.id.finish);
        webView.loadUrl("https://www.mini798.com/protocol");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_xie_yi;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.finish:
                finish();
                break;
        }
    }
}
