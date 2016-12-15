package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import mybatis.model.ModelBook;

@Repository("daobook")
public class DaoBook implements IDaoBook {
    
    /*------------------- getter & setter -------------------*/
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

    /*------------------- constructor -------------------*/
    public DaoBook() {
        super();
    }

    /*------------------- method -------------------*/
    @Override
    public List<ModelBook> getSQLSelectAll() {
        return session.selectList("mybatis.mapper.mapperBook.getSQLSelectAll");
    }

    @Override
    public List<ModelBook> getSQLSelectLike(String bookname) {
        bookname = StringUtils.isEmpty(bookname) ? null : "%" + bookname + "%" ;
        return session.selectList("mybatis.mapper.mapperBook.getSQLSelectLike", bookname );
    }

    @Override
    public List<ModelBook> getSQLSelectEqual(String bookname) {
        return session.selectList("mybatis.mapper.mapperBook.getSQLSelectEqual", bookname );
    }

    @Override
    public int setSQLInsert(ModelBook book) {
        return session.insert("mybatis.mapper.mapperBook.setSQLInsert", book);        
    }

    @Override
    public int setSQLInsertMulti(List<ModelBook> books) {
        return session.insert("mybatis.mapper.mapperBook.setSQLInsertMulti", books);        
    }

    @Override
    public int setSQLInsertSequence(String bookname,
            String publisher, String year, int price, String dtm,
            boolean use_yn, int authid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setSQLUpdate(ModelBook updateValue, ModelBook searchValue) {
        Map<String, ModelBook> parameter = new HashMap<String, ModelBook>();
        parameter.put("updateValue"       , updateValue  );
        parameter.put("searchValue"       , searchValue  );
      
        return session.update("mybatis.mapper.mapperBook.setSQLUpdate", parameter);
    }

    @Override
    public int setSQLDelete(ModelBook book) {
        // TODO Auto-generated method stub
        return 0;
    }    
    
}