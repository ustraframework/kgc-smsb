<template>
  <div>
    <!-- 검색조건 테이블 -->
    <div class="columns has-gap">
      <UBox class="card is-sub is-search">
        <UItem class="card-body">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, 1, '170px']">
              <UField label="채널">
                <UCodeComboBox grpCd="CHNL_CD" v-model="searchActions.criteria.schChnlCd" displayNullText="전체" />
              </UField>
              <UField label="약관유형">
                <UCodeComboBox grpCd="TERM_PATR_DV_CD" v-model="searchActions.criteria.schTermPatrDvcd" displayNullText="전체" />
              </UField>
              <UField label="약관ID/명">
                <UTextBox type="text" v-model="searchActions.criteria.schTermNm" style="width: 100%"></UTextBox>
              </UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search"/>
                </div>
              </UField>
            </UFieldRow>
            <UFieldRow :ratio="[1, 1, 1, '170px']">
              <UField label="기준일자">
                <UDateBox v-model="searchActions.criteria.schAplDt" mode="date" />
              </UField>
              <UField blank></UField>
              <UField blank></UField>
            </UFieldRow>
          </UFieldSet>
        </UItem>
      </UBox>
    </div>
    <!-- // 검색조건 테이블 -->

    <!-- 본문 - 약관 목록 -->
    <div class="columns has-gap">
      <UBox class="card is-sub">
        <UItem class="card-body">

          <!-- hader 영역 -->
          <UBox class="table-title-wrap" direction="row">
            <UItem itemDirection="row" :ratio="1">
              <h2 class="table-title">
                <span>약관 목록</span>
                <span class="data-count">조회건수 <span>{{ listActions.chlTms.value.length }}</span> 건</span>
              </h2>
            </UItem>
            <UButtonBox class="table-buttons">
              <UButton text="신규" type="primary" small @click="() => listActions.init()" />
              <UButton text="저장" type="primary" small @click="() => detailActions.save()" />
              <UButton text="삭제" type="primary" small @click="() => detailActions.remove()" />
            </UButtonBox>
          </UBox>

          <!-- grid 영역 -->
          <WjFlexGrid :itemsSource="listActions.chlTms.value" :initialized="listActions.grid.initialize" style="min-height: 250px; max-height: 250px">
            <WjFlexGridColumn header="No" :width="60" align="center" :cellTemplate="ctx => ctx.row.index + 1" />
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
      </UBox>
    </div>
    <!-- //본문 - 약관 목록 끝 -->

    <!-- 본문 - 이용약관 상세정보 -->
    <div class="columns has-gap">
      <UBox class="card is-sub">
        <UItem class="card-body">
          <UBox class="table-title-wrap" direction="row">
            <UItem itemDirection="row" :ratio="1">
              <h2 class="table-title">
                <span>이용약관 상세정보</span>
              </h2>
            </UItem>
          </UBox>

          <UFieldSet>
            <UValidationGroup ref="validationGroup">
              <UFieldRow>
                <UField left required label="채널" labelWidth="120">
                  <UCodeComboBox grpCd="CHNL_CD" v-model="detailActions.chlTm.value.chnlCd" displayNullText="선택" />
                </UField>
                <UField left required label="약관유형" labelWidth="120">
                  <UCodeComboBox grpCd="TERM_PATR_DV_CD" v-model="detailActions.chlTm.value.termPatrDvcd" displayNullText="선택" />
                </UField>
                <UField left required label="약관ID" labelWidth="120">
                  <UTextBox type="text" v-model="detailActions.chlTm.value.termCd" :style="'width: 100%'" :validation="{ rules: ['required'] }" />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField left required label="약관명" labelWidth="120">
                  <UTextBox type="text" v-model="detailActions.chlTm.value.termNm" :style="'width: 100%'" :validation="{ rules: ['required'] }" />
                </UField>
                <UField left required label="약관버전" labelWidth="120">
                  <UTextBox type="text" v-model="detailActions.chlTm.value.termVrsnNo" :style="'width: 100%'" :validation="{ rules: ['required'] }" />
                </UField>
                <UField left required label="필수동의여부" labelWidth="120">
                  <UCodeComboBox grpCd="ESNT_AGRM_TERM_YN_CD" v-model="detailActions.chlTm.value.esntAgrmTermYn" displayNullText="선택" />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField left required label="적용기간" labelWidth="120">
                  <UDatePeriodBox
                    v-model:start="detailActions.chlTm.value.aplStDt"
                    v-model:end="detailActions.chlTm.value.aplEdDt"
                    :isRequired="true"
                  />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField left required label="약관내용" labelWidth="120">
                  <div>
                    <UCkEditor5
                      v-model="detailActions.chlTm.value.termCntt"
                      :height="400"
                      :initialized="detailActions.ckEditor.initialize"
                      :validation="{ rules: ['required'] }"
                    />
                  </div>
                </UField>
              </UFieldRow>
            </UValidationGroup>
          </UFieldSet>
        </UItem>
      </UBox>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjComboBox } from '#ustra/nuxt-wijmo/components'
