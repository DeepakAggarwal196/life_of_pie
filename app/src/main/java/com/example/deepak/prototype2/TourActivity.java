package com.example.deepak.prototype2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TourActivity extends Activity {

    private  static String MyPREFS_NAME = "MyPREFS_NAME";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedBundleInstance){
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.activity_tour);
        sharedPreferences = getSharedPreferences(MyPREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("isFirstTimeUsed", "false");
        editor.commit();

        ViewPager mViewPager = (ViewPager) findViewById(R.id.tour_pager);

// This is just an example. You can use whatever collection of images.
        int[] mResources = {
                R.drawable.first_screen4,
                R.drawable.first_screen1,
                R.drawable.first_screen2,
                R.drawable.first_screen3,
                R.drawable.first_screen5
        };

        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this, mResources);

        mViewPager.setAdapter(mCustomPagerAdapter);
        TextView btn = (TextView) findViewById(R.id.skip);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TourActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    public class CustomPagerAdapter extends PagerAdapter {

        private Context mContext;
        private LayoutInflater mLayoutInflater;
        private int[] mResources;

        public CustomPagerAdapter(Context context, int[] resources) {
            mContext = context;
            mResources = resources;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ConstraintLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.tour_tab_content, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.tour_image_view);
            imageView.setImageResource(mResources[position]);


            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ConstraintLayout) object);
        }

    }

}
