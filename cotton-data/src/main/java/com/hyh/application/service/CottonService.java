package com.hyh.application.service;

import com.hyh.model.entity.Cotton;
import com.hyh.model.mapper.CottonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyh
 * @date 2022/10/4 20:50
 */
@Service
@RequiredArgsConstructor
public class CottonService {

    private final CottonMapper cottonMapper;

    public boolean create(Cotton cotton){
        return cottonMapper.save(cotton);
    }

    public Cotton getById(String id){
        return cottonMapper.getById(id);
    }

    public boolean delById(String id){
        return cottonMapper.delById(id);
    }

    public List<Cotton> getAll(){
        return cottonMapper.getAll();
    }

    public List<Cotton> getByCotton(Cotton cotton){
        return cottonMapper.getByCotton(cotton);
    }
}
