package com.biz.naver.retrofit;

import com.biz.naver.domain.NaverMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RetrofitService { // mybatis처럼 인터페이스만 만들면 내부 구현은 알아서 돌아간다

    @GET("search/movie.json") // url에 붙는다. 리턴타입과 함께 매개변수로 헤더값들을 포함해서 등록해줘야한다
    Call<NaverMovie> getMovie(
            // Header 추가
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clientSec,
            @Query("query") String query
            // 쿼리 문자열을 매개변수로 받아서 inject
            // ex, ?query=기생충
    );
}
