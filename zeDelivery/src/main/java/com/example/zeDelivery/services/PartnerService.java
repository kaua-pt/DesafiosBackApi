package com.example.zeDelivery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zeDelivery.domain.Partner;
import com.example.zeDelivery.repositories.PartnerRepository;

@Service
public class PartnerService {

    @Autowired
    public PartnerRepository partnerRepository;

    public Partner closestPartner(Partner partner) {
        Partner closest = null;

        return closest;
    }
}
