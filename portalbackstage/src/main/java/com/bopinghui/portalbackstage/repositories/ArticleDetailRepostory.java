package com.bopinghui.portalbackstage.repositories;

import com.bopinghui.po.entity.Article;
import com.bopinghui.po.entity.ArticleDetail;
import com.bopinghui.portalbackstage.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

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
    public void saveArticleDetail(ArticleDetail articleDetail){
        mongoTemplate.save(articleDetail, Constants.ARTICLE_DETAIL_COLLECTION_NAME);
    }
}
