package com.bopinghui.portalbackstage.repositories;

import com.bopinghui.po.entity.Article;
import com.bopinghui.portalbackstage.common.Constants;
import com.bopinghui.portalbackstage.common.utils.MongoAtempleUtil;
import com.mongodb.DBDecoder;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.util.DBObjectUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


/**
 * 文章持久层
 *
 * @author kakasun
 * @create 2018-03-01 上午8:20
 */
@Repository
public class ArticleRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 根据栏目id和是否删除进行分页查询
     * 按创建日期降序排
     * @param columnId
     * @param delete
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<Article> pageFindByDeleteAndColumnId(Integer columnId,
                                                     boolean delete,Integer pageNo,Integer pageSize){
        Query query =new Query();
        Criteria columnIdCriteria = Criteria.where("columnId").is(columnId);
        query.addCriteria(columnIdCriteria);
        query.addCriteria(Criteria.where("delete").is(delete));
        Sort sort = new Sort(Sort.Direction.DESC,"createDate");
        query.with(sort);
        pageNo = pageNo -1;
        if(pageNo< 0){
            pageNo = 0;
        }
        Pageable pageable = new PageRequest(pageNo,pageSize);
        query.with(pageable);
        return mongoTemplate.find(query,Article.class, Constants.ARTICLE_COLLECTION_NAME);
    }

    /**
     * 根据栏目id和是否删除进行总条数计数
     * @param columnId
     * @param delete
     * @return
     */
    public Long countByDeleteAndColumnId(Integer columnId,boolean delete){
        Query query =new Query();
        Criteria columnIdCriteria = Criteria.where("columnId").is(columnId);
        query.addCriteria(columnIdCriteria);
        query.addCriteria(Criteria.where("delete").is(delete));
        return mongoTemplate.count(query,Article.class,Constants.ARTICLE_COLLECTION_NAME);
    }

    /**
     * 保存文章到集合
     * id不会自动生成，如果有相同id覆盖已有id的值
     * @param article
     */
    public void saveArticle(Article article) throws IllegalAccessException {
        if(article.getDelete() == null){
            article.setDelete(false);
        }
        if(article.getPublish() == null){
            article.setPublish(false);
        }
        if(!StringUtils.isEmpty(article.getId())){
            updateById(article);
            return;
        }
        article.setUpdateDate(new Date());
        mongoTemplate.save(article,Constants.ARTICLE_COLLECTION_NAME);
    }

    /**
     * 根据id更新文章
     * @param article
     * @throws IllegalAccessException
     */
    public void updateById(Article article) throws IllegalAccessException {
        article.setUpdateDate(new Date());
        Query query = new Query(Criteria.where("id").is(article.getId()));
        Update update = MongoAtempleUtil.entity2UpdateIgnoreNull(article);
        mongoTemplate.updateMulti(query,update,Article.class,Constants.ARTICLE_COLLECTION_NAME);
    }

    /**
     * 根据id删除文章
     * @param articleId
     */
    public void deleteById(String articleId) {
        Query query = new Query(Criteria.where("id").is(articleId));
        mongoTemplate.findAllAndRemove(query,Article.class,Constants.ARTICLE_COLLECTION_NAME);
    }

    /**
     * 根据Id发布文章
     * @param articleId
     */
    public void publishArticle(String articleId) {
        Query query = new Query(Criteria.where("id").is(articleId));
        Update update = new Update();
        update.set("publish",true);
        update.set("publishDate",new Date());
        update.set("updateDate",new Date());
        mongoTemplate.updateMulti(query,update,Article.class,Constants.ARTICLE_COLLECTION_NAME);
    }

    /**
     * 根据id查找文章
     * @param articleId
     * @return
     */
    public Article findArticleById(String articleId) {
        return mongoTemplate.findById(articleId,Article.class,Constants.ARTICLE_COLLECTION_NAME);
    }
}
