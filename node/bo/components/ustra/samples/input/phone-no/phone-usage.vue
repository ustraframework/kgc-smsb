<template>
  <v-container>
    <v-row>
      <v-col cols="7">
        <v-card class="content-box example">
          <template #title> Input - 전화번호 사용법</template>
          <template #subtitle> </template>
          <template #text>
            <div class="sample-wrap">
              <UPhoneNoBox v-model="data" :width="width" :disabled="disabled" :required="required" :maxlength="maxlength"></UPhoneNoBox>
            </div>
          </template>
        </v-card>
      </v-col>
      <v-col cols="5">
        <v-card class="content-box props">
          <template #title>Props</template>
          <template #subtitle> </template>
          <template #text>
            <h3>Input - 전화번호 Props</h3>
            <UFieldSet>
              <UFieldRow>
                <UField label="width">
                  <UTextBox v-model="width"></UTextBox>
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="maxlength(number)">
                  <UTextBox v-model="maxlength"></UTextBox>
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="required">
                  <UButton text="Click" :type="required ? 'primary' : ' '" @click="setProps('required')"></UButton>
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="disabled">
                  <UButton text="Click" :type="disabled ? 'primary' : ' '" @click="setProps('disabled')"></UButton>
                </UField>
              </UFieldRow>
            </UFieldSet>
          </template>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
import { ref } from '#ustra/nuxt'
const data = ref(null)
const width = ref(null)
const maxlength = ref('14')
const disabled = ref(false)
const required = ref(false)
const setProps = propsValue => {
  if (propsValue === 'disabled') {
    disabled.value = !disabled.value
  } else if (propsValue === 'required') {
    required.value = !required.value
  }
}
</script>

<style scoped lang="scss"></style>
