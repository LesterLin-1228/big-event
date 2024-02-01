package com.lesterlin.bigevent.anno;

import com.lesterlin.bigevent.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented // 元註解
@Target({ElementType.FIELD}) // 元註解
@Retention(RetentionPolicy.RUNTIME) // 元註解
@Constraint(validatedBy = {StateValidation.class}) // 指定提供校驗規則的類
public @interface State {
    // 提供校驗失敗後的提示訊息
    String message() default "state參數的值只能是已發布或是草稿";
    // 指定分組
    Class<?>[] groups() default {};
    // 負載 獲取到state註解的附加訊息
    Class<? extends Payload>[] payload() default {};
}
