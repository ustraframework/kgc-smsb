UImageUploader 컴포넌트를 사용하여 이미지 파일을 업로드 처리할 수 있으며 다음과 같은 속성을 제공한다.

| name | 유형 | 설명 | default |
| --- | --- | --- | --- |
| fileGroupId | string | 업로드를 처리하기 위해 fileGroupId 속성이 필요하며, 백 오피스 파일 그룹 관리에서 그룹 정보를 등록하고 사용할 그룹 아이디 값을 해당 속성에 세팅한다. (필수 값) |  |
| fileId  | string | 수정 모드 시, 기존 파일 정보를 로드하기 위한 양방향 바인딩 값이며, string 유형으로 필수로 설정해야 한다. 신규 모드는 null 값을 설정한다. (필수 값) |  |
| width | string ｜ number | 컴포넌트의 넓이를 숫자 또는 문자열 형태로 세팅한다. | '100%' |
| height | string ｜ number | 컴포넌트의 높이를 숫자 또는 문자열 형태로 세팅한다. | '100%' |
| readonly  | boolean | 컴포넌트를 조회와 다운로드만 가능한 상태로 만든다. | false |
| autoLoadFileInfo  | boolean | fileId 속성이 변경되었을 경우, API를 호출하여 파일 정보를 로드한다. false로 지정할 경우는 API 호출을 통한 파일 정보 로드를 수행하지 않으므로 업로드 된 이미지도 표시되지 않는다. load 메소드를 호출 시에 수동으로 로드가 가능하다. | true |


UImageUploader 컴포넌트에서 지원하는 이벤트는 다음과 같다.
| name | 설명 | 인자 값 |
| --- | --- | --- |
| selected | 파일이 선택되었을 경우 발생한다. | file : 선택된 file 객체 |
| removed | 업로드 된 파일이 삭제되었을 경우, 발생한다. | - |
| initialized | 컴포넌트 초기화 시 | exposed: 컴포넌트에서 지원하는 메소드 객체 (Record<string, any>) |

