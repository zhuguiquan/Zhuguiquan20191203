package com.bw.zhuguiquan20191203.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.zhuguiquan20191203.R;
import com.bw.zhuguiquan20191203.model.bean.GridBean;
import com.bw.zhuguiquan20191203.uitl.NetUtil;

import java.util.List;

/**
 * DateTime:2019/12/3 0003
 * author:朱贵全(Administrator)
 * function:
 */
public class MyAdapter extends BaseAdapter {
    private List<GridBean.ShopGridDataBean> shopGridData;

    public MyAdapter(List<GridBean.ShopGridDataBean> shopGridData) {

        this.shopGridData = shopGridData;
    }

    @Override
    public int getCount() {
        return shopGridData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            view=View.inflate(viewGroup.getContext(), R.layout.item,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView=view.findViewById(R.id.img);
            viewHolder.textView=view.findViewById(R.id.tv);
            view.setTag(viewHolder);
        }else{
             viewHolder = (ViewHolder) view.getTag();
        }
        GridBean.ShopGridDataBean shopGridDataBean = shopGridData.get(i);
        viewHolder.textView.setText(shopGridDataBean.getTitle());
        NetUtil.getInstance().getPhoto(shopGridDataBean.getImageurl(),viewHolder.imageView);
        return view;
    }
    private class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
