<template>
  <v-card>
    <template #title> UBox disabled 속성 </template>
    <template #subtitle> disabled설정된 레이아웃 작업 불가 처리. </template>
    <template #text>
      <div class="sample-wrap">
        <UBox direction="col">
          <UItem :baseSize="100">
            <div class="box3">Top</div>
          </UItem>
          <UItem :ratio="1">
            <UBox direction="row" disabled>
              <UItem ratio="1"><div class="box1">Left</div> </UItem>
              <UItem ratio="1">
                <UBox direction="col">
                  <UItem ratio="1"><div class="box2">Right1</div> </UItem>
                  <UItem ratio="1"><div class="box2">Right2</div> </UItem>
                </UBox>
              </UItem>
            </UBox>
          </UItem>
        </UBox>
      </div>
      <UMarkdownViewer>
        {{ page8 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import './style/page.scss'
import page8 from './md/page8.md'
</script>
<style scoped>
.u-layout-state-disabled {
  opacity: 0.3;
}
</style>
