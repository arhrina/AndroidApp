package com.biz.myapp.utils;

import android.view.View;
import android.widget.TextView;

import com.biz.myapp.R;
import com.google.android.material.snackbar.Snackbar;

/*
View class
안드로이드에서 눈에 보이는 모든것(Layout, Button, Textview, TextEdit 등)은 모두
view class를 상속받아서 만들어진 component이다

어떤 이벤트나 액션을 지정할 때 기존의 클래스나 인터페이스를 상속 또는 implements해야하는데
자기 자신의 클래스를 사용하지 않고 View 클래스의 요소들을 상속받아서 클래스를 작성하는게 원칙(패턴)
 */
public class MyViewClass implements View.OnClickListener { // 클릭시 이벤트설정하는 Onclicklistener

    /*
    onClick 메서드는 btn1 버튼을 클릭했을 때 호출되는 메서드
    btn1을 클릭하면 클릭된 버튼의 모든 요소가 View인 v 객체변수에 담겨 onClick 메서드로 전달된다
     */
    @Override
    public void onClick(View v) {

        String msg = "Die";
        /*
        이벤트가 발생하면 onClick 메서드가 실행되고, 어떤 id로부터 호출되었는지를 확인하고 싶을 때
        뷰로부터 getId를 사용하면 호출한 컴포넌트의 id값을 얻어올 수 있다
         */
        if(v.getId() == R.id.btn1){
            msg += "\n버튼1을 클릭";
        }
        else if(v.getId() == R.id.txt1){
            /*
            이벤트가 발생한 뷰로부터 어떤 값을 얻어오고자 한다면, 해당 view로 형변환을 한번 수행해서 객체를 만들고
            만든 객체에서 각 view의 고유한 메서드를 호출하면 된다
             */
            TextView t = (TextView)v;
            msg += "\n" + t.getText();
        }
        else if(v.getId() == R.id.txt2){
            TextView t = (TextView)v;
            msg += "\n" + t.getText();
        }
        Snackbar.make(v, msg, Snackbar.LENGTH_SHORT).show();
    }

}
