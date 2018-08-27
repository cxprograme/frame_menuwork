package com.cx.hslib.service.serviceImp;

import com.cx.hslib.dao.UserDao;
import com.cx.hslib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/8/27.
 */
@Component
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public List<Map<String, Object>> getUserInfo(Map<String, Object> attribute) {
        return userDao.getUserInfo(attribute);
    }

    @Override
    public int insertUserInfo(Map<String, Object> formAttribute) {
        return userDao.insertUserInfo(formAttribute);
    }
}
