package com.font.autofont;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class Applist extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv=findViewById(R.id.tv);
        List<PackageInfo> packList = getPackageManager().getInstalledPackages(0);
        // String app[] = new String[packList.size()];
        for (int i=0; i < packList.size(); i++)
        {
            PackageInfo packInfo = packList.get(i);
            if (  (packInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0)
            {
                String appName = packInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                // Log.e("App № " + Integer.toString(i), appName);
                // app[i]=appName;
                tv.append(appName+"\n");
            }
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
