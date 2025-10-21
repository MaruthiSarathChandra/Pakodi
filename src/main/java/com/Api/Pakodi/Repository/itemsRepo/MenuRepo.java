package com.Api.Pakodi.Repository.itemsRepo;

import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.items.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {
    List<Menu> findByRestaurantId(@Param("restaurantId") Restaurant restaurantId);

    Optional<Menu> findById(@Param("id") Long menuId);

}
