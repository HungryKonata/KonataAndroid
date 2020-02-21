package com.example.konataandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWv = findViewById(R.id.wv_my_blog);
        //加载本地html文件
        // mWv.loadUrl("file:///android_asset/test.html");
        mWv.getSettings().setJavaScriptEnabled(true);
        //getSettings返回一个Websettings对象，因此可以有二重进入
        //上面这个配置一定需要，这样才能正确显示页面
        mWv.loadUrl("https://blog.csdn.net/qq_42138454");
        mWv.setWebViewClient(new MyWebViewClient());  //直接写new MyWebViewClient可以实现相同的功能，不用重写内部方法
        mWv.setWebChromeClient(new MyWebChromeClient());
    }

    class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("Webview", "onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //由JS代码转向native
//            mWv.loadUrl("javascript:alert('hello')");
            mWv.evaluateJavascript("javascript:alert('这里是JS的alert方法')", null);
        }
    }


    class MyWebChromeClient extends WebChromeClient
    {
        @Override
        public void onProgressChanged(WebView view, int newProgress)
        {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title)
        {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }


    //在Activity中重写onKeyDown
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWv.canGoBack())  //必须这么写，如果只写mWv.goBack()则仍然会直接退出WebView。看来onKeyDown的设计并不是点击返回后直接触发
        {
            mWv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
