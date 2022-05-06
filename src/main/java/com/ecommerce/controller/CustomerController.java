package com.ecommerce.controller;


import com.ecommerce.core.exception.BaseException;
import com.ecommerce.core.exception.ControllerOperationException;
import com.ecommerce.core.model.dto.CustomerDTO;
import com.ecommerce.core.model.response.CustomerResponse;
import com.ecommerce.core.validator.abstracts.CustomerCreateValidator;
import com.ecommerce.core.validator.abstracts.IdValidator;
import com.ecommerce.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerCreateValidator customerCreateValidator;
    private final IdValidator idValidator;
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CustomerDTO customerDTO) throws BaseException {
        customerCreateValidator.validate(customerDTO);//Burada gelen datayı "ilkel" olarak zorunlu alan kontrolünü yaptık.
        customerService.create(customerDTO);
        return ResponseEntity.ok().body("Kayıt Başarılı");
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) throws BaseException {
        idValidator.customerIdValidator(id);
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) throws BaseException{
        idValidator.customerIdValidator(id);
        customerCreateValidator.validate(customerDTO);
        customerService.update(id, customerDTO);
        return ResponseEntity.ok().body("Güncelleme Başarılı");
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(){
        return  ResponseEntity.ok(customerService.getAllCustomer());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        idValidator.customerIdValidator(id);
        return ResponseEntity.ok(customerService.deleteById(id));
    }



}
