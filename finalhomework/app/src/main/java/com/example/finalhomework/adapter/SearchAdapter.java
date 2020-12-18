package com.example.finalhomework.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.finalhomework.R;
import com.example.finalhomework.bean.GoodsInfo;

public class SearchAdapter extends BaseQuickAdapter<GoodsInfo, BaseViewHolder> {
    public SearchAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsInfo item) {
        helper.setText(R.id.tv_name, item.name);
        helper.setText(R.id.tv_price, "￥" + item.price);
        Glide.with(mContext).load(item.thumb_path).thumbnail(0.5f).into((ImageView) helper.getView(R.id.image));

        helper.addOnClickListener(R.id.btn_add);
    }
}
