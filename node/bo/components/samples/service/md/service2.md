```html
<template>
  <div>
    <WjFlexGrid :initialized="grid.initialize" :itemsSource="codeList">
      <WjFlexGridColumn header="코드" binding="dtlCd" />
      <WjFlexGridColumn header="명" binding="cdNm" />
    </WjFlexGrid>
  </div>
</template>
<script lang="ts" setup>
import { useSampleService } from '~/services/cu/cu-sample-service'
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'

const sampleService = useSampleService()
const codeList = ref(await sampleService.getList({ grpCd: 'SYS_CD' }))
const grid = useWijmoFlexGrid()
</script>
```
