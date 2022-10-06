package com.hyh.controller;

import com.common.rest.R;
import com.hyh.application.dto.WarehouseInput;
import com.hyh.application.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/** 仓库数据接口
 * @author hyh
 * @date 2022/10/4 21:56
 */
@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseApi {

    private final WarehouseService warehouseService;

    @PostMapping("/")
    public R<?> create(@RequestBody() WarehouseInput input){
        return R.data(warehouseService.create(input));
    }

    /**
     * 获取所有仓库数据
     */
    @GetMapping("/all")
    public R<?> getAll(){
        return R.data(warehouseService.getAll());
    }

    @GetMapping("/condition")
    public R<?> getByCondition(@RequestParam(value = "code", required = false) String code,
                               @RequestParam(value = "totalCapacity", required = false) double totalCapacity,
                               @RequestParam(value = "location", required = false) String location){
        return R.data(warehouseService.getByCotton(new WarehouseInput(code, totalCapacity, location)));
    }

    @GetMapping("/{id}")
    public R<?> get(@PathVariable("id")String id){
        return R.data(warehouseService.getById(id));
    }


    @DeleteMapping("/{id}")
    public R<?> delete(@PathVariable("id")String id){
        return R.data(warehouseService.delById(id));
    }

}
