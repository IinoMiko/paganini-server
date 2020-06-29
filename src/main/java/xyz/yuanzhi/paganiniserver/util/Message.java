package xyz.yuanzhi.paganiniserver.util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer code;
    private String msg;
    private Object object;

    public void addMessage(Boolean success, String successMsg, String failMsg){
        if (success){
            addSuccessMsg(successMsg);
        } else {
            addFailMsg(failMsg);
        }
    }

    public void addSuccessMsg(String successMsg){
        setCode(1);
        setMsg(successMsg);
    }

    public void addFailMsg(String failMsg){
        setCode(0);
        setMsg(failMsg);
    }

    public String toJson(){
        return JacksonUtil.Bean2Json(this);
    }
}
