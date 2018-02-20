package com.kaiueo.atss;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class SummaryResultActivity extends AppCompatActivity {


    public String summarization;
    public TextView summarizationTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        setContentView(R.layout.activity_summary_result);
        summarizationTextview = (TextView)findViewById(R.id.summarization_result_textview);
        Intent intent = getIntent();
        summarizationTextview.setText(intent.getStringExtra("summarization"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static void actionStart(Context context, String sum){
        Intent intent = new Intent(context, SummaryResultActivity.class);
        intent.putExtra("summarization", sum);
        context.startActivity(intent);
    }




}
