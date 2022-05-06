package com.ecommerce.service.concretes;

import com.ecommerce.core.converter.abstracts.CustomerConverter;
import com.ecommerce.core.model.dto.CustomerDTO;
import com.ecommerce.core.model.response.CustomerResponse;
import com.ecommerce.dao.abstracts.CustomerDao;
import com.ecommerce.entity.CustomerEntity;
import com.ecommerce.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerConverter customerConverter;
    private final CustomerDao customerDao;

    @Override
    public void create(CustomerDTO customerDTO) {
        CustomerEntity customerEntity=customerConverter.convertCreate(customerDTO); //Burada gelen customerDTO tipindeki veriyi veri tabanına kaydedebileceğimiz türe yani CustomerEntitye çevirdik.
        log.info("Customer ID should be null : {}",customerEntity.getId());
        customerDao.create(customerEntity);
        log.info("Customer ID should not be null : {}",customerEntity.getId());
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        CustomerResponse customerResponse=
                customerConverter.convertGetById(
                        customerDao.getCustomerById(id));
        log.info("{}",customerResponse);
        return customerResponse;
    }

    @Override
    public void update(Long id, CustomerDTO customerDTO) {
        CustomerEntity customerOld=customerDao.getCustomerById(id);
        CustomerEntity customerNew=customerConverter.convertUpdate(customerOld,customerDTO);
        log.info("Updated Customer: {}",customerNew);
        customerDao.update(customerNew);
    }

    @Override
    public List<CustomerResponse> getAllCustomer() {
        List<CustomerResponse> list=customerConverter.convertGetAll(customerDao.getAllCustomer());
        return list;
    }

    @Override
    public String deleteById(Long id) {
        int resul=customerDao.deleteById(id);
        return resul==1?"Başarılı":"Başarısız";
    }
}
