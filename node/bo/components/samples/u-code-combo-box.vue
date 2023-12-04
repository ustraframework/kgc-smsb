<template>
  <UWjComboBox v-bind="$attrs" :itemsSource="itemsSource" v-model="comboValue" displayMemberPath="display" selectedValuePath="value" />
  <UButton icon="mdi-comment-edit" text="콤보 박스 값 변경" @click="() => (vmodelValue = 'FO')"></UButton>
</template>
<script lang="ts" setup>
import { defineProps, withDefaults, watch } from '#ustra/nuxt'
import { UWjComboBox } from '#ustra/nuxt-wijmo/components'
import { useComboComponent } from '#ustra/nuxt-wijmo/management/components/composables/code-combo'
import type { CodeComboBoxProps, CodeItem } from '#ustra/nuxt-wijmo/management/components/composables/code-combo'

export interface UCodeComboBoxProps extends CodeComboBoxProps {
  /**
   * model value
   */
  modelValue?: string

  /**
   * 그룹 코드
   */
  grpCd: string

  /**
   * 사용 중인 코드 값만 조회 여부
   */
  onlyUse?: boolean

  /**
   * 코드 디스플레이 여부
   */
  displayCode?: boolean

  /**
   * 목록 커스토마이징 function
   */
  customizeItems?: (codes: CodeItem[]) => CodeItem[]

  /**
   * 이름 순 정렬 여부
   */
  sortByName?: boolean

  /**
   * 코드 순 정렬 여부
   */
  sortByCode?: boolean

  /**
   * null value text
   */
  displayNullText?: string

  /**
   * object value
   */
  objectValue?: CodeItem
}

const props = withDefaults(defineProps<UCodeComboBoxProps>(), {
  onlyUse: true,
  modelValue: null,
  objectValue: null,
  displayCode: false,
  customizeItems: null,
  sortByName: false,
  sortByCode: false,
  displayNullText: null,
})

const { comboValue, itemsSource, vmodelValue, objectValue } = useComboComponent(props)

watch(vmodelValue, v => {
  console.log('modelValue', v)
})

watch(
  itemsSource,
  v => {
    console.log('watch itemssource')
    // select first value
    if (!comboValue.value && v.length > 0) {
      comboValue.value = v[0].value
    }
  },
  {
    immediate: true,
  },
)
</script>

<script lang="ts">
export default {
  name: 'UCodeComboBox',
  inheritAttrs: false,
}
</script>
