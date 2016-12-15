package mybatis.test.dbunit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.operation.DatabaseOperation;

public class SeedDataLoader {
    
    private java.sql.Connection conn = null;
    
    private String driver;
    private String url   ;
    private String username  ; 
    private String password;

    public SeedDataLoader(java.sql.Connection conn) {
        super();
        this.conn = conn;
        java.sql.DatabaseMetaData prop = null;
        try {
            prop = conn.getMetaData();            

            this.driver   = "oracle.jdbc.OracleDriver";
            this.url      = prop.getURL();
            this.username = prop.getUserName();
            this.password = "1234";
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SeedDataLoader(String dirver, String url, String username, String password) {
        super();
        this.driver = dirver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void loadIntegrationTestDataSeed() {
        loadData("src/test/resources/inttest-seed-data.xml");
    }

    public void loadData(String seedFile) {
              
        IDatabaseConnection conn = null;
        
        try {
            String userName = this.conn.getMetaData().getUserName();
            
            conn = DbUnitConnectionUtil.getConnection(this.driver, this.url, this.username, this.password);
            IDataSet data = createDataSet(seedFile);
            conn.getConfig().setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, false);
            conn.getConfig().setProperty(DatabaseConfig.FEATURE_SKIP_ORACLE_RECYCLEBIN_TABLES, true);
           
            
            if (userName != null) {  
                conn = new DatabaseConnection(this.conn, userName);  
            } 
            else {  
                conn = new DatabaseConnection(this.conn);  
            } 

            DatabaseOperation.CLEAN_INSERT.execute(conn, data);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            close(conn);
        }
    }

    private static IDataSet createDataSet(String seedFile)
            throws DataSetException, FileNotFoundException {
        return new XmlDataSet(new FileReader(seedFile));
    }

    private static void close(IDatabaseConnection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
}


