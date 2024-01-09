<template>
  <div class="flex flex-col items-center my-[80px]">
    <TabView class="fill_tab industry_custom_tab" v-model:activeIndex="activeTab">
      <TabPanel header="멤버스 소개" />
      <TabPanel header="멤버스 혜택" />
      <TabPanel header="매장찾기" />

      <!-- 포인트 쓰기 -->
      <TabPanel header="포인트 쓰기" class="header">
        <div class="tabInner__title w-[650px] mx-aut border-b">
          <h2>포인트 쓰기</h2>
          <p>정관장 전국 가맹점 매장과 정관장몰에서 포인트를 현금처럼 사용하실 수 있습니다.</p>
        </div>

        <div class="tabInner__item justify-center ma-auto">
          <div class="tabInner__item-content">
            <div class="flex flex-col mr-[83px]">
              <span class="text-[#222222] text-[15px] mb-[8px]">가맹점 매장 현황</span>
              <span class="text-[30px] font-bold">
                전국 매장
                <br />
                <span class="text-[#D20F27]">770</span>여개 지점
              </span>
            </div>

            <!-- bubble chart -->
            <div class="inner__chart" id="chart">
            </div>

          </div>
        </div>

        <div class="tabInner__item inner__bg">
          <div class="tabInner__item-content gap-[20px]">
            <div class="tabInner__item-card">
              <img src="@/assets/images/svg/ico_coffee.svg" alt="카페 이미지" width="120" height="120" />
              <h2 class="font-bold text-[24px] text-cente mt-[9px]">사푼사푼 카페</h2>
              <div class="chipList">
                <span class="chip">대치본점</span>
                <span class="chip">남대문본점</span>
                <span class="chip">부산 상상마담점</span>
                <span class="chip">인천공항점</span>
                <span class="chip">세종점</span>
              </div>
            </div>

            <div class="tabInner__item-card">
              <img src="@/assets/images/svg/ico_mall.svg" alt="정관장몰 이미지" width="250" />
              <Button class="mt-[32px] mx-auto" label="정관장몰 바로가기"  />
            </div>
          </div>
        </div>

        <div class="tabInner__item">
          <div class="tabInner__item-content">
            <div class="flex flex-col">
              <h3 class="text-[30px] font-bold">포인트 선물하기!</h3>
              <p class="text-[15px] mt-[8px] mb-[40px]">
                차곡차곡 쌓아둔 포인트 선물이 가능해졌어요! <br />
                선물가능 포인트 확인 후 선물 받을 정관장 멤버스 <br />
                회원에게 원하는 만큼 포인트 선물을 할 수 있어요! <br />
              </p>

              <span class="arrow" @click="$router.push('/pubs/MP/PI/UI_FU_0019')"> 내 포인트 확인하기 </span>
              <span class="arrow" @click="$router.push('/pubs/MP/PG/UI_FU_0020')"> 포인트 선물하기 </span>
            </div>
            <img width="326" src="@/assets/images/svg/ico_point_present.svg" alt="포인트 선물하기 이미지" />
          </div>
        </div>

        <div class="tabInner__item inner__bg">
          <div class="tabInner__item-content">
            <img width="215" height="220" src="@/assets/images/svg/ico_point_receive.svg" alt="포인트 선물하기 이미지" />

            <div class="flex flex-col justify-center ml-[130px]">
              <h3 class="text-[30px] font-bold">포인트 받기 완료!</h3>
              <p class="text-[15px] mt-[8px] mb-[40px]">
                선물 받은 포인트로 부담 없이 원하는 <br />
                제품을 구매해보세요!
              </p>
            </div>
          </div>
        </div>
      </TabPanel>
    </TabView>
  </div>
</template>
<script setup lang="ts">
import * as d3 from "d3";
import { ref } from "vue";

const activeTab = ref(3);
const chart_data = ref([
  { name: '수도권((강원포함)', value: 356, x: 230, y: 158 },
  { name: '충청', value: 102, x: 60, y: 120 },
  { name: '부산', value: 100, x: 80, y: 245 },
  { name: '호남', value: 95, x: 130, y: 40 },
  { name: '대구/울산', value: 92, x: 355, y: 240 },
  { name: '제주', value: 10, x: 340, y: 50 }
]);

const chartOptions = { width: 396, height: 307 };

onMounted(() => {
  const _chart = document.querySelector('.inner__chart');
  _chart.append(renderchart());
})

