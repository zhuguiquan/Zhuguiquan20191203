package com.bw.zhuguiquan20191203.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.bw.zhuguiquan20191203.R;
import com.bw.zhuguiquan20191203.base.BaseFragment;
import com.bw.zhuguiquan20191203.contract.IShopContract;
import com.bw.zhuguiquan20191203.model.bean.GridBean;
import com.bw.zhuguiquan20191203.presenter.ShopPresenter;
import com.bw.zhuguiquan20191203.view.activity.MainActivity;
import com.bw.zhuguiquan20191203.view.adapter.MyAdapter;

import java.util.List;

/**
 * DateTime:2019/12/3 0003
 * author:朱贵全(Administrator)
 * function:
 */
public class ShopingCartFragment extends BaseFragment implements IShopContract.Iview {

    private Button button;
    private GridView gridView;

    @Override
    protected void initData() {
        //实例化presenter
        ShopPresenter shopPresenter = new ShopPresenter();
        //调用方法
        shopPresenter.getShopData(this);

    }

    @Override
    protected void initView(View inflate) {
        button = inflate.findViewById(R.id.bt);
        gridView = inflate.findViewById(R.id.gv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.shouye();
            }
        });

    }

    @Override
    protected int layoutId() {
        return R.layout.shoping;
    }

    @Override
    public void onShopSuccess(GridBean gridBean) {
        List<GridBean.ShopGridDataBean> shopGridData = gridBean.getShopGridData();
        MyAdapter myAdapter = new MyAdapter(shopGridData);
        gridView.setAdapter(myAdapter);
    }

    @Override
    public void onShopFailure(Throwable throwable) {

    }
}
