package com.event.api.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.event.api.domain.coupon.Coupon;
import com.event.api.domain.coupon.CouponRequestDTO;
import com.event.api.domain.event.Event;
import com.event.api.repositories.CouponRepository;
import com.event.api.repositories.EventRepository;

public class CouponService {

    @Autowired
    private CouponRepository couponRepository;
    private EventRepository eventRepository;

    public Coupon addCouponsToEvent(UUID eventId, CouponRequestDTO couponData) {
        Event event = eventRepository.findById(eventId).
        orElseThrow(()-> new IllegalArgumentException() );

        Coupon coupon = new Coupon();
        coupon.setCode(couponData.code());
        coupon.setDiscount(couponData.discount());
        coupon.setValid(new Date (couponData.valid()));
        coupon.setEvent(event);

        return couponRepository.save(coupon);
    }
    
}
