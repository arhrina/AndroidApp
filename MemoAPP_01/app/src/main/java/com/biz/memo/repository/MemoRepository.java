package com.biz.memo.repository;

import android.app.Application;

import com.biz.memo.db.MemoDataBase;
import com.biz.memo.domain.MemoVO;

import java.util.List;

/*
DB에 접근할 때 사용할 서비스 클래스. 안드로이드에선 서비스를 Repository라는 이름으로 쓰는것을 권장
 */
public class MemoRepository {
    private MemoDao mDao;

    // alt+insert버튼


    public MemoRepository(Application application) {
        /*
        mainActivity(Controller)에서 호출할 메서드. 메인액티비티에서 application에게 건네주고 db에서 불러온다
         */
        MemoDataBase db = MemoDataBase.getInstance(application);
        mDao = db.getMemoDao();
    }

    public List<MemoVO> selectAll(){
        return mDao.selectAll();
    }

    public void insert(MemoVO memoVO){
        mDao.save(memoVO);
    }
}
