package com.Api.Pakodi.Repository.itemsRepo;

import com.Api.Pakodi.domain.items.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

}
