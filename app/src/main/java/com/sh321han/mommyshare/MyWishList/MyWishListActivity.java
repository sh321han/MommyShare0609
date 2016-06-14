package com.sh321han.mommyshare.MyWishList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.sh321han.mommyshare.Main.MainProductAdapter;
import com.sh321han.mommyshare.OtherProductDetail.OtherProductDetailActivity;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.WishProduct;

public class MyWishListActivity extends AppCompatActivity {

    RecyclerView listView;
    MyWishListAdapter mAdapter;
    MainProductAdapter moAdapter;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wish_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (RecyclerView)findViewById(R.id.wish_rv_list);
        mAdapter = new MyWishListAdapter();
        listView.setAdapter(mAdapter);

        listView.setLayoutManager(new GridLayoutManager(this, 2));

        mAdapter.setOnItemClickListener(new MyWishListViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, WishProduct wishproduct) {
                Intent i = new Intent(MyWishListActivity.this, OtherProductDetailActivity.class);
                startActivity(i);
            }
        });

//        Intent intent = getIntent();
//        id = intent.getStringExtra("id");
//        setData(id);
    }

//    private void setData(String id) {
//
//        NetworkManager.getInstance().MainProductList(id, new NetworkManager.OnResultListener<MainProduct>() {
//            @Override
//            public void onSuccess(Request request, ProductDetailData result) {
////                mAdapter.clear();
//                moAdapter.add(result);
//
//
//            }
//
//            @Override
//            public void onFail(Request request, IOException exception) {
//
//            }
//        });
//
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
