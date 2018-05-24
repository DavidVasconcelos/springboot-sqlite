package com.ciandt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciandt.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
