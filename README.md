# 서버 확인용 프로젝트

서버 구축 후 제대로 되었는지 확인 하기 위한 프로젝트

도메인 등록, 방화벽 설정 제대로 됐는지 확인하고,

프론트 협업 하는 친구한테 테스트로 데이터 가져가 보라고 간단하게 제작

## 사용법

포트 : 8081

ex) http://with.parkh.xyz:8081/api/test

## 정적 페이지

/

```
hello
```

/static/

```
static/test
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

# 과정

전에 하던 것 그대로 올려서 요청 보냈는데 실패

mysql 설치 안 됐다고 그럴리가 없는데...

이 기회에 테스트용 프로젝트 만들자. 불필요한거 삭제해가며 이 프로젝트 제작

AWS 에서 포트 열어주고 했는데 왜 안 될까, jenkins 는 되는데

포트 충돌은 안났어도 어디에서 쓰는 중인가?

curl 이용해서 자체에서 요청 보내 봄

localhost:8081/api/test 성공

with.parkh.xyz:8081/api/test 실패

뇌정지 옴

문제는 포트 바꾸는거 구글링 해올때

```
server.address=localhost
server.port=8081
```

위에꺼 까지 같이 복붙해서 였음

아무 생각 없었다가 음? localhost? 지우니까 됐음

api 는 성공

페이지가 안 불러와짐

현재 내장 톰캣 이용해 배포 중

bootWar 로 빌드, nohup java -jar ~~ & 로 배포

```
@Override
public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**")
            .addResourceLocations("classpath:static/"); // 내장 톰캣으로 배포 시
//              .addResourceLocations("file:src/main/resources/static/", "file:src/main/resources/templates/"); // 파일 갱신 시 적용 O
//              .addResourceLocations("classpath:static/", "classpath:templates/"); // 파일 갱신 시 적용 X
```

위와 같음

성공!

젠킨스, 도커도 살짝 공부하고 있는 중인데 나중에 한 번 적용 해봐야겠다.
