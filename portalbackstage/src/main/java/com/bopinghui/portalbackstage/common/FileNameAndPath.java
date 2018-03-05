package com.bopinghui.portalbackstage.common;

/**
 * ${DESCRIPTION}
 *
 * @author kakasun
 * @create 2018-03-02 下午4:51
 */
public class FileNameAndPath {

    String name;
    String path;

    public FileNameAndPath(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileNameAndPath{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
