<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Default Text Input</h1>
        <UTextBox style="width:300px;" placeholder="enabled" class="mb-1"></UTextBox>
        <UTextBox style="width:300px;" placeholder="enabled" class="mb-1" v-model="value"></UTextBox>
        <UTextBox class="is-outline mb-1" style="width:300px;" placeholder="hover, focus"></UTextBox>
        <UTextBox type="icon" iconType="error" class="mb-1" style="width:300px;"></UTextBox>
        <UTextBox style="width:300px;" placeholder="disabled" class="mb-1" disabled></UTextBox>
        <UTextBox style="width:300px;" v-model="readonly" class="mb-1" readonly></UTextBox>

      </div>
      <div class="column is-half">
        <h1 class="mb-4">Icon Button</h1>
        <UTextBox type="icon" @iconClick="logMessage" placeholder="search" style="width:300px;" class="mb-1" />
        <UTextBox type="icon" @iconClick="logMessage" placeholder="search" style="width:300px;" disabled />

        <div class="columns is-half mt-2"></div>
      </div>
    </div>
  </div>
</template>

<script setup>
definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const value = ref('text');
const readonly = ref('readOnly');

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>