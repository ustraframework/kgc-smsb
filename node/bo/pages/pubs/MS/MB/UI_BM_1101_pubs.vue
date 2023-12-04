<template>
  <div class="columns has-gap">
    <UBox class="card is-sub is-search">
      <UItem class="card-body">
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="회원번호/명"><UTextBox></UTextBox></UField>
            <UField blank></UField>
            <UField blank></UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search" />
              </div>
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>
  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>상세내역</span>
          </h2>
          <UButtonBox class="table-buttons">
            <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 150px !important" />
            <UButton text="처리" type="is-outline" />
            <UButton text="취소" type="is-outline" />
            <UButton text="저장" type="is-filled" />
          </UButtonBox>
        </UBox>
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="회원유형"><UWjComboBox :itemsSource="members" displayMemberPath="text" /></UField>
            <UField label="회원번호"><UTextBox></UTextBox></UField>
            <UField label="회원명"><UTextBox></UTextBox></UField>
            <UField label="CI"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="DI"><UTextBox></UTextBox></UField>
            <UField label="카드번호"><UTextBox></UTextBox></UField>
            <UField label="ID"><UTextBox></UTextBox></UField>
            <UField label="PWD"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="생년월일"><UDateBox mode="date" /></UField>
            <UField label="실생일"><UDateBox mode="date" /></UField>
            <UField label="양/음력"><URadioGroupBox v-model="solarValue" :itemsSource="solarItems" /></UField>
            <UField label="연령"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="단골매장"><UTextBox type="icon" /></UField>
            <UField label="주소"><UTextBox type="icon" /></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="가입일자"><UDateBox mode="date" /></UField>
            <UField label="가입경로"><UWjComboBox :itemsSource="items" displayMemberPath="text" /></UField>
            <UField label="회원상태"><UWjComboBox :itemsSource="items" displayMemberPath="text" /></UField>
            <UField label="회원등급"><UWjComboBox :itemsSource="items" displayMemberPath="text" /></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="회원통합여부"><URadioGroupBox v-model="radioValue" :itemsSource="radioItems" /></UField>
            <UField label="클랜징 상태"><UWjComboBox :itemsSource="items" displayMemberPath="text" /></UField>
            <UField label="클랜징 일자"><UTextBox /></UField>
            <UField></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[2, 1, 1]">
            <UField label="가맹점"><UTextBox type="icon" /></UField>
            <UField></UField>
            <UField></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="법인여부"><URadioGroupBox v-model="radioValue" :itemsSource="radioItems" /></UField>
            <UField label="사업자등록번호"><UTextBox /></UField>
            <UField label="법인명"><UTextBox /></UField>
            <UField></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[2, 1, 1]">
            <UField label="마케팅 동의">
              <UCheckGroupBox
                :items-source="[
                  { trueValue: 'Y', falseValue: 'N', text: 'SMS' },
                  { trueValue: 'Y', falseValue: 'N', text: 'DM' },
                  { trueValue: 'Y', falseValue: 'N', text: 'EMAIL' },
                  { trueValue: 'Y', falseValue: 'N', text: 'TM' },
                ]"
                :border="false"
                :stack="true"
              >
              </UCheckGroupBox>
            </UField>
            <UField label="Push 여부">
              <UCheckGroupBox :items-source="[{ trueValue: 'Y', falseValue: 'N', text: '' }]" item-align="left"> </UCheckGroupBox>
            </UField>
            <UField></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[3, 1]">
            <UField label="기념일">
              <div class="field-grid">
                <WjFlexGrid :itemsSource="itemsSourceGrid" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
                  <WjFlexGridColumn header="기념일 구분" binding="col1" width="*">
                    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                      <UCodeComboBox v-model="cell.value" />
                    </WjFlexGridCellTemplate>
                  </WjFlexGridColumn>

                  <WjFlexGridColumn binding="col1" header="기념일" width="*" format="yyyy-MM-dd">
                    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                      <WjInputDate v-model="cell.item.date" />
                    </WjFlexGridCellTemplate>
                  </WjFlexGridColumn>

                  <WjFlexGridColumn header="양/음력" binding="col1" width="*">
                    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                      <UCodeComboBox v-model="cell.value" />
                    </WjFlexGridCellTemplate>
                  </WjFlexGridColumn>

                  <WjFlexGridColumn header="성별" binding="col1" width="*">
                    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                      <UCodeComboBox v-model="cell.value" />
                    </WjFlexGridCellTemplate>
                  </WjFlexGridColumn>
                </WjFlexGrid>
              </div>
            </UField>
            <UField blanck></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="최초 로그인일시"><UTextBox /></UField>
            <UField label="최종 로그인일시"><UTextBox /></UField>
            <UField label="최초 거래일시"><UTextBox /></UField>
            <UField label="최종 거래일시"><UTextBox /></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="총 포인트"><UTextBox /></UField>
            <UField label="사용 포인트"><UTextBox /></UField>
            <UField label="잔여 포인트"><UTextBox /></UField>
            <UField label="소멸 예정 포인트"><UTextBox /></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
        </UFieldSet>
      </UItem>
    </UBox>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub" style="height: 300px">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <UItem itemDirection="row" :ratio="1">
            <h2 class="table-title">
              <span>회원 이력 정보</span>
            </h2>
          </UItem>
        </UBox>

        <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
          <WjTab>
            <a>포인트</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="포인트 지급일" binding="col1" width="*" />
                <WjFlexGridColumn header="포인트 유형" binding="col1" width="*" />
                <WjFlexGridColumn header="포인트" binding="col1" width="*" />
                <WjFlexGridColumn header="내용" binding="col1" width="*" />
                <WjFlexGridColumn header="소멸 예정일" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>회원변경</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="채널" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="컬럼라벨" binding="col1" width="*" />
                <WjFlexGridColumn header="변경전데이터" binding="col1" width="*" />
                <WjFlexGridColumn header="변경후데이터" binding="col1" width="*" />
                <WjFlexGridColumn header="변경사유" binding="col1" width="*" />
                <WjFlexGridColumn header="컬럼명" binding="col1" width="*" />
                <WjFlexGridColumn header="수정자" binding="col1" width="*" />
                <WjFlexGridColumn header="수정일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>구매</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="주문번호" binding="col1" width="*" />
                <WjFlexGridColumn header="판매처" binding="col1" width="*" />
                <WjFlexGridColumn header="결제금액" binding="col1" width="*" />
                <WjFlexGridColumn header="처리상태" binding="col1" width="*" />
                <WjFlexGridColumn header="상품명" binding="col1" width="*" />
                <WjFlexGridColumn header="수량" binding="col1" width="*" />
                <WjFlexGridColumn header="구매일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>카드발급</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="카드번호" binding="col1" width="*" />
                <WjFlexGridColumn header="카드상태" binding="col1" width="*" />
                <WjFlexGridColumn header="발급채널" binding="col1" width="*" />
                <WjFlexGridColumn header="발급유형" binding="col1" width="*" />
                <WjFlexGridColumn header="카드매체" binding="col1" width="*" />
                <WjFlexGridColumn header="카드유효일자" binding="col1" width="*" />
                <WjFlexGridColumn header="발급일" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="혜지일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>약관동의</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="회원아이디" binding="col1" width="*" />
                <WjFlexGridColumn header="약관유형" binding="col1" width="*" />
                <WjFlexGridColumn header="약관명" binding="col1" width="*" />
                <WjFlexGridColumn header="약관ID" binding="col1" width="*" />
                <WjFlexGridColumn header="동의일자" binding="col1" width="*" />
                <WjFlexGridColumn header="동의여부" binding="col1" width="*" />
                <WjFlexGridColumn header="철회일자" binding="col1" width="*" />
                <WjFlexGridColumn header="철회사유" binding="col1" width="*" />
                <WjFlexGridColumn header="변경일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>마케팅동의</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="마케팅유형" binding="col1" width="*" />
                <WjFlexGridColumn header="동의여부" binding="col1" width="*" />
                <WjFlexGridColumn header="동의일자" binding="col1" width="*" />
                <WjFlexGridColumn header="변경일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>Push동의</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="동의여부" binding="col1" width="*" />
                <WjFlexGridColumn header="동의일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>발송</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="발송일자" binding="col1" width="*" />
                <WjFlexGridColumn header="채널" binding="col1" width="*" />
                <WjFlexGridColumn header="발송자" binding="col1" width="*" />
                <WjFlexGridColumn header="제목" binding="col1" width="*" />
                <WjFlexGridColumn header="메세지" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="성공여부" binding="col1" width="*" />
                <WjFlexGridColumn header="발송유형" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>회원등급</a>
            <WjFlexGrid :itemsSource="itemsSourceGrid">
              <WjFlexGridColumn header="No" binding="col1" width="*" />
              <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
              <WjFlexGridColumn header="채널" binding="col1" width="*" />
              <WjFlexGridColumn header="회원명" binding="col1" width="*" />
              <WjFlexGridColumn header="회원등급" binding="col1" width="*" />
              <WjFlexGridColumn header="승급일시" binding="col1" width="*" />
              <WjFlexGridColumn header="승급사유" binding="col1" width="*" />
              <WjFlexGridColumn header="적용시작일시" binding="col1" width="*" />
              <WjFlexGridColumn header="적용종료일시" binding="col1" width="*" />
              <WjFlexGridColumn header="수정자" binding="col1" width="*" />
              <WjFlexGridColumn header="수정일시" binding="col1" width="*" />
            </WjFlexGrid>
          </WjTab>

          <WjTab>
            <a>회원상태</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="회원상태" binding="col1" width="*" />
                <WjFlexGridColumn header="상태기준" binding="col1" width="*" />
                <WjFlexGridColumn header="상태변경일" binding="col1" width="*" />
                <WjFlexGridColumn header="수정자" binding="col1" width="*" />
                <WjFlexGridColumn header="수정일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>인증</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="채널" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="접속단말" binding="col1" width="*" />
                <WjFlexGridColumn header="인증채널" binding="col1" width="*" />
                <WjFlexGridColumn header="인증상태" binding="col1" width="*" />
                <WjFlexGridColumn header="인증 값" binding="col1" width="*" />
                <WjFlexGridColumn header="인증일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>인증</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="채널" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="접속단말" binding="col1" width="*" />
                <WjFlexGridColumn header="인증채널" binding="col1" width="*" />
                <WjFlexGridColumn header="인증상태" binding="col1" width="*" />
                <WjFlexGridColumn header="인증 값" binding="col1" width="*" />
                <WjFlexGridColumn header="인증일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>접촉</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="채널" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉일시" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉자" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉자명" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉방법" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉결과" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉내용" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>통합 전 회원정보</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="카드번호" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="ID" binding="col1" width="*" />
                <WjFlexGridColumn header="생년월일" binding="col1" width="*" />
                <WjFlexGridColumn header="HP" binding="col1" width="*" />
                <WjFlexGridColumn header="주소" binding="col1" width="*" />
                <WjFlexGridColumn header="관심매장" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>간편 로그인 정보</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="인증채널" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="접속단말" binding="col1" width="*" />
                <WjFlexGridColumn header="인증채널" binding="col1" width="*" />
                <WjFlexGridColumn header="인증상태" binding="col1" width="*" />
                <WjFlexGridColumn header="인증 값" binding="col1" width="*" />
                <WjFlexGridColumn header="인증일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>080 수신거부</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="채널" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉일시" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉자" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉자명" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉방법" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉결과" binding="col1" width="*" />
                <WjFlexGridColumn header="접촉내용" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>
        </WjTabPanel>
      </UItem>
    </UBox>
  </div>
</template>

<script setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components'

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})

const tabPanel = useWijmoTabPanel()

definePageMeta({
  auth: {
    required: false,
  },
  layout: 'ustra-pub',
})

const pwd = [{ value: 'reset', text: '비밀번호 초기화' }]

const members = [{ value: '1', text: '일반회원' }]

const solarItems = reactive([
  { value: '1', text: '양력' },
  { value: '2', text: '음력' },
])
const solarValue = ref('1')

const radioItems = reactive([
  { value: 'y', text: '예' },
  { value: 'n', text: '아니오' },
])
const radioValue = ref('y')

const items = [
  { value: '1', text: 'item1' },
  { value: '2', text: 'item2' },
]

const itemsSourceGrid = ref([{ col1: '텍스트' }, { col1: '텍스트2' }, { col1: '텍스트3' }])
</script>

<style lang="scss" scoped></style>
