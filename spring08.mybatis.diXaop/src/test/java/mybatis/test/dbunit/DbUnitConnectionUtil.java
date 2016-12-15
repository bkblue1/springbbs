package mybatis.test.dbunit;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;

public class DbUnitConnectionUtil {

    public static IDatabaseConnection getConnection(String dirver, String url, String user, String password)
            throws ClassNotFoundException, SQLException, DatabaseUnitException {
        
        Class.forName( dirver );
        
        return new DatabaseConnection(DriverManager.getConnection( url, user, password) );
    }

}