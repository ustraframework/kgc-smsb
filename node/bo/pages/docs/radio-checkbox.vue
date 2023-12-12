<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Default Radio</h1>
        <URadioGroupBox v-model="radioValue" :itemsSource="radioItems" />
        <URadioGroupBox v-model="radioValue" :itemsSource="radioItems2" />

        
      </div>

      <!-- search input -->
      <div class="column is-half">
        <h1 class="mb-4">Default Checkbox</h1>
        <UCheckGroupBox
          :items-source="[
            { trueValue: 'Y', falseValue: 'N', text: 'Item1' },
            { trueValue: 'Y', falseValue: 'N', text: 'Item2' },
            { trueValue: 'Y', falseValue: 'N', text: 'Item3', disabled: true},
            { trueValue: 'Y', falseValue: 'N', text: 'Item4', disabled: true },
          ]"
          :border="false"
          v-model="checkValue"
          :stack="true"
          item-align="left"
          @click="onCheckClick"
        >
        </UCheckGroupBox>
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
});

const radioItems = reactive([
  { value: '1', text: 'Y' },
  { value: '2', text: 'N' },
]);

const radioItems2 = reactive([
  { value: '1', text: 'Y', disabled: true },
  { value: '2', text: 'N', disabled: true },
]);

const radioValue = ref('1');

const checked = ref(true);
const checked1 = ref(false);

const checkValue = ref(['Y', 'N', 'Y', 'N'])

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>