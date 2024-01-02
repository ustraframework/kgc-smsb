<template>
  <div class="flex flex-col items-center m-[20px]">
    <h1 class="text-[30px] font-medium mb-[30px]">{{`기념일 ${isEdit ? '수정' : '등록'}`}}</h1>
    <div class="w-full bg-[#F4F6FA] px-[20px] py-[12px] rounded-[12px]">
      <div class="flex items-center justify-center">
        <span>자녀는 최대 3명까지 가능하며 그 외에는 1명만 가능합니다.</span>
      </div>
    </div>

    <div class="w-full flex flex-col items-center mt-[40px] gap-[40px]">
      <!-- 기념일 종류 -->
      <div class="anniversary__type pb-[40px] border-b border-[#E7E7E7]">
        <div v-for="(type, i) in types" :key="i" class="anniversary__type-item" :class="[anniversaryType === type.value ? 'selected' : '']">
          <RadioButton class="p-radiobutton-box-lg" v-model="anniversaryType" :inputId="type.value" :name="type.value" :value="type.value" />
          <label :for="type.value">{{type.label}}</label>
        </div>
      </div>

      <!-- 성별 -->
      <div class="w-full flex pb-[40px] border-b border-[#E7E7E7] gap-[20px]">
        <div class="flex items-center">
          <RadioButton class="p-radiobutton-box-lg" v-model="gender" inputId="male" name="male" value="male" />
          <label for="male">남자</label>
        </div>
        
        <div class="flex items-center">
          <RadioButton class="p-radiobutton-box-lg ml-[20px]" v-model="gender" inputId="female" name="female" value="female" />
          <label for="female">여자</label>
        </div>
      </div>

      <!-- 날짜 -->
      <div class="w-full flex flex-col items-center pb-[40px] border-b border-[#E7E7E7] gap-[20px]">
        <Calendar class="w-full" v-model="date" placeholder="2023-01-01" />
        <div class="w-full flex items-center">
          <RadioButton class="p-radiobutton-box-lg" v-model="dateType" inputId="birthInfo1" name="birthInfo1" value="birthInfo1" />
          <label for="birthInfo1">양력</label>
          
          <RadioButton class="p-radiobutton-box-lg ml-[20px]" v-model="dateType" inputId="birthInfo2" name="birthInfo2" value="birthInfo2" />
          <label for="birthInfo2">음력</label>
        </div>
      </div>

      <!-- 개인정보 수집 동의 -->
      <div class="w-full flex items-center justify-between pb-[40px] border-b border-[#E7E7E7] gap-[20px]">
        <div class="flex items-center">
          <Checkbox class="p-checkbox-box-lg" v-model="isAgree" inputId="agree" name="agree" :value="true" />
          <label for="agree"> 개인정보 수집 및 이용 동의 </label>
        </div>
        <Button label="내용보기" text @click="isShowAgree = true" />
      </div>

      <!-- 버튼 -->
      <div class="w-full flex gap-[8px]">
        <Button class="w-2/4" size="large" label="취소" outlined @click="$router.push('/pubs/MP/MI/UI_FU_0058')" />
        <Button class="w-2/4" size="large" label="확인" @click="onClickConfirm()" />
      </div>
    </div>
    
    <!-- 약관 팝업 -->
    <Dialog v-model:visible="isShowAgree" modal header="약관" :style="{ width: '500px' }">
      <div class="dialog-content-inner max-h-[456px]">
        <h2 class="mb-1 font-bold text-[15px] text-black">타이틀</h2>
        <p class="text-sm text-[#666]">약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>
      </div>
      <template #footer>
        <div class="border-t border-[#E7E7E7] pt-[24px] pb-[30px] px-[30px]">
          <Button class="block mx-auto" label="확인" @click="isShowAgree=false" />
        </div>
      </template>
    </Dialog>

    <!-- 등록 완료 팝업 -->
    <Dialog
      v-model:visible="isShowConfirm"
      modal
      :style="{ width: '500px' }"
    >
      <div class="dialog-content-inner max-h-[456px]">
        <p class="text-center text-[18px] text-black">
          {{ `기념일을 정상적으로 ${isEdit ? '수정' : '등록'}했습니다.`}}
        </p>
      </div>
      <template #footer>
        <div class="flex justify-center pt-[24px] pb-[30px] px-[30px] gap-[10px]">
          <Button label="확인" @click="$router.push('/pubs/MP/MI/UI_FU_0058')" />
        </div>
      </template>
    </Dialog>
  </div>
</template>

<script setup lang="ts">
import { onMounted } from '#ustra/nuxt';
import { defaultOptions } from 'primevue/config';

// false: 등록, true: 수정
const isEdit = ref(false);
const routerValue = useRouter().currentRoute.value;

// 캘린더
const i18n = {
  dateFormat: 'yy-mm-dd',
  dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  showMonthAfterYear: true,
};

onMounted(() => {
  // Prime Vue Calendar 한국어 변경
  Object.assign(defaultOptions.locale, i18n);

  // 등록, 수정 확인
  isEdit.value = !!routerValue.query.id;
});

const anniversaryType = ref('parent');
const types = ref([
  { label: '부모생일', value: 'parent'},
  { label: '자녀생일', value: 'children'},
  { label: '배우자생일', value: 'spouse'},
  { label: '결혼기념일', value: 'marriage'},
]);

const gender = ref('male');
const date = ref('');
const dateType = ref('birthInfo1');
const isAgree = ref('');
const isShowAgree = ref(false);
const isShowConfirm = ref(false);

const onClickConfirm = () => {
  isShowConfirm.value = true
}

</script>

<style lang="scss" scoped>
button {
  color: var(--j-white);
}
.anniversary__type {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  width: 100%;

  .anniversary__type-item {
    flex: 45%;
    border-radius: 8px;
    border: 1px solid var(--j-gray200);
    padding: 16px 0px 16px 24px;
    color: var(--j-gray700);

    &.selected {
    border-color: var(--j-primary01);
  }
  }
}

</style>