<template>
  <div class="flex flex-col w-[856px] mt-[80px]">
    <div class="bread-wrap">
      <span>홈</span>
      <img src="@/assets/images/svg/ico_bread_arrow.svg" class="mx-[4px]" />
      <Dropdown class="bread-drop" v-model="item" :options="['이용약관', '개인정보처리방침']">
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
    </div>

    <div class="policy-wrap">
      <div class="policy-header">
        <h2>개인정보처리방침</h2>
        <Dropdown
          class="w-[250px] h-[50px]"
          placeholder="개정일: 2023년 10월 23일"
          v-model="monthVal"
          :options="monthList"
          optionLabel="label"
          optionValue="value"
        ></Dropdown>
      </div>
      <div class="policy-content">
        <p class="policy__content mb-[20px]">
          ‘㈜한국인삼공사’는 (이하 ‘KGC’는) 정보주체의 자유와 권리 보호를 위해 「개인정보 보호법」 및 관계 법령이 정한 바를 준수하여, 적법하게
          개인정보를 처리하고 안전하게 관리하고 있습니다. 이에 「개인정보 보호법」 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 기준을
          안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 다음과 같이 개인정보 처리방침을 수립·공개합니다.
        </p>

        <span class="policy_title"> 제1조 (개인정보의 처리 목적, 수집항목, 보유 및 이용기간)</span>
        <p class="policy__content">
          KGC는 다음의 목적을 위하여 개인정보를 처리합니다. 처리하고 있는 개인정보는 다음의 목적 이외의 용도로는 이용되지 않으며, 이용 목적이 변경되는
          경우에는 「개인정보 보호법」 제18조에 따라 별도의 동의를 받는 등 필요한 조치를 이행할 예정입니다.
        </p>
        <p class="policy__content">1. 정관장몰 서비스</p>
        <p class="policy__content mb-[20px]">① 온라인 구매(멤버스 회원)</p>

        <span class="policy_title"> 제1조 (개인정보의 처리 목적, 수집항목, 보유 및 이용기간)</span>
        <p class="policy__content">
          KGC는 다음의 목적을 위하여 개인정보를 처리합니다. 처리하고 있는 개인정보는 다음의 목적 이외의 용도로는 이용되지 않으며, 이용 목적이 변경되는
          경우에는 「개인정보 보호법」 제18조에 따라 별도의 동의를 받는 등 필요한 조치를 이행할 예정입니다.
        </p>
        <p class="policy__content">1. 정관장몰 서비스</p>
        <p class="policy__content mb-[20px]">① 온라인 구매(멤버스 회원)</p>

        <span class="policy_title"> 제1조 (개인정보의 처리 목적, 수집항목, 보유 및 이용기간)</span>
        <p class="policy__content">
          KGC는 다음의 목적을 위하여 개인정보를 처리합니다. 처리하고 있는 개인정보는 다음의 목적 이외의 용도로는 이용되지 않으며, 이용 목적이 변경되는
          경우에는 「개인정보 보호법」 제18조에 따라 별도의 동의를 받는 등 필요한 조치를 이행할 예정입니다.
        </p>
        <p class="policy__content">1. 정관장몰 서비스</p>
        <p class="policy__content">① 온라인 구매(멤버스 회원)</p>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue';

const item = ref('개인정보처리방침');

const monthVal = ref('');
const monthList = [
  { label: '개정일: 2023년 10월 23일', value: '20231023' },
  { label: '개정일: 2023년 9월 10일', value: '20230910' },
];
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

.policy-wrap {
  margin-top: 40px;

  .policy-header {
    display: flex;
    justify-content: space-between;
    padding-bottom: 24px;
    border-bottom: 2px solid #666666;

    h2 {
      color: #000000;
      font-size: 30px;
      font-weight: 500;
    }

    .p-dropdown {
      :deep(.p-inputtext) {
        height: 48px;
        line-height: 48px;
      }
    }
  }

  .policy-content {
    margin-top: 24px;

    .policy_title {
      display: block;
      font-size: 14px;
      color: #000;
      font-weight: 700;
      line-height: 22.4px;
    }

    .policy__content {
      font-size: 14px;
      color: #000;
      font-weight: 400;
      line-height: 22.4px;
    }

    .policy__list {
      font-size: 14px;
      color: #000;
      line-height: 22.4px;
    }
  }
}
</style>
