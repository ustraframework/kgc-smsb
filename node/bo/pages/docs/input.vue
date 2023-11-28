<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Default Text Input</h1>
        <UTextBox style="width:300px;" placeholder="enabled" class="mb-1" v-model="value"></UTextBox>
        <UTextBox class="is-outline mb-1" style="width:300px;" placeholder="hover, focus"></UTextBox>
        <UTextBox type="icon" iconType="error" v-model="errorVal" class="mb-1" style="width:300px;"></UTextBox>
        <UTextBox style="width:300px;" placeholder="disabled" class="mb-1" disabled></UTextBox>
        <UTextBox style="width:300px;" v-model="readonly" class="mb-2" readonly></UTextBox>

        <div></div>
        <span>Large (40px)</span><br/>
        <div class="mb-2"></div>
        <UTextBox style="width:300px;" placeholder="enabled" class="is-large"></UTextBox>
      </div>

      <!-- search input -->
      <div class="column is-half">
        <h1 class="mb-4">Search Input</h1>
        <div class="mb-2"></div>
        <UTextBox type="icon" @iconClick="logMessage" placeholder="search" style="width:300px;"/>
        <div class="mb-2"></div>
        <UTextBox type="icon" @iconClick="logMessage" class="is-outline" placeholder="hover, focus" style="width:300px;"/>
        <div class="mb-2"></div>
        <UTextBox type="icon" class="is-error" style="width:300px;"></UTextBox>
        <div class="mb-2"></div>
        <UTextBox type="icon" @iconClick="logMessage" placeholder="disabled" style="width:300px;" disabled />
        <div class="mb-2"></div>
        <UTextBox type="icon" @iconClick="logMessage" v-model="readonly" style="width:300px;" readonly />
        <div class="mb-4"></div>
        <span>Large (40px)</span><br/>
        <div class="mb-2"></div>
        <UTextBox type="icon" @iconClick="logMessage" class="is-large" placeholder="search" style="width:300px;"/>
      </div>
    </div>

    <!-- 2 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Text Area</h1>
        <UTextBox type="textarea" v-model="value"/>
        <UTextBox type="textarea" class="is-outline" v-model="value"/>
        <UTextBox type="textarea" class="is-error" v-model="errorVal"/>
        <UTextBox type="textarea" v-model="value" disabled/>
        <UTextBox type="textarea" readonly v-model="readonly"/>
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
const errorVal = ref('error');

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>