package com.alejandro_example.backend_apirest.services;

import com.alejandro_example.backend_apirest.entities.CustomerEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    public List<CustomerEntity> findAll();

    public Page<CustomerEntity> findAll(Pageable pageable);

    public CustomerEntity findById(Long id);

    public CustomerEntity save(CustomerEntity customer);

    public void delete(Long id);
}
