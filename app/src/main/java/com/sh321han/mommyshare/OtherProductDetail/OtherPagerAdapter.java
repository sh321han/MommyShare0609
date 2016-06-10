package com.sh321han.mommyshare.OtherProductDetail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductDetailData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-24.
 */
public class OtherPagerAdapter extends PagerAdapter {

    private static final String MOMMYSHARE_SERVER = "http://52.79.57.157:3000";
    ProductDetailData data;
    List<String> mPicture_name;

    Context mContext;

    View mView;
    ImageView imgView;


    public void addData(ProductDetailData _data){
        data = _data;
        notifyDataSetChanged();
    }

    public OtherPagerAdapter(Context context) {
        mContext = context;
        mPicture_name=new ArrayList<>();
    }

    @Override
    public int getCount() {
        return 2;
//        return mPicture_name.size();
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        mView = LayoutInflater.from(mContext).inflate(R.layout.viewpager_childview, null);
        imgView = (ImageView)mView.findViewById(R.id.pager_image);

        imgView.setScaleType(ImageView.ScaleType.FIT_XY);
        Log.d("lllllllooo", position+"");
        Glide.with(mContext).load(MOMMYSHARE_SERVER + data.getPicture_path() + data.getPicture_name().get(position)).into(imgView);

        ((ViewPager)container).addView(mView,0);

//        View view = null;
      /*  ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(imageView.getContext()).load(MOMMYSHARE_SERVER + data.getPicture_path() + data.getPicture_name().get(position)).into(imageView);*/
//        Glide.with(thumbView.getContext()).load(MOMMYSHARE_SERVER + product.getPicture_path() + product.getPicture_name().get(0)).into(thumbView);

        return mView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }




}
