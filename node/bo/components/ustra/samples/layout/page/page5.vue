<template>
  <v-card>
    <template #title> 마스터디테일구조 </template>
    <template #subtitle> width 고정 </template>
    <template #text>
      <div class="sample-wrap">
        <UBox direction="col">
          <UItem baseSize="100">
            <div class="box3">Top</div>
          </UItem>
          <UItem ratio="1">
            <UBox direction="row">
              <UItem baseSize="200"><div class="box1">Left</div> </UItem>
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
        {{ page5 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import './style/page.scss'
import page5 from './md/page5.md'
</script>
<style scoped></style>
