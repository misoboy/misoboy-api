-- 사용자
CREATE TABLE `TB_USER` (
    `EMPLYR_ID` VARCHAR(20)  NOT NULL, -- 사용자_ID
    `EMPLYR_NM` VARCHAR(50)  NOT NULL, -- 사용자_이름
    `EMAIL`     VARCHAR(100) NOT NULL, -- 이메일
    `PASSWORD`  VARCHAR(150) NOT NULL, -- 비밀번호
    `USE_AT`    CHAR(1)      NOT NULL, -- 사용_여부
    `SECSN_AT`  CHAR(1)      NULL,     -- 탈퇴_여부
    `REGIST_DT` DATETIME         NOT NULL, -- 등록_일시
    `UPDT_DT`   DATETIME         NULL      -- 수정_일시
);

-- 사용자
ALTER TABLE `TB_USER`
    ADD CONSTRAINT `PK_TB_USER` -- 사용자 기본키
        PRIMARY KEY (
            `EMPLYR_ID` -- 사용자_ID
        );

-- 피드정보
CREATE TABLE `TB_FEED` (
    `FEED_SN`          INTEGER     NOT NULL, -- 피드_일련번호
    `REGIST_EMPLYR_ID` VARCHAR(20) NOT NULL, -- 등록_사용자_ID
    `CN`               CLOB        NOT NULL, -- 내용
    `ATCH_FILE_ID`     VARCHAR(20) NULL,     -- 첨부_파일_ID
    `DELETE_AT`        CHAR(1)     NULL,     -- 삭제_여부
    `REGIST_DT`        DATETIME        NOT NULL, -- 등록_일시
    `UPDT_DT`          DATETIME        NULL,     -- 수정_일시
    `DELETE_DT`        DATETIME        NULL      -- 삭제_일시
);

-- 피드정보
ALTER TABLE `TB_FEED`
    ADD CONSTRAINT `PK_TB_FEED` -- 피드정보 기본키
        PRIMARY KEY (
            `FEED_SN` -- 피드_일련번호
        );

-- 사용자_팔로우_정보
CREATE TABLE `TB_FOLLOW` (
    `EMPLYR_ID`       VARCHAR(20) NOT NULL, -- 사용자_ID
    `TRGET_EMPLYR_ID` VARCHAR(20) NOT NULL, -- 대상_사용자_ID
    `PERM_AT`         CHAR(1)     NOT NULL, -- 허용_여부
    `REQUST_DT`       DATETIME        NOT NULL, -- 요청_일시
    `PERM_DT`         DATETIME        NULL      -- 허용_일시
);

-- 사용자_팔로우_정보
ALTER TABLE `TB_FOLLOW`
    ADD CONSTRAINT `PK_TB_FOLLOW` -- 사용자_팔로우_정보 기본키
        PRIMARY KEY (
             `EMPLYR_ID`,       -- 사용자_ID
             `TRGET_EMPLYR_ID`  -- 대상_사용자_ID
        );

-- 첨부파일_상세
CREATE TABLE `TB_ATCH_FILE_DTL` (
    `ATCH_FILE_ID`    VARCHAR(20)  NOT NULL, -- 첨부_파일_ID
    `FILE_SN`         INTEGER      NOT NULL, -- 파일_일련번호
    `LOGIC_FILE_NM`   VARCHAR(50)  NOT NULL, -- 논리_파일_이름
    `PHYSICL_FILE_NM` VARCHAR(50)  NOT NULL, -- 물리_파일_이름
    `FILE_STRE_COURS` VARCHAR(200) NOT NULL, -- 파일_저장_경로
    `FILE_SIZE`       INTEGER      NOT NULL, -- 파일_사이즈
    `FILE_EXTSN`      VARCHAR(20)  NOT NULL, -- 파일_확장자
    `REGIST_DT`       DATETIME         NOT NULL, -- 등록_일시
    `DELETE_DT`       DATETIME         NULL,     -- 삭제_일시
    `DELETE_AT`       CHAR(1)      NULL      -- 삭제_여부
);

-- 첨부파일_상세
ALTER TABLE `TB_ATCH_FILE_DTL`
    ADD CONSTRAINT `PK_TB_ATCH_FILE_DTL` -- 첨부파일_상세 기본키
        PRIMARY KEY (
            `ATCH_FILE_ID`, -- 첨부_파일_ID
            `FILE_SN`       -- 파일_일련번호
        );

