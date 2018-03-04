package com.bopinghui.portalbackstage.repositories;

import com.bopinghui.po.entity.Article;
import com.bopinghui.portalbackstage.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

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
    public void saveArticle(Article article){
        mongoTemplate.save(article,Constants.ARTICLE_COLLECTION_NAME);
    }
}
