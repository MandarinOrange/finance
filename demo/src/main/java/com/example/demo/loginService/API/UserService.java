package com.example.demo.loginService.API;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserService {
    public User selectUserByuserName(String userName);
    public User selectUserBytelephoneNum(String telephoneNum);
    public void insertUser(long userNum, String userName, String userPwd, String registerTime, String userRight);
    public long count();
}
