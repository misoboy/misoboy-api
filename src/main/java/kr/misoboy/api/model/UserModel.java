package kr.misoboy.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("userModel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User Model")
public class UserModel {

    @ApiModelProperty(value = "사용자 ID", example = "00000000000000000001")
    private String emplyrId;

    @ApiModelProperty(value = "사용자 이름", example = "홍길동")
    private String emplyrNm;

    @ApiModelProperty(value = "이메일", example = "hong@gmail.com")
    private String email;

    @ApiModelProperty(value = "비밀번호", example = "password")
    private String password;

    @ApiModelProperty(value = "사용 여부", example = "Y")
    private String useAt;

    @ApiModelProperty(value = "탈퇴 여부", example = "N")
    private String secsnAt;

    @ApiModelProperty(value = "등록 일시", example = "2020-07-18 05:11:39.538418")
    private Date registDt;

    @ApiModelProperty(value = "수정 일시", example = "2020-07-18 05:11:39.538418")
    private Date updtDt;
}
