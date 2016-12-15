package mybatis.test;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

import java.io.IOException;
import java.net.*;

import mybatis.service.*;

import org.junit.runners.MethodSorters;

//Sorts by method name
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPath {
    private static ApplicationContext context = null;
    private static IServiceBoard board  = null;
    
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        board   = context.getBean(IServiceBoard.class); 
//
//        javax.sql.DataSource dataSource = sqlMapper.getConfiguration().getEnvironment().getDataSource();
//        java.sql.Connection conn = dataSource.getConnection();
//        java.sql.DatabaseMetaData prop = conn.getMetaData();
//        
//        String  driver   = "oracle.jdbc.OracleDriver";
//        String  url      = prop.getURL();
//        String  username = prop.getUserName();
//        String  password = "1234";
//
//        new SeedDataLoader(conn).loadIntegrationTestDataSeed();
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //((ClassPathXmlApplicationContext)context).close();
    }
    
    @Test
    public void testGetClassPath ( ) {

        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            System.out.println(url.getFile());
        }
    }

    @Test
    public void testGetClassPath2( ) {

        String classpath = System.getProperty("java.class.path");
        String[] classpathEntries = classpath.split(File.pathSeparator);

        for(String url: classpathEntries){
            System.out.println( url );
        }
    }

    @Test
    public void testGetResourcePath( ) throws IOException {

//        File folder = new ClassPathResource("sql").getFile();
//        File[] listOfFiles = folder.listFiles();

        File inputXmlFile = new File(this.getClass().getResource("Configuration.xml").getFile());
        System.out.println(inputXmlFile.getAbsolutePath());


        ClassLoader classLoader = getClass().getClassLoader();
        String str = classLoader.getResource("/Configuration.xml").getFile();
        System.out.println( str );
        //File file = new File(classLoader.getResource("/Configuration.xml").getFile());
        //System.out.println(file.getAbsolutePath());
    }    
    
}
