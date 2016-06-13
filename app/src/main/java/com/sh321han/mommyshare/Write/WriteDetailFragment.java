package com.sh321han.mommyshare.Write;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh321han.mommyshare.Manager.NetworkManager;
import com.sh321han.mommyshare.MyProductDetail.MyProductDetailActivity;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.WriteData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * A simple {@link Fragment} subclass.
 */
public class WriteDetailFragment extends Fragment {

    private static final int RC_GALLERY1 = 1;
    private static final int RC_CAMERA1 = 2;
    private static final int RC_GALLERY2 = 3;
    private static final int RC_CAMERA2 = 4;
    private static final int RC_GALLERY3 = 5;
    private static final int RC_CAMERA3 = 6;
    ImageView imgview1, imgview2, imgview3;
    ImageButton btn_camera, btn_gallery;
    Intent intent1, intent2, intent3;
    int a[] = {0, 0, 0};

    EditText editText;
    String content;


    private void getImageFromCamera(Intent intent, int a) {
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, getCameraCaptureFile());
        startActivityForResult(intent, a);
    }

    File mCameraCaptureFile;

    private Uri getCameraCaptureFile() {
        File dir = getContext().getExternalFilesDir("myphoto");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        mCameraCaptureFile = new File(dir, "mommyshare_" + System.currentTimeMillis() + ".jpg");
        return Uri.fromFile(mCameraCaptureFile);
    }

    private void getImageFromGallery(Intent intent, int a) {
        intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/jpeg");
        startActivityForResult(intent, a);
    }

    List<File> mUploadFile = new ArrayList<>();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mUploadFile != null) {
//            outState.putString("uploadfile", mUploadFile.getAbsolutePath());
        }
        if (mCameraCaptureFile != null) {
            outState.putString("cameraFile", mCameraCaptureFile.getAbsolutePath());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_GALLERY1) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                String[] projection = {MediaStore.Images.Media.DATA};
                Cursor c = getContext().getContentResolver().query(uri, projection, null, null, null);
                if (c.moveToNext()) {
                    String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
                    mUploadFile.add(0, new File(path));
                    BitmapFactory.Options opts = new BitmapFactory.Options();
                    opts.inSampleSize = 2;
                    Bitmap bm = BitmapFactory.decodeFile(path, opts);
                    imgview1.setImageBitmap(bm);
                    a[0] = 1;

                }
            }
            return;
        }

        if (requestCode == RC_CAMERA1) {
            if (resultCode == Activity.RESULT_OK) {

                File file = mCameraCaptureFile;
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inSampleSize = 2;
                Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath(), opts);
                imgview1.setImageBitmap(bm);
                mUploadFile.add(0, file);
                a[0] = 1;

            }
            return;
        }

        if (requestCode == RC_GALLERY2) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                String[] projection = {MediaStore.Images.Media.DATA};
                Cursor c = getContext().getContentResolver().query(uri, projection, null, null, null);
                if (c.moveToNext()) {
                    String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
                    mUploadFile.add(1, new File(path));
                    BitmapFactory.Options opts = new BitmapFactory.Options();
                    opts.inSampleSize = 2;
                    Bitmap bm = BitmapFactory.decodeFile(path, opts);
                    imgview2.setImageBitmap(bm);
                    a[1] = 1;

                }
            }
            return;
        }

        if (requestCode == RC_CAMERA2) {
            if (resultCode == Activity.RESULT_OK) {

                File file = mCameraCaptureFile;
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inSampleSize = 2;
                Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath(), opts);
                imgview2.setImageBitmap(bm);
                mUploadFile.add(1, file);
                a[1] = 1;

            }
            return;
        }

        if (requestCode == RC_GALLERY3) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                String[] projection = {MediaStore.Images.Media.DATA};
                Cursor c = getContext().getContentResolver().query(uri, projection, null, null, null);
                if (c.moveToNext()) {
                    String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
                    mUploadFile.add(2, new File(path));
                    BitmapFactory.Options opts = new BitmapFactory.Options();
                    opts.inSampleSize = 2;
                    Bitmap bm = BitmapFactory.decodeFile(path, opts);
                    imgview3.setImageBitmap(bm);
                    a[2]=1;

                }
            }
            return;
        }

        if (requestCode == RC_CAMERA3) {
            if (resultCode == Activity.RESULT_OK) {

                File file = mCameraCaptureFile;
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inSampleSize = 2;
                Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath(), opts);
                imgview3.setImageBitmap(bm);
                mUploadFile.add(2, file);
                a[2]=1;

            }
            return;
        }


    }

    public WriteDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            String path = savedInstanceState.getString("uploadfile");
            if (!TextUtils.isEmpty(path)) {
//                mUploadFile = new File(path);
            }
            path = savedInstanceState.getString("cameraFile");
            if (!TextUtils.isEmpty(path)) {
                mCameraCaptureFile = new File(path);
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final String name = getArguments().getString("name");
        final int rent_fee = getArguments().getInt("rent_fee");
        final String category = getArguments().getString("category");
        final int rent_deposit = getArguments().getInt("rent_deposit");
        final int min_rent_period = getArguments().getInt("min_rent_period");
        final int max_rent_period = getArguments().getInt("max_rent_period");
        final double longitude = getArguments().getDouble("longitude");
        final double latitude = getArguments().getDouble("latitude");



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_write_detail, container, false);

        editText = (EditText) view.findViewById(R.id.edit_detail);
        editText.requestFocus();


        TextView button = (TextView) getActivity().findViewById(R.id.btn_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //네트워크 매니저

                content = editText.getText().toString();

                NetworkManager.getInstance().ProductWrite(longitude, latitude, name, category, rent_fee, rent_deposit, min_rent_period, max_rent_period, content, mUploadFile,
                        new NetworkManager.OnResultListener<WriteData>() {
                            @Override
                            public void onSuccess(Request request, WriteData result) {
                                Intent i = new Intent(getActivity(), MyProductDetailActivity.class);
                                i.putExtra("longitude", longitude);
                                i.putExtra("latitude", latitude);
                                i.putExtra("content", content);
                                i.putExtra("name", name);
                                i.putExtra("category", category);
                                i.putExtra("rent_fee", rent_fee);
                                i.putExtra("rent_deposit", rent_deposit);
                                i.putExtra("min_rent_period", min_rent_period);
                                i.putExtra("max_rent_period", max_rent_period);
                                i.putExtra("home", 1);
//                                i.putExtra("pictures", mUploadFile);
                                startActivity(i);

                            }

                            @Override
                            public void onFail(Request request, IOException exception) {

                            }
                        });
            }
        });


        imgview1 = (ImageView) view.findViewById(R.id.image1);
        imgview2 = (ImageView) view.findViewById(R.id.image2);
        imgview3 = (ImageView) view.findViewById(R.id.image3);

        btn_camera = (ImageButton) view.findViewById(R.id.btn_camera);
        btn_gallery = (ImageButton) view.findViewById(R.id.btn_gallery);


        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a[0] == 0)
                    getImageFromCamera(intent1, RC_CAMERA1);
                if (a[0] == 1 && a[1] == 0 && a[2] == 0)
                    getImageFromCamera(intent2, RC_CAMERA2);
                if(a[0]==1 && a[1]==1 && a[2]==0)
                    getImageFromCamera(intent3, RC_CAMERA3);
                if(a[0]==1 && a[1]==1 && a[2]==1) return;

            }
        });


        btn_gallery.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (a[0] == 0)
                    getImageFromGallery(intent1, RC_GALLERY1);
                if (a[0] == 1 && a[1] == 0 && a[2] == 0)
                    getImageFromGallery(intent2, RC_GALLERY2);
                if(a[0]==1 && a[1]==1 && a[2]==0)
                    getImageFromGallery(intent3, RC_GALLERY3);
                if(a[0]==1 && a[1]==1 && a[2]==1) return;
            }
        });

        return view;
    }
}

