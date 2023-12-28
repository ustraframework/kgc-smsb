<template>
  <div>
    <div>
      <WjFlexGrid
        :itemsSource="gridData"
        :isReadOnly="true"
        selectionMode="Row"
        :initialized="(e) => (gridControl0 = e)"
      >
        <WjFlexGridColumn header="이름" binding="name" :width="100" />
        <WjFlexGridColumn header="주소" binding="address" width="*" />
      </WjFlexGrid>
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        gridSelectionData0 : {{ gridSelectionData0 }}
      </v-chip>
    </div>

    <div>CheckBox Selection</div>
    <div>
      <WjFlexGrid
        :itemsSource="gridData"
        :isReadOnly="true"
        :initialized="(e) => (gridControl1 = e)"
      >
        <WjFlexGridColumn header="이름" binding="name" :width="100" />
        <WjFlexGridColumn header="주소" binding="address" width="*" />
      </WjFlexGrid>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        gridSelectionData1 : {{ gridSelectionData1 }}
      </v-chip>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { reactive, shallowRef } from "#ustra/nuxt";
import { WjFlexGrid, WjFlexGridColumn, UButton } from "#ustra/nuxt-wijmo/components";
import { useWjGridSelectionData } from "#ustra/nuxt-wijmo/composables";
import { FlexGrid } from "@grapecity/wijmo.grid";
import { useWjGridCheckBoxSelection } from "~/composables/grid";

// @ts-ignore
import selection1 from "./md/selection1.md";

const gridControl0 = shallowRef<FlexGrid>();
const gridSelectionData0 = useWjGridSelectionData<GrdData>(gridControl0, true);

const gridControl1 = shallowRef<FlexGrid>();

const { selectionRowData: gridSelectionData1 } = useWjGridCheckBoxSelection(gridControl1, true);


type GrdData = {
  name: string;
  address: string;
};
const gridData: GrdData[] = reactive([
  {
    name: "홍길동",
    address: "서울시 강남구 양재동",
  },
  {
    name: "강감찬",
    address: "서울 서초구 양재동",
  },
  {
    name: "유관순",
    address: "서울시 중구 종로동",
  },
]);
</script>
<script lang="ts">
export default {
  name: "PleaseInputComponentName",
};
</script>
