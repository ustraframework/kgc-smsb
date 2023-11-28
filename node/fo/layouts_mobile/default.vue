<template>
  <div class="flex flex-col h-full">
    <Header />
    <main class="container !max-w-full bg-white flex flex-col flex-1">
      <slot></slot>
    </main>
  </div>
</template>
<script lang="ts" setup>
import Header from '@/components/mobile/layouts/header.vue';
</script>
<style lang="scss"></style>
