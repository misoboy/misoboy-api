package kr.misoboy.api.controller;

import kr.misoboy.api.AbstractSpringTest;
import kr.misoboy.api.common.SecurityConst;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringJUnitConfig
@ActiveProfiles("test")
public class MainControllerTest extends AbstractSpringTest {

    @Resource
    protected MockMvc mockMvc;

    @WithMockUser(username = SecurityConst.API_ACCESS_USER_ID, password = SecurityConst.API_ACCESS_USER_PWD, roles = SecurityConst.API_ACCESS_USER_ROLE)
    @DisplayName("ut_GET_main_101 : 샘플 메인 목록 테스트")
    @Test
    public void ut_GET_main_101() throws Exception {
        log.debug("ut_GET_main_101 : run test");
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/main/"))
                .andDo(print()).andExpect(status().isOk());
    }
}
