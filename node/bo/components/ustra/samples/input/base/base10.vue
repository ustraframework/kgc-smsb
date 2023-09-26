<template>
  <v-card>
    <template #title> 버튼 - 아이콘버튼(MDI) </template>
    <template #subtitle> MDI Icon 활용 <NuxtLink to="https://materialdesignicons.com/" target="_blank"> Material Design Icons</NuxtLink></template>
    <template #text>
      <UBox>
        <UItem>
          <UButton text="text" icon="mdi-account-box-multiple" />
          <UButton text="text" icon="mdi-assistant" right mdiIconColor="red" />
          <UButton icon="mdi-bell-circle" mdiIconColor="blue" />
          <UButton icon="mdi-arrow-left" mdiIconColor="green" />
        </UItem>
      </UBox>

      <UMarkdownViewer>{{ base10 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import base10 from './md/base10.md'
</script>
