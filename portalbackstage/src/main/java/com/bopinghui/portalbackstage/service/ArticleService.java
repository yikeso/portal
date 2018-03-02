package com.bopinghui.portalbackstage.service;

import com.bopinghui.po.entity.Article;
import com.bopinghui.portalbackstage.common.PageResult;
import com.bopinghui.portalbackstage.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章service
 *
 * @author kakasun
 * @create 2018-03-01 下午8:45
 */
@Service
public class ArticleService {

    @Resource
    ArticleRepository articleRepository;

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

}
