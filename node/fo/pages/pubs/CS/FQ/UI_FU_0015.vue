<template>
  <div class="flex flex-col items-center w-[650px]">
    <h1 class="text-[30px] font-medium mb-[30px]">자주하는 질문</h1>

    <span class="p-input-icon-right w-full">
      <i class="pi pi-search qa-search-ico" />
      <InputText class="qa-search w-full" v-model="value1" placeholder="검색어를 입력하세요." size="large"/>
    </span>

    <div class="qa-select w-full flex mt-[40px]">
      <!-- <TabMenu :model="items" /> -->
      <SelectButton
        v-model="selectedValue"
        :options="selectOptions"
        optionLabel="label"
        optionValue="value"
        class=" w-full"
      />
    </div>

    <div class="qa-list">
      <div class="qa-item" v-for="(item, i) in items" :key="item.id">
        <div class="qa-top">
          <div class="qa-title">
            <h2>{{ item.title }}</h2>
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
    <Paginator class="mt-[20px]" :pageLinkSize="10" :rows="10" :totalRecords="120"></Paginator>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';

definePageMeta({
  layout: 'side',
  name: 'customer'
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
  {id: 1 , title: '회원탈퇴는 어떻게 하나요?', desc: '회원탈퇴 창에서 합니다.' , isOpen: false},
  {id: 2 , title: '아이디와 비밀번호를 잊어 버렸어요.', desc: '로그인 화면에서 아이디 찾기/비밀번호 찾기를 통해 확인 가능합니다.', isOpen: false},
  {id: 3 , title: '아이디를 변경할 수 있나요?', desc: 'afawefawef', isOpen: false},
  {id: 4 , title: '영수증 적립은 어떻게 할 수 있나요?', desc: 'awefawefawef', isOpen: false},
  {id: 5 , title: '쿠폰을 사용하려고 하는데 사용이 안돼요. 어떻게 해야하나요?', desc: 'awefawefawef', isOpen: false},
  {id: 6 , title: '멤버십 혜택은 무엇인가요?', desc: 'awefawefawefa', isOpen: false},
]);

const onClickExpandButton = (i) => {
  const _isOpen = items.value[i].isOpen;
  items.value[i].isOpen = !_isOpen;
}

</script>

<style scoped>
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

.qa-select{
  .p-selectbutton{
    border: 0;

    :deep(.p-button){
      border: 1px solid #E7E7E7;
      border-radius: 4px;

      &:not(:last-child) {
        margin-right: 8px;
      }
    }
  }  
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