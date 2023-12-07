<template>
  <div class="docs__wrap">
    <div class="columns has-gap">
      <div class="card is-sub">
        <div class="card-body">
          <h2 class="table-title"><span>컴포넌트 목록</span></h2>
          <WjFlexGrid :itemsSource="items2" :initialized="grid2.initialize" style="min-height: 250px; max-height: 250px">
            <WjFlexGridColumn header="컴포넌트명" binding="col1" width="*" />
            <WjFlexGridColumn header="경로" binding="col2" width="*" />
            <WjFlexGridColumn header="링크" binding="col2" :width="110">
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                <div>
                  <UButtonBox v-if="cell.item.col2">
                    <UButton small type="primary" text="링크" :width="80" @click="openLink(cell.item.col2)" />
                  </UButtonBox>
                </div>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>
          </WjFlexGrid>
        </div>
      </div>
      <div class="card is-sub">
        <div class="card-body">
          <h2 class="table-title"><span>BO 템플릿 목록</span></h2>
          <WjFlexGrid :itemsSource="items3" :initialized="grid3.initialize" style="min-height: 250px; max-height: 250px">
            <WjFlexGridColumn header="템플릿" binding="col1" width="*" />
            <WjFlexGridColumn header="구조" binding="col3" width="*" />
            <WjFlexGridColumn header="경로" binding="col2" width="2*" />
            <WjFlexGridColumn header="링크" binding="col2" :width="110">
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                <div>
                  <UButtonBox v-if="cell.item.col2">
                    <UButton small type="primary" text="링크" :width="80" @click="openLink(cell.item.col2)" />
                  </UButtonBox>
                </div>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>
          </WjFlexGrid>
        </div>
      </div>
    </div>


    <div class="columns has-gap">
      <div class="card is-sub">
        <div class="card-body">
          <h2 class="table-title"><span>BO 페이지 목록</span></h2>
          <WjFlexGrid :itemsSource="items" :initialized="grid.initialize" style="min-height: 800px; max-height: 800px">
            <WjFlexGridColumn header="단위업무명" binding="col1" width="*" />
            <WjFlexGridColumn header="레벨" binding="col2" width="*" />
            <WjFlexGridColumn header="화면명" binding="col3" width="2*" />
            <WjFlexGridColumn header="화면ID" binding="col4" width="*" />
            <WjFlexGridColumn header="경로" binding="col5" width="2*" />
            <WjFlexGridColumn header="링크" binding="col5" :width="110">
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                <div>
                  <UButtonBox v-if="cell.item.col5">
                    <UButton small type="primary" text="링크" :width="80" @click="openLink(cell.item.col5)" />
                  </UButtonBox>
                </div>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>
            <WjFlexGridColumn header="템플릿 유형" binding="col6" width="*" />
            <WjFlexGridColumn header="작업유무" binding="col7" width="*" align="center" />
          </WjFlexGrid>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate } from '#ustra/nuxt-wijmo/components'
import { wijmoGrid } from '#ustra/nuxt-wijmo'

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

function openLink(url: string) {
  window.open(url, '_blank')
}

const grid = useWijmoFlexGrid({
  isReadOnly: true,
  selection: {
    mode: wijmoGrid.SelectionMode.None,
  },
  onAfterInitialized(control) {
    control.autoSizeMode = wijmoGrid.AutoSizeMode.None
  },
})

const grid2 = useWijmoFlexGrid({
  isReadOnly: true,
  selection: {
    mode: wijmoGrid.SelectionMode.None,
  },
  onAfterInitialized(control) {
    control.autoSizeMode = wijmoGrid.AutoSizeMode.None
  },
})

const grid3 = useWijmoFlexGrid({
  isReadOnly: true,
  selection: {
    mode: wijmoGrid.SelectionMode.None,
  },
  onAfterInitialized(control) {
    control.autoSizeMode = wijmoGrid.AutoSizeMode.None
  },
})

