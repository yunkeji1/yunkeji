package com.cloudclass.course.common;

/**
 * @author ss
 * @date 2020-6-10
 */
public class Constant {

    /**
     * 超级用户
     */
    public static final String SUPERR_USER="026a564bbfd84861ac4b65393644beef";

    /**
     * 系统默认密码
     */
    public static final String DEF_PASSWORD="a";

    /**
     * 分页条数
     */
    public static final int pageSize=10;

    /**
     * 返回状态值
     */
    public enum RESULT{
        /**
         * 成功
         */
        CODE_YES("0"),
        /**
         * 失败
         */
        CODE_NO("-1"),
        /**
         * 成功msg
         */
        MSG_YES("操作成功"),
        /**
         * 失败msg
         */
        MSG_NO("操作失败");
        private String value;

        private RESULT(String value){
            this.value=value;
        }
        public String getValue(){
            return value;
        }
    }

}
