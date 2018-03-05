package com.bopinghui.portalbackstage.repositories;

import com.bopinghui.po.entity.Article;
import com.bopinghui.po.entity.ArticleDetail;
import com.bopinghui.portalbackstage.common.Constants;
import com.bopinghui.portalbackstage.common.utils.MongoAtempleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 文章内容持久层
 *
 * @author kakasun
 * @create 2018-03-01 上午8:21
 */
@Repository
public class ArticleDetailRepostory {

    @Autowired
    MongoTemplate mongoTemplate;
    /**
     * 保存文章内容到集合
     * id不会自动生成，如果有相同id覆盖已有id的值
     * @param articleDetail
     */
    public void saveArticleDetail(ArticleDetail articleDetail) throws IllegalAccessException {
        if(!StringUtils.isEmpty(articleDetail.getId())){
            updateById(articleDetail);
        }
        articleDetail.setUpdateDate(new Date());
        mongoTemplate.save(articleDetail, Constants.ARTICLE_DETAIL_COLLECTION_NAME);
    }

    /**
     * 根据id更新文章
     * @param articleDetail
     * @throws IllegalAccessException
     */
    public void updateById(ArticleDetail articleDetail) throws IllegalAccessException {
        articleDetail.setUpdateDate(new Date());
        Query query = new Query(Criteria.where("id").is(articleDetail.getId()));
        Update update = MongoAtempleUtil.entity2UpdateIgnoreNull(articleDetail);
        mongoTemplate.updateMulti(query,update,ArticleDetail.class,Constants.ARTICLE_DETAIL_COLLECTION_NAME);
    }

    public ArticleDetail findArticleDetailById(String articleId) {
        return mongoTemplate.findById(articleId,ArticleDetail.class,Constants.ARTICLE_DETAIL_COLLECTION_NAME);
    }
}
