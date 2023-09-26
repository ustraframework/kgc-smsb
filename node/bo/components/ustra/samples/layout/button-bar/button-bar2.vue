<template>
  <v-card>
    <template #title> ButtonBar + USpacer</template>
    <template #subtitle> USpacer 컴포넌트를 활용하여 양옆 또는 3단 정렬이 가능합니다. </template>
    <template #text>
      <div class="sample-wrap">
        <UButtonBar>
          <UButtonBox>
            <UButton text="그룹1-버튼1" type="primary" />
            <UButton text="그룹1-버튼2" />
          </UButtonBox>
          <USpacer></USpacer>
          <UButtonBox>
            <UButton text="그룹2-버튼1" type="primary" />
            <UButton text="그룹2-버튼2" />
          </UButtonBox>
        </UButtonBar>
        <div style="margin: 15px"></div>
        <UButtonBar>
          <UButtonBox>
            <UButton text="그룹1-버튼1" type="primary" />
            <UButton text="그룹1-버튼2" />
          </UButtonBox>
          <USpacer></USpacer>
          <UButtonBox>
            <UButton text="그룹2-버튼1" type="primary" />
            <UButton text="그룹2-버튼2" />
          </UButtonBox>
          <USpacer></USpacer>
          <UButtonBox>
            <UButton text="그룹3-버튼1" type="primary" />
            <UButton text="그룹3-버튼2" />
          </UButtonBox>
        </UButtonBar>
      </div>

      <UMarkdownViewer>
        {{ buttonBar2 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import './style/form.scss'
import buttonBar2 from './md/button-bar2.md'
</script>

<style scoped></style>
