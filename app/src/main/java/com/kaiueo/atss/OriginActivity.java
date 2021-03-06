package com.kaiueo.atss;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;


public class OriginActivity extends AppCompatActivity {

    public String originArticle;

    private TextView originTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origin);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        originArticle = intent.getStringExtra("origin");
        originTextView = (TextView) findViewById(R.id.origin_textView);
        originTextView.setMovementMethod(new LinkMovementMethod());
        originTextView.setText(originArticle);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static void actionStart(Context context, String origin){
        Intent intent = new Intent(context, OriginActivity.class);
        intent.putExtra("origin", origin);
        context.startActivity(intent);
    }
}
