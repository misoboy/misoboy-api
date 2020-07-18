package kr.misoboy.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("feedCometModel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Feed Comment Model")
public class FeedCometModel extends FeedModel {

    @ApiModelProperty(value = "코멘트 일련번호", example = "1")
    private Integer cmSn;
}
