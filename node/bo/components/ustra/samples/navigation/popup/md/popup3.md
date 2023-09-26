```html
<template>
  <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>

  <UPopup v-model="showPopup" :width="800" :height="600" title="팝업제목">
    <div>내용</div>
    <template #buttons>
      <UButton
        text="저장"
        type="primary"
        @click="
          () => {
            useGlobal()
              .alert('저장되었습니다.')
              .then(() => (showPopup = false))
          }
        "
      />
      <UButton
        text="닫기"
        @click="
          () => {
            useGlobal()
              .confirm('창을 닫으시겠습니까?')
              .then(r => {
                if (r) showPopup = false
              })
          }
        "
      />
    </template>
  </UPopup>
</template>
<script lang="ts" setup>
  const showPopup = ref(false)
</script>
```
