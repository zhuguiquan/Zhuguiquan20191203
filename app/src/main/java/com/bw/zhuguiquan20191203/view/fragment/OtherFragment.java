package com.bw.zhuguiquan20191203.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.zhuguiquan20191203.R;
import com.bw.zhuguiquan20191203.base.BaseFragment;
import com.bw.zhuguiquan20191203.uitl.NetUtil;

/**
 * DateTime:2019/12/3 0003
 * author:朱贵全(Administrator)
 * function:
 */
public class OtherFragment extends BaseFragment {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View inflate) {
        textView = inflate.findViewById(R.id.other_text);
        imageView = inflate.findViewById(R.id.other_img);
        if(NetUtil.getInstance().hanNet(getContext())){
            textView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
        }else{
            textView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);

        }

    }

    @Override
    protected int layoutId() {
        return R.layout.other;
    }
}
