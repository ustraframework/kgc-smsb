<template>
  <UBox direction="row">
    <UItem :ratio="1">
      <WjFlexGrid
        :initialized="ctl => (listActions.gridControl.value = ctl)"
        :itemsSource="listActions.fileGroups.value"
        style="height: 100%"
        :isReadOnly="true"
      >
        <WjFlexGridColumn header="아이디" binding="fileGrpId" />
        <WjFlexGridColumn header="그룹명" binding="fileGrpNm" width="*" />
        <WjFlexGridColumn header="사용여부" binding="useYn" :cellTemplate="ctx => `${ctx.value === 'Y' ? '사용' : '미사용'}`" align="center" />
      </WjFlexGrid>
    </UItem>

    <UItem :ratio="1">
      <UBox direction="col">
        <UItem :ratio="1">
          <UValidationGroup :ref="r => (formActions.validationGroup.value = r as InstanceType<typeof UValidationGroup>)">
            <UFieldSet>
              <UFieldRow>
                <UField required label="아이디">
                  <WjInputMask
                    v-model="formActions.inputData.fileGrpId"
                    :isDisabled="!formActions.isNew.value"
                    :validation="{
                      rules: [
                        {
                          type: 'custom',
                          delay: 200,
                          handler: async v => {
                            if (!v) {
                              return '필수 입력입니다.'
                            }
                            if (await fileGroupService.getFileGroup(v)) {
                              return '이미 사용 중인 아이디입니다.'
                            }

                            return true
                          },
                        },
                      ],
                    }"
                  />
                </UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="그룹명">
                  <WjInputMask v-model="formActions.inputData.fileGrpNm" />
                </UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="저장경로">
                  <WjInputMask v-model="formActions.inputData.svPath" />
                </UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="최대용량">
                  <WjInputNumber v-model="formActions.inputData.maxSz" />
                </UField>
              </UFieldRow>

              <UFieldRow>
                <UField label="확장자제한">
                  <WjInputMask v-model="formActions.inputData.extenLmt" :isRequired="false" />
                  <UMessage type="info">
                    미 입력시 모든 유형에 대해 업로드가 가능합니다.<br />
                    확장자 또는 Mime type별로 제한을 설정하는 경우, comma로 구분하여 입력해주세요. <br />
                    ex) .doc,.docx,application/msword,image/*
                  </UMessage>
                </UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="파일구조">
                  <UCodeComboBox grpCd="DIR_STRUCT_CD" v-model="formActions.inputData.dirStructCd" />
                </UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="파일명 저장방식">
                  <UCodeComboBox grpCd="FILE_NM_SV_METH_CD" v-model="formActions.inputData.fileNmSvMethCd" />
                </UField>
              </UFieldRow>

              <UFieldRow>
                <UField label="웹 기본 url">
                  <WjInputMask v-model="formActions.inputData.webDefUrl" :isRequired="false" />
                </UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="파일 암호화">
                  <UCodeComboBox grpCd="FILE_CRYT_METH_CD" v-model="formActions.inputData.fileCrytMethCd" />
                </UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="사용여부">
                  <URadioGroupBox
                    v-model="formActions.inputData.useYn"
                    :itemsSource="[
                      { value: 'Y', text: '사용' },
                      { value: 'N', text: '미사용' },
                    ]"
                  />
                </UField>
              </UFieldRow>
            </UFieldSet>
          </UValidationGroup>
        </UItem>
        <UItem>
          <UButtonBox right top>
            <UButton text="신규" type="primary" :width="80" @click="() => formActions.init(true)" />
            <UButton text="저장" type="primary" :width="80" @click="() => formActions.save()" />
            <UButton text="삭제" v-if="!formActions.isNew.value" :width="80" @click="() => formActions.remove()" />
          </UButtonBox>
        </UItem>
      </UBox>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { shallowRef, ref, onBeforeMount, reactive, useDeepMerge, useOnError, watch, nextTick } from '#ustra/nuxt'
import {
  UBox,
  UItem,
  WjFlexGrid,
  WjFlexGridColumn,
  UFieldSet,
  UFieldRow,
  UField,
  URadioGroupBox,
  UValidationGroup,
  WjInputMask,
  WjInputNumber,
  UMessage,
} from '#ustra/nuxt-wijmo/components'
import { useWjGridSelectionData } from '#ustra/nuxt-wijmo/composables'
import { useUstraFileGroupService } from '#ustra/nuxt/management/composables'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { FileGrp } from '#ustra/nuxt/management'
import { FlexGrid } from '@grapecity/wijmo.grid'

const fileGroupService = useUstraFileGroupService()

/**
 * 그리드 목록 관련
 */
