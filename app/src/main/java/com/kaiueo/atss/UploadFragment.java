package com.kaiueo.atss;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zyao89.view.zloading.ZLoadingBuilder;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UploadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UploadFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TextView summarizationTexrView;

    public UnsummarizedArticle unsummarizedArticle;

    public ZLoadingDialog zLoadingDialog;
    public Dialog dialog;
    public UploadResult uploadResult;


    public UploadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UploadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UploadFragment newInstance(String param1, String param2) {
        UploadFragment fragment = new UploadFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        zLoadingDialog = new ZLoadingDialog(getActivity());
        zLoadingDialog.setLoadingBuilder(Z_TYPE.STAR_LOADING).setLoadingColor(Color.BLACK).setHintText("Loading...");

        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //refresh();

        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        summarizationTexrView = (TextView) view.findViewById(R.id.summarization_textView);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.upload_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.upload_show_origin:
                if(unsummarizedArticle==null){

                    refresh();
                }else{
                    OriginActivity.actionStart(getActivity(), unsummarizedArticle.data.text);
                }

                return true;
            case R.id.upload_refresh:
                refresh();
                return true;
            case R.id.upload_upload:
                upload();
                return true;
            case R.id.upload_empty:
                summarizationTexrView.setText("");
            default:
                return false;
        }
    }

    public void showOrigin(){
        OriginActivity.actionStart(getActivity(), unsummarizedArticle.data.text);
    }


    public void refresh(){
        dialog = zLoadingDialog.show();
        NetworkHelper.getUnsummarizedArticle(this);

    }

    public void upload(){
        NetworkHelper.uploadSummary(this, unsummarizedArticle.data.id, unsummarizedArticle.data.text, summarizationTexrView.getText().toString());
    }

    public void showResult(){
        if(uploadResult == null){
            Toast.makeText(getActivity(), "请检查网络连接", Toast.LENGTH_LONG).show();
        }else if (uploadResult.code!=0){
            Toast.makeText(getActivity(), uploadResult.msg, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getActivity(), "上传成功", Toast.LENGTH_LONG).show();
        }
    }
}
