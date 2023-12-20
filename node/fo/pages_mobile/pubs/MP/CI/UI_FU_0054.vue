<template>
  <!-- 쿠폰 조회 -->
  <div class="flex flex-col items-center m-[20px]">
    <div class="w-full flex bg-[#F4F6FA] py-[12px] px-[20px] rounded-xl justify-center ">
      정관장 온오프라인에서 발행한 쿠폰을 조회하실 수 있습니다.
    </div>

    <div class="w-full mt-[24px]">
      <TabView class="default_tab" v-model:activeIndex="activeTab">

        <!-- 사용가능 쿠폰 -->
        <TabPanel header="사용가능 쿠폰">
          <div class="flex justify-between mb-[20px]">
            <span className="text-[15px] font-medium"> {{ `총 ${availableList.length}건` }}</span>
            <div class="coupon__search">
              <span
                v-for="(type, i) in selectType"
                :key="i"
                @click.prevent="onClickSearchType('available', type.value)"
                :class="{ selected: selected['available'] == type.value }"
              >
                {{ type.label }}
              </span>
            </div>
          </div>

          <!-- 쿠폰 리스트 있을 경우 -->
          <div v-if="availableList?.length > 0" class="coupon__list">
            <div v-for="(item, i) in availableList" :key="i" class="coupon__item">
              <div class="coupon__item-top">
                <span>정관장몰</span>
                <span class="tag">{{ item.tag }}</span>
              </div>

              <span class="coupon__item-title">
                {{ item.title }}
              </span>

              <p class="coupon__item-content">
                {{ item.content }}
              </p>

              <div class="coupon__item-bottom">
                <span class="percent"> <strong class="mr-[2px]">{{ item.percent }}</strong>%</span>
                <div class="coupon__item-bottom-right">
                  <span>D-2</span>
                  <span class="date">{{ `${item.startDate} ~ ${item.endDate}` }}</span>
                </div>
              </div>
            </div>
          </div>

          <!-- 쿠폰 리스트 없을 경우 -->
          <div v-else class="empty__coupon">
            <i ></i>
            <span>사용완료 또는 기간 만료된 쿠폰이 없습니다.</span>
          </div>

        </TabPanel>

        <!-- 사용완료/기간만료 쿠폰 -->
        <TabPanel header="사용완료/기간만료 쿠폰">
          <div class="flex justify-between mb-[20px]">
            <span className="text-[15px] font-medium"> {{ `총 ${unavailableList.length}건` }}</span>
            <div class="coupon__search">
              <span
                v-for="(type, i) in selectType"
                :key="i"
                @click.prevent="onClickSearchType('unavailable', type.value)"
                :class="{ selected: selected['unavailable'] == type.value }"
              >
                {{ type.label }}
              </span>
            </div>
          </div>

          <!-- 쿠폰 리스트 있을 경우 -->
          <div v-if="unavailableList?.length > 0" class="coupon__list">
            <div v-for="(item, i) in unavailableList" :key="i" class="coupon__item disabled">
              <div class="coupon__item-top">
                <span>정관장몰</span>
                <span class="tag">{{ item.tag }}</span>
              </div>

              <span class="coupon__item-title">
                {{ item.title }}
              </span>

              <p class="coupon__item-content">
                {{ item.content }}
              </p>

              <div class="coupon__item-bottom">
                <span class="percent"> <strong class="mr-[2px]">{{ item.percent }}</strong>%</span>
                <div class="coupon__item-bottom-right">
                  <span class="location">{{ `사용처 : ${item.usedLocation}` }}</span>
                  <span class="date">{{ `${item.usedDate ? `사용완료 ${item.usedDate}` : `${item.startDate} ~ ${item.endDate}`}` }}</span>
                </div>
              </div>
            </div>
          </div>

          <!-- 쿠폰 리스트 없을 경우 -->
          <div v-else class="empty__coupon">
            <i ></i>
            <span>사용완료 또는 기간 만료된 쿠폰이 없습니다.</span>
          </div>
        </TabPanel>
      </TabView>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";

const activeTab = ref(0)

const availableList = [
  {
    tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, startDate: '2023-09-01', endDate: '2023-09-01',
    content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  }, {
    tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, startDate: '2023-09-01', endDate: '2023-09-01',
    content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  }, {
    tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, startDate: '2023-09-01', endDate: '2023-09-01',
    content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  }, {
    tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, startDate: '2023-09-01', endDate: '2023-09-01',
    content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  }, {
    tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, startDate: '2023-09-01', endDate: '2023-09-01',
    content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  }, {
    tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, startDate: '2023-09-01', endDate: '2023-09-01',
    content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  }, {
    tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, startDate: '2023-09-01', endDate: '2023-09-01',
    content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  }, {
    tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, startDate: '2023-09-01', endDate: '2023-09-01',
    content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  }, {
    tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, startDate: '2023-09-01', endDate: '2023-09-01',
    content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  }, {
    tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, startDate: '2023-09-01', endDate: '2023-09-01',
    content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  }
]

