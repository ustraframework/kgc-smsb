<template>
  <UBox direction="col">
    <UItem>
      <UButtonBar>
        <UFieldSet>
          <UFieldRow>
            <UField label="그릅코드" totalWidth="400"
              ><WjComboBox
                v-model="selectedGrpCode"
                :itemsSource="groupCodes"
                displayMemberPath="displayText"
                selectedValuePath="grpCd"
                :width="300"
              ></WjComboBox>
            </UField>
            <UButtonBox right top>
              <UButton text="신규" :width="80" @click="() => openNewForm(0, null)" />
              <UButton
                v-if="!!selectedGrpCode"
                text="수정"
                :width="80"
                @click="
                  () => {
                    openEditForm(
                      0,
                      groupCodes.find(c => c.grpCd === selectedGrpCode),
                    )
                  }
                "
              />
            </UButtonBox>
          </UFieldRow>
        </UFieldSet>
      </UButtonBar>
    </UItem>
    <UItem :ratio="1">
      <UBox direction="row">
        <UItem :ratio="1">
          <UstraSystemCodeList
            :ref="c => listComponents.push(c as InstanceType<typeof UstraSystemCodeList>)"
            :depth="1"
            :parentCode="parentCode1"
            @selectionChanged="
              data => {
                parentCode3 = null
                parentCode2 = data
              }
            "
            @clickEditButton="(depth, data) => openEditForm(depth, data)"
            @clickNewButton="(depth, sortNo) => openNewForm(depth, sortNo)"
          />
        </UItem>
        <UItem :ratio="1">
          <UstraSystemCodeList
            :ref="c => listComponents.push(c as InstanceType<typeof UstraSystemCodeList>)"
            :depth="2"
            :parentCode="parentCode2"
            @selectionChanged="
              data => {
                parentCode3 = data
              }
            "
            @clickEditButton="(depth, data) => openEditForm(depth, data)"
            @clickNewButton="(depth, sortNo) => openNewForm(depth, sortNo)"
          />
        </UItem>
        <UItem :ratio="1">
          <UstraSystemCodeList
            :ref="c => listComponents.push(c as InstanceType<typeof UstraSystemCodeList>)"
            :depth="3"
            :parentCode="parentCode3"
            @clickEditButton="(depth, data) => openEditForm(depth, data)"
            @clickNewButton="(depth, sortNo) => openNewForm(depth, sortNo)"
          />
        </UItem>
      </UBox>
    </UItem>
    <UItem>
      <UstraSystemCodeFrom
        v-model="isOpendForm"
        :sortNo="newSortNo"
        :selectedCode="selectedCode"
        :depth="formDepth"
        @updated="(depth, code) => reload(depth, code)"
      />
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { reactive, onBeforeMount, ref, computed, watch } from '#ustra/nuxt'
import { useOnError } from '#ustra/nuxt/composables'
import { UBox, UItem, UButtonBar, UFieldRow, UFieldSet, UField } from '#ustra/nuxt-vuetify/components'
import { Code } from '#ustra/nuxt/management/models/code'
import { WjFlexGrid, WjFlexGridColumn, WjComboBox } from '#ustra/nuxt-wijmo/components'
import { useUstraCodeService } from '#ustra/nuxt/management/services/code'
import UstraSystemCodeList from './list.vue'
import UstraSystemCodeFrom from './form.vue'

const codeService = useUstraCodeService()
const groupCodes = ref<Code[]>([])
const selectedGrpCode = ref<string>(null)

//#region gropup code
const loadGroupCode = useOnError(async () => {
  groupCodes.value = (await codeService.getCodeGroups({}))
    .map(code => {
      code.displayText = `${code.grpCd} : ${code.cdNm}`
      return code
    })
    .sort((a, b) => a.grpCd.localeCompare(b.grpCd))
})
onBeforeMount(() => loadGroupCode())
//#endregion

//#region reload
const listComponents = ref<InstanceType<typeof UstraSystemCodeList>[]>([])
async function reload(depth: number, code: string) {
  isOpendForm.value = false

  if (depth === 0) {
    await loadGroupCode()

    if (code) {
      selectedGrpCode.value = code
    }
  } else {
    listComponents.value[depth - 1].loadCodes(code)
  }
}
//#endregion

//#region parent code
const parentCode1 = computed(() => {
  if (!selectedGrpCode.value) {
    return null
  }

  return { grpCd: selectedGrpCode.value }
})

const parentCode2 = ref(null)
const parentCode3 = ref(null)

watch(parentCode1, v => {
  parentCode2.value = null
  parentCode3.value = null
})
//#endregion

// for form
const isOpendForm = ref(false)
const selectedCode = ref<Code>(null)
const formDepth = ref(0)
const newSortNo = ref(0)

// 신규 폼 오픈
function openNewForm(depth, sortNo: number) {
  newSortNo.value = sortNo
  selectedCode.value = null
  formDepth.value = depth

  if (depth === 1) {
    selectedCode.value = {
      grpCd: selectedGrpCode.value,
      grpNm: groupCodes.value.find(c => c.grpCd === selectedGrpCode.value).cdNm,
    }
  }

  if (depth > 1) {
    const prevListComponent = listComponents.value[depth - 2]

    selectedCode.value = {
      uprGrpCd: prevListComponent.selectedRowData.grpCd,
      uprDtlCd: prevListComponent.selectedRowData.dtlCd,
      grpCd: `${prevListComponent.selectedRowData.grpCd}_${prevListComponent.selectedRowData.dtlCd}`,
    }
  }

  isOpendForm.value = true
}

// 수정 폼 오픈
function openEditForm(depth, data: Code) {
  selectedCode.value = data
  formDepth.value = depth

  isOpendForm.value = true
}
</script>
<script lang="ts">
export default {
  name: 'UstraSystemCode',
}
</script>
