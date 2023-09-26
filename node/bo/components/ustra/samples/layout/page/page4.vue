<template>
  <v-card>
    <template #title> 마스터디테일구조 </template>
    <template #subtitle> </template>
    <template #text>
      <div class="sample-wrap">
        <UBox direction="col">
          <UItem :baseSize="100">
            <div class="box3">Top</div>
          </UItem>
          <UItem :ratio="1">
            <UBox direction="row">
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
        {{ page4 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import './style/page.scss'
import page4 from './md/page4.md'
</script>
<style scoped></style>
