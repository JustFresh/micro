
package com.xiudoua.study.micro.utils;

import java.util.UUID;

/**
 * ClassName: UUIDTool <br/>
 * Description: TODO <br/>
 * Date: 2018年3月30日 下午5:59:08 <br/>
 * <br/>
 * 
 * @author JustFresh
 * @desc
 *
 *       修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class UUIDTool {
    public UUIDTool() {
    }

    /**
     * 自动生成32位的UUid，对应数据库的主键id进行插入用。
     * 
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
