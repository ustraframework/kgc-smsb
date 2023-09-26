<template>
  <VCard>
    <template #text>
      Image Uploader 컴포넌트를 그리드 Editor로 사용하여 이미지를 그리드 상에서 입력하는 방법에 대해 안내한다.
      <br /><br />
      <br />
      <UMarkdownViewer :content="doc1"></UMarkdownViewer>

      <UButton text="저장" @click="() => save()" />

      <br />
      <WjFlexGrid :virtualizationThreshold="50" :itemsSource="data" :initialized="grid.initialize" class="mt-2" style="height: 450px">
        <WjFlexGridColumn header="Title" binding="title" width="*" />

        <WjFlexGridColumn header="Image" binding="fileId" :width="310">
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
          <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
            <UImageUploader
              v-model:fileId="cell.item.fileId"
              fileGroupId="ustra-sample-image"
              :width="300"
              :height="200"
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
        </WjFlexGridColumn>
      </WjFlexGrid>

      <UMarkdownViewer :content="doc2"></UMarkdownViewer>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { UImageUploader } from '#ustra/nuxt-wijmo/management/components'

// @ts-ignore
import doc1 from './md/uploader1-1.md'

// @ts-ignore
import doc2 from './md/uploader1-2.md'

interface GridData {
  // 제목
  title: string

  // 파일 아이디
  fileId: string

  // 파일 업데이트 여부
  updatedFile: boolean

  // 선택 파일 정보
  selectedFile: File

  // 이미지 소스
  imgSrc: string
}

const data = ref<GridData[]>()
function init() {
  data.value = ['첫 번째 데이터', '두 번째 데이터', '세 번째 데이터'].map(title => {
    return {
      title,
      fileId: null,
      updatedFile: false,
      imgSrc: null,
      selectedFile: undefined,
    }
  })
}
init()

const grid = useWijmoFlexGrid<GridData>({
  onAfterInitialized(control) {
    control.rows.defaultSize = 210
  },
  isReadOnly: false,
  autoSelection: false,
  editing: {
    useInlineEditTracking: true,
  },
})

async function setFile(data: GridData, file: File) {
  data.updatedFile = true
  data.selectedFile = file
  data.imgSrc = await $ustra.utils.file.readDataUrl(file)
}

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
</script>
