package com.Ecommerce.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Ecommerce.entities.Cart;

public interface CartRepository  extends CrudRepository<Cart, Integer>{

}
