package com.biz.naver;

import android.os.Bundle;

import com.biz.naver.config.NaverSearch;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextInputEditText txt_search;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        txt_search = findViewById(R.id.txt_search);
        recyclerView = findViewById(R.id.movie_list);

        // imeOption으로 actionSearch 옵션으로 키보드의 돋보기 버튼을 클릭했을 때 동작할 이벤트
        // TextView 액션리스너
        txt_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    String strSearch = txt_search.getText().toString();

                    if(strSearch.isEmpty()){ // 값을 입력하지 않고 검색하면 토스트를 띄운다
                        Toast.makeText(MainActivity.this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        // Toast.makeText(MainActivity.this, strSearch, Toast.LENGTH_SHORT).show(); // 값이 입력되면 입력된 값을 토스트로 띄운다
                        NaverSearch nSearch = new NaverSearch(strSearch, recyclerView);
                        nSearch.execute();
                    }

                }
                return false;
            }
        });





        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
