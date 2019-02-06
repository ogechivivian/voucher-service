package com.voucherz.voucherservice.api.repository;

//import org.springframework.data.repository.CrudRepository;
import com.voucherz.voucherservice.api.model.Discount;
import org.springframework.data.repository.CrudRepository;

public interface DiscountRepository extends CrudRepository<Discount, Integer > {
}
