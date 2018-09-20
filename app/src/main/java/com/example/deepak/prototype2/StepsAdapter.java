package com.example.deepak.prototype2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
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

public class StepsAdapter  extends RecyclerView.Adapter<StepsAdapter.StepsCardViewHolder>{

    private Context mCtx;
    private List<StepsCard> stepsList;
    StepsCounter stepsCounter;

    public StepsAdapter(Context mCtx, List<StepsCard> stepsList) {
        this.mCtx = mCtx;
        this.stepsList = stepsList;
    }

    @NonNull
    @Override
    public StepsAdapter.StepsCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout_steps, viewGroup,false);
        return new StepsAdapter.StepsCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepsCardViewHolder stepsCardViewHolder, int position) {


        StepsCard StepsCard = stepsList.get(position);
        stepsCardViewHolder.textViewCount.setText(StepsCard.getCount());
        stepsCardViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(StepsCard.getImage()));
        stepsCardViewHolder.imageSmallView.setImageDrawable(mCtx.getResources().getDrawable(StepsCard.getImage_small()));

        stepsCardViewHolder.progressBar.setProgress(StepsCard.getProgress());

        if(StepsCard.getType() == 1)
        {
            stepsCardViewHolder.textViewSmall.setText("Steps");
            stepsCardViewHolder.progressBar.getProgressDrawable().setColorFilter(ContextCompat.getColor(mCtx,R.color.progress_blue), PorterDuff.Mode.SRC_IN);;
        }
        else if(StepsCard.getType() == 2)
        {
            stepsCardViewHolder.textViewSmall.setText("Calories");
            stepsCardViewHolder.progressBar.getProgressDrawable().setColorFilter(ContextCompat.getColor(mCtx,R.color.progress_red), PorterDuff.Mode.SRC_IN);
        }


    }



    @Override
    public int getItemCount() {
        return stepsList.size();
    }

    class StepsCardViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView, imageSmallView;
        TextView textViewCount, textViewSmall;
        CardView cardView;
        ProgressBar progressBar;

        public StepsCardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView_steps);
            imageSmallView = itemView.findViewById(R.id.imageViewStepsSmall);

            textViewCount = itemView.findViewById(R.id.textViewCount);
            textViewSmall = itemView.findViewById(R.id.textViewStepsSmall);

            cardView = itemView.findViewById(R.id.card_view_steps);

            progressBar = itemView.findViewById(R.id.progress_bar_steps);
        }
    }

}
