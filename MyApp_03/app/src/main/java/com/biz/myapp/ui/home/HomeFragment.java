package com.biz.myapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.biz.myapp.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;

    TextInputEditText textView1;
    TextInputEditText textView2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);

        textView1 = root.findViewById(R.id.txt_name);
        textView2 = root.findViewById(R.id.txt_tel);
        Button btn_save = root.findViewById(R.id.btn_save);

        btn_save.setOnClickListener(this);

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView1.setText(s);

            }
        });
        return root;
    }

    // 알트 엔터. 안드로이드 스튜디오 메서드 불러오기
    @Override
    public void onClick(View v) {

        // EditText는 getText() 메서드로 값 추출
        // TextInputEditText는 getText().toString()을 해야 정상적인 문자열로 추출이 가능
        String strName = textView1.getText().toString();
        String strTel = textView2.getText().toString();

        // btn_save 버튼이 눌렸을 때만 반응
        int id = v.getId();
        if(id == R.id.btn_save) {
            String msg = String.format("이름 : %s, 전화번호 : %s", strName, strTel);
            Snackbar.make(v, msg, Snackbar.LENGTH_LONG).show();
        }

    }
}