<template>
  <div class="flex flex-col items-center m-[20px]">

    <span class="p-input-icon-right w-full">
      <i class="pi pi-search qa-search-ico" />
      <InputText class="qa-search w-full" v-model="value1" placeholder="검색어를 입력하세요." size="large"/>
    </span>

    <div class="qa-list">
      <div class="qa-item" v-for="(item, i) in items" :key="item.id">
        <div class="qa-top">
          <div class="qa-title">
            <div class="flex mb-[10px]">
              <img v-if="item.isIcon" src="@/assets/images/svg/ico_pin.svg" class="mr-[8px]"/>
              <h2>{{ item.title }}</h2>
            </div>
            <span class="text-[#666666]">{{ item.date }}</span>
          </div>
          <div class="qa-item-expand">
            <button @click="onClickExpandButton(i)">
              <img class="expand-icon" :class="item.isOpen ? 'active' : ''" src="@/assets/images/svg/ico_down_arrow.svg"/>
            </button>
          </div>
        </div>
        <div class="qa-desc" v-if="item.isOpen">
          <p>
            {{ item.desc }}
          </p>
        </div>
      </div>
    </div>

  </div>
</template>

<script setup>
definePageMeta({
  layout: 'sub',
  title: '공지사항',
})


const value1 = ref(null);

const selectedValue = ref('all');
const selectOptions = ref([
  { label: '전체' , value: 'all' },
  { label: '회원관련' , value: 'member' },
  { label: '멤버십/포인트' , value: 'point' },
  { label: '사이트이용/기타' , value: 'etc' }
])

const items = ref([
  {id: 1 , title: '2023년 멤버십 등급 변경 안내', desc: '2023년부로 멤버십 등급을 변경합니다.', date:'2023-11-20', isOpen: false, isIcon: true },
  {id: 1 , title: '통합회원 One-ID 전환 안내', desc: '통합회원 One-ID 전환 안내', date:'2023-11-20', isOpen: false, isIcon: true },
  {id: 1 , title: '개인정보처리방침 개정 안내', desc: '개인정보처리방침 개정 안내', date:'2023-11-20', isOpen: false, isIcon: false },
  {id: 1 , title: '멤버십 이용약관 개정 안내', desc: '멤버십 이용약관 개정 안내', date:'2023-11-20', isOpen: false, isIcon: false },
  {id: 1 , title: '고객센터 변경 안내', desc: '고객센터 변경 안내', date:'2023-11-20', isOpen: false, isIcon: false },
]);

const onClickExpandButton = (i) => {
  const _isOpen = items.value[i].isOpen;
  items.value[i].isOpen = !_isOpen;
}

</script>

<style lang="scss" scoped>
.qa-search-ico{
  right: 15px;
}

.qa-search{
  background-color: #F4F6FA;
  border-radius: 999px;
  border: 0;
  padding-left: 25px;
  padding-right: 2.8rem;
  font-size: 15px;
}

.qa-list {
  border: 1px solid #E7E7E7;
  border-radius: 12px;
  padding: 8px 32px;
  margin-top: 20px;
  width: 100%;

  .qa-item{
    &:not(:last-child) {
      .qa-top{
        border-bottom: 1px solid #E7E7E7;
      }
    }

    &:last-child {
      .qa-desc {
        border-top: 1px solid #E7E7E7;
      }
    }

    .qa-top {
      padding: 24px 0;
      display: flex;
      justify-content: space-between;
      align-items: center;

      .qa-title{
        max-width: calc(100% - 40px);

        h2{
          font-weight: 500;
          font-size: 16px;
          color: #000;
          overflow: hidden;
          white-space: nowrap;
          text-overflow: ellipsis;
          word-break: break-all;
        }
      }

      .qa-item-expand{
        display: flex;
        width: 20px;
        align-items: center;

        .expand-icon {
          width: 20px;
          height: 20px;
          transition: all 0.25s;

          &.active{
            transform:rotate(180deg);
            transition: all 0.25s;
          }
        }
      }
    }

    .qa-desc{
      padding: 24px;
      font-size: 16px;
      background-color: #F9FAFC;
      color: #000;
      border-bottom: 1px solid #E7E7E7;
    }
  }
}
</style>