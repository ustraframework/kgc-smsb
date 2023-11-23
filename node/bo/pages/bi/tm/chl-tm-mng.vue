<template>
  <div>
    <!-- 검색조건 테이블 -->
    <div class="section-depth">
      <UFieldSet @keyup.enter="listActions.load()">
        <UFieldRow :ratio="[1, 1, 1, 0.3]">
          <UField label="채널" itemDirection="row" labelWidth="100" left>
            <UCodeComboBox grpCd="CHNL_CD" v-model="searchActions.criteria.schChnlCd" displayNullText="전체" />
          </UField>
          <UField label="약관유형" itemDirection="row" labelWidth="100" left>
            <UCodeComboBox grpCd="TERM_PATR_DV_CD" v-model="searchActions.criteria.schTermPatrDvcd" displayNullText="전체" />
          </UField>
          <UField label="약관ID/명" itemDirection="row" labelWidth="100" left>
            <UTextBox type="text" v-model="searchActions.criteria.schTermNm" style="width: 100%"></UTextBox>
          </UField>
          <UField blank>
            <UButtonBox right>
              <UButton text="조회" type="primary" small @click="() => listActions.load()" />
            </UButtonBox>
          </UField>
        </UFieldRow>
        <UFieldRow :ratio="[1, 1, 1, 0.3]">
          <UField label="기준일자" itemDirection="row" labelWidth="100" left>
            <UDateBox v-model="searchActions.criteria.schAplDt" mode="date" />
          </UField>
        </UFieldRow>
      </UFieldSet>
    </div>
    <!-- // 검색조건 테이블 -->

    <div class="section-depth">
      <UBox direction="col" class="tableSection1">
        <!-- top 영역 -->
        <UItem :ratio="1">
          <UButtonBar title="약관 목록" backgroundColor="transparent" class="sub-title">
            <div class="control-txt">조회건수 {{ listActions.chlTms.value.length }}</div>
            <UButtonBox right>
              <UButton text="신규" type="primary" small @click="() => listActions.init()" />
              <UButton text="저장" type="primary" small @click="() => detailActions.save()" />
              <UButton text="삭제" type="primary" small @click="() => detailActions.remove()" />
            </UButtonBox>
          </UButtonBar>

          <!-- 그리드 -->
          <WjFlexGrid :itemsSource="listActions.chlTms.value" :initialized="listActions.grid.initialize" style="min-height: 250px; max-height: 250px">
            <WjFlexGridColumn header="No" binding="rowNum" :width="60" align="center" />
            <WjFlexGridColumn
              header="채널"
              binding="chnlCd"
              width="*"
              align="center"
              :cellTemplate="ctx => useUstraCodeValue('CHNL_CD', ctx.value)"
            />
            <WjFlexGridColumn
              header="약관유형"
              binding="termPatrDvcd"
              width="*"
              align="center"
              :cellTemplate="ctx => useUstraCodeValue('TERM_PATR_DV_CD', ctx.value)"
            />
            <WjFlexGridColumn header="약관ID" binding="termCd" width="*" align="center" />
            <WjFlexGridColumn header="약관명" binding="termNm" width="*" align="center" />
            <WjFlexGridColumn header="약관버전" binding="termVrsnNo" width="*" align="center" />
            <WjFlexGridColumn
              header="필수동의여부"
              binding="esntAgrmTermYn"
              width="*"
              align="center"
              :cellTemplate="ctx => useUstraCodeValue('ESNT_AGRM_TERM_YN_CD', ctx.value)"
            />
            <WjFlexGridColumn
              header="적용시작일자"
              binding="aplStDt"
              width="*"
              align="center"
              :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)"
            />
            <WjFlexGridColumn
              header="적용종료일자"
              binding="aplEdDt"
              width="*"
              align="center"
              :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)"
            />
            <WjFlexGridColumn header="약관내용" binding="termCntt" width="*" align="center" />
          </WjFlexGrid>
        </UItem>
        <UButtonBar title="이용약관 상세정보" backgroundColor="transparent" class="sub-title"> </UButtonBar>
        <!-- bottom 영역 -->
        <UItem :ratio="1">
          <UFieldSet>
            <UFieldRow>
              <UField left label="채널" labelWidth="100">
                <UCodeComboBox grpCd="CHNL_CD" v-model="detailActions.chlTm.value.chnlCd" displayNullText="선택" />
              </UField>
              <UField left label="약관유형" labelWidth="100">
                <UCodeComboBox grpCd="TERM_PATR_DV_CD" v-model="detailActions.chlTm.value.termPatrDvcd" displayNullText="선택" />
              </UField>
              <UField left label="약관ID" labelWidth="100">
                <UTextBox type="text" v-model="detailActions.chlTm.value.termCd" :style="'width: 100%'" />
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField left label="약관명" labelWidth="100">
                <UTextBox type="text" v-model="detailActions.chlTm.value.termNm" :style="'width: 100%'" />
              </UField>
              <UField left label="약관버전" labelWidth="100">
                <UTextBox type="text" v-model="detailActions.chlTm.value.termVrsnNo" :style="'width: 100%'" />
              </UField>
              <UField left label="필수동의여부" labelWidth="100">
                <UCodeComboBox grpCd="ESNT_AGRM_TERM_YN_CD" v-model="detailActions.chlTm.value.esntAgrmTermYn" displayNullText="선택" />
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField left label="적용기간" labelWidth="100">
                <UDatePeriodBox v-model:start="detailActions.chlTm.value.aplStDt" v-model:end="detailActions.chlTm.value.aplEdDt" />
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField left label="약관내용" labelWidth="100">
                <div>
                  <UCkEditor5 v-model="detailActions.chlTm.value.termCntt" :height="400" :initialized="detailActions.ckEditor.initialize" />
                </div>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UItem>
        <!-- // left 영역 -->
      </UBox>
    </div>
    <!-- // 검색결과 : 좌1단 우1단 샘플 -->
  </div>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjComboBox } from '#ustra/nuxt-wijmo/components'
