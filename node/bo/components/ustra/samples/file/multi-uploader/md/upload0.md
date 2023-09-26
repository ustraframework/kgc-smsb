USingleFileUploader 컴포넌트는 단일 파일의 업로드 및 수정을 지원하는 컴포넌트이며, 다음과 같은 속성을 지원한다.


| name | 유형 | 설명 | default |
| --- | --- | --- | --- |
| fileGroupId | string | 업로드를 처리하기 위해 fileGroupId 속성이 필요하며, 백 오피스 파일 그룹 관리에서 그룹 정보를 등록하고 사용할 그룹 아이디 값을 해당 속성에 세팅한다. (필수 값) |  |
| fileId  | string | 수정 모드 시, 기존 파일 정보를 로드하기 위한 양방향 바인딩 값이며, string 유형으로 필수로 설정해야 한다. 신규 모드는 null 값을 설정한다. (필수 값) |  |
| readonly  | boolean | 컴포넌트를 조회와 다운로드만 가능한 상태로 만든다. | false |

