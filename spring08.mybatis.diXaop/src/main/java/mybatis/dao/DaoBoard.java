package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;

@Repository("daoboard")
public class DaoBoard implements IDaoBoard {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;    
    public SqlSession getSession() { return session; }
    public void setSession(SqlSession session) { this.session = session; }

    public DaoBoard() {
        super();
    }
    public DaoBoard(SqlSession session) {
        super();
        this.session = session;
    }

    @Override
    public int getBoardTotalRecord(HashMap<String, String> hashmap) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getBoardName(String boardcd) {
        return  session.selectOne("mybatis.mapper.mapperBoard.getBoardName", boardcd);        
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        return  session.selectOne("mybatis.mapper.mapperBoard.getBoardOne", boardcd);        
    }

    @Override
    public List<ModelBoard> getBoardList() {
        return  session.selectList("mybatis.mapper.mapperBoard.getBoardList");        
    }

    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        return  session.selectMap("mybatis.mapper.mapperBoard.getBoardListResultMap", "boardcd");        
    }

    @Override
    public int insertBoard(ModelBoard board) {
        return  session.insert("mybatis.mapper.mapperBoard.insertBoard", board);        
    }

    @Override
    public int updateBoard(ModelBoard updateBoard, ModelBoard searchBoard) {
        Map<String, ModelBoard> map = new HashMap<String, ModelBoard>();
        map.put("updateValue", updateBoard);
        map.put("searchValue", searchBoard);
        return  session.insert("mybatis.mapper.mapperBoard.updateBoard", map);        
    }

    @Override
    public int deleteBoard(ModelBoard board) {
        return  session.insert("mybatis.mapper.mapperBoard.deleteBoard", board);        
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        return  session.selectList("mybatis.mapper.mapperBoard.getBoardSearch", board);        
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd"   , StringUtils.isEmpty(boardcd)    ?  null : boardcd            );
        map.put("searchWord", StringUtils.isEmpty(searchWord) ?  null : "%"+searchWord+"%" );
        map.put("start"     , start      );
        map.put("end"       , end        );
        
        return  session.selectList("mybatis.mapper.mapperBoard.getBoardPaging", map); 
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        return  session.insert("mybatis.mapper.mapperBoard.insertBoardList", list);        
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("boardcd"   , boardcd    );
        map.put("searchWord", searchWord );
        
        return  session.selectOne("mybatis.mapper.mapperBoard.getArticleTotalRecord", map);        
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardCd"   , boardcd    );
        map.put("searchWord", "%"+searchWord+"%" );
        map.put("start"     , start      );
        map.put("end"       , end        );
        
        return  session.selectList("mybatis.mapper.mapperBoard.getArticleList", map);        
    }

    @Override
    public ModelArticle getArticle(int articleNo) {
        return  session.selectOne("mybatis.mapper.mapperBoard.getArticle", articleNo);        
    }

    @Override
    public int insertArticle(ModelArticle article) {
        return  session.insert("mybatis.mapper.mapperBoard.insertArticle", article );        
    }

    @Override
    public int updateArticle(ModelArticle updateValue, ModelArticle searchValue) {
        
        Map<String, ModelArticle> map = new HashMap<String, ModelArticle>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        
        return  session.insert("mybatis.mapper.mapperBoard.updateArticle", map );    
    }

    @Override
    public int deleteArticle(ModelArticle article) {
        return  session.insert("mybatis.mapper.mapperBoard.deleteArticle", article ); 
    }

    @Override
    public int increaseHit(int articleNo) {
        return  session.update("mybatis.mapper.mapperBoard.increaseHit", articleNo ); 
    }

    @Override
    public ModelArticle getNextArticle(Map<String, Object> hashmap) {
        return  session.selectOne("mybatis.mapper.mapperBoard.getNextArticle", hashmap);        
    }

    @Override
    public ModelArticle getPrevArticle(Map<String, Object> hashmap) {
        return  session.selectOne("mybatis.mapper.mapperBoard.getPrevArticle", hashmap);        
    }

    @Override
    public ModelAttachfile getAttachFile(int attachFileNo) {
        return  session.selectOne("mybatis.mapper.mapperBoard.getAttachFile", attachFileNo);        
    }

    @Override
    public List<ModelAttachfile> getAttachFileList(int articleNo) {
        return  session.selectList("mybatis.mapper.mapperBoard.getAttachFileList", articleNo);        
    }

    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
        return  session.insert("mybatis.mapper.mapperBoard.insertAttachFile", attachFile );        
    }

    @Override
    public int deleteAttachFile(ModelAttachfile attachFile) {
        return  session.update("mybatis.mapper.mapperBoard.deleteAttachFile", attachFile );        
    }

    @Override
    public int insertComment(ModelComments comment) {
        return  session.insert("mybatis.mapper.mapperBoard.insertComment", comment );        
    }

    @Override
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
        
        Map<String, ModelComments> map = new HashMap<>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        
        return  session.update("mybatis.mapper.mapperBoard.updateComment", map );        
    }

    @Override
    public int deleteComment(ModelComments comment) {
        return  session.delete("mybatis.mapper.mapperBoard.deleteComment", comment );        
    }

    @Override
    public ModelComments getComment(int commentNo) {
        return  session.selectOne("mybatis.mapper.mapperBoard.getComment", commentNo);        
    }

    @Override
    public List<ModelComments> getCommentList(int articleNo) {
        return  session.selectList("mybatis.mapper.mapperBoard.getCommentList", articleNo);        
    }
    
}
