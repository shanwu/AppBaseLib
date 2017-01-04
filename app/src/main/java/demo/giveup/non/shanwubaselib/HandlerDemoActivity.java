package demo.giveup.non.shanwubaselib;

import android.app.Activity;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import giveup.none.shanwubaselib.BaseHandler;

public class HandlerDemoActivity extends Activity implements BaseHandler.Callback, View.OnClickListener{
    private BaseHandler mHandler;
    private final static int MSG_TEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_handler_demo);
        mHandler = new BaseHandler(this);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        final int what = msg.what;
        if(what == MSG_TEST) {
            Toast.makeText(this, "TEST", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        mHandler.sendEmptyMessage(MSG_TEST);
    }
}
