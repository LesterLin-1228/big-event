package com.lesterlin.bigevent.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//统一響應结果
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code; //業務狀態馬  0-成功  1-失敗
    private String message; //提示訊息
    private T data; //響應數據

    // 快速返回操作成功響應结果(带響應數據)
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    // 快速返回操作成功響應结果
    public static <E> Result<E> success() {
        return new Result<>(0, "操作成功", null);
    }

    // 失敗
    public static <E> Result<E> error(String message) {
        return new Result<>(1, message, null);
    }
}
