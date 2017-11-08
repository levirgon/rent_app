package com.example.noushad.to_let_bd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noushad on 10/25/17.
 */

public class CategoriesAdapter extends RecyclerView.Adapter {

    private final Context mContext;
    private final ArrayList<CategoriesItem> mItems;
    private Context mParentContext;


    public CategoriesAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        mParentContext = parent.getContext();
        View viewItem = inflater.inflate(R.layout.list_item, parent, false);
        viewHolder = new CategoriesVH(viewItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CategoriesItem categoriesItem = mItems.get(position);
        CategoriesVH categoriesVH = (CategoriesVH) holder;
        categoriesVH.bind(categoriesItem);
    }

    @Override
    public int getItemCount() {
        return mItems.isEmpty() ? 0 : mItems.size();
    }

    private class CategoriesVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mCoverImage;
        private TextView mTitleTextView;
        private TextView mDescriptionTextView;

        public CategoriesVH(View viewItem) {
            super(viewItem);
            mCoverImage = (ImageView) viewItem.findViewById(R.id.list_item_cover);
            mTitleTextView = (TextView) viewItem.findViewById(R.id.list_item_title);
            mDescriptionTextView = (TextView) viewItem.findViewById(R.id.list_item_describe);
            viewItem.setOnClickListener(this);

        }

        private void bind(CategoriesItem categoriesItem) {
            mCoverImage.setImageResource(categoriesItem.getImageId());
            mTitleTextView.setText(categoriesItem.getCategoriesName());
            mTitleTextView.setTypeface(EasyFonts.caviarDreamsBold(mContext));
            mDescriptionTextView.setText(categoriesItem.getDescription());
            mDescriptionTextView.setTypeface(EasyFonts.caviarDreams(mContext));

        }

        @Override
        public void onClick(View v) {
            //Load items of that category
        }
    }

    public void add(CategoriesItem item) {
        mItems.add(item);
        notifyItemInserted(mItems.size() - 1);
    }

    public void addAll(List<CategoriesItem> items) {
        for (CategoriesItem item : items) {
            add(item);
        }
    }
}
