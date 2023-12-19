<template>
  <div>
    <NuxtLayout :name="layout">
      <NuxtPage />
    </NuxtLayout>
    <UDialog />
    <ULoadingBar />
  </div>
</template>
<script lang="ts" setup>
const UDialog = defineAsyncComponent(() => import('#ustra/nuxt-vuetify/components').then(c => c.UDialog));
const ULoadingBar = defineAsyncComponent(() => import('#ustra/nuxt-vuetify/components').then(c => c.ULoadingBar));
const layout = computed(() => {
  const metaLayout = useCurrentPageMeta()?.layout;

  if (metaLayout !== null && metaLayout !== undefined) {
    return metaLayout;
  }

  return 'default';
});
</script>
