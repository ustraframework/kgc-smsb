<template>
  <v-card>
    <template #title>좌우구성 </template>
    <template #subtitle> </template>
    <template #text>
      <div class="sample-wrap">
        <UBox direction="row">
          <UItem ratio="1"><div class="box1">Left</div> </UItem>
          <UItem ratio="1"><div class="box2">Right</div> </UItem>
        </UBox>
      </div>
      <UMarkdownViewer>
        {{ page1 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import './style/page.scss'
import page1 from './md/page1.md'
</script>

<style scoped></style>
