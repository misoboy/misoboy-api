package kr.misoboy.api.service;

import kr.misoboy.api.model.UserModel;

import java.util.List;

public interface UserService {

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
