package kr.misoboy.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("atchFileModel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Attach File Model")
public class AtchFileModel {

    @ApiModelProperty(value = "첨부 파일 ID", example = "00000000000000000001")
    private String atchFileId;

    @ApiModelProperty(value = "파일 일련번호", example = "1")
    private Integer fileSn;

    @ApiModelProperty(value = "논리 파일 이름", example = "테스트_첨부_파일.txt")
    private String logicFileNm;

    @ApiModelProperty(value = "물리 파일 이름", example = "DJDUHFSIUDFHAASDD")
    private String physiclFileNm;

    @ApiModelProperty(value = "파일 저장 경로", example = "/storage/atchfile")
    private String fileStreCours;

    @ApiModelProperty(value = "파일 사이즈", example = "1239889")
    private Integer fileSize;

    @ApiModelProperty(value = "파일 확장자", example = "txt")
    private String fileExtsn;

    @ApiModelProperty(value = "등록 일시", example = "2020-07-18 05:11:39.538418")
    private Date registDt;

    @ApiModelProperty(value = "삭제 일시", example = "2020-07-18 05:11:39.538418")
    private Date deleteDt;

    @ApiModelProperty(value = "삭제 여부", example = "N")
    private String deleteAt;
}
