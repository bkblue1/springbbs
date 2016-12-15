package mybatis.test;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

import mybatis.model.*;
import mybatis.service.*;

//Sorts by method name
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceBook {

    private static Logger logger = LoggerFactory.getLogger( TestServiceUser.class );

    //private static SqlSession session = null;
    private static ApplicationContext context = null;
    private static IServiceBook service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service = context.getBean("servicebook", IServiceBook.class);  
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //((ClassPathXmlApplicationContext)context).close();
    }
    
    @Test
    public void testGetSQLSelectAll() {
        //IServiceBook service = new ServiceBook(session);
        List<ModelBook> result = service.getSQLSelectAll();        
        assertSame(result.size(), 14);
    }
    
    @Test
    public void testGetSQLSelectLike() {
        //IServiceBook service = new ServiceBook(session);
        List<ModelBook> result = service.getSQLSelectLike("SQL");        
        assertSame(result.size(), 2);
    }
    
    @Test
    public void testGetSQLSelectEqual() {
        //IServiceBook service = new ServiceBook(session);
        List<ModelBook> result = service.getSQLSelectEqual("First SQL");        
        assertSame(result.size(), 1);
    }
    
    @Test
    public void testSetSQLInsert() {
        
        ModelBook book = new ModelBook();
        book.setAuthid(10);
        book.setBookname("test");
        book.setDtm("2016-11-12");
        book.setPrice(10000);
        book.setPublisher("내가");
        book.setUse_yn(true);
        book.setYear("2016");
        
        //IServiceBook service = new ServiceBook(session);
        int result = service.setSQLInsert(book);        
        assertSame(result, 1);
    }
    
    @Test
    public void testSetSQLUpdateWith_Bookid() {
        
        ModelBook updateValue = new ModelBook();
        updateValue.setAuthid(10);
        updateValue.setBookname("test");
        updateValue.setDtm("2016-11-12");
        updateValue.setPrice(10000);
        updateValue.setPublisher("내가");
        updateValue.setUse_yn(true);
        updateValue.setYear("2016");
        

        ModelBook searchValue = new ModelBook();
        searchValue.setBookid(2);
        
        //IServiceBook service = new ServiceBook(session);
        int result = service.setSQLUpdate(updateValue, searchValue);        
        assertSame(result, 1);
    }
    
    @Test
    public void testSetSQLUpdateWith_BookidAndBookname() {
        
        ModelBook updateValue = new ModelBook();
        updateValue.setAuthid(10);
        updateValue.setBookname("test");
        updateValue.setDtm("2016-11-12");
        updateValue.setPrice(10000);
        updateValue.setPublisher("내가");
        updateValue.setUse_yn(true);
        updateValue.setYear("2016");
        

        ModelBook searchValue = new ModelBook();
        searchValue.setBookid(3);
        searchValue.setBookname("JAVA");
        
        //IServiceBook service = new ServiceBook(session);
        int result = service.setSQLUpdate(updateValue, searchValue);        
        assertSame(result, 1);
    }
    
    @Test
    public void testSetSQLDeleteWith_Bookid() {
        
        ModelBook updateValue = new ModelBook();
        updateValue.setAuthid(10);
        updateValue.setBookname("test");
        updateValue.setDtm("2016-11-12");
        updateValue.setPrice(10000);
        updateValue.setPublisher("내가");
        updateValue.setUse_yn(true);
        updateValue.setYear("2016");
        

        ModelBook searchValue = new ModelBook();
        searchValue.setBookid(2);
        
        //IServiceBook service = new ServiceBook(session);
        int result = service.setSQLUpdate(updateValue, searchValue);        
        assertSame(result, 1);
    }
    

    
    @Test
    public void testSetTransCommit() {

        ModelBook delBook = new ModelBook();
        delBook.setBookid(1);
        
        ModelBook insBook = new ModelBook();
        insBook.setAuthid(10);
        insBook.setBookname("trans test insert");
        insBook.setDtm("2016-11-12");
        insBook.setPrice(10000);
        insBook.setPublisher("trans test insert");
        insBook.setUse_yn(true);
        insBook.setYear("2016");        
        
        ModelBook updBook = new ModelBook();
        updBook.setAuthid(10);
        updBook.setBookname("trans test update");
        updBook.setDtm("2016-11-12");
        updBook.setPrice(10000);
        updBook.setPublisher("trans test update");
        updBook.setUse_yn(true);
        updBook.setYear("2016");        

        ModelBook searchBook = new ModelBook();
        searchBook.setBookid(2);
        
        //IServiceBook service = new ServiceBook(session);
        int result = service.setTransCommit(delBook, insBook, updBook, searchBook);      
        assertSame(result, 1);
    }
    
    @Test
    public void testSetTransRollback() {

        ModelBook delBook = new ModelBook();
        delBook.setBookid(1);
        
        ModelBook insBook = new ModelBook();
        insBook.setAuthid(10);
        insBook.setBookname("trans test insert");
        insBook.setDtm("2016-11-12");
        insBook.setPrice(10000);
        insBook.setPublisher("trans test insert");
        insBook.setUse_yn(true);
        insBook.setYear("2016");        
        
        ModelBook updBook = new ModelBook();
        updBook.setAuthid(10);
        updBook.setBookname("trans test update");
        updBook.setDtm("2016-11-12");
        updBook.setPrice(10000);
        updBook.setPublisher("trans test update");
        updBook.setUse_yn(true);
        updBook.setYear("2016");        

        ModelBook searchBook = new ModelBook();
        searchBook.setBookid(2);
        
        //IServiceBook service = new ServiceBook(session);
        int result = service.setTransRollback(delBook, insBook, updBook, searchBook);      
        assertSame(result, -1);
    }
    
    @Test
    public void testSetSQLInsertMulti() {
        
        List<ModelBook> books = new ArrayList<ModelBook>();
        
        for( int i=0; i< 10; i=i+1 ){
        
            ModelBook book = new ModelBook();
            book.setAuthid(10);
            book.setBookname("insert multi " + i );
            book.setDtm("2016-11-12");
            book.setPrice(1000);
            book.setPublisher("insert multi " + i );
            book.setUse_yn(true);
            book.setYear("2016");
            
            books.add( book );            
        }
        
        //IServiceBook service = new ServiceBook(session);
        int result = service.setSQLInsertMulti(books);        
        assertSame(result, 10);
    }
}
