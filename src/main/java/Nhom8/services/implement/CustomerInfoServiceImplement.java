package Nhom8.services.implement;

import Nhom8.models.CustomerInfo;
import Nhom8.models.User;
import Nhom8.services.CustomerInfoService;
import Nhom8.repositories.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CustomerInfoServiceImplement implements CustomerInfoService {

    @Autowired
    CustomerInfoRepository customerInfoRepository;

    @Override
    public CustomerInfo findByUser(User user) {
        return customerInfoRepository.findByUser(user);
    }

    @Override
    public CustomerInfo findByEmail(String email) {
        return customerInfoRepository.findByEmail(email);
    }

    @Override
    public List<CustomerInfo> findAll() {
        return customerInfoRepository.findAll();
    }

    @Override
    public CustomerInfo findCustomerInfoByUserID(Integer id) {
        return customerInfoRepository.getById(id);
    }

    @Override
    public void saveInfo(CustomerInfo info) {
        customerInfoRepository.save(info);
    }

    @Override
    public void deletInfoById(Integer id) {
        customerInfoRepository.deleteById(id);
    }

    @Override
    public Page<CustomerInfo> pagingCustomerInfo(int offset, int pagesize) {
        return customerInfoRepository.findAll(PageRequest.of(offset, pagesize, Sort.by("id").descending()));
    }

    @Override
    public CustomerInfo getByID(Integer id) {
        return customerInfoRepository.getById(id);
    }
}
