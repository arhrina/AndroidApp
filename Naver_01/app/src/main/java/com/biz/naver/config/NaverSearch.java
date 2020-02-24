package com.biz.naver.config;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.biz.naver.adapter.MovieAdapter;
import com.biz.naver.domain.NaverMovieVO;
import com.google.android.material.circularreveal.CircularRevealHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/*
네이버 API를 비동기 방식으로 호출하여 데이터를 가져오는 클래스 AsyncTask

동기방식으로 가져오기에는 성능이 떨어지는 디바이스를 사용하므로 비동기를 사용
 */
public class NaverSearch extends AsyncTask<Integer, Integer, Void> {

    private final String naver_movie_url = "https://openapi.naver.com/v1/search/movie.json";
    private String strSearch;

    private List<NaverMovieVO> mList = null;
    private RecyclerView recyclerView;

    public NaverSearch(){

    }

    // 검색어와 recyclerView를 전달받아서 검색하고 recyclerView에 보이기
    public NaverSearch(String strSearch, RecyclerView recyclerView) {
        this.strSearch = strSearch;
        this.recyclerView = recyclerView;
    }

    /*
            매개변수를 변수타입... 변수명 형식으로 지정하면 매개변수가 몇개인지 관계없이
            어떤 부분이라도 이 메서드를 호출할 수 있다
            doInBackground(3, 4, 5, 6, 7, 8 등)으로 필요한만큼 개수를 마음껏 늘릴 수 있다
            매개변수의 개수가 정해지지 않은 호출방식

            Integer[] integers = new Integer[6] 처럼 배열방식으로 전달된다. java 8 이상 코드
             */
    @Override
    protected Void doInBackground(Integer... integers) {
        naver_search();
        return null;
    }


    /*
    doInBackground 메서드가 naver_search를 호출해서
    백그라운드에서 실행하고 완료되면 완료이벤트를 받을 메서드

    recyclerView에 데이터를 표현
     */
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MovieAdapter mAdapter = new MovieAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void naver_search(){

//        // java 1.8 이상에서는 list의 제네릭타입이 설정되면 arraylist 제네릭은 비어도 된다
//        mList = new ArrayList<>();

        try {

            String api_url = naver_movie_url;
            api_url += "?query=" + URLEncoder.encode(strSearch, "UTF-8");
            api_url += "&start=1";
            api_url += "&display=20"; // 한번에 20개씩

            URL url = new URL(api_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("X-Naver-Client-Id", NaverSecur.NAVER_ID);
            httpURLConnection.setRequestProperty("X-Naver-Client-Secret", NaverSecur.NAVER_SEC);

            int resCode = httpURLConnection.getResponseCode();

            BufferedReader buffer;
            if(resCode == 200){ // 정상적으로 response가 오면
                buffer = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            }
            else{ // 에러가 오면
                buffer = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            }

            String resString = "";
            String reader;
            while(true){
                reader = buffer.readLine();
                if(reader == null)
                    break;
                resString += reader;
            }

            JSONObject resJson = new JSONObject(resString);
            JSONArray resItems = resJson.getJSONArray("items"); // items라는 이름으로 리턴된 것들을 파싱


            for(int i = 0; i < resItems.length(); i++){
                JSONObject item = resItems.getJSONObject(i);

                NaverMovieVO nVO = NaverMovieVO.builder()
                        .title(item.getString("title"))
                        .director(item.getString("director"))
                        .actor(item.getString("actor"))
                        .link(item.getString("link"))
                        .image(item.getString("image"))
                        .build();

                mList.add(nVO);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
