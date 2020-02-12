package com.biz.memo.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity(tableName = "tbl_memo")
public class MemoVO {

    /*
    PK로 지정된 숫자 칼럼에 auto_increment를 부여하는 옵션
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="rowid")
    private long id;

    @ColumnInfo(name="m_date")
    private String m_date;
    @ColumnInfo(name="m_time")
    private String m_time;
    @ColumnInfo(name="m_text")
    private String m_text;

}
