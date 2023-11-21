<template>
  <VCard title="서비스 생성 예제">
    <template #text>
      <UMarkdownViewer :content="service1" />
      아래 예제는 서비스 참조를 통해 API에서 조회된 데이터를 그리드에 바인딩하는 예제이다.

      <div>
        <WjFlexGrid :initialized="grid.initialize" :itemsSource="codeList">
          <WjFlexGridColumn header="코드" binding="dtlCd" />
          <WjFlexGridColumn header="명" binding="cdNm" />
        </WjFlexGrid>
      </div>

      <UMarkdownViewer :content="service2" /> </template
  ></VCard>
</template>
<script lang="ts" setup>
// @ts-ignore
import service1 from './md/service1.md'

// @ts-ignore
import service2 from './md/service2.md'

import { useSampleService } from '~/services/sample/sample-service'
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'

const sampleService = useSampleService()
const codeList = ref(await sampleService.getList({ grpCd: 'SYS_CD' }))
const grid = useWijmoFlexGrid()
</script>
