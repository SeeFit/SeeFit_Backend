package com.carespoon.menu.service;

import com.carespoon.menu.repository.MenuRepository;
import com.carespoon.menu.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MenuService {

    MenuRepository menuRepository;
    public List<Menu> findByMenuName(List<String> name){
        List<Menu> menu = new ArrayList<>(name.size());
        for(int i = 0; i<name.size(); i++){
            menu.add(i, menuRepository.findByMenuName(name.get(i)));
        }
        return menu;
    }
}