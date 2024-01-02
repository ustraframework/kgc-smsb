<template>
  <div class="flex flex-col items-center m-[20px]">
    <span class="p-input-icon-right w-full">
      <i class="pi pi-search qa-search-ico" />
      <InputText class="qa-search w-full" v-model="value1" placeholder="검색어를 입력하세요." size="large"/>
    </span>

    <div class="qa-select w-full flex mt-[40px]">
      <!-- <TabMenu :model="items" /> -->
      <SelectButton
        v-model="selectedValue"
        :options="selectOptions"
        optionLabel="label"
        optionValue="value"
        class=" w-full"
      />
    </div>
  </div>
</template>

<script setup>

const value1 = ref(null);

const selectedValue = ref('all');
const selectOptions = ref([
  { label: '전체' , value: 'all' },
  { label: '회원관련' , value: 'member' },
  { label: '멤버십/포인트' , value: 'point' },
  { label: '사이트이용/기타' , value: 'etc' }
])

</script>

<style lang="scss" scoped>
.qa-search-ico{
  right: 15px;
}

.qa-search{
  background-color: #F4F6FA;
  border-radius: 999px;
  border: 0;
  padding-left: 25px;
  padding-right: 2.8rem;
  font-size: 15px;
}

.qa-select{
  .p-selectbutton{
    border: 0;

    :deep(.p-button){
      border: 1px solid #E7E7E7;
      border-radius: 4px;

      &:not(:last-child) {
        margin-right: 8px;
      }
    }
  }  
}

</style>