// 컴포넌트 목록 그리드 데이터
const items2 = ref([
  { col1: '버튼', col2: '/docs/buttons' },
  { col1: '콤보박스-일자', col2: '/docs/combobox-date' },
  { col1: '폼', col2: '/docs/form' },
  { col1: '인풋', col2: '/docs/input' },
  { col1: '레이아웃-ustra', col2: '/docs/layout-ustra' },
  { col1: '레이아웃', col2: '/docs/layout' },
  { col1: '팝업', col2: '/docs/popup' },
  { col1: '타이포그래피', col2: '/docs/typography' },
])

// BO 템플릿 목록 그리드 데이터
const items3 = ref([
  { col1: 'board-vertical', col2: '/template/board-vertical', col3: '좌 + 우' },
  { col1: 'board', col2: '/template/board', col3: 'board' },
  { col1: 'form-grid-form', col2: '/template/form-grid-form', col3: 'form-grid-form' },
  { col1: 'form-grid', col2: '/template/form-grid', col3: 'form-grid' },
  { col1: 'form-tab', col2: '/template/form-tab', col3: 'form-tab' },
  { col1: 'form', col2: '/template/form', col3: 'form' },
  { col1: 'grid-form-grid-vertical', col2: '/template/grid-form-grid-vertical', col3: 'grid-form-grid-vertical' },
  { col1: 'grid-form-vertical', col2: '/template/grid-form-vertical', col3: 'grid-form-vertical' },
  { col1: 'grid-form', col2: '/template/grid-form', col3: 'grid-form' },
  { col1: 'grid-grid-vertical', col2: '/template/grid-grid-vertical', col3: 'grid-grid-vertical' },
  { col1: 'grid-grid', col2: '/template/grid-grid', col3: 'grid-grid' },
  { col1: 'grid-tab-vertical', col2: '/template/grid-tab-vertical', col3: 'grid-tab-vertical' },
  { col1: 'grid-tab', col2: '/template/grid-tab', col3: 'grid-tab' },
  { col1: 'grid', col2: '/template/grid', col3: 'grid' },
  { col1: 'popup-form-grid', col2: '/template/popup-form-grid', col3: 'popup-form-grid' },
  { col1: 'popup-form', col2: '/template/popup-form', col3: 'popup-form' },
  { col1: 'popup-grid', col2: '/template/popup-grid', col3: 'popup-grid' },
  { col1: 'popup-search', col2: '/template/popup-search', col3: 'popup-search' },
  { col1: 'popup-shuffle', col2: '/template/popup-shuffle', col3: 'popup-shuffle' },
  { col1: 'tab', col2: '/template/tab', col3: 'tab' },
])

