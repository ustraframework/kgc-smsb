UExcelFileUploader 컴포넌트는 USingleFileUploader를 확장하여 엑셀 파일을 업로드하고 리딩된 결과를 수신하거나 Java Applicaiton 에서 후처리를 수행할 수 있는 기능을 제공한다.
이를 위해 USingleFileUploader가 제공하는 속성 외에 아래와 같은 추가 속성을 제공한다.

| name | 유형 | 설명 | default |
| --- | --- | --- | --- |
| storeResource | boolean | 저장소에 저장할지 여부. false로 설정할 경우, 저장소에 저장하지 않고 엑셀을 리딩한 결과만 반환한다. | false |
| stopOnError | boolean | 엑셀 리딩 중 오류가 발생했을 경우, 중지 여부 | false |
| modelClassName | string | 모델로 변환할 경우, 클래스 명 |  |
| headerRowIndex | number | 헤더 row의 index 번호를 지정 | 0 |
| excelDataPostProcessorBeanName | string | 엑셀 업로드 후처리 Bean 명 |  |
| excelDataPostProcessorParameter | string | 엑셀 데이터 후처리기 전송 파라메터 |  |
| sheetNamesOrIndexes | (string ｜ number)[] | 다중 sheet 리딩 시 index 또는 sheet 명 | [] |
| password | string | 엑셀 파일 비밀번호 |  |

UExcelFileUploader 컴포넌트에서 지원하는 이벤트는 다음과 같다.
| name | 설명 | 인자 값 |
| --- | --- | --- |
| selected | 파일이 선택되었을 경우 발생한다. | file : 선택된 file 객체 |
| removed | 업로드 된 파일이 삭제되었을 경우, 발생한다. | - |


storeResource 프로퍼티가 false로 설정되어 있을 경우, 서버 상에 파일을 저장하지 않고 엑셀 파일을 리딩하여 데이터를 제공하는 기능을 제공한다. 단일 파일 업로드 시와 동일하게 upload 메소드를 호출하고 return 값으로 변환된 결과를 수신한다.
