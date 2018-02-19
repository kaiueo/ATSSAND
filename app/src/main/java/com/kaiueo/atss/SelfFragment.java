package com.kaiueo.atss;


import android.app.Activity;
import android.os.Bundle;
import android.os.Trace;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelfFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelfFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView avatarImageView;
    private TextView usernameLabel;
    private TextView createLabel;
    private TextView useLabel;
    private TextView bioLabel;


    public SelfFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelfFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelfFragment newInstance(String param1, String param2) {
        SelfFragment fragment = new SelfFragment();
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

    public void change(User user){
        //System.out.print("asdsad\n");
        usernameLabel.setText(user.data.username);
        createLabel.setText(user.data.created_at);
        useLabel.setText(getRemain(user.data.use, user.data.uploads));
        bioLabel.setText(user.data.biography);
    }

    public String getRemain(int use, int uploads){
        int amount = uploads / 10 + 10;
        return "    用量："+use+"/"+amount;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_self, container, false);
        avatarImageView = (ImageView) view.findViewById(R.id.avatar_imageview);
        usernameLabel = (TextView) view.findViewById(R.id.username_label);
        createLabel = (TextView) view.findViewById(R.id.create_label);
        useLabel = (TextView) view.findViewById(R.id.use_label);
        bioLabel = (TextView) view.findViewById(R.id.biography_label);
        NetworkHelper.getUserDetail(this);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflater.inflate(R.menu.upload_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }
}
