package com.example.zeDelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zeDelivery.domain.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Partner findById(String tradingName);
}
