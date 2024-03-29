package mybatis.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.dao.*;
import mybatis.model.*;

@Service("serviceuser")
public class ServiceUser implements IServiceUser {
    
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);

    @Autowired
    @Qualifier("daouser")
    private IDaoUser daouser;

    public ServiceUser() {
        super();
    }

    @Override
    public int insertUser(ModelUser user) {
        
        int result = -1;
        try {
            result = daouser.insertUser(user);
            //session.commit();
        } catch (Exception e) {
            logger.error("insertUser " + e.getMessage() );
        }
		
        return result;
    }

    @Override
    public ModelUser login(ModelUser user) {
        
        ModelUser result = null;
		
        try {
            result = daouser.login(user);
        } catch (Exception e) {
            logger.error("login " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser updateValue, ModelUser searchValue) {
        int result = -1;
        try {
            result = daouser.updateUserInfo(updateValue, searchValue);
        } catch (Exception e) {
            logger.error("updateUserInfo" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int updatePasswd(ModelUser user) {
        int result = -1;
        try {
            result = daouser.updatePasswd(user);
        } catch (Exception e) {
            logger.error("updateUserInfo" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int deleteUser(ModelUser searchValue) {
        int result = -1;
        try {
            result = daouser.deleteUser(searchValue);
        } catch (Exception e) {
            logger.error("updateUserInfo " + e.getMessage() );
        }
        return result;
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        ModelUser result = null;
        try {
            result = daouser.selectUserOne(user);
        } catch (Exception e) {
            logger.error("selectUserOne " + e.getMessage() );
        }
        return result;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        List<ModelUser> result = null;
        try {
            result = daouser.selectUserList(user);
        } catch (Exception e) {
            logger.error("selectUserList " + e.getMessage() );
        }
        return result;
    }
}
