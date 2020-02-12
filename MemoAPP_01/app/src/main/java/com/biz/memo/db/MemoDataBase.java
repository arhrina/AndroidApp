package com.biz.memo.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.biz.memo.domain.MemoVO;
import com.biz.memo.repository.MemoDao;

/*
abstract로 만들고 RoomDatabase를 extends하고 어노테이션을 붙인다
version은 임의의 숫자를 넣고 갱신되면 그보다 큰 수로만 수정해주면 된다
 */
@Database(entities = {MemoVO.class}, version = 1)
abstract public class MemoDataBase extends RoomDatabase {


    /*
    데이터베이스 INSTANCE가 생성되면서 MemoDao Interface를 가져다가 사용할 수 있는 클래스를 생성
     */
    abstract public MemoDao getMemoDao();

    /*
    DB를 생성하는 클래스를 싱글톤으로 선언하기 위해 외부에서 접근하는 변수를 선언
     */
    private static volatile MemoDataBase INSTANCE;

    public static MemoDataBase getInstance(Context context){
        if(INSTANCE == null){ // DB가 없으면
            synchronized (MemoDataBase.class){ // 싱글톤으로 선언
                INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        MemoDataBase.class,
                        "memo.dbf"
                ).build(); // 물리적으로 memo.dbf 생성
            }
        }
        return INSTANCE; // 싱글톤 선언한 객체를 리턴
    }
}
