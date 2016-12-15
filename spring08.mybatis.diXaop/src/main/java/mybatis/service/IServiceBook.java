package mybatis.service;

import java.util.List;

import mybatis.model.ModelBook;

public interface IServiceBook {

    public List<ModelBook> getSQLSelectAll() ;
     
    public List<ModelBook> getSQLSelectLike(String expr) ;

    public List<ModelBook> getSQLSelectEqual(String expr) ;

    public int setSQLInsert(ModelBook book) ;
    
    public int setSQLInsertMulti(List<ModelBook> books);

    public int setSQLUpdate(ModelBook updateValue, ModelBook searchValue) ;

    public int setSQLDelete(String bookname) ;
    
    public int setTransCommit(ModelBook delBook, 
            ModelBook insBook, 
            ModelBook updBook, 
            ModelBook searchBook) ;

    public int setTransRollback(ModelBook delBook, 
            ModelBook insBook, 
            ModelBook updBook, 
            ModelBook searchBook);
   
}