import { wijmoInput } from '#ustra/nuxt-wijmo'
import { useChlTmMgntService, Criteria, ChlTm } from '~/services/bi/tm/chl-tm-mng-service'
import { UValidationGroup } from '#ustra/nuxt-wijmo/components'

// 서비스 정의
const chlTmMgntService = useChlTmMgntService()

// Validation 그룹 정의
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()

// SP 필수 ioUiId
const uiId = 'chl-tm-mng'

/**
 * 검색 기능
 */
const searchActions = (() => {
  // api 파라메터
  const criteria: Criteria = reactive({
    schAplDt: null,
    schChnlCd: null,
    schTermNm: null,
    schTermPatrDvcd: null,
    ioUiId: uiId,
  })

  return {
    criteria,
  }
})()

/**
 * 목록 기능
 */
const listActions = (() => {
  // 약관 목록
  const chlTms = ref<ChlTm[]>([])

  /**
   * 회원사 목록 검색
   */
  async function load() {
    await init()
    useOnError(
      async () => {
        const data = await chlTmMgntService.getList(searchActions.criteria)
        chlTms.value = data.record
      },
      {
        message: '조회 중 오류가 발생하였습니다.',
      },
    )()
  }

  async function init() {
    listActions.grid.control.value.select(-1, -1)
    await detailActions.init()
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

/**
 * 상세 기능
 */
const detailActions = (() => {
  // 약관 데이터
  const chlTm = ref<ChlTm>({})

  /**
   * 초기화
   */
  async function init() {
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
      ioUiId: uiId,
    }
    await validationGroup.value.init(true)
  }

  /**
   * 상세
   */
  async function detail(data: ChlTm) {
    chlTm.value = data
    chlTm.value.inReqGbn = 'U'
    chlTm.value.ioUiId = uiId
  }

  /**
   * 저장
   */
  async function save() {
    // Validation 체크
    const validationResult = await validationGroup.value.validate()
    if (!validationResult.isValid) {
      return
    }

    if (chlTm.value.inReqGbn === 'C') {
      if (await confirm('신규등록 하시겠습니까??')) {
        useOnError(
          async () => {
            const result = await chlTmMgntService.save(chlTm.value)
            // 정상
            if (result.otResponCode === '00000') {
              await init()
              await listActions.load()
            }
            // 오류
            else {
            }
          },
          {
            message: '저장 중 오류가 발생하였습니다.',
          },
        )()
      }
    } else {
      if (await confirm('수정 하시겠습니까??')) {
        useOnError(
          async () => {
            const result = await chlTmMgntService.save(chlTm.value)
            // 정상
            if (result.otResponCode === '00000') {
              await init()
              await listActions.load()
            }
            // 오류
            else {
            }
          },
          {
            message: '저장 중 오류가 발생하였습니다.',
          },
        )()
      }
    }
  }

  /**
   * 삭제
   */
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
