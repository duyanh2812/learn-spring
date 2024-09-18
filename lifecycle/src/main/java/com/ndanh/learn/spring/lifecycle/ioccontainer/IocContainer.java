package com.ndanh.learn.spring.lifecycle.ioccontainer;

class DataSource{

}
class UserDao{
    private DataSource dataSource;
    public UserDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
}

class UserService{
    private UserDao userDao;
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }
}
public class IocContainer {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        UserDao userDao = new UserDao(dataSource);
        UserService userService = new UserService(userDao);
    }
}
