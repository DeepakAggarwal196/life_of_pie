package com.example.deepak.prototype2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, viewGroup,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int position) {

        Product product = productList.get(position);

        productViewHolder.textViewTitle.setText(product.getTitle());
        productViewHolder.textViewTimestamp.setText(product.getTimestamp());
        productViewHolder.textViewTimeDuration.setText(product.getTimeDuration());
        productViewHolder.textViewSteps.setText(String.valueOf(product.getSteps()));
        productViewHolder.textViewCalories.setText(String.valueOf(product.getCalories()));

        productViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textViewTitle, textViewTimestamp, textViewTimeDuration, textViewSteps, textViewCalories;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewTimestamp = itemView.findViewById(R.id.textViewTimeStamp);
            textViewTimeDuration = itemView.findViewById(R.id.textViewTimeDuration);
            textViewSteps = itemView.findViewById(R.id.textViewSteps);
            textViewCalories = itemView.findViewById(R.id.textViewCalories);
        }
    }


}
