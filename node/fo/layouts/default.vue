<template>
  <Header />
  <main class="container !max-w-full bg-white">
    <slot></slot>
  </main>
</template>
<script lang="ts" setup>
import Header from '@/components/layouts/header.vue'
</script>
<script lang="ts"></script>
<style lang="scss">
.contents {
}
</style>
