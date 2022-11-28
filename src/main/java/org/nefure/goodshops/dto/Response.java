package org.nefure.goodshops.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author nefure
 * @since 2022/11/23 18:23
 */
@Data
@Accessors(chain = true)
public class Response {

    private Boolean success;

    private String errorMsg;

    private Object data;

    private Long total;


    public static Response ok(){
        return new Response().setSuccess(true);
    }

    public static Response ok(Object data){
        return new Response().setSuccess(true).setData(data);
    }

    public static Response ok(List<?> data, Long total){
        return new Response().setSuccess(true).setData(data).setTotal(total);
    }

    public static Response fail(String msg) {
        return new Response().setErrorMsg(msg);
    }
}
