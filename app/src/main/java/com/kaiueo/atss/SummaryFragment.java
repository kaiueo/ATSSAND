package com.kaiueo.atss;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SummaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SummaryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditText articleOrUrlTextview;
    public SummarizedArticle summarizedArticle;
    public SeekBar countBar;
    public ZLoadingDialog zLoadingDialog;
    public Dialog dialog;


    public SummaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SummaryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SummaryFragment newInstance(String param1, String param2) {
        SummaryFragment fragment = new SummaryFragment();
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
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        articleOrUrlTextview = (EditText) view.findViewById(R.id.url_or_article);
        countBar = (SeekBar) view.findViewById(R.id.count_seekBar);
        zLoadingDialog = new ZLoadingDialog(getActivity());
        zLoadingDialog.setLoadingBuilder(Z_TYPE.STAR_LOADING).setLoadingColor(Color.BLACK).setHintText("Loading...");

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.summary_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.summary_url:
                //SummaryResultActivity.actionStart(getActivity(), "asdadad\nadadasd\n");
                dialog = zLoadingDialog.show();
                getSummarizationFromUrl();
                return true;
            case R.id.summary_text:
                dialog = zLoadingDialog.show();
                getSummarizationFromText();
                return true;
            case R.id.summary_clear:
                articleOrUrlTextview.setText("");
            default:
                return false;
        }
    }

    public void getSummarizationFromUrl(){
        String url = articleOrUrlTextview.getText().toString();
        NetworkHelper.getSummaryFromUrl(this, url, countBar.getProgress());
    }

    public void getSummarizationFromText(){
        String text = articleOrUrlTextview.getText().toString();
        NetworkHelper.getSummaryFromText(this, text, countBar.getProgress());
    }

    public void showResult(){

        if(summarizedArticle==null){
            Toast.makeText(getActivity(), "请检查网络连接", Toast.LENGTH_LONG).show();
        }else if(summarizedArticle.code!=0){
            Toast.makeText(getActivity(), summarizedArticle.msg, Toast.LENGTH_LONG).show();
        }else{

            String summarization = "";
            for (String summary :
                    summarizedArticle.data.summary) {
                summarization = summarization + summary + "\n";

            }
            SummaryResultActivity.actionStart(getActivity(), summarization);
        }

    }
}
