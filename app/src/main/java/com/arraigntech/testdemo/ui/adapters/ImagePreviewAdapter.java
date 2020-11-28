package com.arraigntech.testdemo.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.arraigntech.testdemo.ui.data.ResultPojo;
import com.bumptech.glide.Glide;

import java.util.List;

public class ImagePreviewAdapter extends PagerAdapter {

    private Context mContext;
    private List<ResultPojo.Items> list;
    private int pos;
    public ImagePreviewAdapter(Context context, List<ResultPojo.Items> list,int pos) {
        this.mContext = context;
        this.list = list;
        this.pos = pos;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(mContext).load(list.get(position).volumeInfo.imageLinks.thumbnail).into(imageView);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
