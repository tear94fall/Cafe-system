package com.example.moducafe.Adapter;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.moducafe.Activity.ItemPopupActivity;
import com.example.moducafe.Activity.MainActivity;
import com.example.moducafe.Activity.ShoppingCartActivity;
import com.example.moducafe.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<com.example.moducafe.Adapter.ItemAdapter.ItemViewHolder> {

    private List<ItemDto> itemDtoList;

    public ItemAdapter() {
        itemDtoList = new ArrayList<>();
        itemDtoList.add(new ItemDto(1L, "", "아메리카노", "Americano",4500));
        itemDtoList.add(new ItemDto(3L, "", "에스프레소", "Espresso", 4200));
        itemDtoList.add(new ItemDto(4L, "", "카푸치노", "Cappuccino", 4800));
        itemDtoList.add(new ItemDto(5L, "", "카페 라떼", "Caffe latte", 4800));
        itemDtoList.add(new ItemDto(6L, "", "카라멜 마끼야또", "Caramel Macchiato", 4500));
        itemDtoList.add(new ItemDto(6L, "", "아포카토", "Affogato", 4500));
        itemDtoList.add(new ItemDto(2L, "", "콜드 브루", "Cold brew",5000));
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_row, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemDto item = this.itemDtoList.get(position);

        holder.setUserInfo(item);
        holder.setUserClickEvent(item);
    }

    @Override
    public int getItemCount() {
        return this.itemDtoList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout itemViewLayout;
        ImageView itemImage;
        TextView itemName;
        TextView itemNameEnglish;
        TextView itemPrice;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemViewLayout = itemView.findViewById(R.id.itemViewLayout);
            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemNameEnglish = itemView.findViewById(R.id.item_name_english);
            itemPrice = itemView.findViewById(R.id.item_price);
        }

        public void setUserInfo(ItemDto item) {
            this.itemName.setText(item.getName());
            this.itemNameEnglish.setText(item.getEnglishName());
            this.itemPrice.setText(item.getPrice() + "원");

            Glide.with(itemImage)
                    .load(item.getImage() != null && !item.getImage().equals("") ? item.getImage() : R.drawable.basic_coffee)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            if (resource instanceof BitmapDrawable) {
                                Bitmap bitmap = ((BitmapDrawable) resource).getBitmap();
                                Log.d("Glide", String.format("bitmap %,d bytes, size: %d x %d", bitmap.getByteCount(), bitmap.getWidth(), bitmap.getHeight()));
                            }
                            return false;
                        }
                    })
                    .error(Glide.with(itemImage)
                            .load(R.drawable.basic_coffee)
                            .into(itemImage))
                    .into(itemImage);
        }

        public void setUserClickEvent(ItemDto item) {
            this.itemViewLayout.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), ItemPopupActivity.class);
                v.getContext().startActivity(intent);
            });
        }
    }
}
