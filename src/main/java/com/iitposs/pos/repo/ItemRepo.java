package com.iitposs.pos.repo;

import com.iitposs.pos.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {

    List<Item> findAllByActiveState(boolean state);

    List<Item> findAllByNameEqualsAndActiveState(String itemName, boolean b);

    Page<Item> findAllByActiveStateEquals(boolean state, Pageable pageable);
}
