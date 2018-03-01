package com.bopinghui.portalbackstage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * mongodb的配置属性
 *
 * @author kakasun
 * @create 2018-02-28 下午6:20
 */
@Configuration
@PropertySource("classpath:mongodb.properties")
@ConfigurationProperties(prefix = "mongodb")
public class MongodbPropertiesBean {

    String host;
    int port;
    String db;
    String user;
    String pwd;
    boolean socketKeepAlive;
    int socketTimeout;
    String articleCollectionName;
    String articleDetailCollectionName;
    int connectionsPerHost;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isSocketKeepAlive() {
        return socketKeepAlive;
    }

    public void setSocketKeepAlive(boolean socketKeepAlive) {
        this.socketKeepAlive = socketKeepAlive;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getArticleCollectionName() {
        return articleCollectionName;
    }

    public void setArticleCollectionName(String articleCollectionName) {
        this.articleCollectionName = articleCollectionName;
    }

    public String getArticleDetailCollectionName() {
        return articleDetailCollectionName;
    }

    public void setArticleDetailCollectionName(String articleDetailCollectionName) {
        this.articleDetailCollectionName = articleDetailCollectionName;
    }

    public int getConnectionsPerHost() {
        return connectionsPerHost;
    }

    public void setConnectionsPerHost(int connectionsPerHost) {
        this.connectionsPerHost = connectionsPerHost;
    }
}

