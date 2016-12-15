package mybatis.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import mybatis.dao.*;
import mybatis.model.*;

@Service("servicebook")
public class ServiceBook implements IServiceBook {

    private static Logger logger = LoggerFactory.getLogger(ServiceBook.class);
    
    @Autowired
    @Qualifier("daobook")
    private IDaoBook dao;
    
    public ServiceBook() {
        super();
    }
    
    
    /*------------------- method -------------------*/
    @Override
    public List<ModelBook> getSQLSelectAll() {
        
        List<ModelBook> result = null;
        try {
            result = dao.getSQLSelectAll();
        } catch (Exception e) {
            logger.error("getSQLSelectAll " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<ModelBook> getSQLSelectLike(String expr) {
        List<ModelBook> result = null;
        try {
            result = dao.getSQLSelectLike(expr);
        } catch (Exception e) {
            logger.error("getSQLSelectLike " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<ModelBook> getSQLSelectEqual(String expr) {
        List<ModelBook> result = null;
        try {
            result = dao.getSQLSelectEqual(expr);
        } catch (Exception e) {
            logger.error("getSQLSelectEqual " + e.getMessage() );
        }
                
        return result;
    }

    @Override
    public int setSQLInsert(ModelBook book) {
        int result = -1;
        try {
            result = dao.setSQLInsert(book);
        } catch (Exception e) {
            logger.error("setSQLInsert " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int setSQLInsertMulti(List<ModelBook> books) {
        int result = 0;
        try {
            for(int i=0; i<books.size(); i=i+1) {
                result += dao.setSQLInsert(books.get(i));
            }
        } catch (Exception e) {
            logger.error("setSQLInsert " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int setSQLUpdate(ModelBook updateValue, ModelBook searchValue) {
        int result = -1;
        try {
            result = dao.setSQLUpdate(updateValue, searchValue);
        } catch (Exception e) {
            logger.error("setSQLUpdate " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int setSQLDelete(String bookname) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setTransCommit(ModelBook delBook, 
            ModelBook insBook, 
            ModelBook updBook, 
            ModelBook searchBook) {
        int result = -1;
        
        try {
            dao.setSQLDelete(delBook);
            dao.setSQLInsert(insBook);
            dao.setSQLUpdate(updBook, searchBook);
            
            result = 1;
        } catch (Exception e) {
            logger.error("setTransCommit " + e.getMessage() );
        }
      
        return result;
    }

    @Override
    public int setTransRollback(ModelBook delBook, 
            ModelBook insBook, 
            ModelBook updBook, 
            ModelBook searchBook) {
        int result = -1;
        
        try {
            dao.setSQLDelete(delBook);
            dao.setSQLInsert(insBook);
            dao.setSQLUpdate(updBook, searchBook);

            result = 1;
            
            throw new Exception("rollback test");
            
        } catch (Exception e) {
            logger.error("setTransCommit " + e.getMessage() );
            result = -1;
        }
      
        return result;
    }

}