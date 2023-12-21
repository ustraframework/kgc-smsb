<template>
  <div class="flex flex-col items-center m-[20px]">
    <div class="w-full flex bg-[#F4F6FA] py-[12px] px-[20px] rounded-xl justify-center">
      결제한 내역을 확인하실 수 있습니다. 자세한 내용은 해당 사이트에서 확인해주시기 바랍니다.
    </div>

    <div class="w-full flex flex-col mt-[24px] gap-[16px]">
      <SelectButton
        v-model="selectedValue"
        :options="selectOptions"
        optionLabel="label"
        optionValue="value"
        class="flex"
      />
      <div class="p-calendar-group w-full">
        <Calendar v-model="startDate" placeholder="2023-01-01" />
        <span class="range">~</span>
        <Calendar v-model="endDate" placeholder="2023-01-01" />
      </div>

      <Button label="조회" />
    </div>

    <div class="w-full flex justify-between mt-[40px]">
      <span className="text-[15px] font-medium"> {{ `총 ${list.length}건` }}</span>
      <span class="text-[15px]">
        {{ `${selectedValue ? `최근 ${selectedValue}개월` : ''}`}}
      </span>
    </div>

    <div class="purchase__list">
      <div v-for="(item, i) in list" :key="i" class="purchase__item">
        <div class="purchase__item-top">
          <span class="title">{{ item.title }}</span>
          <span class="date">{{ item.date }}</span>
        </div>

        <div :class="[item.isOpen ? 'purchase__item-center expand' : 'purchase__item-center']" @click="onClickExpandButton(i)">
          <span v-if="item.orderNumber">
            <strong>주문번호</strong>
            {{ item.orderNumber }}
          </span>
          <span v-if="item.pay">
            <strong>결제금액</strong>
            {{ `${item.pay}원` }}
          </span>
        </div>

        <div class="purchase__item-expand" v-if="item.isOpen">
          <div v-for="(purchase, i) in item.list" class="purchase__item-expand-item">
            <span>{{ purchase.name }}</span>
            <span>{{ `${purchase.count}개` }}</span>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { defaultOptions } from 'primevue/config';
import { ref } from "vue";

const i18n = {
  dateFormat: 'yy-mm-dd',
  dayNames: ['일요일','월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
  dayNamesMin: ['일','월', '화', '수', '목', '금', '토'],
  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  showMonthAfterYear: true
}

onMounted(() => {
  // Prime Vue Calendar 한국어 변경
  Object.assign(defaultOptions.locale, i18n);
})

const selectOptions = ref([
  { label: '3개월' , value: 3 },
  { label: '6개월' , value: 6 },
  { label: '9개월' , value: 9 },
  { label: '직접입력' , value: 0 }
])

const selectedValue = ref(3)

const startDate = ref('')
const endDate = ref('')
const dropdownValue = ref('전체')

const list = ref([
  { title: '정관장몰', date: '2023.11.05 10:00', orderNumber: '3211234566', pay: '446,000', isOpen: false,
    list: [ { name: '홍삼정 240g(80일분, 특별포장)', count: 1}, { name: '홍삼톤 리미티드 50ml*30포(30일분)', count: 1},  { name: '홍이장군 키즈랩 프로바이오틱스 30포(1개월)', count: 1}]
  },
  { title: '정관장몰', date: '2023.11.05 10:00', orderNumber: '3211234566', pay: '446,000', isOpen: false,
    list: [ { name: '홍삼정 240g(80일분, 특별포장)', count: 1}, { name: '홍삼톤 리미티드 50ml*30포(30일분)', count: 1},  { name: '홍이장군 키즈랩 프로바이오틱스 30포(1개월)', count: 1}]
  },
  { title: '대치점', date: '2023.11.05 10:00', pay: '446,000', isOpen: false,
    list: [ { name: '홍삼정 240g(80일분, 특별포장)', count: 1}, { name: '홍삼톤 리미티드 50ml*30포(30일분)', count: 1},  { name: '홍이장군 키즈랩 프로바이오틱스 30포(1개월)', count: 1}] 
  },
  { title: '정관장몰', date: '2023.11.05 10:00', orderNumber: '3211234566', pay: '446,000', isOpen: false,
    list: [ { name: '홍삼정 240g(80일분, 특별포장)', count: 1}, { name: '홍삼톤 리미티드 50ml*30포(30일분)', count: 1},  { name: '홍이장군 키즈랩 프로바이오틱스 30포(1개월)', count: 1}]
  },
])

const onClickExpandButton = (i) => {
  const _isOpen = list.value[i].isOpen;
  list.value[i].isOpen = !_isOpen;
}
</script>

<style scoped>
.purchase__list {
  border: 1px solid #E7E7E7;
  border-radius: 12px;
  padding: 0 20px;
  margin-top: 20px;
  margin-bottom: 35px;
  width: 100%;

  .purchase__item {
    padding: 20px 0;

    &:not(:last-child) {
      border-bottom: 1px solid #E7E7E7;
    }

    .purchase__item-top {
      display: flex;
      justify-content: space-between;
      margin-bottom: 16px;

      .title {
        font-size: 13px;
        font-weight: 700;
      }

      .date {
        font-size: 13px;
        color: #666666;
      }
    }

    .purchase__item-center {
      display: flex;
      flex-direction: column;
      font-size: 15px;
      gap: 4px;

      &.expand span:first-child::after {
        transform:rotate(180deg);
      }

      span:first-child::after {
        content: '';
        background-image: url("data:image/svg+xml,%3Csvg width='20' height='20' viewBox='0 0 20 20' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M4 8L9.64645 13.6464C9.84171 13.8417 10.1583 13.8417 10.3536 13.6464L16 8' stroke='%23222222' stroke-width='1.2' stroke-linecap='round'/%3E%3C/svg%3E%0A");
        width: 20px;
        height: 16px;
        float: right;
        cursor: pointer;
        transition: all 0.25s;
      }
    }

    .purchase__item-expand {
      display: flex;
      flex-direction: column;
      gap: 4px;
      background-color: #F9FAFC;
      border-radius: 12px;
      padding: 20px;
      font-size: 15px;
      color: #666666;
      margin-top: 16px;

      .purchase__item-expand-item {
        display: flex;
        justify-content: space-between;
      }
    }
  }
}
</style>