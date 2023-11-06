<template>
  <div>
    <NuxtLayout :name="layout">
      <NuxtLoadingIndicator />
      <NuxtPage />
    </NuxtLayout>
    <UDialog />
    <ULoadingBar />
  </div>
</template>

<script lang="ts" setup>
const stringState = useStringState()
const UDialog = defineAsyncComponent(() => import('#ustra/nuxt-vuetify/components').then(c => c.UDialog))
const ULoadingBar = defineAsyncComponent(() => import('#ustra/nuxt-vuetify/components').then(c => c.ULoadingBar))
const layout = computed(() => {
  const useTabUi = $ustra.env.appProps.nuxt?.management?.ui?.tabMenu?.enabled
  const mainPagePath = $ustra.env.appProps.nuxt?.management?.ui?.defaultPage?.main?.path
  const layoutProp = $ustra.env.appProps.nuxt?.management?.ui?.defaultPage?.layout
  const metaLayout = useCurrentPageMeta()?.layout
  const route = useRoute()

  if (metaLayout !== null && metaLayout !== undefined) {
    return metaLayout
  }

  if (mainPagePath === route.path && useTabUi && layoutProp?.layoutName) {
    return layoutProp.layoutName
  }

  if (useTabUi && layoutProp?.layoutName) {
    return false
  }

  if (layoutProp?.include && layoutProp?.layoutName) {
    return layoutProp.layoutName
  }
  return 'default'
})

$ustra.hooks.hook('management:initial-data:loaded', info => {
  // console.log(info.sourceType, info.data)
  // console.log('app.vue : stringState : ' + stringState.stringValue.value)
})
</script>
