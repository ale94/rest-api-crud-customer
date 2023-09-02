package com.alejandro_example.backend_apirest.services;

import com.alejandro_example.backend_apirest.entities.CustomerEntity;
import java.util.List;

public interface ICustomerService {

    public List<CustomerEntity> findAll();

    public CustomerEntity findById(Long id);

    public CustomerEntity save(CustomerEntity customer);

    public void delete(Long id);
}
