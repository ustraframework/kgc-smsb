각 데이터 유형별 포맷에 대한 항목은 다음을 참고한다.
- Number : https://learn.microsoft.com/en-us/dotnet/standard/base-types/standard-numeric-format-strings
- Date/Time : https://learn.microsoft.com/en-us/dotnet/standard/base-types/standard-date-and-time-format-strings
- Custom Date/Time : https://learn.microsoft.com/en-us/dotnet/standard/base-types/custom-date-and-time-format-strings


Date 유형의 경우, U.STRA Java 프레임워크와 REST API 통신을 수행한 데이터를 바인딩하는 경우는 반드시 다음과 같이 Date 유형으로 변경하여 그리드 데이터에 바인딩 해야 한다.
```typescript
const data = apiListData.map(row => {
  row.inputDate = row.inputData ? new Date(row.inputDate) : row.inputDate
})
```
