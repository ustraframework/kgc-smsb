<template>
  <div>메인 화면 입니다</div>
</template>
<script lang="ts" setup>
import { onMounted } from '#ustra/nuxt'

onMounted(() => {})

const definePageMeta = (arg: any) => {}
definePageMeta({
  auth: {
    required: true,
  },
  layout: 'ustra',
})
</script>
