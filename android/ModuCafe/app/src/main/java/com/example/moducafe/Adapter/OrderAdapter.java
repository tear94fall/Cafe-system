package com.example.moducafe.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moducafe.Activity.ItemActivity;
import com.example.moducafe.Activity.OrderActivity;
import com.example.moducafe.R;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<OrderDto> orderDtoList;

    public OrderAdapter() {
        orderDtoList = new ArrayList<>();
        orderDtoList.add(new OrderDto(1L, "AAAA", 10, 28000));
        orderDtoList.add(new OrderDto(2L, "BBBB", 1, 4000));
        orderDtoList.add(new OrderDto(3L, "CCCC", 3, 12000));
        orderDtoList.add(new OrderDto(4L, "DDDD", 13, 42000));
        orderDtoList.add(new OrderDto(5L, "EEEE", 4, 32000));
        orderDtoList.add(new OrderDto(6L, "FFFF", 7, 35000));
        orderDtoList.add(new OrderDto(7L, "GGGG", 21, 50000));
        orderDtoList.add(new OrderDto(8L, "HHHH", 7, 16500));
        orderDtoList.add(new OrderDto(9L, "IIII", 2, 7000));
        orderDtoList.add(new OrderDto(10L, "JJJJ", 18, 39000));
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_row, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderDto order = this.orderDtoList.get(position);

        holder.setOrderInfo(order);
        holder.setOrderClickEvent(order);
    }

    @Override
    public int getItemCount() {
        return this.orderDtoList.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout orderViewLayout;
        TextView orderNumber;
        TextView orderQuantity;
        TextView orderPrice;

        public OrderViewHolder(@NonNull View orderView) {
            super(orderView);
            orderViewLayout = orderView.findViewById(R.id.orderViewLayout);
            orderNumber = orderView.findViewById(R.id.order_number);
            orderQuantity = orderView.findViewById(R.id.order_quantity);
            orderPrice = orderView.findViewById(R.id.order_price);
        }

        public void setOrderInfo(OrderDto order) {
            this.orderNumber.setText(String.valueOf(order.getId()));
            this.orderQuantity.setText(order.getQuantity() + "잔");
            this.orderPrice.setText(order.getPrice() + "원");
        }

        public void setOrderClickEvent(OrderDto order) {
            this.orderViewLayout.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), OrderActivity.class);
                intent.putExtra("orderNumber", String.valueOf(order.getId()));
                v.getContext().startActivity(intent);
            });
        }
    }
}