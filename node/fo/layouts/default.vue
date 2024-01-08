<template>
  <div class="flex flex-col min-w-[1280px] h-full">
    <Header />
    <main class="container !max-w-full flex flex-1 justify-center my-[80px]">
      <slot></slot>
    </main>
    <Footer />
  </div>
</template>
<script lang="ts" setup>
import Header from '@/components/layouts/header.vue';
import Footer from '@/components/layouts/footer.vue';
</script>
<style lang="scss"></style>
