/*


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sub.dbtable.pojo.Book;
import com.sub.dbtable.router.DbContextHolder;
import com.sub.dbtable.service.BookService;
import com.sub.dbtable.util.GsonUtils;

*//**
 * Created by supers on 2017/3/9.
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "classpath:spring/applicationContext_dao.xml"

})
public class Test {

    @Autowired
    private BookService userService;

    *//**
     * @Description 测试分库分表插入
     * @Autohr supers【weChat:13031016567】
     *//*
    @org.junit.Test
    public void testInsertUser(){
       Book book =new Book();
       book.setName("10");
       book.setPrice("22广告");
       book.setSummary("gg");
       book.setDescription("gg");
        int re = userService.insertBook(book);
        System.out.println(DbContextHolder.getDb()+"库 "+DbContextHolder.getTableIdx()+"表 的插入结果:"+GsonUtils.toJson(re));
    }
    @org.junit.Test
    public void testGetBook(){
       Book book =new Book();
       book.setName("gagag");
       Book book2 = userService.selectByBookName(book);
        System.out.println(DbContextHolder.getDb()+"库 "+DbContextHolder.getTableIdx()+"表 的查询结果:"+GsonUtils.toJson(book2));
    }

   
}
*/