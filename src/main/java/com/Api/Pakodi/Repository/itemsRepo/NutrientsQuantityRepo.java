package com.Api.Pakodi.Repository.itemsRepo;

import com.Api.Pakodi.domain.items.NutrientsQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NutrientsQuantityRepo extends JpaRepository<NutrientsQuantity, Long> {

    @Query(value = "SELECT nq.id as id, n.name AS nutrientName, n.unit AS unit, nq.quantity AS quantity " +
            "FROM nutrients_quantity nq " +
            "JOIN nutrients n ON n.id = nq.nutrients_id " +
            "WHERE nq.menu_id = :menuId", nativeQuery = true)
    List<Object[]> findNutrientsByMenuId(Long menuId);




    @Query(value = "SELECT m.restaurant_id as restaurantId, m.id as menuId, m.item_name as itemName,  m.item_status as status, m.item_type as itemType, m.price as price, m.ingredients as ingredients, m.string_image as image FROM " +
            "menu as m " +
            "join " +
            "nutrients_quantity as nq on m.id = nq.menu_id " +
            "join " +
            "nutrients as n on nq.nutrients_id = n.id " +
            "WHERE nq.menu_id = :menuId", nativeQuery = true)
    List<Object[]> findNutrientsByMenusId(Long menuId);
}

