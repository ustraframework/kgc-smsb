useWijmoFlexGrid 메소드에서 반환되는 객체의 export.toExcel 메소드를 사용하여 grid 데이터를 엑셀 파일 형태로 Export할 수 있다.

toExcel 메소드의 원형은 다음과 같다.
```typescript
/**
 * grid 데이터를 excel로 변환한다.
 * @param filename 파일 명
 * @param async 비동기 여부 (@default true)
 * @param options export 옵션
 * @returns Workbook
 */
function toExcel(filename: string, async: boolean = true, options: ExcelExportOption = {}) {
}
```

toExcel 메소드는 반환할 파일명과 비동기 여부, 세부 option을 설정할 수 있다.
단순 그리드 데이터를 파일로 저장하기 위한 기본 사용법은 다음과 같다.

```typescript
const grid = useWijmoFlexGrid()

// to excel
grid.export.toExcel('export.xlsx')
```

두번째 인자 값인 async 메소드의 경우 비동기적으로 처리를 할 수 있는 추sheetVisible가 옵션을 제공하며 ExcelExportOption 항목에 세팅할 수 있다.
세번째 인자인 ExcelExportOption은 다음과 같은 속성을 제공한다.

| name | 유형 | 설명 | default |
| --- | --- | --- | --- |
| sheetVisible | boolean | sheet 표시 여부를 설정한다. single sheet를 가진 엑셀을 생성할 경우는 엑셀 파일이 열리지 않으므로 주의해야 한다.  | true |
| includeColumnHeaders  | boolean | 첫째 행에 컬럼 헤더 표시 여부를 설정한다. | true |
| includeRowHeaders  | boolean | 첫째 열에 Row 헤더 표시 여부를 설정한다. | false |
| includeStyles  | boolean | 그리드의 Style을 적용할지 여부를 설정한다. true로 설정할 경우, 웹에서 표시하는 형태대로 변환된다. | true |
| activeWorksheet  | string ｜ number | Multi sheet일 경우, 활성화 된 sheet를 지정한다. |  |
| includeColumns  | (column:Column) => boolean | 변환 시 포함될 컬럼을 동적으로 설정한다. |  |
| formatItem  | (args: XlsxFormatItemEventArgs) => void | 변환 시 모든 cell마다 호출되며 cell의 값과 style을 조정할 수 있다. |  |
| quickCellStyles  | boolean | 빠른 변환을 위해 cell style을 캐싱할지 여부를 설정한다. | true |
| convertHtmlEntities  | HtmlEntityConversion | "＆quot;", "＆lt;", "＆gt;" and "＆amp;" 등의 HTML 전용 문자열을 컨버젼하는 방식을 지정한다. | HtmlEntityConversion.Auto |
| onSaved  | onSaved?: (base64: string, workbook: mXlsx.Workbook) => any | 엑셀 저장이 완료되었을 때 호출되는 callback  (async only) |  |
| onError  | (reason?: any) => any | 오류가 발생했을 때, 호출되는 callback  (async only) |  |
| onProgress  | (value: number) => void | 엑셀 변환이 이루어질 때 호출되는 progress callback (async only) |  |

