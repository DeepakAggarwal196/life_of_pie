package com.example.deepak.prototype2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class AppUsageAdapter extends RecyclerView.Adapter<AppUsageAdapter.AppUsageCardViewHolder>{

    private Context mCtx;
    private List<AppUsageItem> appUsageItemList;

    public AppUsageAdapter(Context mCtx, List<AppUsageItem> appUsageItemList) {
        this.mCtx = mCtx;
        this.appUsageItemList = appUsageItemList;
    }

    @NonNull
    @Override
    public AppUsageAdapter.AppUsageCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout_appusage, viewGroup,false);
        return new AppUsageAdapter.AppUsageCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppUsageAdapter.AppUsageCardViewHolder stepsCardViewHolder, int position) {


        AppUsageItem appUsageItem = appUsageItemList.get(position);
        stepsCardViewHolder.textViewTitle.setText(appUsageItem.getAppName());
        stepsCardViewHolder.imageView.setImageDrawable(getAppIconfromPackageName(appUsageItem.getPackageName()));
        stepsCardViewHolder.textViewDuration.setText(appUsageItem.getUsageTime());

    }

    @Override
    public int getItemCount() {
        return appUsageItemList.size();
    }

    private Drawable getAppIconfromPackageName(String packageName)
    {
        try {
            Drawable icon = mCtx.getPackageManager().getApplicationIcon(packageName);
            return icon;
        }
        catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    class AppUsageCardViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textViewTitle, textViewDuration;
        CardView cardView;
//        ProgressBar progressBar;

        public AppUsageCardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView_appusage);

            textViewTitle = itemView.findViewById(R.id.textViewTitle_appusage);
            textViewDuration = itemView.findViewById(R.id.textViewTimeDuration_appusage);

            cardView = itemView.findViewById(R.id.card_view_appusage);

//            progressBar = itemView.findViewById(R.id.progress_bar_steps);
        }
    }

}
