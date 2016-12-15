package mybatis.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.model.*;
import mybatis.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Sorts by method name
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUser {

    private static Logger logger = LoggerFactory.getLogger( TestServiceUser.class );
    
    //private static SqlSession session = null;
    private static ApplicationContext context = null;
    private static IServiceUser service = null;

    Date from = new Date();
    SimpleDateFormat tf = new SimpleDateFormat("yyMMddhhmmss");
    String dtm = tf.format(from);

    String userid = "MISS A" + dtm;
    
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service = context.getBean("serviceuser", IServiceUser.class);
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //((ClassPathXmlApplicationContext)context).close();
    }
    

    @Test
    public void testInsertUser() {
        ModelUser user = new ModelUser();
        user.setUserid( this.userid );
        user.setEmail("missa@naver.com");
        user.setMobile("010-3214-6879");
        user.setInsertDT(from);
        user.setInsertUID("ufy uygyu");
        user.setName("miss");
        user.setPasswd("miss1234");
        user.setUpdateDT(from);
        user.setUpdateUID("uytf yui");
        
        //IServiceUser service = new ServiceUser(session);
        int result = service.insertUser(user);
        
        assertEquals(result, 1);
    }

    @Test
    public void testLogin() {
        ModelUser user = new ModelUser();
        user.setUserid( this.userid );
        user.setPasswd("miss1234");
        //IServiceUser service = new ServiceUser(session);
        ModelUser result = service.login(user);
        
        assertNotNull(result);
        assertEquals(result.getUserid(), this.userid );
    }

    @Test
    public void testLogout() {
    }

    @Test
    public void testupdateUserInfo() {
        ModelUser updatevalue = new ModelUser();
        updatevalue.setEmail("sonyo@hanmail.net");
        updatevalue.setMobile("010-5555-6666");
        updatevalue.setName("98g uhu ihuu");
        updatevalue.setRetireYN(true);
        updatevalue.setPasswd("girls8888");
        updatevalue.setUpdateDT(from);
        updatevalue.setUpdateUID("JYP");
        
        ModelUser searchvalue = new ModelUser();
        searchvalue.setUserid( this.userid ); 
        
        //IServiceUser service = new ServiceUser(session);
        int result = service.updateUserInfo(updatevalue, searchvalue);
        
        assertEquals(result, 1);
    }

    @Test
    public void testupdatePasswd() {
        ModelUser user = new ModelUser();
        user.setPasswd("uuji");
        user.setUserid( this.userid ); 
        
        //IServiceUser service = new ServiceUser(session);
        int result = service.updatePasswd(user);
        
        assertEquals(result, 1);
    }

    @Test
    public void testDeleteUser() {
        ModelUser searchvalue = new ModelUser();
        searchvalue.setUserid("MISS A"); 
        
        //IServiceUser service = new ServiceUser(session);
        int result = service.deleteUser(searchvalue);
        
        assertEquals(result, 1);
    }

    @Test
    public void testSelectUserOne() {
        ModelUser user = new ModelUser();
        user.setUserno(1);

		//IServiceUser service = new ServiceUser(session);
        ModelUser result = service.selectUserOne(user);
        
        assertEquals(result.getUserid(), "MISS A");
    }

    @Test
    public void testSelectUserList() {
        
        ModelUser user = new ModelUser();
        user.setName("miss");

        //IServiceUser service = new ServiceUser(session);
        List<ModelUser> result = service.selectUserList(user); 
        assertNotNull( result );
        assertTrue( result.size() > 1 );
    }
    
}
