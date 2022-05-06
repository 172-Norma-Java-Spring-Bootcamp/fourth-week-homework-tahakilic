package com.ecommerce.core.converter.concretes;

import com.ecommerce.core.converter.abstracts.CustomerConverter;
import com.ecommerce.core.model.dto.CustomerAddressDTO;
import com.ecommerce.core.model.dto.CustomerDTO;
import com.ecommerce.core.model.response.CustomerResponse;
import com.ecommerce.entity.CustomerAddressEntity;
import com.ecommerce.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CustomerConverterImpl implements CustomerConverter {

    @Override
    public CustomerEntity convertCreate(CustomerDTO customerDTO) {

        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setUsername(customerDTO.getUserName());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setIdentity(customerDTO.getIdentity());
        customerEntity.setGender(customerDTO.getGender());
        customerEntity.setPassword(customerDTO.getPassword());
        customerEntity.setCreatedAt(new Date());
        customerEntity.setCreatedBy("Taha KILIÇ");

        CustomerAddressEntity customerAddressEntity=new CustomerAddressEntity();
        customerAddressEntity.setCity(customerDTO.getCustomerAddress().getCity());
        customerAddressEntity.setPhoneNumber(customerDTO.getCustomerAddress().getPhoneNumber());
        customerAddressEntity.setCountry(customerDTO.getCustomerAddress().getCountry());
        customerAddressEntity.setPostalCode(customerDTO.getCustomerAddress().getPostalCode());
        customerAddressEntity.setDescription(customerDTO.getCustomerAddress().getDescription());

        customerAddressEntity.setCustomer(customerEntity);              //Bu bölümde oluşturduğumuz nesneleri bir birine setledik.
        customerEntity.setCustomerAddress(customerAddressEntity);       //Bu işlem ilişkide kimin neye bağlı olduğunu belirliyor.
                                                                        //Yapılmasaydı tabloda bağlantı kurulmayacaktı. Sütun olacak ama null olarak atanacaktı.
        customerEntity.setIsDeleted(false);
        return customerEntity;
    }

    @Override
    public CustomerResponse convertGetById(CustomerEntity customerEntity) {
        CustomerResponse customerResponse=new CustomerResponse();
        customerResponse.setUsername(customerEntity.getUsername());
        customerResponse.setEmail(customerEntity.getEmail());
        customerResponse.setGender(customerEntity.getGender());

        CustomerAddressDTO customerAddressDTO= new CustomerAddressDTO();
        customerAddressDTO.setCity(customerEntity.getCustomerAddress().getCity());
        customerAddressDTO.setCountry(customerEntity.getCustomerAddress().getCountry());
        customerAddressDTO.setPhoneNumber(customerEntity.getCustomerAddress().getPhoneNumber());
        customerAddressDTO.setDescription(customerEntity.getCustomerAddress().getDescription());
        customerAddressDTO.setPostalCode(customerEntity.getCustomerAddress().getPostalCode());

        customerResponse.setCustomerAddress(customerAddressDTO);
        return customerResponse;
    }

    @Override
    public CustomerEntity convertUpdate(CustomerEntity customerEntity, CustomerDTO customerDTO) {
        customerEntity.setUsername(customerDTO.getUserName());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setIdentity(customerDTO.getIdentity());
        customerEntity.setGender(customerDTO.getGender());
        customerEntity.setPassword(customerDTO.getPassword());

        customerEntity.setCustomerAddress(convertCustomerAddressEntity(customerDTO.getCustomerAddress()));

        customerEntity.setUpdatedAt(new Date());
        customerEntity.setUpdatedBy("Zeynep Sıla");

        return customerEntity;
    }



    @Override
    public List<CustomerResponse> convertGetAll(List<CustomerEntity> allCustomer) {
        List<CustomerResponse> customerResponses=new ArrayList<>();

        for (CustomerEntity customer:allCustomer){
            CustomerResponse customerResponse=new CustomerResponse();
            customerResponse.setUsername(customer.getUsername());
            customerResponse.setEmail(customer.getEmail());
            customerResponse.setGender(customer.getGender());
            customerResponse.setCustomerAddress(convertCustomerAddressResponse(customer.getCustomerAddress()));
            customerResponses.add(customerResponse);
        }
        return customerResponses;
    }


    public CustomerAddressEntity convertCustomerAddressEntity(CustomerAddressEntity customerAddress){
        CustomerAddressEntity customerAddressEntity=new CustomerAddressEntity();
        customerAddressEntity.setCity(customerAddress.getCity());
        customerAddressEntity.setPhoneNumber(customerAddress.getPhoneNumber());
        customerAddressEntity.setCountry(customerAddress.getCountry());
        customerAddressEntity.setPostalCode(customerAddress.getPostalCode());
        customerAddressEntity.setDescription(customerAddress.getDescription());
        return customerAddressEntity;
    }

    public CustomerAddressDTO convertCustomerAddressResponse(CustomerAddressEntity customerAddressEntity){
        CustomerAddressDTO customerAddressDTO=new CustomerAddressDTO();
        customerAddressDTO.setPostalCode(customerAddressEntity.getPostalCode());
        customerAddressDTO.setDescription(customerAddressEntity.getDescription());
        customerAddressDTO.setCountry(customerAddressEntity.getCountry());
        customerAddressDTO.setCity(customerAddressEntity.getCity());
        customerAddressDTO.setPhoneNumber(customerAddressEntity.getPhoneNumber());
        return customerAddressDTO;
    }
}
