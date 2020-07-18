package kr.misoboy.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("feedModel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Feed Model")
public class FeedModel extends UserModel {

    @ApiModelProperty(value = "피드 일련번호", example = "1")
    private Integer feedSn;

    @ApiModelProperty(value = "등록 사용자 ID", example = "00000000000000000001")
    private String registEmplyrId;

    @ApiModelProperty(value = "내용", example = "테스트 내용 입니다.")
    private String cn;

    @ApiModelProperty(value = "첨부파일 ID", example = "00000000000000000001")
    private String atchFileId;

    @ApiModelProperty(value = "삭제 여부", example = "N")
    private String deleteAt;

    @ApiModelProperty(value = "등록 일시", example = "2020-07-18 05:11:39.538418")
    private Date registDt;

    @ApiModelProperty(value = "수정 일시", example = "2020-07-18 05:11:39.538418")
    private Date updtDt;

    @ApiModelProperty(value = "삭제 일시", example = "2020-07-18 05:11:39.538418")
    private Date deleteDt;
}
