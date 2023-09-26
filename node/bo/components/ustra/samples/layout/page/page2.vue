<template>
  <v-card>
    <template #title> 상하구성 </template>
    <template #subtitle> </template>
    <template #text>
      <div class="sample-wrap">
        <UBox direction="col">
          <UItem ratio="1"><div class="box1">Top</div> </UItem>
          <UItem ratio="2"><div class="box2">Bottom</div> </UItem>
        </UBox>
      </div>

      <UMarkdownViewer>
        {{ page2 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import './style/page.scss'
import page2 from './md/page2.md'
</script>

<style scoped></style>
