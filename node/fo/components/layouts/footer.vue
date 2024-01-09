<template>
  <footer class="flex-none h-[152px] border-t border-[#F6F6F6] mt-auto px-[120px] pt-[30px]">
    <div class="flex justify-between align-center">
      <div class="flex items-center text-[15px]">
        <router-link to="/pubs/MI/ID/UI_FU_0033" class="text-[#464646]">이용약관</router-link>
        <div class="empty-line-col"></div>
        <router-link to="/pubs/MI/ID/UI_FU_0033_1" class="text-[#666666]">개인정보처리방침</router-link>
      </div>

      <div class="flex items-center justify-between py-[8px]">
        <h2 class="text-[15px] text-[#222222] font-medium">FAMILY SITE</h2>
        <button class="w-[20px] h-[20px]">
          <img src="@/assets/images/svg/ico_plus.svg" />
        </button>
      </div>
    </div>

    <span class="text-[13px] text-[#666666] mt-[20px]">
      ㈜한국인삼공사∙대전광역시 대덕구 벚꽃길 71(평촌동)∙대표이사 허철호∙사업자등록번호 314-81-23992∙고객센터 1588-2304 /
      contact@kgc.co.kr∙호스팅서비스제공자 ㈜한국인삼공사
    </span>
  </footer>
</template>

<script setup></script>

<style lang="scss" scoped>
.empty-line-col {
  height: 14px;
  padding: 2px 0;
  border-right: 1px solid #e0e0e0;
  margin: 0 20px;
}
</style>
