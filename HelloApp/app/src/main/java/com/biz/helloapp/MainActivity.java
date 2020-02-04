package com.biz.helloapp;

import android.content.Intent;
import android.os.Bundle;

import com.biz.helloapp.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    EditText txt_Input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView(R.layout.activity_main);

        setContentView(R.layout.my_layout);

        /*
        layout xml에서 선언한 객체 컴포넌트를 사용하기 위한 자바에서 객체생성
         */
        txt_Input = findViewById(R.id.txtInput);


        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);

        /*
        익명클래스 방식으로 클릭이벤트를 설정
         */
        btn1.setOnClickListener(new View.OnClickListener() { // 무슨일을 할지 클래스로 지정. 버튼이 눌렸을 경우의 이벤트 지정
            @Override
            public void onClick(View v) {
                String txt = txt_Input.getText().toString();
                Toast.makeText(MainActivity.this, txt, Toast.LENGTH_LONG).show();
                // toast는 alert와 같은 느낌의 효과
            }
            /*
            context는 현재 실행되고 있는 화면의 액티비티에 text 내용물을 toast.length_short 시간만큼 show해라. 빌드패턴. 메서드 체이닝 패턴
             */
        });
        /*
        context는 현재 동작중인 액티비티에서 텍스트를 length_long만큼 show해라. 빌드패턴. 메서드 체이닝패턴
         */

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "사라져", Snackbar.LENGTH_INDEFINITE).show();
                // 버튼이 parent로 버튼 바로 아래에서 떠오른다
        } // 버튼이 parent라 버튼의 바로 아래쪽에 생성된다
        });

        /*
        새로운 activity를 화면에 띄울 때 intent 클래스로 객체를 생성하고 startActivity() 메서드에게 객체를 주입
         */
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent는 만든 activity 중 화면에 보이는 activity
                // 현재 화면(MainActivity.this)에서 새로운 Activity가 보이도록 인텐트를 생성
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);

                // 생성된 새로운 인텐트를 보이도록 start
                startActivity(loginIntent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pIntent = new Intent(Intent.ACTION_CALL_BUTTON); // 시스템에 들어있는 인텐트를 불러온다
                startActivity(pIntent);
            }
        });

        // Toolbar toolbar = findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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
