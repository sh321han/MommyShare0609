package com.sh321han.mommyshare.Main;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.sh321han.mommyshare.Manager.NetworkManager;
import com.sh321han.mommyshare.OtherProductDetail.OtherProductDetailActivity;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.KeepData;
import com.sh321han.mommyshare.data.MainProduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    RecyclerView listView;
    MainProductAdapter mAdapter;

    List<String> categoryList = new ArrayList<String>();
    ArrayAdapter<String> adapter, adapter3;

    Spinner spinner1, spinner2, spinner3;
    String category;

    String member_id = "123123";


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setCategoryList();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        listView = (RecyclerView) view.findViewById(R.id.main_rv_list);


        mAdapter = new MainProductAdapter();
        listView.setAdapter(mAdapter);


        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);


        listView.setLayoutManager(manager);

        mAdapter.setOnHeartClickListener(new MainProductViewHolder.OnHeartClickListener() {
            @Override
            public void onHeartClick(View view, final MainProduct product) {
                Toast.makeText(getContext(), "찜", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(getContext(), MyWishListActivity.class);
//                intent.putExtra("id", product.get_id());
//                startActivity(intent);


                NetworkManager.getInstance().Keep(product.get_id(), member_id, new NetworkManager.OnResultListener<KeepData>() {
                    @Override
                    public void onSuccess(Request request, KeepData result) {
                        if (result.success.equals("true")) {
                            Log.d("성공", product.get_id());


                        } else {

                        }
                    }

                    @Override
                    public void onFail(Request request, IOException exception) {

                    }
                });
            }
        });


        mAdapter.setOnItemClickListener(new MainProductViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, MainProduct product) {
                Intent intent = new Intent(getContext(), OtherProductDetailActivity.class);
                intent.putExtra("id", product.get_id());
                startActivity(intent);
            }
        });
//        setData();

        category = (String) spinner1.getSelectedItem();

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (categoryList != null) {
//                    Toast.makeText(getActivity(), categoryList.get(position), Toast.LENGTH_LONG).show();
                    //수정
                    if (categoryList.size() != 0) category = categoryList.get(position);
                    setData(category);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String priceKey = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.dropdown_item);

        adapter3 = new ArrayAdapter<String>(getContext(), R.layout.spinner_item);
        adapter3.setDropDownViewResource(R.layout.dropdown_item);

        spinner3.setAdapter(adapter3);

        spinner2.setAdapter(adapter);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String distanceKey = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       initData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setData(category);
    }

    private void setData(String category) {

        NetworkManager.getInstance().MainProductList(category, new NetworkManager.OnResultListener<List<MainProduct>>() {
            @Override
            public void onSuccess(Request request, List<MainProduct> result) {
                mAdapter.clear();
                mAdapter.addAll(result);

            }

            @Override
            public void onFail(Request request, IOException exception) {


            }
        });


    }

    private void setCategoryList() {
        NetworkManager.getInstance().getCategoryList(this, new NetworkManager.OnResultListener<List<String>>() {
            @Override
            public void onSuccess(Request request, List<String> result) {
                categoryList.add("전체");
                categoryList.addAll(result);
                categoryList.size();

                //categoryList = result;

                adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, categoryList);
                adapter.setDropDownViewResource(R.layout.dropdown_item);

                spinner1.setAdapter(adapter);
            }

            @Override
            public void onFail(Request request, IOException exception) {

            }
        });
    }

    private void initData() {
        String[] arrays = getResources().getStringArray(R.array.price_item);
        for (String s : arrays) {
            adapter.add(s);
        }

        String[] arrays3 = getResources().getStringArray(R.array.dist_item);
        for (String d : arrays3) {
            adapter3.add(d);
        }


    }



}
