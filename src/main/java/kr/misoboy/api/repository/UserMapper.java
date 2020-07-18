package kr.misoboy.api.repository;

import kr.misoboy.api.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 사용자 목록 조회
     * @return
     */
    List<UserModel> selectUserList();

    /**
     * 사용자 상세 조회
     * @param emplyrId
     * @return
     */
    UserModel selectUserDetail(String emplyrId);
}
