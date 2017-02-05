package com.ligong.actionbartab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pec on 2016/9/13.
 */
public class TabContentFragment extends Fragment {
    private String mText = "首页";

    public TabContentFragment() {
    }

    public String getText() {
        return mText;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = this.getArguments();
        if (b!=null) {
            mText = b.getString("content");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.action_bar_tab_content, container, false);

        TextView text = (TextView) fragView.findViewById(R.id.text);
        text.setText(mText);

        return fragView;
    }
}
