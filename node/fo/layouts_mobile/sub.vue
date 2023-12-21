<template>
  <div class="flex flex-col h-full">
    <SubHeader />
    <main class="container !max-w-full bg-white flex flex-col flex-1">
      <slot></slot>
    </main>
  </div>
</template>
<script lang="ts" setup>
import SubHeader from '@/components/mobile/layouts/subHeader.vue';
</script>
<style lang="scss"></style>
