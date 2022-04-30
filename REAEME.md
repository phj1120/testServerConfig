# 협업용 서버 연결 확인

AWS EC2, 도메인 연결 완료.

제대로 됐는지 확인하고,

프론트 협업 하는 친구한테 테스트로 데이터 가져가 보라고

간단하게 제작

포트 : 8081

ex) http://with.parkh.xyz:8081/api/test

## 정적 페이지
/
```
hello
```

## API

* /api/test
```
{
    "error": null,
    "data": [
        "test"
    ]
}
```


/api/test?msg=hi
```
{
    "error": null,
    "data": [
        "hi"
    ]
}
```