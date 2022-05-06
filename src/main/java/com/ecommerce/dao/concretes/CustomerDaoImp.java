package com.ecommerce.dao.concretes;

import com.ecommerce.core.exception.BaseException;
import com.ecommerce.core.exception.DaoOperationException;
import com.ecommerce.core.model.response.CustomerResponse;
import com.ecommerce.dao.abstracts.CustomerDao;
import com.ecommerce.entity.CustomerEntity;
import com.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerDaoImp implements CustomerDao {

    private final CustomerRepository customerRepository;


    @Override
    public CustomerEntity create(CustomerEntity customerEntity) {
    return customerRepository.save(customerEntity);

    }

    @Override
    public CustomerEntity getCustomerById(Long id) throws BaseException {
        CustomerEntity customerEntity= customerRepository.findById(id).get().getIsDeleted()==false ?
                customerRepository.findById(id).orElseThrow(()-> new DaoOperationException.CustomerNotFoundException("Customer not found")) :
                null;
        return customerEntity;
    }

    @Override
    public CustomerEntity update(CustomerEntity customerNew) {
        return customerRepository.save(customerNew);
    }

    @Override
    public List<CustomerEntity> getAllCustomer() {
        List<CustomerEntity> list=(List<CustomerEntity>) customerRepository.findAll();
        return list;
    }

    @Override
    public int deleteById(Long id) throws BaseException {
        CustomerEntity customer=customerRepository.findById(id)
                .orElseThrow(()-> new DaoOperationException.CustomerNotFoundException("Customer not found"));
        customer.setIsDeleted(true);
        return 1;
    }
}
