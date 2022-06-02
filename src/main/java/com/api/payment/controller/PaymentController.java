package com.api.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.payment.entity.Payment;
import com.api.payment.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentservice;
	
	@PostMapping("/doPay")
	public Payment makePayment(@RequestBody Payment payment) {
		
		return paymentservice.makePayment(payment);
		
	}
	
	@GetMapping("/findPayment/{orderid}")
	public Payment getPayementByOrderId(@PathVariable String orderid) {
		
		return paymentservice.getPaymentDetailsbyId(Integer.parseInt(orderid));
		
	}

}
