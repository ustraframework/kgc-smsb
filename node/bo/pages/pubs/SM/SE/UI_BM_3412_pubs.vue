<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">메시지 발송 결과</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="620" title="메시지 발송 결과">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField label="채널">통합멤버스</UField>
            <UField label="발송유형">알림톡</UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField label="회원번호">1234567890</UField>
            <UField label="회원명">홍*동</UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField label="수신번호">010-1234-5678</UField>
            <UField label="피로도">N</UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField label="발송부서">CRM</UField>
            <UField label="발송자">김승용</UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField label="발송일시">2023-11-03 20:00:00</UField>
            <UField label="발송상태">실패</UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1]">
            <UField label="결과값">통신사 장애</UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="발송내용">
              홍길동 회원님, <br>
              안녕하세요!회원님께서 보유하신 멤버스포인트가 소멸될 예정입니다. <br>
              ■ 현재 잔여포인트 : 10,000 <br>
              ■당월 소멸 예정포인트 : 300 <br>
              ■ 소멸날짜 : 당월 말일※ 단, 선포인트로 추가된 포인트는 소멸 날짜가 다를 수 있습니다. 회원님의 포인트는 정관장 매장에서 결제수단으로  사용하실 수 있습니다.정관장과 함께 항상 건강하고 행복한 날 되시기 바랍니다. 감사합니다. <br>
              ■ 고객센터 : 080-041-0303
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="is-outline"/>
          <UButton text="재전송" type="primary"/>
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components';

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const showPopup = ref(false)

const itemsSourceGrid = ref([
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
]);
</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>