// BO 페이지 목록 그리드 데이터
const items = ref([
  {
    col1: '회원',
    col2: '회원관리',
    col3: '회원 조회',
    col4: 'UI_BM_1101',
    col5: '/pubs/MS/MB/UI_BM_1101_pubs',
    col6: 'form-tab',
    col7: 'O',
  },
  { col1: '회원', col2: '회원관리', col3: '회원정보 변경 사유', col4: 'UI_BM_1102', col5: '/pubs/MS/MB/UI_BM_1102_pubs', col6: 'popup-form', col7: 'O' },
  { col1: '회원', col2: '회원관리', col3: '회원정보 이용 목적', col4: 'UI_BM_1103', col5: '/pubs/MS/MB/UI_BM_1103_pubs', col6: 'popup-form', col7: 'O' },
  { col1: '회원', col2: '회원관리', col3: '회원 등록 처리', col4: 'UI_BM_1104', col5: '/pubs/MS/MB/UI_BM_1104_pubs', col6: 'form', col7: 'O' },
  { col1: '회원', col2: '회원관리', col3: '탈퇴회원 복원 처리', col4: 'UI_BM_1105', col5: '/pubs/MS/MB/UI_BM_1105_pubs', col6: 'grid-form', col7: 'O' },
  { col1: '회원', col2: '회원관리', col3: '회원정보 열람 이력 조회', col4: 'UI_BM_1106', col5: '/pubs/MS/MB/UI_BM_1106_pubs', col6: 'grid', col7: 'O' },
  { col1: '회원', col2: '회원관리', col3: '프로그램 검색', col4: 'UI_BM_1107', col5: '/pubs/MS/MB/UI_BM_1107_pubs', col6: 'popup-search', col7: 'O' },
  { col1: '회원', col2: '회원관리', col3: '임직원 검색', col4: 'UI_BM_1108', col5: '/pubs/MS/MB/UI_BM_1108_pubs', col6: 'popup-search', col7: 'O' },
  { col1: '회원', col2: '회원관리', col3: '회원정보 변경 이력 조회', col4: 'UI_BM_1109', col5: '/pubs/MS/MB/UI_BM_1109_pubs', col6: 'grid', col7: 'O' },
  { col1: '회원', col2: '회원관리', col3: '회원인증 이력 조회', col4: 'UI_BM_1110', col5: '/pubs/MS/MB/UI_BM_1110_pubs', col6: 'grid', col7: 'O' },

  { col1: '회원', col2: '승인관리', col3: '승인관리', col4: 'UI_BM_1201', col5: '', col6: 'grid', col7: 'X' },
  { col1: '회원', col2: '승인관리', col3: '회원 가입(점유인증)', col4: 'UI_BM_1202', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '승인관리', col3: '가맹점주 회원 가입', col4: 'UI_BM_1203', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '승인관리', col3: '회원변경 (HP)', col4: 'UI_BM_1204', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '승인관리', col3: '단골매장 변경처리', col4: 'UI_BM_1205', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '승인관리', col3: '매장 양수/양도처리', col4: 'UI_BM_1206', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '승인관리', col3: '매장검색', col4: 'UI_BM_1207', col5: '', col6: 'popup-search', col7: 'X' },
  { col1: '회원', col2: '승인관리', col3: '회원통합처리', col4: 'UI_BM_1208', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '승인관리', col3: '회원검색', col4: 'UI_BM_1209', col5: '', col6: 'popup-search', col7: 'X' },

  { col1: '회원', col2: '부정회원관리', col3: '부정적립 의심회원 기준관리', col4: 'UI_BM_1301', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '부정회원관리', col3: '리셀러 기준관리', col4: 'UI_BM_1302', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '부정회원관리', col3: '부정적립 회원관리', col4: 'UI_BM_1303', col5: '/pubs/MS/UM/UI_BM_1303_pubs', col6: 'grid-grid', col7: 'O' },
  { col1: '회원', col2: '부정회원관리', col3: '부정적립 회원 처리 내역', col4: 'UI_BM_1304', col5: '', col6: 'popup-form', col7: 'X' },
  { col1: '회원', col2: '부정회원관리', col3: '부정적립 회원 검토 요청', col4: 'UI_BM_1305', col5: '', col6: 'popup-form', col7: 'X' },
  { col1: '회원', col2: '부정회원관리', col3: '부정적립 회원관리 이력', col4: 'UI_BM_1306', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '회원', col2: '부정회원관리', col3: '부정관리-구매 이력 팝업', col4: 'UI_BM_2308', col5: '', col6: 'popup-grid', col7: 'X' },

  { col1: '회원', col2: '클랜징관리', col3: '회원정보 상태 클랜징 관리', col4: 'UI_BM_1401', col5: '', col6: 'grid', col7: 'X' },
  { col1: '회원', col2: '클랜징관리', col3: '회원정보 상태 이력 조회', col4: 'UI_BM_1402', col5: '', col6: 'grid', col7: 'X' },

  { col1: '회원', col2: '클럽관리', col3: '회원정보 상태 이력 조회', col4: 'UI_BM_1501', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '클럽관리', col3: '클럽 대상 관리', col4: 'UI_BM_1502', col5: '', col6: 'grid-grid-vertical', col7: 'X' },
  { col1: '회원', col2: '클럽관리', col3: '클럽 대상 추가', col4: 'UI_BM_1503', col5: '', col6: 'popup-search', col7: 'X' },
  { col1: '회원', col2: '클럽관리', col3: '타겟팅 검색', col4: 'UI_BM_1504', col5: '', col6: 'popup-search', col7: 'X' },
  { col1: '회원', col2: '클럽관리', col3: '타겟팅 대상자 등록', col4: 'UI_BM_1505', col5: '', col6: 'popup-search', col7: 'X' },
  { col1: '회원', col2: '클럽관리', col3: '타겟팅 대상 추출 내역', col4: 'UI_BM_1506', col5: '', col6: 'grid-grid', col7: 'X' },

  { col1: '회원', col2: '약관관리', col3: '채널별 약관정보 관리', col4: 'UI_BM_2101', col5: '/pubs/BI/TM/UI_BM_2101_pubs', col6: 'board', col7: 'O' },
  { col1: '회원', col2: '약관관리', col3: '약관 동의 이력조회', col4: 'UI_BM_2102', col5: '', col6: 'grid-grid', col7: 'X' },
  { col1: '회원', col2: '약관관리', col3: '마케팅이용동의조회', col4: 'UI_BM_2103', col5: '', col6: 'grid', col7: 'X' },
  { col1: '회원', col2: '약관관리', col3: '마케팅이용동의 이력 조회', col4: 'UI_BM_2104', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '회원', col2: '약관관리', col3: '개인정보처리방침 관리', col4: 'UI_BM_2105', col5: '', col6: 'board', col7: 'X' },

  { col1: '회원', col2: '회원상태관리', col3: '회원 상태 관리', col4: 'UI_BM_2201', col5: '', col6: 'grid-grid', col7: 'X' },
  { col1: '회원', col2: '회원상태관리', col3: '회원정보 상태 상세 내역 조회', col4: 'UI_BM_2202', col5: '', col6: 'grid', col7: 'X' },

  { col1: '회원', col2: '등급관리', col3: '회원 등급 마스터 관리', col4: 'UI_BM_2301', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '등급관리', col3: '회원등급 기준관리', col4: 'UI_BM_2302', col5: '', col6: 'grid-form-grid-vertical', col7: 'X' },
  { col1: '회원', col2: '등급관리', col3: '회원등급 기준 이력', col4: 'UI_BM_2303', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '회원', col2: '등급관리', col3: '우수회원관리', col4: 'UI_BM_2304', col5: '', col6: 'grid', col7: 'X' },
  { col1: '회원', col2: '등급관리', col3: '우수회원 엑셀업로드', col4: 'UI_BM_2305', col5: '', col6: 'popup-form', col7: 'X' },
  { col1: '회원', col2: '등급관리', col3: '회원검색', col4: 'UI_BM_1209', col5: '', col6: 'popup-search', col7: 'X' },
  { col1: '회원', col2: '등급관리', col3: '회원 등급 관리', col4: 'UI_BM_2306', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '등급관리', col3: '회원 등급 이력', col4: 'UI_BM_2307', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '회원', col2: '등급관리', col3: '회원 구매 이력', col4: 'UI_BM_2308', col5: '', col6: 'popup-grid', col7: 'X' },

  { col1: '회원', col2: '카드관리', col3: 'Card BIN 마스터 관리', col4: 'UI_BM_2401', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '카드관리', col3: '회원카드 발급 관리', col4: 'UI_BM_2402', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '카드관리', col3: '회원카드 발급', col4: 'UI_BM_2403', col5: '', col6: 'popup-form', col7: 'X' },
  { col1: '회원', col2: '카드관리', col3: '회원카드 이력', col4: 'UI_BM_2404', col5: '', col6: 'popup-grid', col7: 'X' },

  { col1: '회원', col2: '마케팅관리', col3: '타겟팅 그룹 관리', col4: 'UI_BM_3101', col5: '', col6: 'grid-form-vertical', col7: 'X' },
  { col1: '회원', col2: '마케팅관리', col3: '타겟팅 조건', col4: 'UI_BM_3102', col5: '', col6: 'popup-shuffle', col7: 'X' },
  { col1: '회원', col2: '마케팅관리', col3: '타겟팅 대상자 등록', col4: 'UI_BM_3103', col5: '', col6: 'popup-search', col7: 'X' },
  { col1: '회원', col2: '마케팅관리', col3: '타겟팅 대상자 등록', col4: 'UI_BM_1209', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '회원', col2: '마케팅관리', col3: '타겟팅 대상 추출 내역', col4: 'UI_BM_3104', col5: '', col6: 'grid-grid', col7: 'X' },

  { col1: '회원', col2: '전시/배너관리', col3: '전시관리', col4: 'UI_BM_3201', col5: '', col6: 'grid-form-grid-vertical', col7: 'X' },
  { col1: '회원', col2: '전시/배너관리', col3: '전시상세 등록', col4: 'UI_BM_3202', col5: '', col6: 'popup-form', col7: 'X' },
  { col1: '회원', col2: '전시/배너관리', col3: '배너관리', col4: 'UI_BM_3203', col5: '/pubs/SY/DP/UI_BM_3203_pubs', col6: 'grid-form-grid-vertical', col7: 'O' },
  { col1: '회원', col2: '전시/배너관리', col3: '배너상세 등록', col4: 'UI_BM_3204', col5: '', col6: 'popup-form', col7: 'X' },
  { col1: '회원', col2: '전시/배너관리', col3: '팝업관리', col4: 'UI_BM_3205', col5: '', col6: 'board', col7: 'X' },

  { col1: '회원', col2: '영업일관리', col3: '특수기일자', col4: 'UI_BM_3301', col5: '', col6: 'grid', col7: 'X' },
  { col1: '회원', col2: '영업일관리', col3: '특수기일자 - 특수기 추가', col4: 'UI_BM_3302', col5: '', col6: 'popup-form', col7: 'X' },

  { col1: '회원', col2: '발송관리', col3: '방송 채널(시스템)관리', col4: 'UI_BM_3401', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '방송 채널(시스템)관리 - 이력보기', col4: 'UI_BM_3402', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '방송 템플릿 관리', col4: 'UI_BM_3403', col5: '', col6: 'grid-form-grid-vertical', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '방송 템플릿 관리 - 미리보기', col4: 'UI_BM_3404', col5: '', col6: '퍼블리싱에서 처리', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '방송 템플릿 관리 - 파라미터(대체문자) 선택', col4: 'UI_BM_3405', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '회원 피로도 기준 관리', col4: 'UI_BM_3406', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '피로도 기준 이력', col4: 'UI_BM_3407', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '발송관리-문자발송 내역', col4: 'UI_BM_3408', col5: '', col6: 'grid-form-grid-vertical', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '발송관리-발송 일정', col4: 'UI_BM_3408', col5: '', col6: 'grid-tab-vertical', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '발송관리-발송 대상자', col4: 'UI_BM_3408', col5: '', col6: 'grid-tab-vertical', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '회원검색', col4: 'UI_BM_1209', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '발송 대상자 추출 - 회원등급', col4: 'UI_BM_3409', col5: '', col6: 'popup-shuffle', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '발송 대상자 추출 - 회원유형', col4: 'UI_BM_3409', col5: '', col6: 'popup-shuffle', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '발송 대상자 추출 - 회원상태', col4: 'UI_BM_3409', col5: '', col6: 'popup-shuffle', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '발송 대상자 추출 - 기념일', col4: 'UI_BM_3409', col5: '', col6: 'popup-shuffle', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '메시지 발송 모니터링', col4: 'UI_BM_3410', col5: '', col6: 'grid', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '메시지 발송 결과 모니터링', col4: 'UI_BM_3411', col5: '', col6: 'grid', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '메시지 발송 결과 상세보기', col4: 'UI_BM_3412', col5: '', col6: 'popup-form', col7: 'X' },
  { col1: '회원', col2: '발송관리', col3: '메시지 발송 정산', col4: 'UI_BM_3413', col5: '', col6: 'grid', col7: 'X' },

  { col1: '회원', col2: '게시판(프론트)', col3: '공지사항', col4: 'UI_BM_4101', col5: '', col6: 'board-vertical', col7: 'X' },
  { col1: '회원', col2: '게시판(프론트)', col3: 'FAQ', col4: 'UI_BM_4102', col5: '', col6: 'grid-form', col7: 'X' },

  { col1: '회원', col2: '게시판(백오피스)', col3: '공지사항', col4: 'UI_BM_4201', col5: '', col6: 'board-vertical', col7: 'X' },
  { col1: '회원', col2: '게시판(백오피스)', col3: '게시판', col4: 'UI_BM_4202', col5: '', col6: 'board', col7: 'X' },
  { col1: '회원', col2: '게시판(백오피스)', col3: 'FAQ', col4: 'UI_BM_4203', col5: '', col6: 'grid-form', col7: 'X' },

  { col1: '회원', col2: '업무관리', col3: '업무담당자관리', col4: 'UI_BM_5101', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '업무관리', col3: '업무담당자', col4: 'UI_BM_5102', col5: '', col6: 'board-vertical', col7: 'X' },

  { col1: '회원', col2: 'APP관리', col3: '앱버전관리', col4: 'UI_BM_5201', col5: '', col6: 'grid-form', col7: 'X' },

  { col1: '회원', col2: '배치관리', col3: '배치관리', col4: 'UI_BM_5301', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '배치관리', col3: '인터페이스 이력조회', col4: 'UI_BM_5302', col5: '', col6: 'grid', col7: 'X' },

  { col1: '회원', col2: '인터페이스 관리', col3: '인터페이스 관리', col4: 'UI_BM_5401', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '회원', col2: '인터페이스 관리', col3: '인터페이스 이력조회', col4: 'UI_BM_5402', col5: '', col6: 'grid', col7: 'X' },

  {
    col1: '포인트',
    col2: '포인트기준관리',
    col3: '포인트유형관리',
    col4: 'UI_BP_0001',
    col5: '/pubs/PO/PB/UI_BP_0001_pubs',
    col6: 'grid-form',
    col7: 'O',
  },
  { col1: '포인트', col2: '포인트기준관리', col3: '포인트적립기준관리(NEW)', col4: 'UI_BP_0002', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '포인트기준관리', col3: '적립기준이력-popup', col4: 'UI_BP_0002-popup', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '포인트', col2: '포인트기준관리', col3: '포인트사용기준관리(NEW)', col4: 'UI_BP_0003', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '포인트기준관리', col3: '사용기준이력-popup', col4: 'UI_BP_0003-popup', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '포인트', col2: '포인트기준관리', col3: '포인트사용제한관리', col4: 'UI_BP_0004', col5: '/pubs/PO/PB/UI_BP_0004_pubs', col6: 'grid-form', col7: 'O' },
  { col1: '포인트', col2: '포인트기준관리', col3: '사용제한이력', col4: 'UI_BP_0004-popup', col5: '/pubs/PO/PB/UI_BP_0004_popup_pubs', col6: 'popup-grid', col7: 'O' },
  { col1: '포인트', col2: '포인트기준관리', col3: '가맹점분담률관리', col4: 'UI_BP_0005', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '포인트기준관리', col3: '가맹점분담률이력', col4: 'UI_BP_0005-popup', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '포인트', col2: '포인트기준관리', col3: '소멸기준관리', col4: 'UI_BP_0006', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '포인트기준관리', col3: '소멸기준이력-popup', col4: 'UI_BP_0006-popup', col5: '', col6: 'popup-grid', col7: 'X' },
  { col1: '포인트', col2: '정산 마감 관리', col3: '매장별 일집계조회(마감)', col4: 'UI_BP_0008', col5: '', col6: 'grid-grid', col7: 'X' },
  { col1: '포인트', col2: '정산 마감 관리', col3: '매장별 월집계조회(마감)', col4: 'UI_BP_0009', col5: '', col6: 'grid-grid', col7: 'X' },
  { col1: '포인트', col2: '정산 마감 관리', col3: '브랜드별일집계조회', col4: 'UI_BP_0011', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '정산 마감 관리', col3: '브랜드별월집계조회', col4: 'UI_BP_0012', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '정산 마감 관리', col3: '마이너스포인트조회', col4: 'UI_BP_0013', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '포인트 조회 관리', col3: '포인트선물내역조회', col4: 'UI_BP_0014', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '포인트 조회 관리', col3: '포인트거래내역조회', col4: 'UI_BP_0015', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '포인트 조회 관리', col3: '포인트소멸처리이력조회', col4: 'UI_BP_0016', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '포인트 조회 관리', col3: '소멸예정내역조회', col4: 'UI_BP_0017', col5: '/pubs/PO/PI/UI_BP_0017_pubs', col6: 'grid-form', col7: 'O' },
  { col1: '포인트', col2: '회원정보조회', col3: '회원거래내역조회(포인트탭)', col4: 'UI_BP_0018', col5: '', col6: 'form-grid', col7: 'X' },
  { col1: '포인트', col2: '회원지원', col3: '추가포인트지급', col4: 'UI_BP_0019', col5: '/pubs/PO/MB/UI_BP_0019_pubs', col6: 'form-grid-form', col7: 'O' },

  { col1: '포인트', col2: '회원지원', col3: '포인트선물하기', col4: 'UI_BP_0020', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '회원지원', col3: '영수증포인트적립요청', col4: 'UI_BP_0021', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '회원지원', col3: '영수증포인트적립확정', col4: 'UI_BP_0022', col5: '/pubs/PO/MB/UI_BP_0022_pubs', col6: 'grid-form', col7: 'O' },
  { col1: '포인트', col2: '회원지원', col3: '추가포인트일괄지급(점주포함) - 지급결과 상세(팝업)', col4: 'UI_BP_0023', col5: '', col6: 'popup-search', col7: 'X' },
  { col1: '포인트', col2: '회원지원', col3: '포인트적립취소', col4: 'UI_BP_0024', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '회원지원', col3: '포인트이관처리', col4: 'UI_BP_0025', col5: '', col6: 'grid-form', col7: 'X' },

  { col1: '포인트', col2: '고객지원', col3: '기부현황 ( AS-IS : POS 시스템 > 고객관리 > 포인트관리 > 홍이야부탁해기부현황 ) ', col4: 'UI_BP_0026', col5: '', col6: 'grid-grid', col7: 'X' },
  { col1: '포인트', col2: '프로모션관리', col3: '판매프로모션마스터', col4: 'UI_BP_0027', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '프로모션관리', col3: '판매프로모션포인트', col4: 'UI_BP_0028', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '프로모션관리', col3: '판매프로모션유통채널', col4: 'UI_BP_0029', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '프로모션관리', col3: '선포인트지급관리', col4: 'UI_BP_0030', col5: '', col6: 'grid-form', col7: 'X' },

  { col1: '포인트', col2: '마스터관리', col3: '제휴마스터', col4: 'UI_BP_0031', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '마스터관리', col3: '채널마스터', col4: 'UI_BP_0032', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '마스터관리', col3: '브랜드마스터', col4: 'UI_BP_0033', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '마스터관리', col3: '가맹점마스터', col4: 'UI_BP_0034', col5: '', col6: 'grid-form', col7: 'X' },
  { col1: '포인트', col2: '마스터관리', col3: '판매프로모션(팝업)', col4: 'UI_BP_0035', col5: '', col6: 'popup-search', col7: 'X' },
  { col1: '포인트', col2: '마스터관리', col3: '제휴사마스터(팝업) ', col4: 'UI_BP_0036', col5: '', col6: 'popup-search', col7: 'X' },
  { col1: '포인트', col2: '마스터관리', col3: '회원마스터조회(팝업)', col4: 'UI_BP_0039', col5: '/pubs/PO/MT/UI_BP_0039_pubs', col6: 'popup-grid', col7: 'O' },
  { col1: '포인트', col2: '마스터관리', col3: '조직조회(팝업) ', col4: 'UI_BP_0040', col5: '', col6: 'popup-search', col7: 'X' },
])
</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
  background-color: #f2f5f6;
}
</style>
