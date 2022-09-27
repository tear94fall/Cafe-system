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

    public CoffeeDto joinCoffee(CoffeeDto coffeeDto) {
        return new CoffeeDto(itemRepository.save(new Coffee(coffeeDto)));
    }

    public CoffeeDto findCoffeeByName(String name) {
        return new CoffeeDto(itemRepository.findByName(name));
    }

    public CoffeeDto updateCoffeePrice(CoffeeDto coffeeDto) {
        Coffee find = itemRepository.findByName(coffeeDto.getName());
        find.setPrice(coffeeDto.getPrice());

        return new CoffeeDto(itemRepository.save(find));
    }

    public String removeCoffee(String name) {
        Coffee find = itemRepository.findByName(name);
        itemRepository.deleteById(find.getId());
        return find.getName();
    }
}
