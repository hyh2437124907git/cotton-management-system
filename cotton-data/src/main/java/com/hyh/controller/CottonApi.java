package com.hyh.controller;

import com.common.rest.R;
import com.hyh.application.service.CottonService;
import com.hyh.model.entity.Cotton;
import com.hyh.model.entity.enums.Color;
import com.hyh.model.entity.enums.Rank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 棉花功能接口
 * @author hyh
 * @date 2022/10/4 21:16
 */
@RestController
@RequestMapping("/cotton")
@RequiredArgsConstructor
public class CottonApi {

    private final CottonService cottonService;

    @PostMapping("/")
    public R<?> create(@RequestBody() Cotton cotton){
        return R.data(cottonService.create(cotton));
    }

    /**
     * 获取所有棉花数据
     */
    @GetMapping("/all")
    public R<?> getAll(){
        return R.data(cottonService.getAll());
    }

    @GetMapping("/condition")
    public R<?> getByCondition(@RequestParam(value = "variety", required = false) String variety,
                               @RequestParam(value = "color", required = false) Color color,
                               @RequestParam(value = "rank", required = false) Rank rank,
                               @RequestParam(value = "source", required = false) String source){
        return R.data(cottonService.getByCotton(new Cotton(variety, color, rank, source)));
    }

    @GetMapping("/{id}")
    public R<?> get(@PathVariable("id")String id){
        return R.data(cottonService.getById(id));
    }

    @DeleteMapping("/{id}")
    public R<?> delete(@PathVariable("id")String id){
        return R.data(cottonService.delById(id));
    }

}
