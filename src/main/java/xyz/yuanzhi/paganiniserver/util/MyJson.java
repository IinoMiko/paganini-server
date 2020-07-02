package xyz.yuanzhi.paganiniserver.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MyJson {
    private JSONObject jsonObject;

    public MyJson(){
        jsonObject = new JSONObject();
    }

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

    public void setCode(int code){
        jsonObject.put("code", code);
    }

    public void setMsg(String msg){
        jsonObject.put("msg", msg);
    }

    public void setObject(Object object){
        jsonObject.put("object", JSON.parseObject(JSON.toJSONString(object)));
    }
}
