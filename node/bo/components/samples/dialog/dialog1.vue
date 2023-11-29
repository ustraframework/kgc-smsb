<template>
  <VCard>
    <template #text>
      프로젝트에 적용된 공통 Dialog 기능에 대해 안내한다.
      <br /><br />

      <h3>일반 alert 창 오픈</h3>
      <UMarkdownViewer :content="doc1" />
      <UButton text="일반 alert 창 오픈" @click="() => showAlert()" />
      <UMarkdownViewer :content="doc2" />

      <br /><br />
      <h3>오류 alert 창 오픈</h3>
      <UMarkdownViewer :content="doc3" />
      <UButton text="오류 alert 창 오픈" @click="() => showErrorAlert()" />
      <UMarkdownViewer :content="doc4" />

      <br /><br />
      <h3>confirm 창 오픈</h3>
      <UMarkdownViewer :content="doc5" />
      <UButton text="confirm 창 오픈" @click="() => showConfirm()" />
      <UMarkdownViewer :content="doc6" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
// @ts-ignore
import doc1 from './md/dialog1-1.md'

// @ts-ignore
import doc2 from './md/dialog1-2.md'

// @ts-ignore
import doc3 from './md/dialog2-1.md'

// @ts-ignore
import doc4 from './md/dialog2-2.md'

// @ts-ignore
import doc5 from './md/dialog3-1.md'

// @ts-ignore
import doc6 from './md/dialog3-2.md'

function showAlert() {
  useAlert('성공적으로 완료됨.', '완료되었습니다.', '완료안내')
}

function showErrorAlert() {
  useErrorAlert('정보를 정확하게 입력해주세요.')
}

async function showConfirm() {
  const result = await useConfirm('삭제된 데이터는 복구가 불가능합니다.', '데이터를 삭제하시겠습니까?', '삭제안내', '삭제')
  useErrorAlert('결과 값 : ' + result)
}
</script>
