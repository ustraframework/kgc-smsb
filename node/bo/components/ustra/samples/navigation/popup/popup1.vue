<template>
  <v-card>
    <template #title> Popup </template>
    <template #subtitle> <UMarkdownViewer :content="popup1" /></template>
    <template #text>
      <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>

      <UPopup v-model="showPopup" :width="800" :height="600" title="팝업제목">
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

                <UFieldRow>
                  <UField label="코드 설명" :labelWidth="100">
                    <UTextBox v-model="inputFormData.cdDesc" type="textarea"></UTextBox>
                  </UField>
                </UFieldRow>

                <UFieldRow>
                  <UField label="기타필드1" :labelWidth="100">
                    <WjInputMask v-model="inputFormData.etc1" :isRequired="false"></WjInputMask>
                  </UField>
                </UFieldRow>

                <UFieldRow>
                  <UField label="기타필드2" :labelWidth="100">
                    <WjInputMask v-model="inputFormData.etc2" :isRequired="false"></WjInputMask>
                  </UField>
                </UFieldRow>

                <UFieldRow>
                  <UField label="기타필드3" :labelWidth="100">
                    <WjInputMask v-model="inputFormData.etc3" :isRequired="false"></WjInputMask>
                  </UField>
                </UFieldRow>

                <UFieldRow>
                  <UField label="기타필드4" :labelWidth="100">
                    <WjInputMask v-model="inputFormData.etc4" :isRequired="false"></WjInputMask>
                  </UField>
                </UFieldRow>

                <UFieldRow>
                  <UField label="기타필드5" :labelWidth="100">
                    <WjInputMask v-model="inputFormData.etc5" :isRequired="false"></WjInputMask>
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
      <UMarkdownViewer :content="popup2" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UPopup, UButton, WjInputMask, WjInputNumber } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import popup1 from './md/popup1.md'
// @ts-ignore
import popup2 from './md/popup2.md'

// for form
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

const showPopup = ref(false)
</script>
