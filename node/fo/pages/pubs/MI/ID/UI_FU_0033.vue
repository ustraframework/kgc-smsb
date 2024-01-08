<template>
  <div class="flex flex-col w-[856px] mt-[80px]">
    <div class="bread-wrap">
      <span>홈</span>
      <img src="@/assets/images/svg/ico_bread_arrow.svg" class="mx-[4px]" />
      <Dropdown v-model="item" :options="['이용약관', '개인정보처리방침']">
        <template #dropdownicon>
          <svg width="20" height="21" viewBox="0 0 20 21" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M4 8.5L9.64645 14.1464C9.84171 14.3417 10.1583 14.3417 10.3536 14.1464L16 8.5"
              stroke="#222222"
              stroke-width="1.2"
              stroke-linecap="round"
            />
          </svg>
        </template>
      </Dropdown>

      <div class="content-wrap"></div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const item = ref('이용약관');
</script>

<style scoped>
.bread-wrap {
  width: 100%;
  display: flex;
  align-items: center;
  font-size: 15px;
  color: #000;

  .p-dropdown {
    border: 0;

    :deep(.p-inputtext) {
      height: 22.5px;
      line-height: 22.5px;
      padding: 0;
      font-size: 15px;
    }

    :deep(.p-dropdown-trigger) {
      width: 20px;
      margin-left: 4px;
    }
  }
}

.content-wrap {
  margin-top: 40px;
}
</style>
