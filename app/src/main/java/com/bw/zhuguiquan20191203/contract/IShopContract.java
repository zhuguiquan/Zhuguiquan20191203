package com.bw.zhuguiquan20191203.contract;

import com.bw.zhuguiquan20191203.model.bean.GridBean;

/**
 * DateTime:2019/12/3 0003
 * author:朱贵全(Administrator)
 * function:
 */
public interface IShopContract {
    interface Iview{
        void onShopSuccess(GridBean gridBean);
        void onShopFailure(Throwable throwable);
    }
    interface IModelBack{
        void onShopSuccess(GridBean gridBean);
        void onShopFailure(Throwable throwable);
    }
}
