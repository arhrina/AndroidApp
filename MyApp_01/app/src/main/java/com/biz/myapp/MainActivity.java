package com.biz.myapp;

import android.os.Bundle;

import com.biz.myapp.utils.MyViewClass;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/*
안드로이드 이벤트 핸들러. 두번째로 많이 사용되는 방법
Activity 자체를 이벤트 핸들러로 선언

View.On....클래스를 implements 해주고 on....메서드를 구현
사용할 땐 view.setOn...(this)
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt11;
    TextView txt22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt11 = findViewById(R.id.txt1);
        txt22 = findViewById(R.id.txt2);

        TextView txt1 = findViewById(R.id.txt1);
        TextView txt2 = findViewById(R.id.txt2);
        Button btn1 = findViewById(R.id.btn1);

        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);

        btn1.setOnClickListener(this); // 익명클래스가 아닌 만든 클래스



        FloatingActionButton fab = findViewById(R.id.fab);
        /*
        이벤트 핸들링 첫번째 방식. 혼자 단독으로 이벤트
        익명 클래스를 생성하여 자체적으로 이벤트를 핸들링
         */
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

    /*
    자체에서 onClick 메서드를 구현하여 이벤트를 핸들링하는 이유
    이벤트를 처리해야 할 view들은 대체로 이벤트 처리 코드가 유사한 경우, 한번만 이벤트 처리코드를 작성하고
    view들이 공유해서 사용하기 위함

    뷰의 getId 메서드를 사용해서 누가 호출했는가를 구분해서 코드를 진행
     */

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.txt2){
            txt11.setText(txt22.getText());
        }
        else{
            txt11.setText("GOOD DAY TO DIE");
        }
    }
}
