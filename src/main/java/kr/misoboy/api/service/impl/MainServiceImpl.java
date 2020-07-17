package kr.misoboy.api.service.impl;

import kr.misoboy.api.model.MainVo;
import kr.misoboy.api.repository.MainMapper;
import kr.misoboy.api.service.MainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("mainService")
public class MainServiceImpl implements MainService {

    @Resource(name = "mainMapper")
    private MainMapper mainMapper;


    @Override
    public List<MainVo> selectEmployeeList() {
        return mainMapper.selectEmployeeList();
    }
}
