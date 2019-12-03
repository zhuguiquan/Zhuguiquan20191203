package com.bw.zhuguiquan20191203.model;

import com.bw.zhuguiquan20191203.contract.IShopContract;
import com.bw.zhuguiquan20191203.model.bean.GridBean;
import com.bw.zhuguiquan20191203.uitl.NetUtil;
import com.google.gson.Gson;

/**
 * DateTime:2019/12/3 0003
 * author:朱贵全(Administrator)
 * function:
 */
public class ShopModel {
    //声明方法
    public void getShopData(final IShopContract.IModelBack iModelBack){
        //调用接口
        NetUtil.getInstance().getJson("http://blog.zhaoliang5156.cn/api/mall/mall.json", new NetUtil.MyCallBack() {
            @Override
            public void ongetjson(String json) {
                //gson解析
                GridBean gridBean = new Gson().fromJson(json, GridBean.class);
                iModelBack.onShopSuccess(gridBean);

            }

            @Override
            public void onError(Throwable throwable) {
                iModelBack.onShopFailure(throwable);

            }
        });

    }
}
