<template>
  <div class="flex flex-col min-w-[1280px] h-full">
    <Header />
    <main class="container !max-w-full bg-white flex flex-1 justify-center mt-[80px]">
      <Sidebar/>
      <div class="px-[103px]">
        <slot></slot>
      </div>
    </main>
    <Footer />
  </div>
</template>
<script lang="ts" setup>
import Header from '@/components/layouts/header.vue';
import Footer from '@/components/layouts/footer.vue';
import Sidebar from '@/components/layouts/sidebar.vue'
</script>
<style lang="scss"></style>
