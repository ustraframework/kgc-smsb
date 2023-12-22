<template>
  <div class="flex flex-col items-center m-[20px]">
    <div class="w-full bg-[#F4F6FA] p-[20px] rounded-[12px]">
      <div class="flex flex-col flex-wrap items-center justify-center gap-[16px]">
        <span class="text-[15px]">나의 기념일을 등록해보세요. <br /> 최대 7개까지 가능합니다.</span>
        <Button label="기념일 등록"  @click="$router.push('/pubs/MP/MI/UI_FU_0059')" />
      </div>
    </div>

    <!-- 기념일 리스트 있을 경우 -->
    <div class="w-full mt-[40px]" v-if="list?.length > 0">
      <span className="text-[15px] font-medium">{{ `총 ${list?.length || 0}건` }}</span>

      <div class="anniversary__list">
        <div class="anniversary__card" v-for="(item, i) in list" :key="i" >
          <div class="anniversary__card-top">
            <span class="title">
              {{item.title }}
            </span>
            <span>
              <i class="icon icon-edit" />
              <i class="icon icon-delete" />
            </span>
          </div>

          <div class="anniversary__card-bottom">
            <span>{{item.gender }}</span>
            <span>{{ `[${item.dateType}] ${item.date}` }}</span>
          </div>
        </div>
      </div>
    </div>
    
    <!-- 기념일 리스트 없을 경우 -->
    <div v-else class="empty">
      <i ></i>
      <span>등록된 기념일이 없습니다.</span>
    </div>
  </div>
</template>

<script setup lang="ts">

const list = ref([
  { title: '결혼기념일', gender: '남자', dateType: '양력', date: '2023-11-30' },
  { title: '부모생일', gender: '여자', dateType: '양력', date: '2010-04-20' },
  { title: '배우자 생일', gender: '남자', dateType: '양력', date: '1986-02-25' },
  { title: '자녀 생일', gender: '남자', dateType: '양력', date: '2019-05-16' },
])
</script>

<style scoped>
.anniversary__list {
  display: flex;
  flex-direction: column;
  margin-top: 20px;
  gap: 16px;

  .anniversary__card {
    display: flex;
    flex-direction: column;
    padding: 20px;
    border: 1px solid #E7E7E7;
    border-radius: 8px;
    flex: 45%;
    gap: 20px;

    .anniversary__card-top {
      display: flex;
      justify-content: space-between;

      .title {
        background-color: #FFF5EF;
        border-radius: 4px;
        padding: 6px 8px;
        font-size: 13px;
        font-weight: 500;
        color: var(--j-primary02);
      }
      i.icon {
        width: 20px;
        height: 20px;
        display: inline-block;
      }
      i.icon-edit {
        background-image: url("data:image/svg+xml,%3Csvg width='20' height='20' viewBox='0 0 20 20' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M14.8309 7.48034L11.5197 4.16916M2 17L4.80157 16.6887C5.14385 16.6507 5.31499 16.6317 5.47496 16.5799C5.61688 16.5339 5.75194 16.469 5.87648 16.3869C6.01684 16.2943 6.1386 16.1726 6.38213 15.9291L16.3142 5.99696C17.2286 5.0826 17.2286 3.60013 16.3142 2.68577C15.3999 1.77141 13.9174 1.77141 13.0031 2.68577L3.07094 12.6179C2.82742 12.8614 2.70566 12.9832 2.6131 13.1235C2.53098 13.2481 2.46606 13.3831 2.42012 13.525C2.36833 13.685 2.34932 13.8561 2.31128 14.1984L2 17Z' stroke='%23222222' stroke-width='1.2' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M2 17H17' stroke='%23222222' stroke-width='1.2' stroke-linecap='round'/%3E%3C/svg%3E%0A");
        margin-right: 20px;
      }

      i.icon-delete {
        background-image: url("data:image/svg+xml,%3Csvg width='20' height='20' viewBox='0 0 20 20' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M7.33333 2H12.6667M2 4.66667H18M16.2222 4.66667L15.5989 14.0171C15.5053 15.42 15.4586 16.1215 15.1556 16.6533C14.8888 17.1216 14.4864 17.498 14.0015 17.7331C13.4506 18 12.7476 18 11.3416 18H8.65836C7.25236 18 6.54936 18 5.99852 17.7331C5.51356 17.498 5.11119 17.1216 4.84443 16.6533C4.54143 16.1215 4.49467 15.42 4.40114 14.0171L3.77778 4.66667M8.22222 8.66667V14.1111M11.7778 8.66667V14.1111' stroke='%23222222' stroke-width='1.2' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/svg%3E%0A");
      }
    }

    .anniversary__card-bottom {
      display: flex;
      justify-content: space-between;
      font-size: 16px;
    }
  }
}

.empty {
  margin-top: 60px;
  display: flex;
  flex-direction: column;
  align-items: center;
  color: #888888;
  font-weight: 500;
  font-size: 16px;
  
  i {
    width: 40px;
    height: 40px;
    background-image: url("data:image/svg+xml,%3Csvg width='40' height='40' viewBox='0 0 40 40' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23clip0_1292_13378)'%3E%3Ccircle cx='20' cy='20' r='20' fill='%23C8D1E2'/%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M20 11C19.1716 11 18.5 11.6716 18.5 12.5V22.5C18.5 23.3284 19.1716 24 20 24C20.8284 24 21.5 23.3284 21.5 22.5V12.5C21.5 11.6716 20.8284 11 20 11ZM20 26C18.8954 26 18 26.8954 18 28C18 29.1046 18.8954 30 20 30C21.1046 30 22 29.1046 22 28C22 26.8954 21.1046 26 20 26Z' fill='white'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0_1292_13378'%3E%3Crect width='40' height='40' fill='white'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A");
    background-repeat: no-repeat;
    margin-bottom: 20px;
  }
}
</style>