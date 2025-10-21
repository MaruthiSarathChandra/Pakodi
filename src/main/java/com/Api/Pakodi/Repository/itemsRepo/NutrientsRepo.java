package com.Api.Pakodi.Repository.itemsRepo;


import com.Api.Pakodi.domain.items.Nutrients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutrientsRepo extends JpaRepository<Nutrients, Long> {
}
