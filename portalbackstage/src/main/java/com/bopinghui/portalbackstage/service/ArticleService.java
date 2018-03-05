package com.bopinghui.portalbackstage.service;

import com.bopinghui.po.entity.Article;
import com.bopinghui.po.entity.ArticleDetail;
import com.bopinghui.portalbackstage.common.PageResult;
import com.bopinghui.portalbackstage.common.ServerResponse;
import com.bopinghui.portalbackstage.common.utils.IdUtil;
import com.bopinghui.portalbackstage.repositories.ArticleDetailRepostory;
import com.bopinghui.portalbackstage.repositories.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 文章service
 *
 * @author kakasun
 * @create 2018-03-01 下午8:45
 */
@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleDetailRepostory articleDetailRepostory;

    private static final Logger log = LoggerFactory.getLogger(ArticleService.class);

    /**
     * 对未删除文章根据栏目id分页查询
     * @return
     */
    public PageResult<Article> pageFindByColumnId(Integer columnId,
                                                  Integer pageNo,Integer pageSize){
        PageResult<Article> pageResult = new PageResult<Article>();
        pageResult.setCount(articleRepository.countByDeleteAndColumnId(columnId,false));
        pageResult.setPageNo(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setData(articleRepository.pageFindByDeleteAndColumnId(columnId,false,pageNo,pageSize));
        return pageResult;
    }

    /**
     * 添加新的文章到集合
     * @param article
     * @param articleDetail
     * @return
     */
    public ServerResponse addArticle(Article article, ArticleDetail articleDetail){
        List<String> covers = article.getCover();
        if(covers != null) {
            Iterator<String> it = article.getCover().iterator();
            String url = null;
            while (it.hasNext()) {
                url = it.next();
                if (StringUtils.isEmpty(url)) {
                    it.remove();
                }
            }
        }
        article.setDelete(false);
        article.setPublish(false);
        String id = IdUtil.createId();
        Date now = new Date();
        article.setId(id);
        article.setCreateDate(now);
        log.debug("保存文章：{}",article);
        articleDetail.setId(id);
        articleDetail.setCreateDate(now);
        log.debug("保存文章内容：{}",articleDetail);
        articleDetailRepostory.saveArticleDetail(articleDetail);
        articleRepository.saveArticle(article);
        return ServerResponse.ofSucess();
    }

    /**
     * 根据文章id删除文章
     * @param articleId
     * @return
     */
    public ServerResponse deleArticleById(String articleId) {
        articleRepository.deleteById(articleId);
        return ServerResponse.ofSucess();
    }

    /**
     * 发布文章
     * @param articleId
     * @return
     */
    public ServerResponse publishArticle(String articleId) {
        articleRepository.publishArticle(articleId);
        return ServerResponse.ofSucess();
    }

}
