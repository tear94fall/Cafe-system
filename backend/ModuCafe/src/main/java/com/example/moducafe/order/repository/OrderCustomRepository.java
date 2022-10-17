package com.example.moducafe.order.repository;

import com.example.moducafe.order.entity.Order;

public interface OrderCustomRepository {

    Order findByNumber(String number);
}
