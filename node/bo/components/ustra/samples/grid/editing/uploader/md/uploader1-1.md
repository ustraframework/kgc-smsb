업로드 컴포넌트는 인라인으로 사용할 경우 잦은 refresh 로 인한 성능 저하 이슈가 있으므로 CellEdit 템플릿을 사용하여 에디트 모드에서만 에디터를 렌더링하여 편집을 처리한다. 

```html
<WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
  <UImageUploader
    v-model:fileId="cell.item.fileId"
    fileGroupId="ustra-sample-image"
    :width="300"
    :height="300"
    :autoLoadFileInfo="false"
    @initialized="
      exposed => {
        if (cell.item.selectedFile || cell.item.selectedFile === null) {
          exposed.setFile(cell.item.selectedFile)
        } else if (cell.item.fileId) {
          exposed.load()
        }
      }
    "
    @selected="file => setFile(cell.item, file)"
    @removed="
      () => {
        if (cell.item.fileId) {
          cell.item.updatedFile = true
        }
        cell.item.selectedFile = null
        cell.item.imgSrc = null
      }
    "
  />
</WjFlexGridCellTemplate>
```

CellEdit 유형으로 설정된 UImageUploader 컴포넌트의 selected와 removed 이벤트를 사용하여 선택된 파일 정보를 데이터에 저장한다.
에디트 모드가 종료되면 컴포넌트는 unmount 되므로 에디트 모드에서 기존에 입력된 파일 정보를 재복원해야 한다. 이 때는 initialized 이벤트를 사용하여 컴포넌트가 초기화 되어 있고, 선택된 파일이 있을 경우 setFile 메소드를 사용하여 선택된 파일 정보를 로드하도록 한다.
UImageUploader의 autoLoadFileInfo 속성은 false로 설정하였는데 fileId가 존재할 경우, 에디트 모드에 진입할 때마다 API 호출 후 파일 정보를 조회하도록 되어 있으므로 부하를 줄이기 위해 설정된 값이며, 선택된 파일 정보가 없고, fileId 존재 시에는 initialized 이벤트에서 load 메소드 호출을 통해 파일 정보를 로드하도록 처리한다.

위의 코드를 보면 파일 선택 시에는 setFile 메소드를 호출한다.
```typescript
async function setFile(data: GridData, file: File) {
  data.updatedFile = true
  data.selectedFile = file
  data.imgSrc = await $ustra.utils.file.readDataUrl(file)
}
```
setFile 메소드는 위와 같으며 File 객체의 값을 $ustra.utils.file.readDataUrl 메소드를 사용하여 data URL로 변환하여 브라우저에 표시할 수 있도록 한다.

에디트 모드가 아닐 때 표시되는 Cell 유형의 템플릿은 선택된 파일이 존재할 경우와 서버 상의 이미지를 표시할 경우를 분리하여 설정한다.
```html
<WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
  <div style="width: 300px; height: 100%">
    <img :src="cell.item.imgSrc" v-if="cell.item.imgSrc" style="max-height: 100%; max-width: 100%" />
    <img
      v-else-if="!!cell.item.fileId && cell.item.selectedFile !== null"
      :src="$ustra.management.file.getViewUrl(cell.item.fileId)"
      style="max-height: 100%; max-width: 100%"
    />
  </div>
</WjFlexGridCellTemplate>
```

useWijmoFlexGrid의 editing.useInlineEditTracking 설정을 true로 세팅하여 파일 변경 시에 데이터의 추적이 가능하도록 설정한다.
```typescript
const grid = useWijmoFlexGrid<GridData>({
  onAfterInitialized(control) {
    control.rows.defaultSize = 310
  },
  isReadOnly: false,
  autoSelection: false,
  editing: {
    useInlineEditTracking: true,
  },
})
```

저장 시에는 컴포넌트의 upload 메소드를 사용할 수 없으므로 프레임워크 플러그인에서 제공하는 $ustra.management.file.upload 메소드를 사용하여 업데이트된 파일 정보를 저장한다.
```typescript
async function save() {
  grid.selection.clear()
  const updatedData: GridData[] = grid.collectionView.itemsEdited
  $ustra.logger.info('updatedData', updatedData)

  if (updatedData.length < 1) {
    alert('변경된 데이터가 없습니다.')
    return
  }

  // 변경된 데이터의 파일을 모두 업로드 한다.
  for (const data of updatedData) {
    // 파일이 업데이트 되었을 경우, upload 처리
    if (data.updatedFile) {
      const result = await $ustra.management.file.upload('ustra-sample-image', data.fileId, data.selectedFile)
      data.fileId = result.fileId

      // 업로드가 완료되었으므로 파일 관련 속성은 초기화한다.
      data.selectedFile = undefined
      data.imgSrc = null
      data.updatedFile = false
    }
  }

  // 변경된 데이터의 변경 사항을 초기화한다.
  grid.collectionView.clearChanges()
  alert('저장되었습니다.')
}
```
