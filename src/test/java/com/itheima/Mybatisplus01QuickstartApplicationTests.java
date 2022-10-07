package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        List<User> users = userDao.selectList(null);
        System.out.println(users);
        System.out.println("nihaoa");
        System.out.println("123456789");
        System.out.println("master test");

    }

    @Test
    void testInsert(){
        User user = new User();
        user.setName("黑马程序员");
        user.setAge(15);
        user.setPassword("123");
        user.setTel("18884445555");
        userDao.insert(user);
    }

    @Test
    void testPage(){
        IPage page = new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("每页条数："+page.getSize());
        System.out.println("总页数："+page.getPages());
        System.out.println("数据总量："+page.getTotal());
        System.out.println("当前页数据："+page.getRecords());
    }

//    条件查询
    @Test
    void testGetById(){
//        第一种方法， age容易写错
//        QueryWrapper<User> qw = new QueryWrapper<User>();
//        qw.lt("age",13);
//        List<User> users = userDao.selectList(qw);
//        System.out.println(users);

//        方式二，lambda格式按条件查询
//        QueryWrapper<User> qw = new QueryWrapper<>();
//        qw.lambda().lt(User::getAge,12);
//        List<User> users = userDao.selectList(qw);
//        System.out.println(users);

//        方式三，lambda格式按条件查询
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.lt(User::getAge,4).or().gt(User::getAge,10);
        List<User> users = userDao.selectList(qw);
        System.out.println(users);

    }

}
