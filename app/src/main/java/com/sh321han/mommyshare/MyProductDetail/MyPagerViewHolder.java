package com.sh321han.mommyshare.MyProductDetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.ProductDetailData;

/**
 * Created by Tacademy on 2016-05-24.
 */
public class MyPagerViewHolder extends RecyclerView.ViewHolder {

    private static final String MOMMYSHARE_SERVER = "http://52.79.57.157:3000";
    ImageView imageView;
    ProductDetailData data;

    public MyPagerViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.default_image);


    }

    public void setData() {


//        imageView.setImageDrawable(ContextCompat.getDrawable(MyApplication.getContext(),R.drawable.defalt_pic));

//        Glide.with(imageView.getContext()).load(MOMMYSHARE_SERVER + data.getPicture_path() + data.getPicture_name().get(0)).into(imageView);



    }
}
