package net.blover.website.user.service;

import net.blover.website.user.dao.UserDao;
import net.blover.website.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getById(String id) {
        return userDao.getById(id);
    }


}
