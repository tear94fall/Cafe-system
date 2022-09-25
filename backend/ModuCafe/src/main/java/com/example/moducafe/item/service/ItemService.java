package com.example.moducafe.item.service;

import com.example.moducafe.item.dto.CoffeeDto;
import com.example.moducafe.item.entity.Coffee;
import com.example.moducafe.item.entity.Item;
import com.example.moducafe.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<CoffeeDto> getAllCoffees() {
        List<Item> allCoffees = itemRepository.findAllCoffees();

        return allCoffees.stream()
                .map(items -> new CoffeeDto((Coffee) items))
                .collect(Collectors.toList());
    }

    public CoffeeDto join(CoffeeDto coffeeDto) {
        return new CoffeeDto(itemRepository.save(new Coffee(coffeeDto)));
    }

    public CoffeeDto findByName(String name) {
        return new CoffeeDto(itemRepository.findByName(name));
    }

    public int updatePrice(Long id, int price) {
        Item item = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        item.setPrice(price);

        return item.getPrice();
    }

    public void removeItem(Item item) {
        itemRepository.deleteById(item.getId());
    }
}
