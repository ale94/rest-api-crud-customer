package com.alejandro_example.backend_apirest.controllers;

import com.alejandro_example.backend_apirest.entities.CustomerEntity;
import com.alejandro_example.backend_apirest.services.ICustomerService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerEntity> index() {
        return customerService.findAll();
    }

    @GetMapping("/customers/page/{page}")
    public Page<CustomerEntity> index(@PathVariable Integer page) {
        return customerService.findAll(PageRequest.of(page, 4));
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        CustomerEntity customer = null;
        Map<String, Object> response = new HashMap<>();

        try {
            customer = customerService.findById(id);
        } catch (DataAccessException e) {
            response.put("message", "Error when querying the database");
            response.put("error",
                e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response,
                HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (customer == null) {
            response.put("message", "Customer ID: " + id + " does not exist in database");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CustomerEntity>(customer, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<?> create(@Valid @RequestBody CustomerEntity customer,
        BindingResult result) {

        CustomerEntity newCustomer = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                .stream()
                .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                .toList();
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response,
                HttpStatus.BAD_REQUEST);
        }

        try {
            newCustomer = customerService.save(customer);
        } catch (DataAccessException e) {
            response.put("message", "Failed to perform insert into database");
            response.put("error",
                e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response,
                HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "The customer has been created successfully");
        response.put("customer", newCustomer);
        return new ResponseEntity<Map<String, Object>>(response,
            HttpStatus.CREATED);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody CustomerEntity customer,
        BindingResult result, @PathVariable Long id) {

        var nowCustomer = customerService.findById(id);
        CustomerEntity updatedCustomer = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                .stream()
                .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                .toList();
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response,
                HttpStatus.BAD_REQUEST);
        }

        if (nowCustomer == null) {
            response.put("message",
                "Error: Could not edit, customer ID: " + id + " does not exist in database");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            nowCustomer.setFirstName(customer.getFirstName());
            nowCustomer.setLastName(customer.getLastName());
            nowCustomer.setEmail(customer.getEmail());
            nowCustomer.setCreateAt(customer.getCreateAt());
            updatedCustomer = customerService.save(nowCustomer);
        } catch (DataAccessException e) {
            response.put("message", "Error updating customer in database");
            response.put("error",
                e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response,
                HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "The customer has been successfully updated");
        response.put("customer", updatedCustomer);
        return new ResponseEntity<Map<String, Object>>(response,
            HttpStatus.CREATED);

    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        var customer = customerService.findById(id);

        if (customer == null) {
            response.put("message",
                "Error: Could not delete, customer ID: " + id + " does not exist in database");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            customerService.delete(id);
        } catch (DataAccessException e) {
            response.put("message", "Error removing customer from database");
            response.put("error",
                e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response,
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "The customer has been successfully deleted");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