const unavailableList = [
  // {
  //   tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, usedLocation: '정관장 멤버스 앱', usedDate: '2023-09-01',
  //   content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  // }, {
  //   tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, usedLocation: '기간만료',  startDate: '2023-09-01', endDate: '2023-09-01',
  //   content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  // }, {
  //   tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, usedLocation: '기간만료',  startDate: '2023-09-01', endDate: '2023-09-01',
  //   content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  // }, {
  //   tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, usedLocation: '정관장 멤버스 앱', usedDate: '2023-09-01',
  //   content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  // }, {
  //   tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, usedLocation: '정관장 멤버스 앱', usedDate: '2023-09-01',
  //   content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  // }, {
  //   tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, usedLocation: '기간만료', startDate: '2023-09-01', endDate: '2023-09-01',
  //   content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  // }, {
  //   tag: '12022', title: '[기획전] 환절기 건강관리엔 정몰 할인쿠폰', percent: 10, usedLocation: '기간만료', startDate: '2023-09-01', endDate: '2023-09-01',
  //   content: '상품금액이 20,000원 이상일 때/최대할인금액 제한없음 \n ※ 1개의 상품에 1개의 쿠폰 사용 가능\n ※ 사용처 : 온라인전용\n ※ 구매수량제한 : 20개 이하\n ※ 정관장 상품을 제외한 상품에 사용가능',
  // }
]

const selectType = [
  { label: '온라인', value: 'online'},
  { label: '오프라인', value: 'offline'},
]

const selected = ref({
  'available': 'online',
  'unavailable': 'online'
})

const onClickSearchType = (tabType, searchType) => {
  selected.value[tabType] = searchType;
}

</script>

<style scoped>

.coupon__search {
  span {
    cursor: pointer;
    font-size: 15px;
    &.selected {
      font-weight: 700;
    }

    & + span::before {
      content: '';
      background-image: url("data:image/svg+xml,%3Csvg width='1' height='15' viewBox='0 0 1 15' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Crect y='0.5' width='1' height='14' fill='%23D9D9D9'/%3E%3C/svg%3E%0A");
      background-repeat: no-repeat;
      width: 1px;
      height: 14px;
      display: inline-block;
      margin: 0 12px;
    }
  }
}

::v-deep(.p-tabview-nav-container) {
  margin-left: -20px;
  margin-right: -20px;
}

