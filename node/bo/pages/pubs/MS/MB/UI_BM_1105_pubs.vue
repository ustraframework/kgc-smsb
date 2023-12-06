<template>
<div>
  <div class="columns has-gap">
    <UBox class="card is-sub is-search">
      <UItem class="card-body">
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="탈퇴일자" required>
              <UDatePeriodBox v-model:start="start" v-model:end="end" />
            </UField>
            <UField label="회원번호/명">
              <UBox>
                <UTextBox type="icon"/>
                <UTextBox disabled/>
              </UBox>
            </UField>
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
            <span class="data-count">총<span>50</span>건</span>
          </h2>
          <UButtonBox class="table-buttons">
            <UButton text="탈퇴복원처리" type="is-filled" />
          </UButtonBox>
        </UBox>

        <UBox height="345">
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
            <WjFlexGridColumn header="회원명" binding="col1" width="*" />
            <WjFlexGridColumn header="회원구분" binding="col1" width="*" />
            <WjFlexGridColumn header="잔여포인트" binding="col1" width="*" />
            <WjFlexGridColumn header="탈퇴일자" binding="col1" width="*" />
            <WjFlexGridColumn header="삭제예정일자" binding="col1" width="*" />
            <WjFlexGridColumn header="탈퇴사유" binding="col1" width="*" />
          </WjFlexGrid>
        </UBox>
      </UItem>
    </UBox>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>회원 상세 정보</span>
          </h2>
        </UBox>

        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="회원번호"><UTextBox disabled /></UField>
            <UField label="회원명"><UTextBox disabled /></UField>
            <UField label="회원유형">
              <UWjComboBox :itemsSource="members" displayMemberPath="text" :disabled="true"/>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="잔여포인트">
              <UTextBox disabled />
            </UField>
            <UField label="탈퇴일자">
              <UTextBox disabled />
            </UField>
            <UField label="삭제예정일자">
              <UTextBox disabled />
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="탈퇴사유">
              <UTextBox disabled />
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="복원사유" required>
              <UTextBox type="textarea" v-model="test" />
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>
</div>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components'

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})

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
