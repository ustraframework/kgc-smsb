<template>
  <!-- 삭제 확인 팝업 -->
  <Dialog
    v-model:visible="props.modelValue"
    @update:visible="handleChangeValue"
    modal
    header="단골매장 변경"
    :style="{ width: '500px' }"
    contentClass="store__content"
  >
    <div class="dialog-content-inner max-h-[456px]">
      <p class="mb-1 text-[16px] text-center text-[#222222]">
        단골매장을 변경하시려면
        <br/>
        휴대폰 인증이 필요합니다.
      </p>

      <!-- 인증요청 -->
      <div class="w-full flex flex-col mt-[24px] gap-[8px]">
        <InputText
          size="large"
          v-model="phoneNumber"
          inputId="integeronly"
          placeholder="휴대폰 번호를 입력해주세요"
        />
        <Button
          @click="onClickRequest()"
          size="large"
          severity="secondary"
          :label="isShowCert ? '다시요청': '인증요청'"
          class="py-[13px]"
        />
      </div>

      <!-- 인증번호 입력 -->
      <div class="w-full flex flex-col flex-wrap mt-[20px] gap-[8px]" v-if="isShowCert">
        <span class="timer__input">
          <InputText
            class="w-full"
            :class="[{'p-invalid': type === 'error'}]"
            v-model="certNumber"
            inputId="integeronly"
            placeholder="휴대폰 번호를 입력해주세요"
            size="large"
          />
          <span v-if="type !== 'confirm'" class="timer">{{ timer }}</span>
        </span>

        <p class="desc__content" :class="[type]">
          {{ desc_content[type] }}
        </p>

        <Button
          @click="onClickCertConfirm()"
          size="large"
          severity="secondary"
          label="인증번호 확인"
          class="p-[0] w-[116px]"
          :disabled="type === 'confirm'"
        />
      </div>
    </div>
  </Dialog>
</template>

<script setup lang="ts">
const props = defineProps({
  /**
   * 팝업 Open 여부
   */
  modelValue: {
    type: Boolean,
    default: true,
  },
})

const emit = defineEmits(['update:modelValue']);

const phoneNumber = ref('');
const certNumber = ref('');
const isShowCert = ref(false);
const timer = ref('2:37');
const type = ref('normal');

const desc_content = {
  normal: `3분 이내에 인증번호(6자리)를 입력해주세요. \n입력 시간 초과 시 ‘다시요청’ 버튼을 클릭해주세요.`,
  confirm: '인증이 완료되었습니다.',
  error: '입력하신 인증번호가 올바르지 않습니다.\n 다시 확인해주세요.'
}

const handleChangeValue = (e) => {
  emit('update:modelValue', e);

  if( !e ) initValue();
}

// 인증요청 버튼 클릭 시
const onClickRequest = () => {
  // 다시요청
  if (isShowCert.value) {
    return type.value = 'normal';
  } else { // 인층요청
    isShowCert.value = true
  }
}

// 인증번호 확인 버튼 클릭 시
const onClickCertConfirm = () => {
  if(!certNumber.value) {
    type.value = 'error';
  } else if(certNumber.value) {
    type.value = 'confirm';
  }
}

// 팝업 닫은 후 다시 열릴 시 입력한 값 그대로 있는 현상 해결
const initValue = () => {
  phoneNumber.value = '';
  certNumber.value = '';
  isShowCert.value=false;
}
</script>

<style>
.p-dialog-header:has(~ .store__content) {
  border-top-left-radius: inherit;
  border-top-right-radius: inherit;

  .p-dialog-title {
    font-size: 20px;
  }
}

.store__content {
  padding: 16px 0;
  border-bottom-left-radius: inherit;
  border-bottom-right-radius: inherit;

  .dialog-content-inner button {
    padding: 13px 0;
    width: 100%;
  }

  .timer__input {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: flex-end;

    .timer {
      position: absolute;
      color: var(--j-primary02);
      font-weight: 700;
      margin-right: 14px;
    }
  }

  .desc__content {
    font-size: 13px;
    white-space: break-spaces;
    width: 100%;
    line-height: 16px;
    
    &.normal {
      color: #888888;
    }

    &.confirm {
      color: #5361E7;
    }

    &.error {
      color: #c32727;

    }
  }
}
</style>