smsb.common.file.drm.file-groups에 지정한 파일 그룹을 설정할 경우, 업로드 시에는 복호화를 수행하고 다운로드 시에는 암호화를 수행하나 다운로드 시에는 암호화를 수행하지 않으려는 경우는 smsb.common.file.drm.decrypt-only-file-groups 에 특정 파일 그룹을 추가한다.
```yaml
smsb:
  common:
    file:
      drm:
        file-groups: #drm 적용할 파일 그룹 목록
          - ustra-sample
          - ustra-sample-excel
        decrypt-only-file-groups: #복호화만 수행할 파일 그룹 목록
          - ustra-sample-excel 
```

단, file-groups 에도 파일 그룹은 포함되어야 한다.

아래 예제는 암호화 된 파일을 업로드하더라도 다운로드는 복호화 된 파일을 다운로드 받을 수 있는 예제이다.
