## RecyclerView를 사용한 List 표현(2020-2-11)

* RecyclerView만으로는 List를 표현하기가 다소불편하다.
* RecyclerView의 요소를 표현할 Apdater를 생성하고
* Adapter 내부에 Holder를 생성하여 Inflater를 수행하여 모양을 만든다.

1. Holder에 사용할 item view 페이지를 생성

## DB를 반영하기(2020-2-12)

* Android OS에는 SQL Lite라는 소형 DBMS가 내장되어있다
* SQL Lite는 범용으로 사용하는 최소한의 기능을 가진 DBMS이다
* 일반적인 SQL을 사용해서 DB 핸들링이 가능
* SQL Lite를 직접 핸들링하지 않고 room라는 ORM을 사용해 추상화하고
DB 핸들링을 수행한다. hibernate랑 상당히 유사

## Room DB 사용
1. Table로 사용할 vo를 entity로 선언
2. dao로 사용할 interface 정의
3. DB 연결과 dao Imp를 생성할 클래스 정의(MemoDataBase 클래스)
4. Repository(Service) DB에 접근하는 연결 클래스 정의