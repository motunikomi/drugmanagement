package com.drug.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.drug.domain.Item;

@Mapper
public interface ItemMapper {
  List<Item> findAll();

  Item findOne(int id);

  void save(Item item);

  void update(Item item);

  void delete(int id);
}