-- 첨부파일
CREATE TABLE `TB_ATCH_FILE` (
    `ATCH_FILE_ID` VARCHAR(20) NOT NULL, -- 첨부_파일_ID
    `REGIST_DT`    DATETIME        NOT NULL  -- 등록_일시
);

-- 첨부파일
ALTER TABLE `TB_ATCH_FILE`
    ADD CONSTRAINT `PK_TB_ATCH_FILE` -- 첨부파일 기본키
        PRIMARY KEY (
            `ATCH_FILE_ID` -- 첨부_파일_ID
        );

-- 피드_코멘트
CREATE TABLE `TB_FEED_CM` (
    `CM_SN`            INTEGER     NOT NULL, -- 코멘트_일련번호
    `FEED_SN`          INTEGER     NOT NULL, -- 피드_일련번호
    `CN`               CLOB        NOT NULL, -- 내용
    `REGIST_EMPLYR_ID` VARCHAR(20) NOT NULL, -- 등록_사용자_ID
    `DELETE_AT`        CHAR(1)     NULL,     -- 삭제_여부
    `REGIST_DT`        DATETIME        NOT NULL, -- 등록_일시
    `UPDT_DT`          DATETIME        NULL,     -- 수정_일시
    `DELETE_DT`        DATETIME        NULL      -- 삭제_일시
);

-- 피드_코멘트
ALTER TABLE `TB_FEED_CM`
    ADD CONSTRAINT `PK_TB_FEED_CM` -- 피드_코멘트 기본키
        PRIMARY KEY (
            `CM_SN` -- 코멘트_일련번호
        );

-- 피드정보
ALTER TABLE `TB_FEED`
    ADD CONSTRAINT `FK_TB_USER_TO_TB_FEED` -- 사용자 -> 피드정보
        FOREIGN KEY (
            `REGIST_EMPLYR_ID` -- 등록_사용자_ID
        )
        REFERENCES `TB_USER` ( -- 사용자
            `EMPLYR_ID` -- 사용자_ID
        );

-- 피드정보
ALTER TABLE `TB_FEED`
    ADD CONSTRAINT `FK_TB_ATCH_FILE_TO_TB_FEED` -- 첨부파일 -> 피드정보
        FOREIGN KEY (
            `ATCH_FILE_ID` -- 첨부_파일_ID
        )
        REFERENCES `TB_ATCH_FILE` ( -- 첨부파일
            `ATCH_FILE_ID` -- 첨부_파일_ID
        );

-- 사용자_팔로우_정보
ALTER TABLE `TB_FOLLOW`
    ADD CONSTRAINT `FK_TB_USER_TO_TB_FOLLOW` -- 사용자 -> 사용자_팔로우_정보
        FOREIGN KEY (
            `EMPLYR_ID` -- 사용자_ID
        )
        REFERENCES `TB_USER` ( -- 사용자
            `EMPLYR_ID` -- 사용자_ID
        );

-- 첨부파일_상세
ALTER TABLE `TB_ATCH_FILE_DTL`
    ADD CONSTRAINT `FK_TB_ATCH_FILE_TO_TB_ATCH_FILE_DTL` -- 첨부파일 -> 첨부파일_상세
        FOREIGN KEY (
            `ATCH_FILE_ID` -- 첨부_파일_ID
        )
        REFERENCES `TB_ATCH_FILE` ( -- 첨부파일
            `ATCH_FILE_ID` -- 첨부_파일_ID
        );

-- 피드_코멘트
ALTER TABLE `TB_FEED_CM`
    ADD CONSTRAINT `FK_TB_FEED_TO_TB_FEED_CM` -- 피드정보 -> 피드_코멘트
        FOREIGN KEY (
            `FEED_SN` -- 피드_일련번호
        )
        REFERENCES `TB_FEED` ( -- 피드정보
            `FEED_SN` -- 피드_일련번호
        );

-- 피드_코멘트
ALTER TABLE `TB_FEED_CM`
    ADD CONSTRAINT `FK_TB_USER_TO_TB_FEED_CM` -- 사용자 -> 피드_코멘트
        FOREIGN KEY (
            `REGIST_EMPLYR_ID` -- 등록_사용자_ID
        )
        REFERENCES `TB_USER` ( -- 사용자
            `EMPLYR_ID` -- 사용자_ID
        );
