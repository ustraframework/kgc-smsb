```html
<template>
  <UButton text="Image URL 조회" @click="getWebImageUrl" />
  <img :src="webFileImageUrl" v-if="webFileImageUrl" style="max-height: 200px" />
</template>
<script lang="ts" setup>
const webFileImageUrl = ref(null)
async function getWebImageUrl() {
  webFileImageUrl.value = await $ustra.management.file.getWebAccessUrl(fileId.value, fileNo.value, 'ustra-sample-image')
}
```
