package cn.fhypayaso.bodyIndex.business.details.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.fhypayaso.bodyIndex.R;
import cn.fhypayaso.bodyIndex.business.details.model.response.HeartWarningResponseModel;

public class HeartWarningAdapter extends RecyclerView.Adapter<HeartWarningAdapter.ViewHolder> {

    private Context mContext;
    private List<HeartWarningResponseModel> mHeartWarningList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView heartMessage;
        TextView heartTime;

        public ViewHolder(View itemView) {
            super(itemView);
            heartMessage = itemView.findViewById(R.id.heart_waring_message);
            heartTime = itemView.findViewById(R.id.heart_waring_time);
        }
    }

    public HeartWarningAdapter(List<HeartWarningResponseModel> heartWarningList) {
        mHeartWarningList = heartWarningList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_heart_warning,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HeartWarningResponseModel heartWarning = mHeartWarningList.get(position);
        holder.heartMessage.setText(heartWarning.getMessage());
        holder.heartTime.setText(heartWarning.getTime());
    }

    @Override
    public int getItemCount() {
        return mHeartWarningList.size();
    }

}
