package com.biz.memo.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.biz.memo.domain.MemoVO;

import java.util.List;

@Dao
public interface MemoDao {

    @Query("SELECT * FROM tbl_memo")
    public List<MemoVO> selectAll();

    @Query("SELECT * FROM tbl_memo WHERE id = :rowid") // 변수를 집어넣는건 #{rowid}가 아니라 :rowid를 쓴다
    public MemoVO findByRowId(long rowid);

    @Query("SELECT * FROM tbl_memo WHERE m_text LIKE :m_text")
    public List<MemoVO> findByText(String m_text);

    /*
    ORM 구조에서 새로운 데이터는 insert를 수행하고
    기존데이터는 replace(update)를 수행하는 메서드를 공통으로 사용한다
    onConflict해서 REPLACE
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE) // insert보단 save에 가깝다
    public void save(MemoVO memoVO);

    @Delete
    public void delete(long rowid);
}
