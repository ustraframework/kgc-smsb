<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Default Popup</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
      <div class="column is-half">
        <h1 class="mb-4">Icon Button</h1>
  
        
        <div class="columns is-half mt-2"></div>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="800" title="팝업제목">
    <UBox direction="col">
      <UItem :ratio="1" style="overflow: auto">
        <UValidationGroup ref="validationGroup">
          <UFieldSet>
            <UFieldRow>
              <UField label="코드" :required="true" :labelWidth="100">
                <WjInputMask v-model="inputFormData.dtlCd"></WjInputMask>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="코드명" :required="true" :labelWidth="100">
                <WjInputMask v-model="inputFormData.cdNm"></WjInputMask>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="정렬순번" :required="true" :labelWidth="100">
                <WjInputNumber v-model="inputFormData.srtNo"></WjInputNumber>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="사용여부" :required="true" :labelWidth="100">
                <URadioGroupBox
                  :itemsSource="[
                    { value: 'Y', text: '사용' },
                    { value: 'N', text: '미사용' },
                  ]"
                  v-model="inputFormData.useYn"
                ></URadioGroupBox>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UValidationGroup>
      </UItem>
      <UItem>
        <UButtonBox right top>
          <UButton text="저장" type="primary" :width="80" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const showPopup = ref(false)
const inputFormData = reactive({
  dtlCd: null,
  cdNm: null,
  srtNo: 0,
  useYn: 'Y',
  cdDesc: null,
  etc1: null,
  etc2: null,
  etc3: null,
  etc4: null,
  etc5: null,
})

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>