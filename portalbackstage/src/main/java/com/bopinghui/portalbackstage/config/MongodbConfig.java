package com.bopinghui.portalbackstage.config;

import com.bopinghui.po.entity.Article;
import com.bopinghui.po.entity.ArticleDetail;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化Mongodb客户端
 *
 * @author kakasun
 * @create 2018-02-28 下午6:27
 */
@Configuration
@EnableConfigurationProperties({MongodbPropertiesBean.class})
public class MongodbConfig {

    private  static final Logger log = LoggerFactory.getLogger(MongodbConfig.class);

    @Autowired
    MongodbPropertiesBean mongodbPropertiesBean;

    /**
     * mongodb客户端
     * @return
     */
    @Bean
    public MongoClient mongoClient(){
        MongoClientOptions.Builder  builder = MongoClientOptions.builder();
        builder.maxConnectionIdleTime(mongodbPropertiesBean.getSocketTimeout());
        builder.socketKeepAlive(mongodbPropertiesBean.isSocketKeepAlive());
        builder.connectionsPerHost(mongodbPropertiesBean.getConnectionsPerHost());
        MongoClientOptions options = builder.build();
        log.error(options.toString());
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress(mongodbPropertiesBean.getHost(),mongodbPropertiesBean.getPort());
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createCredential(mongodbPropertiesBean.getUser(),
                mongodbPropertiesBean.getDb(),mongodbPropertiesBean.getPwd().toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);
        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(serverAddress,credentials,options);
        return mongoClient;
    }

    /**
     * 获取portal库
     * @param mongoClient
     * @return
     */
    @Bean
    @Autowired
    public MongoDatabase portalDb(@Qualifier("mongoClient") MongoClient mongoClient){
        return mongoClient.getDatabase(mongodbPropertiesBean.getDb());
    }

    /**
     * 获取数据库中的article集合
     * @param database
     * @return
     */
    @Bean
    @Autowired
    public MongoCollection articleCollection(@Qualifier("portalDb") MongoDatabase database){
        MongoCollection<Article> collection = database.getCollection(
                mongodbPropertiesBean.getArticleCollectionName(), Article.class);
        return collection;
    }

    /**
     * 获取数据库中的articleDetail集合
     * @param database
     * @return
     */
    @Bean
    @Autowired
    public MongoCollection articleDetailCollection(@Qualifier("portalDb") MongoDatabase database){
        MongoCollection<ArticleDetail> collection = database.getCollection(
                mongodbPropertiesBean.getArticleDetailCollectionName(), ArticleDetail.class);
        return collection;
    }

}
