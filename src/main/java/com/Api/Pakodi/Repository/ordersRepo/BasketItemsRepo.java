package com.Api.Pakodi.Repository.ordersRepo;

import com.Api.Pakodi.domain.items.Menu;
import com.Api.Pakodi.domain.order.BasketItems;
import com.Api.Pakodi.request.dto.BasketItemsRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface BasketItemsRepo extends JpaRepository<BasketItems, Long> {


    // 1. Update Operation
    @Modifying
    @Transactional
    @Query(value = "UPDATE BASKET_ITEMS " +
            "SET " +
            "total = ?3, quantity = ?4, tax = ?5 " +
            "WHERE " +
            "menu_id = ?2 " +
            "AND "+
            "gmail_id = ?1", nativeQuery = true)
    void updateQuantityAndTaxAndTotalByGmailIdAndMenuId(String gmailId, Long menuId, BigDecimal total, Long quantity, BigDecimal tax);



    // 2. Read Operation
    List<BasketItems> getBasketItemsByGmailId(String gmailId);



    // 3. Read Operation to check whether a menuId exists or not
    BasketItems findByGmailIdAndMenuId(String gmailId, Menu menuId);



    // 4.Delete Operation
    @Transactional
    int deleteByGmailIdAndMenuId(String gmailId, Menu menuId);

    @Transactional
    int deleteByGmailId(String gmailId);

}
