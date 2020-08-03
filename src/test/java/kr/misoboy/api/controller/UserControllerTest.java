package kr.misoboy.api.controller;

import kr.misoboy.api.AbstractSpringTest;
import kr.misoboy.api.common.SecurityConst;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringJUnitConfig
@ActiveProfiles("test")
@WithMockUser(roles = {SecurityConst.API_ACCESS_USER_ROLE})
public class UserControllerTest extends AbstractSpringTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("ut_user_101 : 사용자 목록 조회 테스트")
    @Test
    public void ut_user_101() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/user/")
        ).andDo(print()).andExpect(status().isOk());
    }

    @DisplayName("ut_user_102 : 사용자 정보 조회 테스트")
    @Test
    public void ut_user_102() throws Exception {
        final String emplyrId = "00000000000000000001";
        mockMvc.perform(MockMvcRequestBuilders
                .get(String.format("/v1/user/%s", emplyrId))
        ).andDo(print()).andExpect(status().isOk());
    }

    @DisplayName("ut_user_103 : Follow 목록 조회 테스트")
    @Test
    public void ut_user_103() throws Exception {
        final String emplyrId = "00000000000000000001";
        mockMvc.perform(MockMvcRequestBuilders
                .get(String.format("/v1/user/follow/%s", emplyrId))
        ).andDo(print()).andExpect(status().isOk());
    }

    @DisplayName("ut_user_104 : Follower 목록 조회 테스트")
    @Test
    public void ut_user_104() throws Exception {
        final String emplyrId = "00000000000000000001";
        mockMvc.perform(MockMvcRequestBuilders
                .get(String.format("/v1/user/follow/%s", emplyrId))
        ).andDo(print()).andExpect(status().isOk());
    }

    @DisplayName("ut_user_105 : Follow 등록 테스트")
    @Test
    public void ut_user_105() throws Exception {
        final String emplyrId = "00000000000000000001";
        final String trgetEmplyrId = "00000000000000000002";
        mockMvc.perform(MockMvcRequestBuilders
                .post(String.format("/v1/user/follow/%s", emplyrId))
                .param("trgetEmplyrId", trgetEmplyrId)
        ).andDo(print()).andExpect(status().isConflict());
    }

    @DisplayName("ut_user_106 : Follow 허용 테스트")
    @Test
    public void ut_user_106() throws Exception {
        final String emplyrId = "00000000000000000001";
        final String trgetEmplyrId = "00000000000000000002";
        mockMvc.perform(MockMvcRequestBuilders
                .put(String.format("/v1/user/follow/%s/permit", emplyrId))
                .param("trgetEmplyrId", trgetEmplyrId)
        ).andDo(print()).andExpect(status().isOk());
    }

    @DisplayName("ut_user_107 : Follow 삭제 테스트")
    @Test
    public void ut_user_107() throws Exception {
        final String emplyrId = "00000000000000000001";
        final String trgetEmplyrId = "00000000000000000002";
        mockMvc.perform(MockMvcRequestBuilders
                .delete(String.format("/v1/user/follow/%s", emplyrId))
                .param("trgetEmplyrId", trgetEmplyrId)
        ).andDo(print()).andExpect(status().isOk());
    }
}
