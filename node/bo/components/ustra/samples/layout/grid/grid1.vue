<template>
  <v-card>
    <template #title>좌우구성 </template>
    <template #subtitle> </template>
    <template #text>
      <UBox direction="row">
        <UItem ratio="2">
          <WjFlexGrid :itemsSource="data" style="width: 100%; height: 300px">
            <WjFlexGridColumn :header="'Country'" :binding="'country'" width="*" />
            <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
          </WjFlexGrid>
        </UItem>
        <UItem ratio="1">
          <WjFlexGrid :itemsSource="data" style="width: 100%; height: 300px">
            <WjFlexGridColumn :header="'Country'" :binding="'country'" />
            <WjFlexGridColumn :header="'Sales'" :binding="'sales'" format="n2" />
          </WjFlexGrid>
        </UItem>
      </UBox>
      <UMarkdownViewer>
        {{ grid1 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { reactive } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import grid1 from './md/grid1.md'
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
