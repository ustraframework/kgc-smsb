<template>
<UPopup v-model="show" title="파라미터 입력" @close="close" width="800" height="600">
  <UItem>
    <UBox>
      <UFieldRow v-for="each in value">
        <UField :label="each.batchParamId">
          <WjInputMask v-model="each.batchParamValue" />
        </UField>
      </UFieldRow>
      <UFieldRow>
        <UButtonBar class="mt-2">
          <UButtonBox right>
            <UButton text="시작" @click="submit"></UButton>
            <UButton text="취소" @click="cancel"></UButton>
          </UButtonBox>
        </UButtonBar>
      </UFieldRow>
    </UBox>
  </UItem>
</UPopup>
</template>
<script lang="ts" setup>
import {
  UBox,
  UItem,
  UFieldSet,
  UFieldRow,
  UField,
  WjFlexGrid,
  WjFlexGridColumn,
  WjComboBox,
  WjInputMask,
  WjInputNumber,
  UCheckGroupBox,
  UValidationGroup,
  WjMultiSelect,
} from '#ustra/nuxt-wijmo/components'
const show = ref(false)
const value = ref()

const resolveRef = ref()
const rejectRef = ref()

const open = async (parameters) => {
  value.value = parameters.map(each => {
    return {
      batchParamId: each.batchParamId,
      batchParamValue: '',
    }
  })
  show.value = true

  return new Promise((resolve, reject) => {
    resolveRef.value = resolve
    rejectRef.value = reject
  })
}

const submit = async (param) => {
  close(value)
}

const cancel = async (param) => {
  show.value = false
  rejectRef.value()
}

const close = (param) => {
  resolveRef.value(value.value)
  show.value = false
}

defineExpose({
  open,
  close
})

</script>
