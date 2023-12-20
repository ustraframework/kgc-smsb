<template>
  <v-app>
    <v-main>
      <v-container>
        <v-card>
          <template #title> U.STRA Node Framework3 With Wijmo</template>
          <template #text>
            <v-banner lines="one" icon="mdi-web-refresh" color="deep-purple-accent-4" class="my-4">
              <v-banner-text> U.STRA Node Framework3 Reference Guide </v-banner-text>

              <template v-slot:actions>
                <v-btn @click="() => useGlobal().open('http://guide.ustraframework.kro.kr/ref-doc/11')">Go</v-btn>
              </template>
            </v-banner>

            <v-banner lines="one" icon="mdi-api" color="deep-purple-accent-4" class="my-4">
              <v-banner-text> U.STRA Node Framework3 API Document </v-banner-text>

              <template v-slot:actions>
                <v-btn @click="() => useGlobal().open('http://guide.ustraframework.kro.kr/api-docs')">Go</v-btn>
              </template>
            </v-banner>

            <v-banner lines="one" icon="mdi-weather-hurricane" color="deep-purple-accent-4" class="my-4">
              <v-banner-text> Application Sample : U.STRA Framework Wijmo Sample </v-banner-text>

              <template v-slot:actions>
                <v-btn @click="$router.push('/samples')">Go</v-btn>
              </template>
            </v-banner>

            <v-banner lines="one" icon="mdi-weather-hurricane" color="deep-orange-accent-4" class="my-4">
              <v-banner-text> Nuxt Framework3 </v-banner-text>

              <template v-slot:actions>
                <v-btn @click="() => useGlobal().open('https://v3.nuxtjs.org/')">Go</v-btn>
              </template>
            </v-banner>

            <v-banner lines="one" icon="mdi-weather-hurricane" color="deep-orange-accent-4" class="my-4">
              <v-banner-text> Vue Framework3 </v-banner-text>

              <template v-slot:actions>
                <v-btn @click="() => useGlobal().open('https://vuejs.org/')">Go</v-btn>
              </template>
            </v-banner>

            <v-banner icon="mdi-view-module" color="deep-orange-accent-4" class="my-4">
              <v-banner-text> Other built in modules </v-banner-text>

              <template v-slot:actions>
                <v-btn @click="() => useGlobal().open('https://pinia.vuejs.org/')">Pinia</v-btn>
                <v-btn @click="() => useGlobal().open('https://vueuse.org/')">Vueuse</v-btn>
                <v-btn @click="() => useGlobal().open('https://router.vuejs.org/')">Vue Router</v-btn>
              </template>
            </v-banner>

            <v-row justify="center">
              <UButton text="Go to login page" type="primary" @click="() => navigateTo('/login')"></UButton>
            </v-row>
          </template>
        </v-card>
      </v-container>
    </v-main>
  </v-app>
</template>
<script lang="ts" setup>
definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})
</script>
