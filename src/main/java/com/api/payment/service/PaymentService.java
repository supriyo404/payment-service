package com.api.payment.service;


import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.payment.entity.Payment;
import com.api.payment.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	public Payment makePayment(Payment payment) {
		
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(isPaymentSuccess());
		
		return repository.save(payment);
	}
	
	public Payment getPaymentDetailsbyId(int id) {
		
		return repository.findByOrderId(id);
	}
	
	
	public String isPaymentSuccess() {
		//This should be a REST call to payment gateway service
		return new Random().nextBoolean()?"Success":"Failed";
	}

}
