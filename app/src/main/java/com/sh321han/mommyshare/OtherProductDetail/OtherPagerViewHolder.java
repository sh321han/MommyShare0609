package com.sh321han.mommyshare.OtherProductDetail;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductDetailData;


/**
 * Created by Administrator on 2016-05-24.
 */
public class OtherPagerViewHolder extends RecyclerView.ViewHolder {

    private static final String MOMMYSHARE_SERVER = "http://52.79.57.157:3000";
    OtherPagerAdapter mAdapter;
    ViewPager pager;
//    String data;
    ProductDetailData data;


    public OtherPagerViewHolder(View itemView) {
        super(itemView);

        pager = (ViewPager)itemView.findViewById(R.id.pager);

        mAdapter = new OtherPagerAdapter(itemView.getContext());
        pager.setAdapter(mAdapter);
//        pager.setAdapter(mAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

//    public void setData(ProductDetailData data) {
//        this.data = data;
//
//        pager.setAdapter(mAdapter);
//    }

    public void setData(ProductDetailData item) {
   //     Glide.with(imageView.getContext()).load(MOMMYSHARE_SERVER + data.getPicture_path() + data.getPicture_name().get(position)).into(imageView);

        mAdapter.addData(item);
        mAdapter.notifyDataSetChanged();
/*
        pager.setAdapter(mAdapter);
*/
    }

}
