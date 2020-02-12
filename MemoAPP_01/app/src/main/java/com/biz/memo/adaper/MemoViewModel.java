package com.biz.memo.adaper;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.biz.memo.domain.MemoVO;
import com.biz.memo.repository.MemoRepository;

import java.util.List;

/*
DB와 연동하여 화면에 데이터를 보일 때,
직접 DB에서 데이터를 가져와서 보이지 않고
중간 매개체를 통해 처리를 수행하기 위해 만드는 클래스

안드로이드에서 이 클래스를 ViewModel이라고 한다
 */
public class MemoViewModel extends AndroidViewModel {

    private MemoRepository memoRepository;
    private List<MemoVO> memoList;

    public MemoViewModel(@NonNull Application application) {
        super(application);
        this.memoRepository = new MemoRepository(application);
        this.memoList = memoRepository.selectAll();
    }

    public List<MemoVO> selectAll(){
        return this.memoList;
    }

    public void insert(MemoVO memoVO){
        memoRepository.insert(memoVO);
    }
}
