package com.lesterlin.bigevent.validation;

import com.lesterlin.bigevent.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State,String> {
    /**
     *
     * @param value 將來要校驗的數據
     * @return 如果返回的是false則校驗不通過，若true則通過
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 提供校驗規則
        if(value==null){
            return false;
        }
        return value.equals("已發布") || value.equals("草稿");
    }
}
