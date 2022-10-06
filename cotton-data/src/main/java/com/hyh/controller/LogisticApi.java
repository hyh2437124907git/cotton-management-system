package com.hyh.controller;

import com.common.rest.R;
import com.hyh.application.dto.LogisticInput;
import com.hyh.application.service.LogisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 物流清单
 * @author hyh
 * @date 2022/10/4 22:19
 */
@RestController
@RequestMapping("/logistic")
@RequiredArgsConstructor
public class LogisticApi {

    private final LogisticService logisticService;

    @PostMapping("")
    public R<?> addLogisticsList(@RequestBody LogisticInput input){
        return R.data(logisticService.addLogistic(input));
    }

}