const renderchart = () => {
  // Create the pack layout.
  const pack = d3.pack()
    .size([chartOptions.width, chartOptions.height]);

  // Compute the hierarchy from the (flat) data; expose the values
  // for each node; lastly apply the pack layout.
  const root = pack(d3.hierarchy({children: chart_data.value})
    .sum(d => d.value));

  // Create the SVG container.
  const svg = d3.create("svg")
    .attr("width", chartOptions.width)
    .attr("height", chartOptions.height)
    .attr("viewBox", [0, 0, chartOptions.width, chartOptions.height])
    .attr("text-anchor", "middle");

  // Place each (leaf) node according to the layout’s x and y values.
  const node = svg.append("g")
    .selectAll()
    .data(root.leaves())
    .join("g")
    .attr("transform", d => `translate(${d.data.x},${d.data.y})`);

  // Add a filled circle.
  node.append("circle")
    .attr("fill", d => setChartFillColor(d.value))
    .attr("r", d => setChartRadius(d.value));

  // Add a label.
  const text = node.append("text")
    .attr("clip-path", d => `circle(${setChartRadius(d.data.value)})`);

  // Add a Value
  text.append("tspan")
    .attr("x", 0)
    .attr("y", 0)
    .attr("fill", 'white')
    .style("font-weight", '700')
    .style("font-size", d => setChartFontSize('value', d.data.value))
    .text(d => d.data.value);

  // Add a Name
  text.append("tspan")
    .attr("x", 0)
    .attr("y", d => setChartFontMargin(d.data.value))
    .style("font-size", d => setChartFontSize('name', d.data.value))
    .attr("fill", 'white')
    .text(d => d.data.name);

  return svg.node();
}

const setChartFillColor = (value) => {
  if( value >= 300 ) {
    return '#D20F27';
  } else if ( value < 300 && value >= 100) {
    return '#F46144';
  } else return '#FF947F';
}

const setChartRadius = (value) => {
  if( value >= 300 ) {
    return 100; // 총 넓이 200
  } else if ( value < 300 && value >= 100) {
    return 60; // 총 넓이 120
  } else return 40; // 총 넓이 80
}

const setChartFontSize = (type, value) => {
  if(type === 'value') {
    if( value >= 300 ) {
      return '40px';
    } else if ( value < 300 && value >= 100) {
      return '30px';
    } else return '24px';
  }

  if(type === 'name') {
    if( value >= 300 ) {
      return '16px';
    } else if ( value < 300 && value >= 100) {
      return '14px';
    } else return '13px';
  }
}

const setChartFontMargin = (value) => {
  // value, name 사이 여백 값
  if( value >= 300 ) {
    return '30px';
  } else if ( value < 300 && value >= 100) {
    return '24px';
  } else return '16px';
}
</script>

<style lang="scss" scoped>
/* 소개페이지 공통 css */
.tabInner__title {
  text-align: center;
  display: flex;
  flex-direction: column;

  &.border-b {
    border-color: #ECF0F8;
    padding: 0 16.5px 40px;
    margin: auto;
  }

  h2 {
    font-weight: 700;
    font-size: 40px;
    line-height: 60px;
  }

  p {
    color: const(--j-gray500);
    margin-top: 8px;
    line-height: 24px;
  }
}

/* == 포인트 쓰기 == */
.tabInner__item {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 80px 0;

  &.inner__bg {
    background-color: const(--j-bluegray200);
  }

  > .tabInner__item-content {
    display: flex;
    width: 650px;

    .tabInner__item-card {
      background-color: const(--j-white);
      border: 1px solid  const(--j-gray200);
      border-radius: 12px;
      padding: 24px;
      flex: 1;
      display: flex;
      flex-direction: column;
      align-items: center;
      
      .chipList {
        display: flex;
        flex-wrap: wrap;
        gap: 7px;
        margin-top: 24px;

        .chip {
          background-color: const(--j-bluegray300);
          border-radius: 300px;
          text-align: center;
          padding: 8px 0;
          font-size: 15px;
          font-weight: 500;
          max-width: 130px;
          width: 48.5%;
        }
      }
    }
    .arrow {
      color: const(--j-primary02);
      font-size: 16px;
      font-weight: 500;
      position: relative;
      cursor: pointer;

      & + .arrow {
        margin-top: 16px;
      }

      &::after {
        content: '';
        position: absolute;
        background-image: url("data:image/svg+xml,%3Csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M16.0092 6.21876L21.7827 11.9719C22.0724 12.2636 22.0724 12.7364 21.7827 13.0281L16.0092 18.7812C15.7195 19.0729 15.2498 19.0729 14.9601 18.7812C14.6704 18.4896 14.6704 18.0167 14.9601 17.725L19.4674 13.2469H3.74179C3.33211 13.2469 3 12.9125 3 12.5C3 12.0875 3.33211 11.7531 3.74179 11.7531H19.4674L14.9601 7.275C14.6704 6.98333 14.6704 6.51043 14.9601 6.21876C15.2498 5.92708 15.7195 5.92708 16.0092 6.21876Z' fill='%23F46144'/%3E%3C/svg%3E%0A");
        background-position: right center;
        width: 24px;
        height: 24px;
        margin-left: 4px;
      }
    }
  }
}
/* ============== */
</style>
