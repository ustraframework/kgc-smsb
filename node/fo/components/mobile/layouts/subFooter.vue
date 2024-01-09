<template>
  <div class="sub-footer">
    <div class="flex items-center justify-between py-[8px]">
      <h2 class="text-[15px] text-[#222222] font-medium">FAMILY SITE</h2>
      <button class="w-[20px] h-[20px]">
        <img src="@/assets/images/svg/ico_plus.svg" />
      </button>
    </div>

    <div class="flex items-center mt-[20px] text-[15px]">
      <router-link to="/pubs/MI/ID/UI_FU_0066" class="text-[#464646]">이용약관</router-link>
      <div class="empty-line-col"></div>
      <router-link to="/pubs/MI/ID/UI_FU_0066_1" class="text-[#666666]">개인정보처리방침</router-link>
    </div>

    <div class="text-[13px] text-[#666666] mt-[20px]">
      <p class="mb-[5px]">㈜한국인삼공사∙대전광역시 대덕구 벚꽃길 71(평촌동)</p>
      <p class="mb-[5px]">Copyright@2023 by KOREA GINSENG CORP.</p>
      <p>All rights reserved.</p>
    </div>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
.sub-footer {
  border-top: 1px solid #f1f1f1;
  padding: 20px;
  padding-top: 10px;
}

.empty-line-col {
  height: 14px;
  padding: 2px 0;
  border-right: 1px solid #e0e0e0;
  margin: 0 20px;
}
</style>
