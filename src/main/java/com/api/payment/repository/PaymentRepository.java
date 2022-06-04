package com.api.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.payment.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	
	@Query("select u from tbl_payment u WHERE u.order_id= : id ")
	Payment getPaymentDetailonOrder(@Param("id") int odrid);
	
	Payment findByOrderId(int OderId);

}
