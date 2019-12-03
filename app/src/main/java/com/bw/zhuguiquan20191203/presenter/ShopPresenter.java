package com.bw.zhuguiquan20191203.presenter;

import com.bw.zhuguiquan20191203.contract.IShopContract;
import com.bw.zhuguiquan20191203.model.ShopModel;
import com.bw.zhuguiquan20191203.model.bean.GridBean;

/**
 * DateTime:2019/12/3 0003
 * author:朱贵全(Administrator)
 * function:
 */
public class ShopPresenter {
    public void getShopData(final IShopContract.Iview iview){
        //实例化model
        ShopModel shopModel = new ShopModel();
        //调用方法回传数据
        shopModel.getShopData(new IShopContract.IModelBack() {
            @Override
            public void onShopSuccess(GridBean gridBean) {
                iview.onShopSuccess(gridBean);
            }

            @Override
            public void onShopFailure(Throwable throwable) {
                iview.onShopFailure(throwable);

            }
        });

    }
}
