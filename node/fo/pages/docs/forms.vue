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
        <span>
          <InputText class="p-invalid" v-model="value" type="text" size="small" placeholder="Error" />
          <p class="mt-[5px] text-[13px] text-[#F43131]">Error Text</p>
        </span>
        <span>
          <InputText class="p-invalid" v-model="value" type="text" placeholder="Error" />
          <p class="mt-[5px] text-[13px] text-[#F43131]">Error Text</p>
        </span>
        <span>
          <InputText class="p-invalid" v-model="value" type="text" size="large" placeholder="Error" />
          <p class="mt-[5px] text-[13px] text-[#F43131]">Error Text</p>
        </span>
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
        <Dropdown
          inputClass="p-inputtext-sm"
          panelClass="p-dropdown-panel-sm"
          v-model="selectedCity"
          :options="cities"
          optionLabel="name"
          placeholder="Select A"
          class="w-[200px]"
        />
        <Dropdown v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px]" />
        <Dropdown inputClass="p-inputtext-lg" v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px]" />
      </div>
      <div class="flex items-end gap-[38px] mt-[10px]">
        <Dropdown
          disabled
          inputClass="p-inputtext-sm"
          panelClass="p-dropdown-panel-sm"
          v-model="selectedCity"
          :options="cities"
          optionLabel="name"
          placeholder="Select A"
          class="w-[200px]"
        />
        <Dropdown disabled v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px]" />
        <Dropdown
          disabled
          inputClass="p-inputtext-lg"
          v-model="selectedCity"
          :options="cities"
          optionLabel="name"
          placeholder="Select A"
          class="w-[200px]"
        />
      </div>
      <div class="flex items-end gap-[38px] mt-[10px]">
        <div>
          <Dropdown
            inputClass="p-inputtext-sm"
            panelClass="p-dropdown-panel-sm"
            v-model="selectedCity"
            :options="cities"
            optionLabel="name"
            placeholder="Select A"
            class="w-[200px] p-invalid"
          />
          <p class="mt-[5px] text-[13px] text-[#F43131]">Error Text</p>
        </div>

        <div>
          <Dropdown v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Select A" class="w-[200px] p-invalid" />
          <p class="mt-[5px] text-[13px] text-[#F43131]">Error Text</p>
        </div>

        <div>
          <Dropdown
            inputClass="p-inputtext-lg"
            v-model="selectedCity"
            :options="cities"
            optionLabel="name"
            placeholder="Select A"
            class="w-[200px] p-invalid"
          />
          <p class="mt-[5px] text-[13px] text-[#F43131]">Error Text</p>
        </div>
      </div>
    </div>

    <div class="mt-[40px]">
      <h2 class="text-lg font-bold mb-[20px]">Checkbox</h2>
      <div class="flex flex-wrap items-center gap-10">
        <div class="flex items-center">
          <Checkbox checked v-model="pizza" inputId="ingredient1" name="pizza" value="체크" />
          <label for="ingredient1"> 체크 </label>
        </div>
        <div class="flex items-center">
          <Checkbox disabled v-model="pizza" inputId="ingredient2" name="pizza" value="Disabled" />
          <label for="ingredient2"> Disabled </label>
        </div>
        <div class="flex items-center">
          <Checkbox class="p-checkbox-box-lg" v-model="pizza" inputId="ingredient3" name="pizza" value="Large" />
          <label for="ingredient3"> Large </label>
        </div>
        <div class="flex items-center">
          <Checkbox disabled class="p-checkbox-box-lg" v-model="pizza" inputId="ingredient4" name="pizza" value="Large Disabled" />
          <label for="ingredient4"> Large Disabled </label>
        </div>
      </div>
      <div class="flex flex-wrap items-center gap-10 mt-[20px]">
        <div class="flex items-center">
          <Checkbox class="non-rounded" v-model="pizza" inputId="ingredient5" name="pizza" value="Cheese" />
          <label for="ingredient5"> Cheese </label>
        </div>
        <div class="flex items-center">
          <Checkbox disabled class="non-rounded" v-model="pizza" inputId="ingredient6" name="pizza" value="disabled" />
          <label for="ingredient6"> disabled </label>
        </div>
        <div class="flex items-center">
          <Checkbox class="non-rounded p-checkbox-box-lg" v-model="pizza" inputId="ingredient7" name="pizza" value="Pepper" />
          <label for="ingredient7"> Pepper </label>
        </div>
        <div class="flex items-center">
          <Checkbox class="non-rounded p-checkbox-box-lg" v-model="pizza" inputId="ingredient8" name="pizza" value="Onion" />
          <label for="ingredient8"> Onion </label>
        </div>
      </div>
    </div>

    <div class="mt-[40px]">
      <h2 class="text-lg font-bold mb-[20px]">Radio</h2>
      <div class="flex flex-wrap gap-3">
        <div class="flex items-center">
          <RadioButton v-model="ingredient" inputId="ingredient11" name="rice" value="Radio1" />
          <label for="ingredient11">Radio1</label>
        </div>
        <div class="flex items-center">
          <RadioButton v-model="ingredient" inputId="ingredient12" name="rice" value="Radio2" />
          <label for="ingredient12">Radio2</label>
        </div>
        <div class="flex items-center">
          <RadioButton class="p-radiobutton-box-lg" v-model="ingredient" inputId="ingredient13" name="rice" value="Radio3" />
          <label for="ingredient13">Radio3</label>
        </div>
        <div class="flex items-center">
          <RadioButton class="p-radiobutton-box-lg" disabled v-model="ingredient" inputId="ingredient14" name="rice" value="Radio4" />
          <label for="ingredient14">Radio4</label>
        </div>
      </div>
    </div>

    <div class="mt-[40px]">
      <h2 class="text-lg font-bold mb-[20px]">Switch Button</h2>
      <div>
        <InputSwitch v-model="checked" />
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// input
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
  { name: 'Paris', code: 'PRS' },
]);

// checkbox
const pizza = ref();

// radio
const ingredient = ref('');

// switch
const checked = ref(false);
</script>

<style lang="scss" scoped></style>
