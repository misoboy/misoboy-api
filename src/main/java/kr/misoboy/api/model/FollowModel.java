package kr.misoboy.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("followModel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Follow Model")
public class FollowModel extends UserModel {

    @ApiModelProperty(value = "대상 사용자 ID", example = "00000000000000000001")
    private String trgetEmplyrId;

    @ApiModelProperty(value = "허용 여부", example = "Y")
    private String permAt;

    @ApiModelProperty(value = "요청 일시", example = "2020-07-18 05:11:39.538418")
    private Date requstDt;

    @ApiModelProperty(value = "허용 일시", example = "2020-07-18 05:11:39.538418")
    private Date permDt;
}
