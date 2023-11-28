<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Default ComboBox</h1>
        <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
        <div class="mb-2"></div>
        <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" :disabled="true"/>

        <div></div>
      </div>

      <!-- search input -->
      <div class="column is-half">
        <h1 class="mb-4"></h1>
      </div>
    </div>

    <!-- 2 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4"></h1>

      </div>
    </div>

  </div>
</template>

<script setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const items = [
  { value: '01', text: '항목1' },
  { value: '02', text: '항목2' },
  { value: '03', text: '항목3' },
  { value: '04', text: '항목4' },
  { value: '05', text: '항목5' },
  { value: '06', text: '항목6' },
];

const visible = ref(true);


</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>