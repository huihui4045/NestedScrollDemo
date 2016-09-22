package demo.letv.com.nestedscrolldemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    //private ViewPager mPager;
    private WrapContentHeightViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // 设置返回主页的按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        /*LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) ll.getLayoutParams();
        params.width = dm.widthPixels;
        params.height = (int) (dm.heightPixels * 0.8);
        ll.setLayoutParams(params);*/

        // ViewPager
        //mPager = (ViewPager) findViewById(R.id.viewPager);
        mPager = (WrapContentHeightViewPager) findViewById(R.id.viewPager);
        ResumeAdapter mPagerAdapter = new ResumeAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        tabLayout.setupWithViewPager(mPager);
        // ViewPager切换时NestedScrollView滑动到顶部
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((NestedScrollView) findViewById(R.id.nestedScrollView)).scrollTo(0, 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
