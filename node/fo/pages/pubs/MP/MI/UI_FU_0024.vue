<template>
  <div class="flex flex-col items-center w-[650px]">
    <h1 class="text-[30px] font-medium mb-[30px]">기념일 관리</h1>
    <div class="w-full bg-[#F4F6FA] p-[24px] rounded-[12px]">
      <div class="flex justify-between items-center">
        <span class="text-[15px]">나의 기념일을 등록해보세요. 최대 7개까지 가능합니다.</span>
        <Button label="기념일 등록"/>
      </div>
    </div>

    <div class="flex flex-col items-center mt-[80px]">
      <img src="@/assets/images/svg/ico_warning_gray.svg" class="mb-[20px]">
      <span class="text-[#888888] text-[16px] font-medium">등록된 기념일이 없습니다.</span>
    </div>

  </div>
</template>

<script setup lang="ts">
definePageMeta({
  layout: 'side',
})
</script>

<style scoped>
</style>