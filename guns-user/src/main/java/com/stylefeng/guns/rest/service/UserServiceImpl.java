package com.stylefeng.guns.rest.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.UserMapper;
import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.request.RequestUser;
import com.stylefeng.guns.rest.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean register(RequestUser requestUser) {

        String password = MD5Utils.getMD5(requestUser.getPassword());
        requestUser.setPassword(password);

        int i = userMapper.insertUser(requestUser);
        return i == 1;
    }

    /**
     * 通过用户名检查用户是否存在
     *
     * @param username
     * @return
     */
    @Override
    public boolean checkUser(String username) {

        UserBO userByUsername = userMapper.selectUserByUsername(username);
        return userByUsername == null;
    }

    /**
     * 通过用户名和密码查找用户是否存在
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean findUser(String username, String password) {
        UserBO userBO = userMapper.selectUserByUsernameAndPassword(username, password);
        return userBO != null;
    }
}
