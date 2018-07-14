package com.idaoben.web.shiro.commom;

import com.idaoben.web.shiro.ResultStatus;
import org.springframework.stereotype.Component;

/**
 * @author Sherman 2018/7/15 2:59
 */
@Component
public class ResultStatusProcess {

    public Result process(Integer code, String message) {
        ResultStatus status;
        if (code == 200) {
            status = ResultStatus.valueOf("SUCCESS");
            status.setCode(code);
            status.setMessage(message);
        } else {
            status = ResultStatus.valueOf("ERROR");
            status.setCode(code);
            status.setMessage(message);
        }
        return new Result(status);
    }
}