.coupon__list {
  display:flex;
  flex-wrap: wrap;
  gap: 16px;
  .coupon__item {
    padding: 20px;
    background-image: url("data:image/svg+xml,%3Csvg width='317' height='255' viewBox='0 0 317 255' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cmask id='path-1-inside-1_1162_6826' fill='white'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M0 8C0 3.58172 3.58172 0 8 0H221.397C221.397 6.62742 226.804 12 233.473 12C240.143 12 245.549 6.62742 245.549 0H309C313.418 0 317 3.58172 317 8V247C317 251.418 313.418 255 309 255L246.556 255C246.556 248.373 241.149 243 234.479 243C227.81 243 222.403 248.373 222.403 255L8 255C3.58173 255 0 251.418 0 247V8Z'/%3E%3C/mask%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M0 8C0 3.58172 3.58172 0 8 0H221.397C221.397 6.62742 226.804 12 233.473 12C240.143 12 245.549 6.62742 245.549 0H309C313.418 0 317 3.58172 317 8V247C317 251.418 313.418 255 309 255L246.556 255C246.556 248.373 241.149 243 234.479 243C227.81 243 222.403 248.373 222.403 255L8 255C3.58173 255 0 251.418 0 247V8Z' fill='white'/%3E%3Cpath d='M221.397 0H222.397V-1H221.397V0ZM245.549 0V-1H244.549V0H245.549ZM309 255V254V255ZM246.556 255H245.556V256L246.556 256V255ZM222.403 255V256L223.403 256V255H222.403ZM8 255L8 254H8V255ZM8 -1C3.02944 -1 -1 3.02944 -1 8H1C1 4.13401 4.13401 1 8 1V-1ZM221.397 -1H8V1H221.397V-1ZM233.473 11C227.35 11 222.397 6.06918 222.397 0H220.397C220.397 7.18566 226.257 13 233.473 13V11ZM244.549 0C244.549 6.06918 239.596 11 233.473 11V13C240.689 13 246.549 7.18566 246.549 0H244.549ZM309 -1H245.549V1H309V-1ZM318 8C318 3.02944 313.971 -1 309 -1V1C312.866 1 316 4.13401 316 8H318ZM318 247V8H316V247H318ZM309 256C313.971 256 318 251.971 318 247H316C316 250.866 312.866 254 309 254V256ZM246.556 256L309 256V254L246.556 254V256ZM247.556 255C247.556 247.814 241.695 242 234.479 242V244C240.603 244 245.556 248.931 245.556 255H247.556ZM234.479 242C227.264 242 221.403 247.814 221.403 255H223.403C223.403 248.931 228.356 244 234.479 244V242ZM8 256L222.403 256V254L8 254L8 256ZM-1 247C-1 251.971 3.02944 256 8 256V254C4.13401 254 1 250.866 1 247H-1ZM-1 8V247H1V8H-1Z' fill='%23E7E7E7' mask='url(%23path-1-inside-1_1162_6826)'/%3E%3C/svg%3E%0A");
    background-repeat: no-repeat;
    width: 320px;

    .coupon__item-top {
      display: flex;
      justify-content: space-between;
      font-size: 13px;
      margin-bottom: 16px;
      font-weight: 500;

      .tag {
        font-weight: 400;
        color: #666666;
      }
    }

    .coupon__item-title {
      font-size: 16px;
      font-weight: 700;
      line-height: 24px;
    }

    .coupon__item-content {
      line-height: 18px;
      font-size: 12px;
      white-space: pre-line;
      color: #888888;
      margin-top: 8px;
    }

    .coupon__item-bottom {
      margin-top: 16px;
      display: flex;
      justify-content: space-between;

      .percent {
        color: var(--j-primary01);
        font-size: 30px;
        line-height: 45px;
      }

      .coupon__item-bottom-right {
        display: flex;
        flex-direction: column;
        text-align: right;
        
        :not(.date) {
          font-weight: 700;
          color: var(--j-primary01);
        }
        .location {
          font-size: 13px;
          color: black;
        }
        .date {
          font-size: 13px;
          color: #666666;
        }
      }
    }

    &.disabled {
      background-image: url("data:image/svg+xml,%3Csvg width='317' height='255' viewBox='0 0 317 255' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cmask id='path-1-inside-1_1643_8656' fill='white'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M0 8C0 3.58172 3.58172 0 8 0H221.397C221.397 6.62742 226.804 12 233.473 12C240.143 12 245.549 6.62742 245.549 0H309C313.418 0 317 3.58172 317 8V247C317 251.418 313.418 255 309 255L246.556 255C246.556 248.373 241.149 243 234.479 243C227.81 243 222.403 248.373 222.403 255L8 255C3.58173 255 0 251.418 0 247V8Z'/%3E%3C/mask%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M0 8C0 3.58172 3.58172 0 8 0H221.397C221.397 6.62742 226.804 12 233.473 12C240.143 12 245.549 6.62742 245.549 0H309C313.418 0 317 3.58172 317 8V247C317 251.418 313.418 255 309 255L246.556 255C246.556 248.373 241.149 243 234.479 243C227.81 243 222.403 248.373 222.403 255L8 255C3.58173 255 0 251.418 0 247V8Z' fill='%23FBFBFB'/%3E%3Cpath d='M221.397 0H222.397V-1H221.397V0ZM245.549 0V-1H244.549V0H245.549ZM309 255V254V255ZM246.556 255H245.556V256L246.556 256V255ZM222.403 255V256L223.403 256V255H222.403ZM8 255L8 254H8V255ZM8 -1C3.02944 -1 -1 3.02944 -1 8H1C1 4.13401 4.13401 1 8 1V-1ZM221.397 -1H8V1H221.397V-1ZM233.473 11C227.35 11 222.397 6.06918 222.397 0H220.397C220.397 7.18566 226.257 13 233.473 13V11ZM244.549 0C244.549 6.06918 239.596 11 233.473 11V13C240.689 13 246.549 7.18566 246.549 0H244.549ZM309 -1H245.549V1H309V-1ZM318 8C318 3.02944 313.971 -1 309 -1V1C312.866 1 316 4.13401 316 8H318ZM318 247V8H316V247H318ZM309 256C313.971 256 318 251.971 318 247H316C316 250.866 312.866 254 309 254V256ZM246.556 256L309 256V254L246.556 254V256ZM247.556 255C247.556 247.814 241.695 242 234.479 242V244C240.603 244 245.556 248.931 245.556 255H247.556ZM234.479 242C227.264 242 221.403 247.814 221.403 255H223.403C223.403 248.931 228.356 244 234.479 244V242ZM8 256L222.403 256V254L8 254L8 256ZM-1 247C-1 251.971 3.02944 256 8 256V254C4.13401 254 1 250.866 1 247H-1ZM-1 8V247H1V8H-1Z' fill='%23E7E7E7' mask='url(%23path-1-inside-1_1643_8656)'/%3E%3C/svg%3E%0A");

      *,
      .tag,
      .percent {
        color: #c3c3c3;
      }
    }
  }
}

.empty__coupon {
  margin-top: 80px;
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