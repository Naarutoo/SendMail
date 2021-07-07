package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mBtnSnd;
    private EditText mEtTo;
    private EditText mEtCC;
    private EditText mEtMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        mBtnSnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{mEtTo.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT,mEtCC.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,mEtMsg.getText().toString());
                PackageManager pm = getPackageManager();
                List<ResolveInfo> list = pm.queryIntentActivities(intent,0);
                startActivity(intent);
            }
        });
    }

    private void initview() {
        mBtnSnd=findViewById(R.id.btnSend);
        mEtTo=findViewById(R.id.etTo);
        mEtCC=findViewById(R.id.etcc);
        mEtMsg=findViewById(R.id.etmsg);
    }
}