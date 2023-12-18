<template>
  <div class="flex flex-col items-center m-[20px]">
    <div class="w-full bg-[#F4F6FA] p-[24px] rounded-xl">
      <div class="flex flex-col justify-center items-center mb-[20px] border-b border-[#E7E7E7] pb-[20px]">
        <span class="text-[15px]">
          <strong>홍길동</strong>님의 가용포인트
        </span>
        <span class="text-[30px] text-[#D20F27] mt-[4px]">
          <strong class="mr-0.5">1,000</strong>P
        </span>
      </div>

      <div class="flex flex-col mb-[20px]">
        <div class="flex justify-between items-center text-[15px] mb-[16px]">
          <span>특별 포인트</span>
          <span>
            <strong class="mr-0.5">5,000</strong>P
          </span>
        </div>
        <div class="flex justify-between items-center cursor-pointer text-[15px]" @click="$router.push('/pubs/MP/PI/UI_FU_0051_1')">
          <span>
            당월 소멸예정
            <span class="text-[12px]">(전일기준)</span>
          </span>

          <span>
            <strong class="mr-0.5">50</strong>P
          </span>
        </div>
      </div>

      <div class="flex items-center">
        <img src="@/assets/images/svg/ico_info.svg" class="mr-1" alt="정보"/>
        <span class="text-[12px] text-[#888888]">특별 포인트는 오프라인 매장에서만 사용 가능합니다.</span>
      </div>
    </div>

    <div class="w-full flex flex-col mt-[40px] gap-[16px]">
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

    <div class="w-full flex items-center justify-between mt-[40px]">
      <span class="text-[15px]">
        최근 3개월 ∙ 전체
      </span>

      <Dropdown class="simple-dropdown w-1/4" v-model="dropdownValue" :options="['전체', 'selectA', 'selectB', 'selectC']">
        <template #dropdownicon>
          <svg width="20" height="21" viewBox="0 0 20 21" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M4 8.5L9.64645 14.1464C9.84171 14.3417 10.1583 14.3417 10.3536 14.1464L16 8.5" stroke="#222222" stroke-width="1.2" stroke-linecap="round"/>
          </svg>
        </template>
      </Dropdown>
    </div>

    <div class="w-full flex flex-col rounded-xl border border-[#E7E7E7] mt-[20px] px-[20px]">
      <div v-for="(item, i) in list" :key="i" class="flex justify-between py-[20px]" :class="[i !== 0 ? ' border-t border-[#E7E7E7]' : '']">
        <div class="flex flex-col">
          <span class="text-[16px] font-bold">{{item.title}}</span>
          <span class="text-[13px] text-[#666666] mt-2.5">{{item.date}}</span>
        </div>
        <div class="flex flex-col text-right" :class="[item.pointType === 'plus' ? 'text-[#D20F27]' : '']">
          <span class="text-[13px] font-normal">{{item.type}}</span>
          <span class="text-[16px] mt-0.5">
            <strong class="mr-0.5">{{item.point}}</strong>P
          </span>
        </div>
      </div>
    </div>

    <Button class="more_btn">
      <span class="mr-0.5">더보기</span>
      <svg width="18" height="19" viewBox="0 0 18 19" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M10.2278 4.71875C10.2278 4.25276 9.85006 3.875 9.38407 3.875C8.91808 3.875 8.54032 4.25276 8.54032 4.71875V9.04032H4.21875C3.75276 9.04032 3.375 9.41808 3.375 9.88407C3.375 10.3501 3.75276 10.7278 4.21875 10.7278H8.54032V15.0492C8.54032 15.5152 8.91808 15.8929 9.38407 15.8929C9.85006 15.8929 10.2278 15.5152 10.2278 15.0492V10.7278H14.5492C15.0152 10.7278 15.3929 10.3501 15.3929 9.88407C15.3929 9.41808 15.0152 9.04032 14.5492 9.04032H10.2278V4.71875Z" fill="#758EBC"/>
      </svg>
    </Button>

  </div>
</template>

<script setup lang="ts">
import { onMounted } from '#ustra/nuxt';
import { defaultOptions } from 'primevue/config';
import { ref } from "vue";

interface ListType {
  title: string;
  date: string;
  type: string;
  pointType: string;
  point: string;
}

const list: ListType[] = [
  { title: '케어나우', date: '2023-09-27 01:02', type: '활동 적립', pointType: 'plus', point: '+1,000' },
  { title: '정관장몰', date: '2023-09-27 01:02', type: '구매 사용', pointType: 'minus', point: '-100' },
  { title: '대치점', date: '2023-09-27 01:02', type: '영수증 적립', pointType: 'plus', point: '+10' },
  { title: '정관장', date: '2023-09-27 01:02', type: '특별 포인트', pointType: 'plus', point: '+1,000' },
  { title: '케어나우', date: '2023-09-27 01:02', type: '유효기간 만료로 소멸', pointType: 'minus', point: '-1,000' },
]


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
</script>

<style scoped>
.more_btn {
  margin-top: 20px;
  margin-bottom: 80px;
  font-size: 14px;
  text-align: center;
  width: 100%;
  background-color: #ECF0F8;
  color: #758EBC;
  line-height: 22.5px;
  padding: 15px 0;
  justify-content: center;
}

</style>