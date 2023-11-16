<template>
  <div class="docs__wrap">
    <!-- 1 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">대타이틀</h1>            
        <h1 class="page-title">화면명_대타이틀</h1>
      </div>
      <div class="column is-half">
        <h1 class="mb-4">중타이틀</h1>
        <p class="card-title">유형정보_중타이틀</p>
      </div>
    </div>

    <!-- 2 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">테이블 타이틀</h1>
        <p class="table-title">유형정보_중타이틀 / 테이블 타이틀</p>
      </div>
      <div class="column is-half">
        <h1 class="mb-4">Default</h1>            
        <p>일반적인 본문 텍스트에 사용합니다.</p>
      </div>
    </div>

    <!-- 3 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-6">Description</h1>
          <p class="description">강제성이 없는 단순 정보를 제공할 때 사용합니다.</p>
          <p class="description is-warning">반드시 지켜야하는 사항을 표기할 때 사용합니다.</p>
          <p class="description is-confirm">전송되었습니다.</p>        
      </div>
      <div class="column is-half">
        <h3 class="mb-4">multiple</h3>      
        <div class="caution">
            <div class="caution-inner">   
                <p class="description">강제성이 없는 단순 정보를 제공할 때 사용합니다.</p>
                <p class="description">두 개 이상의 지시문을 노출할 경우 콘텐츠 하단에 박스를 배치하여 사용합니다. </p>
                <p class="description">두 개 이상의 지시문을 노출할 경우 콘텐츠 하단에 박스를 배치하여 사용합니다. </p>
            </div>
        </div>
        <div class="caution">
            <div class="caution-inner">  
                <p class="description is-warning">반드시 지켜야하는 사항을 표기할 때 사용합니다.</p>
                <p class="description is-warning">두 개 이상의 지시문을 노출할 경우 콘텐츠 하단에 박스를 배치하여 사용합니다. </p>
                <p class="description is-warning">금지사항 또는 2개이상의 지시문이 박스형태로 들어갔을때만 허용합니다. </p>
            </div>
        </div>
      </div>
    </div>

    <!-- 4 line -->
    <div class="columns has-gap mb-12">
      <div class="column">
        <h1 class="mb-4">Text Link</h1>
        <a href="#" class="link">텍스트 링크 Underline으로 표시됩니다.</a>
        <br>
        <a href="#" class="link is-hover">텍스트 링크 Underline으로 표시됩니다.</a>
      </div>
    </div>

    <!-- 5 line -->
    <div class="columns has-gap mb-12">
      <div class="column">
        <h1 class="mb-4">Title / BreadCrumb</h1>

        <h1 class="page-title">
          <span>본문 제목</span>
          <div class="columns">
            <ul aria-label="breadcrumbs" class="breadcrumbs has-chevron-separator">
              <li class="breadcrumb"><a href="#none">인사</a></li>
              <li class="breadcrumb"><a href="#none">인사관리</a></li>
              <li aria-current="page" class="breadcrumb is-active"><span>인사코드</span></li>
            </ul>
          </div>
        </h1>
      </div>
    </div>

    <!-- 6 line -->
    <div class="columns has-gap mb-12">
      <div class="column">
        <h1 class="mb-4">Title / Data-count / Description</h1>

        <div class="columns has-table-title">
            <h2 class="table-title">
                <span>기초코드</span>
                <span class="data-count">총<span id="codeDtlGrid-rowcount">24</span>건</span>
                <span class="description">공통코드를 확정하세요</span>
            </h2>
        </div>
  
      </div>
    </div>
  </div>
  
</template>

<script setup>
definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})
</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
}
</style>
