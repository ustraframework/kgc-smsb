<template>
  <UBox direction="col" :disabled="!props.parentCode">
    <UItem :ratio="1" scrollType="hidden">
      <WjFlexGrid
        :itemsSource="!props.parentCode ? [] : codes"
        style="height: 100%"
        :isReadOnly="true"
        selectionMode="Row"
        :initialized="
          grid => {
            gridControl = grid
            addWjGridEventHandler(grid, onGridDblClick)
          }
        "
      >
        <WjFlexGridColumn header="코드" binding="dtlCd" width="*" />
        <WjFlexGridColumn header="코드명" binding="cdNm" width="*" />
        <WjFlexGridColumn
          header="사용여부"
          binding="useYn"
          width="*"
          align="center"
          :cellTemplate="ctx => `${ctx.value === 'Y' ? '사용' : '미사용'}`"
        />
      </WjFlexGrid>
    </UItem>
    <UItem>
      <UButtonBar>
        <UButtonBox>
          <UButton
            text="신규"
            :width="80"
            @click="
              () => {
                emits('clickNewButton', props.depth, Math.max(Math.max(...codes.map(c => c.srtNo), codes.length + 1)))
              }
            "
            type="primary"
          />
        </UButtonBox>
      </UButtonBar>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { defineProps, withDefaults, watchEffect, watch, ref, defineExpose, nextTick } from '#ustra/nuxt'
import { UButtonBar } from '#ustra/nuxt-vuetify/components'
import { UButton } from '#ustra/nuxt-wijmo/components'
import { Code, useUstraCodeService } from '#ustra/nuxt/management'
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { addWjGridEventHandler, useWjGridSelectionData } from '#ustra/nuxt-wijmo/composables'

const codeService = useUstraCodeService()

const props = withDefaults(
  defineProps<{
    depth: number
    parentCode?: Code
  }>(),
  {
    parentCode: null,
  },
)

const emits = defineEmits<{
  (e: 'clickNewButton', depth: number, sortNo: number): void
  (e: 'clickEditButton', depth: number, data: Code): void
  (e: 'selectionChanged', data: Code | null): void
}>()

const gridControl = ref(null)
const selectedRowData = useWjGridSelectionData<Code>(gridControl, true)
watchEffect(() => {
  emits('selectionChanged', selectedRowData.value)
})

//#region load code
const codes = ref<Code[]>()
async function loadCodes(selectedCode = null) {
  selectedRowData.value = null
  if (!props.parentCode) {
    codes.value = []
    return
  }

  if (props.depth === 1) {
    codes.value = await codeService.getCodesByGroup(props.parentCode.grpCd)
  } else {
    codes.value = await codeService.getCodeGroupDepth(props.parentCode.grpCd, props.parentCode.dtlCd)
  }

  if (selectedCode) {
    await nextTick()
    const index = codes.value.findIndex(c => c.dtlCd === selectedCode)
    gridControl.value.select(index, 1)
  }
}
//#endregion

//#region double click
function onGridDblClick() {
  emits('clickEditButton', props.depth, selectedRowData.value)
}
//#endregion

watch(
  () => props.parentCode,
  async () => {
    await nextTick()
    loadCodes()
  },
)

defineExpose({ loadCodes, selectedRowData })
</script>
<script lang="ts">
export default {
  name: 'UstraSystemCodeList',
}
</script>
