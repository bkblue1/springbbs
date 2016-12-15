package mybatis.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import mybatis.dao.*;
import mybatis.model.*;

@Service("serviceboard")
public class ServiceBoard implements IServiceBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class);
    
    @Autowired
    @Qualifier("daoboard")
    private IDaoBoard daoboard;
    
    public ServiceBoard() {
        super();
    }

    @Override
    public String getBoardName(String boardcd) {
        
        String result = null;
        try {
            result = daoboard.getBoardName(boardcd);
        } catch (Exception e) {
            logger.error("getBoardName " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        ModelBoard result = null;
        try {
            result = daoboard.getBoardOne(boardcd);
        } catch (Exception e) {
            logger.error("getBoardOne " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<ModelBoard> getBoardList() {
        List<ModelBoard> result = null;
        try {
            result = daoboard.getBoardList();
        } catch (Exception e) {
            logger.error("getBoardOne " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        Map<String, ModelBoard> result = null;
        try {
            result = daoboard.getBoardListResultMap();
        } catch (Exception e) {
            logger.error("getBoardOne " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertBoard(ModelBoard board) {
        
        int result = -1;
        try {
            result = daoboard.insertBoard(board);
        } catch (Exception e) {
            logger.error("insertBoard " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateBoard(ModelBoard updateBoard, ModelBoard searchBoard) {
        
        int result = -1;
        try {
            result = daoboard.updateBoard(updateBoard, searchBoard);
        } catch (Exception e) {
            logger.error("updateBoard" + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteBoard(ModelBoard board) {
        int result = -1;
        try {
            result = daoboard.deleteBoard(board);
        } catch (Exception e) {
            logger.error("deleteBoard" + e.getMessage());
        }
        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        
        List<ModelBoard> result = null;
        try {
            result = daoboard.getBoardSearch(board);
        } catch (Exception e) {
            logger.error("getBoardOne " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end) {
        
        List<ModelBoard> result = null;
        try {
            result = daoboard.getBoardPaging(boardcd, searchWord, start, end);
        } catch (Exception e) {
            logger.error("getBoardPaging  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        int result = -1;
        try {
            result = daoboard.insertBoardList(list);
            //session.commit();
        } catch (Exception e) {
            logger.error("insertBoardList" + e.getMessage() );
            //session.rollback();
        }
        
        return result;
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        int result = 0;
        try {
            result = daoboard.getArticleTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            logger.error("getArticleTotalRecord  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardCd, String searchWord, int start, int end) {
        
        List<ModelArticle> result = null;
        try {
            result = daoboard.getArticleList(boardCd, searchWord, start, end);
        } catch (Exception e) {
            logger.error("getArticleList  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle getArticle(int articleNo) {
        ModelArticle result = null;
        try {
                     daoboard.increaseHit( articleNo );
            result = daoboard.getArticle ( articleNo );
        } catch (Exception e) {
            logger.error("getArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertArticle(ModelArticle article) {
        int result = -1;
        try {
            result = daoboard.insertArticle(article);
        } catch (Exception e) {
            logger.error("insertArticle " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateArticle(ModelArticle updateValue, ModelArticle searchValue) {
        
        int result = -1;
        try {
            result = daoboard.updateArticle(updateValue, searchValue);
        } catch (Exception e) {
            logger.error("updateArticle " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteArticle(ModelArticle article) {
        int result = -1;
        try {
            result = daoboard.deleteArticle(article);
        } catch (Exception e) {
            logger.error("deleteArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int increaseHit(int articleNo) {
        int result = -1;
        try {
            result = daoboard.increaseHit(articleNo);
        } catch (Exception e) {
            logger.error("increaseHit  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle getNextArticle(int articleNo, String boardCd, String searchWord) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardCd"   , boardCd    );
        map.put("articleNo" , articleNo  );
        map.put("searchWord", searchWord );
        
        ModelArticle result = null;
        try {
            result = daoboard.getNextArticle( map );
        } catch (Exception e) {
            logger.error("getNextArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle getPrevArticle(int articleNo, String boardCd, String searchWord) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardCd"   , boardCd    );
        map.put("articleNo" , articleNo  );
        map.put("searchWord", searchWord );
        
        ModelArticle result = null;
        try {
            result = daoboard.getPrevArticle( map );
        } catch (Exception e) {
            logger.error("getPrevArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelAttachfile getAttachFile(int attachFileNo) {
        ModelAttachfile result = null;
        try {
            result = daoboard.getAttachFile( attachFileNo );
        } catch (Exception e) {
            logger.error("getAttachFile  " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public List<ModelAttachfile> getAttachFileList(int articleNo) {
        List<ModelAttachfile> result = null;
        try {
            result = daoboard.getAttachFileList( articleNo );
        } catch (Exception e) {
            logger.error("getAttachFileList  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
        int result = -1;
        try {
            result = daoboard.insertAttachFile(attachFile);
        } catch (Exception e) {
            logger.error("insertAttachFile " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteAttachFile(ModelAttachfile attachFile) {
        int result = -1;
        try {
            result = daoboard.deleteAttachFile(attachFile);
        } catch (Exception e) {
            logger.error("deleteAttachFile " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelComments getComment(int commentNo) {
        ModelComments result = null;
        try {
            result = daoboard.getComment( commentNo );
        } catch (Exception e) {
            logger.error("getComment  " + e.getMessage() );
        }
        
        return result;
    }


    @Override
    public List<ModelComments> getCommentList(int articleNo) {
        List<ModelComments>  result = null;
        try {
            result = daoboard.getCommentList( articleNo );
        } catch (Exception e) {
            logger.error("getCommentList  " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public int insertComment(ModelComments comment) {
        int result = -1;
        try {
            result = daoboard.insertComment(comment);
        } catch (Exception e) {
            logger.error("insertComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
        int result = -1;
        try {
            result = daoboard.updateComment( updateValue, searchValue );
        } catch (Exception e) {
            logger.error("updateComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteComment(ModelComments comment) {
        int result = -1;
        try {
            result = daoboard.deleteComment( comment );
        } catch (Exception e) {
            logger.error("deleteComment " + e.getMessage() );
        }
        
        return result;
    }
}