import { wijmoInput } from '#ustra/nuxt-wijmo'
import { useChlTmMgntService, Criteria, ChlTm } from '~/services/bi/tm/chl-tm-mng-service'

// 서비스 정의
const chlTmMgntService = useChlTmMgntService()

// 검색 기능
const searchActions = (() => {
  // api 파라메터
  const criteria: Criteria = reactive({
    schAplDt: null,
    schChnlCd: null,
    schTermNm: null,
    schTermPatrDvcd: null,
  })

  return {
    criteria,
  }
})()

// 목록 기능
const listActions = (() => {
  /**
   * 약관 목록
   */
  const chlTms = ref<ChlTm[]>([])

  /**
   * 회원사 목록 검색
   */
  async function load() {
    init()
    const data = await chlTmMgntService.getList(searchActions.criteria)
    chlTms.value = data.record
  }

  function init() {
    listActions.grid.control.value.select(-1, -1)
    detailActions.init()
  }

  /**
   * 그리드 설정
   */
  const grid = useWijmoFlexGrid<ChlTm>({
    autoSelection: false,
    onCellClick: function (col, row, data) {
      detailActions.detail(data)
    },
  })

  return {
    chlTms,
    load,
    grid,
    init,
  }
})()

// 상세 기능
const detailActions = (() => {
  // 약관 데이터
  const chlTm = ref<ChlTm>({})
  // 초기화
  function init() {
    chlTm.value = {
      inReqGbn: 'C',
      aplEdDt: null,
      aplStDt: null,
      chnlCd: null,
      esntAgrmTermYn: null,
      termCd: null,
      termCntt: '',
      termNm: null,
      termPatrDvcd: null,
      termVrsnNo: null,
    }
  }
  init()

  /**
   * 상세
   */
  async function detail(data: ChlTm) {
    chlTm.value = data
    chlTm.value.inReqGbn = 'U'
  }

  /**
   * 저장
   * @param Checkbox selection 그리드 데이터
   */
  async function save() {
    let result = 0
    if (chlTm.value.inReqGbn === 'C') {
      if (await confirm('신규등록 하시겠습니까??')) {
        const result = await chlTmMgntService.save(chlTm.value)
        // 정상
        if (result.otResponCode === '00000') {
          init()
          listActions.load()
        }
        // 오류
        else {
        }
      }
    } else {
      if (await confirm('수정 하시겠습니까??')) {
        const result = await chlTmMgntService.save(chlTm.value)
        // 정상
        if (result.otResponCode === '00000') {
          init()
          listActions.load()
        }
        // 오류
        else {
        }
      }
    }
  }

  async function remove() {
    if (await confirm('삭제 하시겠습니까??')) {
    }
  }

  const ckEditor = useUstraCkEditor5()

  return {
    chlTm,
    save,
    remove,
    ckEditor,
    detail,
    init,
  }
})()
</script>
<script lang="ts">
export default {
  name: 'ChlTmMgnt',
}
</script>
