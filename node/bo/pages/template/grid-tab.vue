<template>
  <div class="card is-sub is-search">
    <div class="card-header">
      <h1 class="page-title">
        <span>회원정보 조회</span>
      </h1>
      <div class="table-title-wrap">
        <h2 class="table-title">
          <span>description</span>
        </h2>
      </div>
    </div>
    <div class="card-body">
      <form action="" class="form">
        <table class="table is-search is-fullwidth">
          <colgroup>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 170px;">
          </colgroup>
          <tbody>
            <tr>
              <th><span class="is-required">회원번호/명</span></th>
              <td>
                <UTextBox></UTextBox>
              </td>
              <th></th>
              <td></td>
              <th></th>
              <td></td>
              <td>
                <div class="buttons is-search">
                  <UButton text="조회" type="is-search"/>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <div class="card is-sub">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span>상세내역</span>
          </h2>
          <div class="buttons">
            <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 150px !important;"/>
            <UButton text="처리" type="is-outline"/>
            <UButton text="취소" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </div>
        </div>

        <div class="field-grid">
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
      </div>
    </div>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <div class="card is-sub" style="height: 300px;">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span>회원 이력 정보</span>
          </h2>
        </div>

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
      </div>
    </div>
  </div>
</template>

<script setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab';
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
})  

const tabPanel = useWijmoTabPanel()

definePageMeta({
auth: {
  required: false,
},
})

const itemsSourceGrid = ref([
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
]);

</script>

<style lang="scss" scoped>

</style>