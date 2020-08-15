package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.User;
import com.famethe.payroll.payroll.repository.CompanyRepository;
import com.famethe.payroll.payroll.repository.UserRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserFactory {

    User user = null;

    @Resource
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    public User getUser(Map<String, Object> values){
        if (values.get("id") == null){
            user = new User();
        }else{
            user = userRepository.findById((Integer)values.get("id")).get();
        }
        user.setActive(true);
        user.setLoginTries(0);
        user.setUsername((String) values.get("username"));
        user.setPassword(bcryptEncoder.encode((String) values.get("password")));
        user.setEmail((String) values.get("email"));

        return user;
    }

}
