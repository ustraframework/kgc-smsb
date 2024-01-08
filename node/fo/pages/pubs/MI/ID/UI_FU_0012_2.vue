<template>
  <div class="flex flex-col items-center my-[80px]">
    <TabView class="fill_tab industry_custom_tab" v-model:activeIndex="activeTab">
      <TabPanel header="멤버스 소개" />
      <TabPanel header="멤버스 혜택" />

      <!-- 매장찾기 -->
      <TabPanel header="매장찾기" >
        <div class="tabInner__title">
          <h2>매장찾기</h2>
          <p>우리집 근처, 우리 회사, 약속 장소 가까운 매장을 쉽게 찾아보세요.</p>
        </div>

        <div class="flex justify-center w-[1180px] mx-auto mt-[60px] mb-[40px]">
          <TabView class="default_tab w-[350px]" v-model:activeIndex="activeBottomTab">
            <TabPanel header="가까운 매장">
              <div class="w-full flex gap-[5px]">
                <Dropdown inputClass="p-inputtext-md" class="flex-1" placeholder="시/도 선택" />
                <Dropdown inputClass="p-inputtext-md" class="flex-1" placeholder="구/군 선택" />
              </div>

              <span class="p-input-icon-right w-full mt-[12px]">
                <button class="pi pi-search text-[24px] indent-[-999em] mr-[12px]" style="font-size: 24px;">검색</button>
                <InputText v-model="value" size="large" placeholder="강남" class="w-full completed" />
              </span>

              <div class="flex justify-between items-center mt-[25px]">
                <span class="text-[14px] text-[#666666]">
                  검색결과 <strong class="text-[#222222]">12</strong>개
                </span>

                <div class="location_btn">
                  <span>현위치</span>
                </div>
              </div>

              <div class="store-list">
                <div :class="[i===0 ? 'selected': '', 'store']" v-for="(store, i) in storeList" :key="i">
                  <h4 class="name">{{ store.name }}</h4>
                  <span class="tel">{{ store.tel }}</span>
                  <span class="address">{{ store.address }}</span>
                  <span class="time">{{ store.time }}</span>
                  <Button label="매장선택" size="small" severity="secondary" />
                </div>
              </div>

              <Paginator class="mt-[20px]" :pageLinkSize="5" :rows="5" :totalRecords="30"></Paginator>

            </TabPanel>

            <TabPanel header="지역별 매장" />
          </TabView>

          <div class="mapArea w-[800px] ml-[30px]"></div>
        </div>
      </TabPanel>

      <TabPanel header="포인트 쓰기" />
    </TabView>
  </div>
</template>
<script setup lang="ts">
import { ref } from "vue";

const activeTab = ref(2);
const activeBottomTab = ref(0);

const value = ref();

const storeList = ref([
  { name: '동인비 테헤란로 본점 (직영)', tel: '02.566.4430', address: '서울특별시 강남구 테헤란로 437 (삼성동)', time: '9:00 ~ 20:00' },
  { name: '정관장 현대백화점 무역점', tel: '02.566.4430', address: '서울특별시 강남구 테헤란로 437 (삼성동)', time: '10:00 ~ 20:00' }
])
</script>

<style scoped>
/* 소개페이지 공통 css */
.tabInner__title {
  text-align: center;
  display: flex;
  flex-direction: column;

  &.border-b {
    border-color: #ECF0F8;
    padding: 0 16.5px 40px;
    margin: auto;
  }

  h2 {
    font-weight: 700;
    font-size: 40px;
    line-height: 60px;
  }

  p {
    color: var(--j-gray500);
    margin-top: 8px;
    line-height: 24px;
  }
}

/* == 멤버스 소개 == */
::v-deep(.default_tab) {
  .p-tabview-nav-container {
    width: 100%;
  }

  .p-tabview-panels {
    margin-top: 12px;
  }
}

.location_btn {
  display: flex;
  align-items: center;
  justify-content: center;
  color: var(--j-bluegray700);
  font-size: 13px;

  &::before {
    content: '';
    width: 16px;
    height: 16px;
    background-image: url("data:image/svg+xml,%3Csvg width='16' height='16' viewBox='0 0 16 16' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23clip0_2061_28986)'%3E%3Cpath d='M13.6 8C13.6 11.0928 11.0928 13.6 8 13.6M13.6 8C13.6 4.90721 11.0928 2.4 8 2.4M13.6 8H15M8 13.6C4.90721 13.6 2.4 11.0928 2.4 8M8 13.6V15M2.4 8C2.4 4.90721 4.90721 2.4 8 2.4M2.4 8H1M8 2.4V1M10.1 8C10.1 9.1598 9.1598 10.1 8 10.1C6.8402 10.1 5.9 9.1598 5.9 8C5.9 6.8402 6.8402 5.9 8 5.9C9.1598 5.9 10.1 6.8402 10.1 8Z' stroke='%23758EBC' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0_2061_28986'%3E%3Crect width='16' height='16' fill='white'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A");
    margin-right: 4px;
  }
}

