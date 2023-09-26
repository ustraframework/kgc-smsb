messages 속성을 설정하여 예외 상황 발생 시의 메시지를 커스토마이징할 수 있다. messages 속성은 다음과 같이 정의되어 있다.
```typescript
/**
 * 메시지 유형
 */
export type CustomMessage = {
  /**
   * 파일 그룹 조회 실패 메시지
   */
  'ustra.file.notFoundFileGroup'?: string

  /**
   * 파일 용량 초과 메시지
   */
  'ustra.file.fileLimitExceeded'?: string

  /**
   * 파일 조회 실패 메시지
   */
  'ustra.file.errorOnRetrievingFile'?: string

  /**
   * 파일 Resource Not Found 실패 메시지
   */
  'ustra.file.cannotFoundFile'?: string

  /**
   * 업로드 오류 메시지
   */
  'ustra.file.errorOnUploadFile'?: string

  /**
   * 다운로드 오류 메시지
   */
  'ustra.file.errorOnDownloadFile'?: string
}
```
messages 속성은 USingleFileUploader, UMultiFileUploader, UImageUploader, UExcelFileUploader 컴포넌트에서 제공하고 있다.

메시지 관련 내용과 전역 메시지 변경 방법은 http://guide.ustraframework.kro.kr/ref-doc/11/4drym773gB4q54P7kobj 를 참고한다.
