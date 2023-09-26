tooltip 옵션은 enabled 외에 다음과 같은 추가 속성을 제공한다.

| name | 유형 | 설명 | default |
| --- | --- | --- | --- |
| position | PopupPosition | 팝업 위치 (http://demo.grapecity.co.kr/wijmo/api/enums/wijmo.popupposition.html) | PopupPosition.RightTop |
| isAnimated  | boolean | fade in 애니메이션 적용 여부 | true |
| isContentHtml  | boolean | HTML 컨텐츠 표시 여부 | true |
| cssClass  | string | 추가할 css class |  |
| gap  | number | Tooltip과 target element의 pixel 거리 | 6 |
| showAtMouse  | boolean | 마우스와의 거리 계산 여부 | true |
| showDelay  | number | tooltip을 보여주는 delay (ms) | 500 |
| hideDelay  | number | toolip을 숨기는 delay (ms) | 0 |
| modifyTooltipText  | (grid: FlexGrid, e: FormatItemEventArgs, text: any) => string | tooltip text를 변경하는 핸들러 |  |
