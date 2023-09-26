<template>
  <div>
    <UFieldSet>
      <UFieldRow>
        <UField label="요청 헤더 내용" :label-width="130" :full-width="true">
          <UTextBox v-model="inputData.reqHedCont" type="textarea" height="150" :read-only="true" />
        </UField>
      </UFieldRow>

      <UFieldRow>
        <UField label="요청 파라메터 내용" :label-width="130" :full-width="true">
          <UTextBox v-model="inputData.reqPrmCont" type="textarea" height="150" :read-only="true" />
        </UField>
      </UFieldRow>
      <UFieldRow>
        <UField label="요청 메시지" :label-width="130" :full-width="true">
          <UTextBox v-model="inputData.reqMsgCont" type="textarea" height="150" :read-only="true" />
        </UField>
      </UFieldRow>

      <UFieldRow>
        <UField label="응답 헤더 내용" :label-width="130" :full-width="true">
          <UTextBox v-model="inputData.resHedCont" type="textarea" height="150" :read-only="true" />
        </UField>
      </UFieldRow>

      <UFieldRow>
        <UField label="응답 메시지" :label-width="130" :full-width="true">
          <UTextBox v-model="inputData.resMsgCont" type="textarea" height="150" :read-only="true" />
        </UField>
      </UFieldRow>

      <UFieldRow>
        <UField label="비고" :label-width="130" :full-width="true">
          <UTextBox v-model="inputData.rmk" type="textarea" height="100" :read-only="true" />
        </UField>
      </UFieldRow>
    </UFieldSet>

    <UButtonBox>
      <UButton text="확인" icon="check" class="right" @click="confirmHistData" />
    </UButtonBox>
  </div>
</template>

<script setup lang="ts">
import { isRef, reactive, defineExpose, ref, useOnError, defineEmits, nextTick, defineProps, computed, useDeepMerge, shallowRef } from '#ustra/nuxt'
import {
  UBox,
  UItem,
  UFieldSet,
  UFieldRow,
  UField,
  UTextBox,
  UValidationGroup,
  UCheckGroupBox,
  WjInputMask,
  WjInputNumber,
  WjMultiSelect,
  WjMultiSelectListBox,
  UIpAddressListBox,
  WjFlexGrid,
  WjFlexGridColumn,
  WjFlexGridCellTemplate,
  WjTabPanel,
  WjTab,
} from '#ustra/nuxt-wijmo/components'
import { IfsHist } from '#ustra/nuxt/management'
import { useUstraInterfaceService } from '#ustra/nuxt/management/services/interface'
const infService = useUstraInterfaceService()
// import { Component, Emit } from 'vue-property-decorator'
// import { UstraBoComponent } from '@ustra/nuxt-mng-bo/src/components/ustra-bo-component'
// import { IfsHist } from '@ustra/nuxt-mng/src/system/models/ifs-hist-model'
// import ustraIfsHistService from '@ustra/nuxt-mng/src/system/services/ustra-ifs-hist-service'
// import { OnError } from '@ustra/nuxt/src/vue/decorators'

// #region variables
const inputData: Partial<IfsHist> = reactive({})

// @OnError()
async function loadData(ifHistId: number) {
  const ifsHist = await infService.getInterfaceHistory(ifHistId)
  console.log('ifsHist', ifsHist)
  useDeepMerge(inputData, ifsHist)
  // inputData.value = ifsHist
}

// @Emit()
// confirmHist() {}

function confirmHistData() {
  // this.confirmHist()
  emits('confirmHist')
}

const emits = defineEmits<{
  (e: 'confirmHist'): void
}>()

defineExpose({
  loadData,
})
// #endregion
// #region watches
// #endregion
</script>
<style lang="scss"></style>
