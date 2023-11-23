<template>
  <div class="min-w-[1280px]">
    <Header />
    <main class="container !max-w-full bg-white flex flex-col">
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
