<template>
  <div class="min-w-[1280px]">
    <Header />
    <main class="container !max-w-full bg-white flex flex-col">
      <slot></slot>
    </main>
  </div>
</template>
<script lang="ts" setup>
import Header from '@/components/layouts/header.vue'
</script>
<script lang="ts"></script>
<style lang="scss">

</style>
