package mybatis.service;

import java.util.List;

import mybatis.model.ModelUser;

public interface IServiceUser {
    
    int insertUser(ModelUser user);

    ModelUser login(ModelUser user );

    int logout(String userid);

    int updateUserInfo(ModelUser updateValue, ModelUser searchValue);

    int updatePasswd(ModelUser user);

    int deleteUser(ModelUser user);

    ModelUser selectUserOne(ModelUser user);

    List<ModelUser> selectUserList(ModelUser user);
    
}
