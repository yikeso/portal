package com.bopinghui.portalbackstage.controllers;

import com.bopinghui.po.constants.ColumnConstant;
import com.bopinghui.po.entity.Article;
import com.bopinghui.po.entity.ArticleDetail;
import com.bopinghui.portalbackstage.common.Constants;
import com.bopinghui.portalbackstage.common.PageResult;
import com.bopinghui.portalbackstage.common.ServerResponse;
import com.bopinghui.portalbackstage.repositories.ArticleDetailRepostory;
import com.bopinghui.portalbackstage.repositories.ArticleRepository;
import com.bopinghui.portalbackstage.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 文章管理控制层
 *
 * @author kakasun
 * @create 2018-03-01 下午3:02
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleDetailRepostory articleDetailRepostory;

    @GetMapping("/column")
    public String articleColumn(Model model){
        model.addAttribute("columnList", ColumnConstant.values());
        return "articlepublish/wenzhang_xinwen :: articlepublish";
    }

    /**
     * 文章分页查询
     * @param columnId
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     */
    @PostMapping("/list")
    public String articleList(Integer columnId,Integer pageNo,
                              Integer pageSize,Model model){
        if(pageNo == null || pageNo.intValue() < 1){
            pageNo = Integer.valueOf(1);
        }
        if(pageSize == null || pageSize.intValue() < 2){
            pageSize = Integer.valueOf(Constants.PAGE_SIZE);
        }
        model.addAttribute("columnId",columnId);
        PageResult<Article> pageResult = articleService.pageFindByColumnId(columnId,pageNo,pageSize);
        model.addAttribute("pageResult",pageResult);
        return "articlepublish/articleList::articleList";
    }

    @GetMapping("/{columnId}/new")
    public String newArticle(@PathVariable("columnId") Integer columnId, Model model){
        model.addAttribute("title","新增文章");
        model.addAttribute("columnId",columnId);
        return "articlepublish/wenzhang_xinwen_fabu";
    }

    @PostMapping("/add")
    @ResponseBody
    public ServerResponse addNewArticle(Article article, ArticleDetail articleDetail) throws IllegalAccessException {
        return articleService.addArticle(article,articleDetail);
    }

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @DeleteMapping("/{articleId}")
    @ResponseBody
    public ServerResponse deleteArticle(@PathVariable("articleId") String articleId){
        return articleService.deleArticleById(articleId);
    }

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @PostMapping("/publish/{articleId}")
    @ResponseBody
    public ServerResponse publishArticle(@PathVariable("articleId") String articleId){
        return articleService.publishArticle(articleId);
    }

    /**
     * 修改文章
     * @param articleId
     * @return
     */
    @GetMapping("/{articleId}")
    public String editArticle(@PathVariable("articleId") String articleId,Model model){
        Article article = articleRepository.findArticleById(articleId);
        ArticleDetail articleDetail = articleDetailRepostory.findArticleDetailById(articleId);
        model.addAttribute("article",article);
        model.addAttribute("articleDetail",articleDetail);
        return "articlepublish/wenzhang_xinwen_xiugai";
    }

    /**
     * 保存文章到集合
     * @param article
     * @param articleDetail
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public ServerResponse saveArticle(Article article, ArticleDetail articleDetail) throws IllegalAccessException {
        articleRepository.updateById(article);
        articleDetailRepostory.updateById(articleDetail);
        return ServerResponse.ofSucess();
    }
}
