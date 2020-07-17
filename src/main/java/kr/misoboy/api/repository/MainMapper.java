package kr.misoboy.api.repository;

import kr.misoboy.api.model.MainVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

    List<MainVo> selectEmployeeList();
}
