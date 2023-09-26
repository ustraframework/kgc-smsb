<template>
  <v-card>
    <template #title> 마스터디테일구조 </template>
    <template #subtitle> height 고정2 </template>
    <template #text>
      <div class="sample-wrap">
        <UBox direction="col">
          <UItem baseSize="100">
            <div class="box3">Top</div>
          </UItem>
          <UItem ratio="1">
            <UBox direction="row" height="500px">
              <UItem ratio="1"
                ><UBox direction="col">
                  <UItem baseSize="50px"><div class="box1">Item1</div> </UItem>
                  <UItem baseSize="150px"><div class="box1">Item2</div> </UItem>
                  <UItem baseSize="180px"><div class="box1">Item3</div> </UItem>
                  <UItem ratio="1"><div class="box1">Item4</div> </UItem>
                </UBox></UItem
              >
              <UItem ratio="1">
                <UBox direction="col">
                  <UItem ratio="5"><div class="box2">Item1</div> </UItem>
                  <UItem ratio="2"><div class="box2">Item2</div> </UItem>
                </UBox>
              </UItem>
            </UBox>
          </UItem>
        </UBox>
      </div>
      <UMarkdownViewer>
        {{ page7 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import './style/page.scss'
import page7 from './md/page7.md'
</script>
<style scoped></style>
