<template>
  <v-card>
    <template #title> 버튼 - 아이콘버튼 </template>
    <template #subtitle> icon 속성 활용 </template>
    <template #text>
      <UBox>
        <UItem>
          <UButton text="text" icon="pin" />
          <UButton text="text" icon="arr" />
          <UButton text="text" icon="find" />
          <UButton text="text" icon="filter" />
          <UButton text="text" icon="excel" />
          <UButton icon="reset" type="primary" />
          <UButton icon="arr-up" />
          <UButton icon="arr-down" />
          <UButton icon="arr-left" />
          <UButton icon="arr-right" />
        </UItem>
      </UBox>

      <UMarkdownViewer>{{ base4 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import base4 from './md/base4.md'
</script>
