package com.alejandro_example.backend_apirest.services;

import com.alejandro_example.backend_apirest.entities.CustomerEntity;
import com.alejandro_example.backend_apirest.repositories.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    @Override
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<CustomerEntity> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public CustomerEntity findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
