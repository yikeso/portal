package com.bopinghui.po.constants;

/**
 * 栏目常量
 *
 * @author kakasun
 * @create 2018-02-28 下午12:56
 */
public enum  ColumnConstant {

    //公司动态
    COMPANY_DYNAMICS,
    //博士人才
    DOCTORATE,
    //博士技术
    PHD_TECHNOLOGY,
    //博士产品
    PHD_PRODUCTS,
    //公司简介
    COMPANY_PROFILE,
    //联系我们
    CONTACT_US;

    /**
     * 获取栏目id
     * @return
     */
    public int getColumnId(){
        switch (this){
            case COMPANY_DYNAMICS:
                return 100;
            case DOCTORATE:
                return 200;
            case PHD_TECHNOLOGY:
                return 300;
            case PHD_PRODUCTS:
                return 400;
            case COMPANY_PROFILE:
                return 500;
            case CONTACT_US:
                return 600;
            default:
                return 0;
        }
    }

    /**
     * 获取栏目名称
     * @return
     */
    public String getColumnName(){
        switch (this){
            case COMPANY_DYNAMICS:
                return "公司动态";
            case DOCTORATE:
                return "博士人才";
            case PHD_TECHNOLOGY:
                return "博士技术";
            case PHD_PRODUCTS:
                return "博士产品";
            case COMPANY_PROFILE:
                return "公司简介";
            case CONTACT_US:
                return "联系我们";
            default:
                return "其它";
        }
    }

    /**
     * 根据栏目id返回栏目名称
     * @return
     */
    public static String getColumnName(int columnId){
        switch (columnId){
            case 100:
                return "公司动态";
            case 200:
                return "博士人才";
            case 300:
                return "博士技术";
            case 400:
                return "博士产品";
            case 500:
                return "公司简介";
            case 600:
                return "联系我们";
            case 0:
                return "其它";
                default:
                    throw new IllegalArgumentException("未定义的栏目id");
        }
    }
}
