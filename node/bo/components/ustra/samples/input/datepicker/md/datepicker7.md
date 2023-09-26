```html
<template>
  <UFieldSet>
    <UFiledRow>
      <UField label="onMounted" itemDirection="row">
        <UDatepicker v-model="value" :enableTimePicker="true" format="yyy-MM-dd HH:mm:ss" enable-seconds />
        <v-chip class="ma-2" color="pink" label text-color="white">
          <v-icon start icon="mdi-label"></v-icon>
          value : {{ value }}
        </v-chip>
      </UField>
    </UFiledRow>
    <UFiledRow>
      <UField label="watch" itemDirection="row">
        <UDatepicker v-model="value1" :enableTimePicker="true" format="yyy-MM-dd HH:mm:ss" enable-seconds />
        <v-chip class="ma-2" color="pink" label text-color="white">
          <v-icon start icon="mdi-label"></v-icon>
          value : {{ value1 }}
        </v-chip>
      </UField>
    </UFiledRow>
  </UFieldSet>
</template>
<script lang="ts" setup>

const value = ref(null)
onMounted(() => {
  value.value = new Date()
})

const value1 = ref(null)
watch(
  value1,
  v => {
    value1.value = new Date()
  },
  {
    immediate: true,
  },
)
</script>
```
