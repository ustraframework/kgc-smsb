파일 업로드에 관련된 기본적인 샘플은 다음의 URL에서 확인할 수 있다.
- 

DRM 관련된 파일 그룹을 common.yml에 설정하면, 암호화 된 파일을 업로드 할 경우 파일의 암호화를 해제하여 저장하고 저장된 파일을 다운로드할 경우는 다시 암호화하여 다운로드할 수 있다.

```yaml
smsb:
  common:
    file:
      drm:
        file-groups: #drm 적용할 파일 그룹 목록
          - ustra-sample
          - ustra-sample-excel
```
