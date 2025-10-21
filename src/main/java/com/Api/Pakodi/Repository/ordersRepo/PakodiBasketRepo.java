package com.Api.Pakodi.Repository.ordersRepo;

import com.Api.Pakodi.domain.items.Restaurant;
import com.Api.Pakodi.domain.order.PakodiBasket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface PakodiBasketRepo extends JpaRepository<PakodiBasket, Long> {


    List<PakodiBasket> findByGmailIdAndRestaurant(String gmailId, Restaurant restaurant);



    @Modifying
    @Transactional
    @Query(value = "UPDATE pakodi_basket " +
            "SET " +
            "total = ?3 " +
            "WHERE gmail_Id = ?1 " +
            "AND " +
            "restaurant = ?2", nativeQuery = true)
    void updateTotalByGmailIdAndRestaurant(String gmailId, Long restaurantId, BigDecimal total);


    @Transactional
    int deleteByGmailIdAndRestaurant(String gmailId, Restaurant restaurant);

    @Transactional
    int deleteByGmailId(String gmailId);


    List<PakodiBasket> findByGmailId(String gmailId);



}
