package com.example.gunjansrivastava.androidsession;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.sendMsg)
    Button sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sendMsg)
    public void sendMessage(){
        Intent sendMsgIntent = new Intent();
        sendMsgIntent.setAction(Intent.ACTION_SEND);
        sendMsgIntent.putExtra(Intent.EXTRA_TEXT, "Hi, Learning Android is just awesome.");
        sendMsgIntent.setType("text/plain");
        Intent chooser = Intent.createChooser(sendMsgIntent, "Choose App ");
        if (sendMsgIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}
