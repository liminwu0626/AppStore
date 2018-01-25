package com.dingzhu.appstore.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dingzhu.appstore.R;
import com.dingzhu.appstore.bean.AppInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wulimin on 2018/1/24.
 */

public class RecommendAppAdapter extends RecyclerView.Adapter<RecommendAppAdapter.ViewHolder> {

    private List<AppInfo> mDatas;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public RecommendAppAdapter(Context context, List<AppInfo> datas) {
        mDatas = datas;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.template_recomend_app, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppInfo appInfo = mDatas.get(position);
        String baseImgUrl = "http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";
        Picasso.with(mContext).load(baseImgUrl + appInfo.getIcon()).into(holder.mImgIcon);
        holder.mTextTitle.setText(appInfo.getDisplayName());
        holder.mTextSize.setText(appInfo.getApkSize() / 1024 / 1024 + "MB");
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_icon)
        ImageView mImgIcon;
        @BindView(R.id.text_title)
        TextView mTextTitle;
        @BindView(R.id.text_size)
        TextView mTextSize;
        @BindView(R.id.btn_dl)
        Button mBtnDl;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
