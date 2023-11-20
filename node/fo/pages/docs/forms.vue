<template>
  <div class="px-[120px]">
    <div>
      <h2 class="text-lg font-bold mb-[20px]">Basic Input</h2>
      <div class="flex items-end gap-[38px]">
        <InputText v-model="value1" type="text" size="small" placeholder="Small" />
        <InputText v-model="value2" type="text" placeholder="Normal" />
        <InputText v-model="value3" type="text" size="large" placeholder="Large" />
      </div>
      <div class="flex items-end gap-[38px] mt-[10px]">
        <InputText disabled v-model="value4" type="text" size="small" placeholder="Disabled" />
        <InputText disabled v-model="value5" type="text" placeholder="Disabled" />
        <InputText disabled v-model="value6" type="text" size="large" placeholder="Disabled" />
      </div>
      <div class="flex items-end gap-[38px] mt-[10px]">
        <InputText class="p-invalid" v-model="value" type="text" size="small" placeholder="Error" />
        <InputText class="p-invalid" v-model="value" type="text" placeholder="Error" />
        <InputText class="p-invalid" v-model="value" type="text" size="large" placeholder="Error" />
      </div>
    </div>
    
    <div class="mt-[40px]">
      <h2 class="text-lg font-bold mb-[20px]">Password</h2>
      <div class="flex items-end gap-[38px] mt-[10px]">
        <Password inputClass="p-inputtext-sm" v-model="value" :feedback="false" toggleMask placeholder="Password" />
        <Password v-model="value" :feedback="false" toggleMask placeholder="Password" />
        <Password inputClass="p-inputtext-lg" v-model="value" :feedback="false" toggleMask placeholder="Password" />
      </div>
    </div>
    
    <div class="mt-[40px]">
      <h2 class="text-lg font-bold mb-[20px]">Search Input</h2>
      <div class="flex items-end gap-[38px]">
        <span class="p-input-icon-right">
          <InputText v-model="value" size="small" placeholder="Search" />
          <i class="pi pi-search" />
        </span>
        <span class="p-input-icon-right">
          <InputText v-model="value" placeholder="Search" />
          <i class="pi pi-search" />
        </span>
        <span class="p-input-icon-right">
          <InputText v-model="value" size="large" placeholder="Search" />
          <i class="pi pi-search" />
        </span>
      </div>
      <div class="flex items-end gap-[38px] mt-[10px]">
        <span class="p-input-icon-right">
          <InputText disabled v-model="value" size="small" placeholder="Search" />
          <i class="pi pi-search" />
        </span>
        <span class="p-input-icon-right">
          <InputText disabled v-model="value" placeholder="Search" />
          <i class="pi pi-search" />
        </span>
        <span class="p-input-icon-right">
          <InputText disabled v-model="value" size="large" placeholder="Search" />
          <i class="pi pi-search" />
        </span>
      </div>
    </div>

    <div class="mt-[40px]">
      <h2 class="text-lg font-bold mb-[20px]">Dropdown</h2>
      <div class="flex items-end gap-[38px]">
        <Dropdown inputClass="p-inputtext-sm" panelClass="p-dropdown-panel-sm" v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px]" />
        <Dropdown v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px]" />
        <Dropdown inputClass="p-inputtext-lg" v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px]" />
      </div>
      <div class="flex items-end gap-[38px] mt-[10px]">
        <Dropdown disabled inputClass="p-inputtext-sm" panelClass="p-dropdown-panel-sm" v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px]" />
        <Dropdown disabled v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px]" />
        <Dropdown disabled inputClass="p-inputtext-lg" v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px]" />
      </div>
      <div class="flex items-end gap-[38px] mt-[10px]">
        <Dropdown inputClass="p-inputtext-sm" panelClass="p-dropdown-panel-sm" v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px] p-invalid" />
        <Dropdown v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px] p-invalid" />
        <Dropdown inputClass="p-inputtext-lg" v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px] p-invalid" />
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const value = ref(null);
const value1 = ref(null);
const value2 = ref(null);
const value3 = ref(null);
const value4 = ref(null);
const value5 = ref(null);
const value6 = ref(null);

// dropdown
const selectedCity = ref();
const cities = ref([
  { name: 'New York', code: 'NY' },
  { name: 'Rome', code: 'RM' },
  { name: 'London', code: 'LDN' },
  { name: 'Istanbul', code: 'IST' },
  { name: 'Paris', code: 'PRS' }
]);
</script>

<style lang="scss" scoped>

</style>