const listActions = (() => {
  /**
   * grid conrol
   */
  const gridControl = shallowRef<FlexGrid>()

  /**
   * 파일 그룹 목록
   */
  const fileGroups = ref<Awaited<ReturnType<typeof fileGroupService.getFileGroups>>>([])

  /**
   * grid 선택 데이터
   */
  const gridSelectionData = useWjGridSelectionData<FileGrp>(gridControl, true)

  watch(gridSelectionData, v => {
    if (v) {
      formActions.loadDetail(v.fileGrpId)
    }
  })

  /**
   * 그롭 목록 조회
   */
  async function load(fileGrpId: string = null) {
    fileGroups.value = await fileGroupService.getFileGroups()
    formActions.init()

    if (fileGrpId) {
      await nextTick()
      const index = fileGroups.value.findIndex(c => c.fileGrpId === fileGrpId)
      gridControl.value.select(index, 1)
    }
  }
  onBeforeMount(() => load())

  return {
    gridControl,
    fileGroups,
    load,
    clearSelection: () => {
      gridControl.value.select(-1, -1)
    },
  }
})()

/**
 * For 관련 action
 */
const formActions = (() => {
  // 입력 데이터
  const inputData: FileGrp = reactive({
    fileGrpId: null,
    fileGrpNm: null,
    svPath: null,
    useYn: 'Y',
    maxSz: 0,
    extenLmt: null,
    dirStructCd: 'RT_DIR',
    fileNmSvMethCd: '01',
    webDefUrl: null,
    fileCrytMethCd: '00',
  })

  // 신규 여부
  const isNew = ref(true)

  const validationGroup = ref<InstanceType<typeof UValidationGroup>>()

  // 초기화
  async function init(clearSelection = false) {
    useDeepMerge(inputData, {
      fileGrpId: null,
      fileGrpNm: null,
      svPath: null,
      useYn: 'Y',
      maxSz: 0,
      extenLmt: null,
      dirStructCd: 'RT_DIR',
      fileNmSvMethCd: '01',
      webDefUrl: null,
      fileCrytMethCd: '00',
    })

    isNew.value = true
    await validationGroup.value.init()

    if (clearSelection) {
      listActions.clearSelection()
    }
  }

  async function loadDetail(fileGrpId: string) {
    await init()

    const fileGrpData = await fileGroupService.getFileGroup(fileGrpId)
    useDeepMerge(inputData, fileGrpData)
    isNew.value = false

    await validationGroup.value.init()
  }

  // 저장
  async function save() {
    return await useOnError(async () => {
      const result = await validationGroup.value.validate()
      if (!result.isValid) {
        return
      }

      if (isNew.value) {
        await fileGroupService.add(inputData)
      } else {
        await fileGroupService.edit(inputData)
      }

      listActions.load(inputData.fileGrpId)
    })()
  }

  // 삭제
  async function remove() {
    return await useOnError(async () => {
      if (await confirm('삭제하시겠습니까?')) {
        await fileGroupService.remove(inputData.fileGrpId)
        listActions.load()
      }
    })()
  }

  return { inputData, isNew, init, validationGroup, save, loadDetail, remove }
})()
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemFileGroup',
}
</script>
