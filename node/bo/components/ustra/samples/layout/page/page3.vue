<template>
  <v-card>
    <template #title> 상단영역고정 </template>
    <template #subtitle> </template>
    <template #text>
      <div class="sample-wrap">
        <UBox direction="col">
          <UItem baseSize="100">
            <div class="box3">Top</div>
          </UItem>
          <UItem ratio="1">
            <UBox direction="row">
              <UItem ratio="1"><div class="box1">Left</div> </UItem>
              <UItem ratio="1"><div class="box2">Right</div> </UItem>
            </UBox>
          </UItem>
        </UBox>
      </div>
      <UMarkdownViewer>
        {{ page3 }}
      </UMarkdownViewer></template
    >
  </v-card>
</template>

<script setup lang="ts">
import './style/page.scss'
import page3 from './md/page3.md'
</script>

<style scoped></style>
