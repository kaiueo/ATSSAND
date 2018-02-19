package com.kaiueo.atss;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ViewPager mViewPager;

    private MenuItem menuItem;

    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_summary:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_upload:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_self:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(mViewPager);
        //NetworkHelper.getSummaryFromUrl("https://www.ithome.com/html/discovery/346511.htm", 3);
        //NetworkHelper.getSummaryFromText("之前在音乐版权问题上掐了好几轮的腾讯和网易，最近终于有了握手言和的苗头。\\n今天下午，在国家版权局的协调下，腾讯音乐与网易云音乐已经就网络音乐版权合作达成了一致，今后双方将相互授权音乐作品，授权范围将达到各自独家音乐作品数量的99%以上。此外，双方还商定要进行音乐版权的长期合作，同时积极向其他网络音乐平台开放音乐作品授权。\\n腾讯音乐和网易云音乐终于“和好”，变灰的歌曲应该快回来了\\n国家版权局还指出，接下来，将继续推动网络音乐各方遵循版权法律法规、市场规则和国际惯例，通过优质服务、公平竞争、差异化发展，建立完善规范有序、持续发展的网络音乐授权和运营模式，促进网络音乐产业的繁荣健康发展。\\n在此之前，腾讯音乐和网易云音乐曾经因为音乐版权问题有过好几轮的争夺，而坐拥版权优势的腾讯，总是站在上风。\\n早在2014年底，双方就曾因为互相指责音乐内容侵权而对簿公堂：QQ音乐先告网易云音乐对包括《时间都去哪儿了》等在内的623首网络音乐侵权，网易云音乐随后反诉QQ音乐侵权使用自己旗下的192首网络音乐。", 3);
        //NetworkHelper.uploadSummary("MjM=\\n", "之前在音乐版权问题上掐了好几轮的腾讯和网易，最近终于有了握手言和的苗头。\\n今天下午，在国家版权局的协调下，腾讯音乐与网易云音乐已经就网络音乐版权合作达成了一致，今后双方将相互授权音乐作品，授权范围将达到各自独家音乐作品数量的99%以上。此外，双方还商定要进行音乐版权的长期合作，同时积极向其他网络音乐平台开放音乐作品授权。\\n腾讯音乐和网易云音乐终于“和好”，变灰的歌曲应该快回来了\\n国家版权局还指出，接下来，将继续推动网络音乐各方遵循版权法律法规、市场规则和国际惯例，通过优质服务、公平竞争、差异化发展，建立完善规范有序、持续发展的网络音乐授权和运营模式，促进网络音乐产业的繁荣健康发展。\\n在此之前，腾讯音乐和网易云音乐曾经因为音乐版权问题有过好几轮的争夺，而坐拥版权优势的腾讯，总是站在上风。\\n早在2014年底，双方就曾因为互相指责音乐内容侵权而对簿公堂：QQ音乐先告网易云音乐对包括《时间都去哪儿了》等在内的623首网络音乐侵权，网易云音乐随后反诉QQ音乐侵权使用自己旗下的192首网络音乐。\n\n", "12345");
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adapter.addFragment(SelfFragment.newInstance("aaa", "bbb"));
        adapter.addFragment(SummaryFragment.newInstance("vvv", "ssd"));
        adapter.addFragment(UploadFragment.newInstance("aaa", "bbb"));
        adapter.addFragment(SelfFragment.newInstance("sfs", "sdsf"));
        viewPager.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