.store-list {
  margin-top: 10px;
  border-radius: 12px;
  border: 1px solid var(--j-gray200);
  height: 368px;
  padding: 10px;

  .store {
    display: flex;
    flex-direction: column;
    padding: 15px 20px;
    font-size: 14px;
    color: var(--j-gray500);

    &:first-child {
      border-bottom: 1px solid #E6E6E6;
    }

    &.selected {
      background-color: #F4F6FA;

      &:first-child {
        border-radius: 8px 8px 0 0;
      }

      &:not(:first-child) {
        border-radius: 0px 0px 8px 8px;
      }
    }

    .name {
      font-size: 16px;
      font-weight: 500;
      margin-bottom: 7px;
      color: var(--j-black);
    }

    span {
      display: flex;
      align-items: center;
      margin-bottom: 3px;
      line-height: 22.4px;
    }

    .tel {
      &::before {
        content: '';
        width: 16px;
        height: 16px;
        background-image: url("data:image/svg+xml,%3Csvg width='16' height='16' viewBox='0 0 16 16' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Ccircle cx='8' cy='8' r='8' fill='%23C8D1E2'/%3E%3Cpath d='M7.07701 5.89871L7.07718 5.89869L7.0761 5.89285L6.78748 4.33874C6.76837 4.21713 6.70683 4.11366 6.60981 4.02987C6.51092 3.94447 6.39535 3.9 6.26667 3.9H4.46667C4.3086 3.9 4.17149 3.95375 4.06262 4.06262C3.95375 4.17149 3.9 4.3086 3.9 4.46667C3.9 5.4076 4.10522 6.33626 4.51425 7.2519C4.92322 8.16739 5.50265 8.99962 6.25151 9.74849C7.00038 10.4974 7.83261 11.0768 8.7481 11.4857C9.66374 11.8948 10.5924 12.1 11.5333 12.1C11.6914 12.1 11.8285 12.0462 11.9374 11.9374C12.0462 11.8285 12.1 11.6914 12.1 11.5333V9.73333C12.1 9.61157 12.0571 9.50179 11.9759 9.40714C11.8958 9.31368 11.7934 9.24967 11.6719 9.21496L11.672 9.21466L11.6643 9.21311L10.131 8.902L10.131 8.90183L10.1253 8.90101C10.0058 8.88394 9.88531 8.89487 9.7648 8.93227C9.64487 8.96949 9.54278 9.02691 9.46262 9.10707L8.47281 10.0969C8.21953 9.9466 7.97873 9.78245 7.75036 9.60446C7.50181 9.41074 7.26415 9.2005 7.03738 8.97373L7.03739 8.97373L7.03628 8.97265C6.79477 8.73846 6.57358 8.49531 6.37264 8.24322C6.18859 8.01232 6.02785 7.77403 5.89029 7.52836L6.91516 6.49293C6.91522 6.49287 6.91528 6.49281 6.91534 6.49275C6.98691 6.42112 7.0364 6.33547 7.06314 6.23742C7.08991 6.13927 7.09282 6.02522 7.07701 5.89871Z' fill='white' stroke='white' stroke-width='0.2'/%3E%3C/svg%3E%0A");
        margin-right: 7px;
      }
    }

    .address {
      &::before {
        content: '';
        width: 16px;
        height: 16px;
        background-image: url("data:image/svg+xml,%3Csvg width='16' height='16' viewBox='0 0 16 16' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Ccircle cx='8' cy='8' r='8' fill='%23C8D1E2'/%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M5.19508 9.69718C5.81341 10.6111 6.74869 11.6008 8.00091 12.6663C9.25313 11.6008 10.1884 10.6111 10.8067 9.69718C11.4251 8.78329 11.7342 7.93745 11.7342 7.15967C11.7342 5.99301 11.359 5.06356 10.6084 4.37134C9.85786 3.67912 8.98869 3.33301 8.00091 3.33301C7.01313 3.33301 6.14397 3.67912 5.39341 4.37134C4.64286 5.06356 4.26758 5.99301 4.26758 7.15967C4.26758 7.93745 4.57674 8.78329 5.19508 9.69718ZM8 8.35693C8.82843 8.35693 9.5 7.68536 9.5 6.85693C9.5 6.02851 8.82843 5.35693 8 5.35693C7.17157 5.35693 6.5 6.02851 6.5 6.85693C6.5 7.68536 7.17157 8.35693 8 8.35693Z' fill='white'/%3E%3C/svg%3E%0A");
        margin-right: 7px;
      }
    }

    .time {
      &::before {
        content: '';
        width: 16px;
        height: 16px;
        background-image: url("data:image/svg+xml,%3Csvg width='16' height='16' viewBox='0 0 16 16' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Ccircle cx='8' cy='8' r='8' fill='%23C8D1E2'/%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M8.5 3.5H7V8.5L11.0298 11.1692L11.918 9.96045L8.5 7.44913V3.5Z' fill='white'/%3E%3C/svg%3E%0A");
        margin-right: 7px;
      }
    }

    button {
      width: 76px;
      margin-top: 10px;
      align-self: flex-end;
      background-color: var(--j-bluegray400);
    }
  }
}

.mapArea {
  border-radius: 12px;
  width: 800px;
  height: 650px;
  background-image: url('@/assets/images/intro/store-map.svg');
}

/* ============== */

</style>