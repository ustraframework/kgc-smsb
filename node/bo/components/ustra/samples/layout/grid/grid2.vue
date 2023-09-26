<template>
  <v-card>
    <template #title> 상하구성 </template>
    <template #subtitle> </template>
    <template #text>
      <UBox direction="col">
        <UItem ratio="1">
          <WjFlexGrid :itemsSource="data">
            <WjFlexGridColumn :header="'Country'" :binding="'country'" width="*" />
            <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" /> </WjFlexGrid
        ></UItem>
        <UItem ratio="1">
          <WjFlexGrid :itemsSource="data">
            <WjFlexGridColumn :header="'Country'" :binding="'country'" width="*" />
            <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" /> </WjFlexGrid
        ></UItem>
      </UBox>
      <UMarkdownViewer>
        {{ grid2 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { reactive } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import grid2 from './md/grid2.md'
//요청 URL: http://guide-dx.ustraframework.kro.kr/api/system/initializing-data.json
//요청 URL: http://guide-dx.ustraframework.kro.kr/api/system/code/group
const _getData = () => {
  // create some random data
  const countries = 'US,Germany,UK,Japan,Italy,Greece,US,Germany,UK,Japan,Italy,Greece,US,Germany,UK,Japan,Italy,Greece'.split(',')
  const data = []
  for (let i = 0; i < countries.length; i++) {
    data.push({
      id: i,
      country: countries[i],
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
    })
  }

  return data
}

const data = reactive(_getData())
</script>

<style scoped></style>
