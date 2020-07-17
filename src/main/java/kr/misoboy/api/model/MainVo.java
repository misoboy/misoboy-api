package kr.misoboy.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.Date;

@Alias("mainVo")
@Data
@Builder
@ApiModel(value = "샘플 메인 목록 조회 Model")
public class MainVo {

    @ApiModelProperty(value = "Employee id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "first name", example = "Chiseok")
    private String firstName;
    @ApiModelProperty(value = "last name", example = "Song")
    private String lastName;
    @ApiModelProperty(value = "email", example = "misoboy.kor@gmail.com")
    private String email;
    @ApiModelProperty(value = "phone number", example = "010-1234-5678")
    private String phoneNumber;
    @ApiModelProperty(value = "hire date", example = "1594962438874")
    private Date hireDate;
    @ApiModelProperty(value = "salary", example = "10")
    private Integer salary;
    @ApiModelProperty(value = "commission pct", example = "20")
    private Integer commissionPct;
}
