<template>
  <div class="card is-sub is-search">
    <div class="card-header">
      <h1 class="page-title">
        <span>본문 제목</span>
        <div class="columns">
          <ul aria-label="breadcrumbs" class="breadcrumbs has-chevron-separator">
            <li class="breadcrumb"><a href="#none">인사</a></li>
            <li class="breadcrumb"><a href="#none">인사관리</a></li>
            <li aria-current="page" class="breadcrumb is-active"><a>인사코드</a></li>
          </ul>
        </div>
      </h1>
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

  <div class="columns has-gap">
    <UBox direction="row">
      <UItem ratio="1">
        <div class="card is-sub" style="width: 100%">
          <div class="card-body">
            <h2 class="table-title">
              <span>col12</span>
              <span class="data-count">
                총
                <span>0</span>
                건
              </span>
            </h2>
            <div class="card-body">
              <p>
              Contents
              </p>
            </div>
          </div>
        </div>
      </UItem>
    </UBox>
  </div>

  <div class="columns has-gap">
    <UBox direction="row">
      <UItem ratio="1">
        <div class="card is-sub">
          <div class="card-body">
            <h2 class="table-title">
              <span>col5</span>
              <span class="data-count">
                총
                <span>0</span>
                건
              </span>
            </h2>
            <div class="card-body">
              <p>
              Contents
              </p>
            </div>
          </div>
        </div>
      </UItem>
      <UItem ratio="1">
        <div class="card is-sub">
          <div class="card-body">
            <h2 class="table-title">
              <span>col5</span>
              <span class="data-count">
                총
                <span>0</span>
                건
              </span>
            </h2>
            <div class="card-body">
              <p>
              Contents
              </p>
            </div>
          </div>
        </div>
      </UItem>
    </UBox>
  </div>

  <div class="columns has-gap">
    <UBox direction="row">
      <UItem ratio="1">
        <div class="card is-sub">
          <div class="card-body">
            <h2 class="table-title">
              <span>col3</span>
              <span class="data-count">
                총
                <span>0</span>
                건
              </span>
            </h2>
            <div class="card-body">
              <p>
              Contents
              </p>
            </div>
          </div>
        </div>
      </UItem>
      <UItem ratio="4">
        <div class="card is-sub">
          <div class="card-body">
            <h2 class="table-title">
              <span>col9</span>
              <span class="data-count">
                총
                <span>0</span>
                건
              </span>
            </h2>
            <div class="card-body">
              <p>
              Contents
              </p>
            </div>
          </div>
        </div>
      </UItem>
    </UBox>
  </div>

  <div class="columns has-gap">
    <UBox direction="row">
      <UItem ratio="1">
        <div class="card is-sub">
          <div class="card-body">
            <h2 class="table-title">
              <span>col4</span>
              <span class="data-count">
                총
                <span>0</span>
                건
              </span>
            </h2>
            <div class="card-body">
              <p>
              Contents
              </p>
            </div>
          </div>
        </div>
      </UItem>
      <UItem ratio="3">
        <div class="card is-sub">
          <div class="card-body">
            <h2 class="table-title">
              <span>col8</span>
              <span class="data-count">
                총
                <span>0</span>
                건
              </span>
            </h2>
            <div class="card-body">
              <p>
              Contents
              </p>
            </div>
          </div>
        </div>
      </UItem>
    </UBox>
  </div>

  <div class="columns has-gap">
    <UBox direction="row">
      <UItem ratio="1">
        <div class="card is-sub">
          <div class="card-body">
            <h2 class="table-title">
              <span>col4</span>
              <span class="data-count">
                총
                <span>0</span>
                건
              </span>
            </h2>
            <div class="card-body">
              <p>
              Contents
              </p>
            </div>
          </div>
        </div>
      </UItem>
      <UItem ratio="1">
        <div class="card is-sub">
          <div class="card-body">
            <h2 class="table-title">
              <span>col4</span>
              <span class="data-count">
                총
                <span>0</span>
                건
              </span>
            </h2>
            <div class="card-body">
              <p>
              Contents
              </p>
            </div>
          </div>
        </div>
      </UItem>
      <UItem ratio="1">
        <div class="card is-sub">
          <div class="card-body">
            <h2 class="table-title">
              <span>col4</span>
              <span class="data-count">
                총
                <span>0</span>
                건
              </span>
            </h2>
            <div class="card-body">
              <p>
              Contents
              </p>
            </div>
          </div>
        </div>
      </UItem>
    </UBox>
  </div>
</template>

<script setup>
definePageMeta({
  auth: {
    required: true,
  },
})
</script>

<style lang="scss" scoped>

</style>