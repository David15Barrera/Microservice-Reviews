package com.service.reviewsService.common.infrastructure.annotation;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

}
