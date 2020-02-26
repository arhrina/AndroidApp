package com.biz.naver.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NaverMovie {

    // @Expose
    // 만약에 해당 칼럼에 데이터가 null이면 자동으로 안받아서
    // Nullpoint 오류를 최소화 시킨다.
    @SerializedName("lastBuildDate") // retrofit를 위한 설정
    @Expose
    private String lastBuildDate;

    @SerializedName("total")
    @Expose
    private String total;

    @SerializedName("start")
    @Expose
    private String start;

    @SerializedName("display")
    @Expose
    private String display;

    @SerializedName("items") // 핵심. 공식 api문서 참조
    List<NaverMovieItem> items = null;

}
