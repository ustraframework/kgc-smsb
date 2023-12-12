<template>
  <!-- 검색영역 - 본문제목 있는 경우 -->
  <UBox class="columns" direction="row">
    <UItem class="card is-sub is-search" ratio="1" >
      <UBox class="card-header">
        <h1 class="page-title">
          <span>본문 제목</span>
        </h1>
      </UBox>
      
      <UFieldSet class="is-search">
        <UFieldRow :ratio="[1, 1, 1, '170px']">
          <UField label="검색영역" ><UTextBox></UTextBox></UField>
          <UField blank></UField>
          <UField blank></UField>
          <UField blank>
            <div class="search-btn">
              <UButton text="조회" type="is-search"/>
            </div>
          </UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>
  </UBox>
  <!-- // 검색영역 - 본문제목 있는 경우 --> 

  <!-- 검색영역 - 본문제목 없는 경우 -->
  <UBox class="columns" direction="row">
    <UItem class="card is-sub is-search" ratio="1" >
      <UFieldSet class="is-search">
        <UFieldRow :ratio="[1, 1, 1, '170px']">
          <UField label="검색영역" ><UTextBox></UTextBox></UField>
          <UField blank></UField>
          <UField blank></UField>
          <UField blank>
            <div class="search-btn">
              <UButton text="조회" type="is-search"/>
            </div>
          </UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>
  </UBox>
  <!-- // 검색영역 - 본문제목 없는 경우 --> 

  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="1" >
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>col12</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
        
        <UButtonBox class="table-buttons">
          <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 200px !important" />
          <UButton text="엑셀 다운로드" icon="excel" />
          <UButton text="취소" type="is-outline" />
          <UButton text="저장" type="is-filled" />
        </UButtonBox>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
  </UBox>
  
  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="1">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>col5</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
    <UItem class="card is-sub" ratio="1">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>col5</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
        
        <UButtonBox class="table-buttons">
          <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 200px !important" />
          <UButton text="엑셀 다운로드" icon="excel" />
          <UButton text="취소" type="is-outline" />
          <UButton text="저장" type="is-filled" />
        </UButtonBox>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
  </UBox>

  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="3">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>col3</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
    <UItem class="card is-sub" ratio="9">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>col9</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
        
        <UButtonBox class="table-buttons">
          <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 200px !important" />
          <UButton text="엑셀 다운로드" icon="excel" />
          <UButton text="취소" type="is-outline" />
          <UButton text="저장" type="is-filled" />
        </UButtonBox>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
  </UBox>

  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="4">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>col4</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
    <UItem class="card is-sub" ratio="8">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>col8</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
        
        <UButtonBox class="table-buttons">
          <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 200px !important" />
          <UButton text="엑셀 다운로드" icon="excel" />
          <UButton text="취소" type="is-outline" />
          <UButton text="저장" type="is-filled" />
        </UButtonBox>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
  </UBox>

  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="1">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>col3</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
    <UItem class="card is-sub" ratio="1">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>col3</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
    <UItem class="card is-sub" ratio="1">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>col3</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
  </UBox>

  <UBox class="columns" direction="row" height="500px">
    <UItem class="card is-sub" baseSize="500px">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>width size</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
      </UBox>
      
      <UBox>
        Contents
      </UBox>
    </UItem>
    <UItem class="card is-sub" ratio="1">
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>width size auto</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
      </UBox>

      <UBox>
        Contents
      </UBox>
    </UItem>
  </UBox>

</template>

<script setup>
definePageMeta({
  auth: {
    required: false,
  },
  layout: 'ustra-pub'
})
</script>

<style lang="scss" scoped>

</style>