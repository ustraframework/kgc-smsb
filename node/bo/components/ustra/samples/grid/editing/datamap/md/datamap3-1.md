프레임워크에서는 공통코드를 DataMap으로 생성해주는 createUstraCodeDataMap 메소드를 제공한다.
createUstraCodeDataMap는 2개의 인자 값을 설정할 수 있다.

| name | 유형 | 설명 | 필수 여부 |
| --- | --- | --- | --- |
| grpCd | string | 공통코드 목록을 가져오기 오기 위한 그룹 코드 |  |
| nullText  | string | null 값을 가진 기본 목록을 표시하기 위한 텍스트 값 | 필수 |

다음과 같이 호출하여 코드 목록을 가진 DataMap 객체를 리턴 받을 수 있다.
```typescript
// 시스템 코드 목록 DataMap 조회
createUstraCodeDataMap('SYS_CD')

// null 값 항목과 코드 목록 DataMap 조회
createUstraCodeDataMap('USE_DV_CD', '없음.')
```
