<template>
  <WjFlexGrid
    :isReadOnly="true"
    style="height: calc(100% - 300px); min-height: 300px;"
    :itemsSource="ifs"
    selectionMode="Row"
    :initialized="grid.initialize"
    headersVisibility="Column"
  >
    <WjFlexGridColumn header="I/F 아이디" binding="ifId" width="*"/>
    <WjFlexGridColumn header="I/F 버전" binding="ifVer" width="*"/>
    <WjFlexGridColumn header="I/F명" binding="ifNm" width="*"/>
    <WjFlexGridColumn header="url" binding="url" width="*"/>
    <WjFlexGridColumn header="사용여부" binding="useYn" width="*"/>
  </WjFlexGrid>
</template>

<script setup lang="ts">
import { reactive, ref, shallowRef, onBeforeMount, useDeepMerge, useOnError, computed, watch } from '#ustra/nuxt'
import { WjComboBox, UBox, UItem, WjInputMask, UFieldSet, UFieldRow, UField, WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { IfsCriteria, Ifs } from '#ustra/nuxt/management'
import { useUstraInterfaceService } from '#ustra/nuxt/management/services/interface'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables/grid'

const infService = useUstraInterfaceService()

const ifs = ref<Ifs[]>([])

async function loadData(criteria) {
  const list = await infService.getInterfaces(criteria)
  ifs.value = list
}

function clearSelection() {
  console.log('clearSelection')
  //this.grid.instance.clearSelection()
}

const grid = useWijmoFlexGrid<Ifs>({
  autoSelection: false,
  onCellClick: function (col, row, data) {
    select(data as Ifs)
  },
})

const emits = defineEmits<{
  (e: 'select', ifs?: Ifs): void
}>()

function select(ifs: Ifs) {
  emits('select', ifs)
}

defineExpose({
  loadData,
  clearSelection,
})
</script>

<style scoped></style>
