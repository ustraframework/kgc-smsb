<template>
  <div class="flex flex-col h-full">
    <SubHeader />
    <main class="container !max-w-full bg-white flex flex-col flex-1">
      <slot></slot>
    </main>
    <SubFooter v-show="footerVisible"/>
  </div>
</template>
<script lang="ts" setup>
import SubHeader from '@/components/mobile/layouts/subHeader.vue';
import SubFooter from '@/components/mobile/layouts/subFooter.vue';

const route = useRoute();

const footerVisible = computed(() => {
  return route.meta.footer === "none" ? false : true ;
})

</script>
<style lang="scss"></style>
